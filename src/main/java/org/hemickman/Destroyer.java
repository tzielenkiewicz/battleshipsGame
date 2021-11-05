package org.hemickman;

import java.util.Random;

public class Destroyer {
    public int row;
    public int column;
    public String position;
    public String status = "sailing";
    public shipPart bridge = new shipPart(true);
    public shipPart chimney = new shipPart(true);
    public shipPart gun = new shipPart(true);
    public shipPart radar = new shipPart(true);

    public static class shipPart {
        public boolean active;
        public int locationX;
        public int locationY;

        public shipPart(boolean active) {
            this.active = active;
        }

        public boolean isActive() {
            return active;
        }

        public int getLocationX() {
            return locationX;
        }

        public int getLocationY() {
            return locationY;
        }
    }

    public Destroyer(int row, int column, String position) {
        this.row = row;
        this.column = column;
        this.position = position;

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getPosition() {
        return position;
    }

    public String getStatus() {
        return status;
    }

    public static int[][] defineDestroyerLocation(Destroyer dstr, char[][] dsbrd) {
        boolean collision;
        do {
            collision = false;
            if (dstr.getPosition().equals("vertical")) {
                for (int j = -1; j < 5; j++) {
                    for (int i = -1; i < 2; i++) {
                        try {
                            if (dsbrd[dstr.getRow() + j][dstr.getColumn() + i] == 'X') {
                                if (dstr.getColumn() < 9) {
                                    dstr.column++;
                                } else {
                                    dstr.column = 0;
                                    if (dstr.getRow() < 6) dstr.row++;
                                    else dstr.row = 0;
                                }
                                collision = true;
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                    }
                }
            }
            else {
                for (int j = -1; j < 5; j++) {
                    for (int i = -1; i < 2; i++) {
                        try {
                            if (dsbrd[dstr.getRow() + i][dstr.getColumn() + j] == 'X') {
                                if (dstr.getRow() < 9) {
                                    dstr.row++;
                                } else {
                                    dstr.row = 0;
                                    if (dstr.getColumn() < 6) dstr.column++;
                                    else dstr.column = 0;
                                }
                                collision = true;
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                    }
                }
            }

        } while (collision);
        int[][] dstrLoc;
        if (dstr.getPosition().equals("vertical")) dstrLoc =
                new int[][]{{dstr.getRow(), dstr.getColumn()}, {dstr.getRow() + 1, dstr.getColumn()},
                        {dstr.getRow() + 2, dstr.getColumn()}, {dstr.getRow() + 3, dstr.getColumn()}};
        else dstrLoc = new int[][] {{dstr.getRow(), dstr.getColumn()}, {dstr.getRow(), dstr.getColumn()+1},
                {dstr.getRow(), dstr.getColumn()+2}, {dstr.getRow(), dstr.getColumn()+3}};
        return dstrLoc;
    }

    public static void inputDestroyerIntoDashboard(Destroyer dstr, char[][] dsbrd) {
        switch (dstr.getPosition()) {
            case "vertical" -> {
                for (int i = 0; i < 4; i++) {
                    dsbrd[dstr.getRow() + i][dstr.getColumn()] = 'X';
                }
                dstr.bridge.locationX = dstr.getRow();
                dstr.bridge.locationY = dstr.getColumn();
                dstr.gun.locationX = dstr.getRow()+1;
                dstr.gun.locationY = dstr.getColumn();
                dstr.chimney.locationX = dstr.getRow()+2;
                dstr.chimney.locationY = dstr.getColumn();
                dstr.radar.locationX = dstr.getRow()+3;
                dstr.radar.locationY = dstr.getColumn();
            }
            case "horizontal" -> {
                for (int i = 0; i < 4; i++) {
                    dsbrd[dstr.getRow()][dstr.getColumn()+i]= 'X';
                }
                dstr.bridge.locationX = dstr.getRow();
                dstr.bridge.locationY = dstr.getColumn();
                dstr.gun.locationX = dstr.getRow();
                dstr.gun.locationY = dstr.getColumn()+1;
                dstr.chimney.locationX = dstr.getRow();
                dstr.chimney.locationY = dstr.getColumn()+2;
                dstr.radar.locationX = dstr.getRow();
                dstr.radar.locationY = dstr.getColumn()+3;
            }
        }
    }

    public void changeStatus(int x, int y) {
        if ((bridge.getLocationX() == x) && (bridge.getLocationY() == y)) bridge.active = false;
        if ((gun.getLocationX() == x) && (gun.getLocationY() == y)) gun.active = false;
        if ((chimney.getLocationX() == x) && (chimney.getLocationY() == y)) chimney.active = false;
        if ((radar.getLocationX() == x) && (radar.getLocationY() == y)) radar.active = false;

        if (gun.isActive() && chimney.isActive() && radar.isActive() &&
                bridge.isActive()) this.status = "sailing";
        else if (!gun.isActive() && !chimney.isActive() && !radar.isActive() &&
                !bridge.isActive()) this.status = "sunk";
        else this.status = "hit";

    }

    public static Destroyer createDestroyerInRandomLocation() {
        Random generator = new Random();
        int number1 = Math.round(generator.nextInt(9));
        int number2 = Math.round(generator.nextInt(6));
        String position = Dashboard.generatePosition();
        Destroyer dstr = null;
        switch (position) {
            case "horizontal" -> dstr = new Destroyer(number1, number2, position);
            case "vertical" -> dstr = new Destroyer(number2, number1, position);
        }
        return dstr;
    }

}

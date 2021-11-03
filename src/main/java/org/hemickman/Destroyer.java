package org.hemickman;

public class Destroyer {
    public int row;
    public int column;
    public String position;
    public String status = "sailing";
    public boolean chimney = true;
    public boolean gun = true;
    public boolean radar = true;
    public boolean bridge = true;


    public Destroyer(int row, int column, String position) {
        this.row = row;
        this.column = column;
        this.position = position;

    }

    public static void inputDestroyerIntoDashboard(Destroyer dstr, char[][] dsbrd) {
        for (int i = 0; i < 4; i++) {
            if (dstr.getPosition().equals("vertical")) dsbrd[dstr.getRow()+i][dstr.getColumn()]= 'X';
            else dsbrd[dstr.getRow()][dstr.getColumn()+i]= 'X';
        }
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
                                if (dstr.getRow() < 9) {
                                    dstr.column++;
                                } else {
                                    dstr.column = 0;
                                    dstr.row++;
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
                                    dstr.column++;
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

    public boolean isChimney() {
        return chimney;
    }

    public boolean isGun() {
        return gun;
    }

    public boolean isRadar() {
        return radar;
    }

    public boolean isBridge() {
        return bridge;
    }
    public void changeStatus() {
        if (gun && chimney && radar && bridge) this.status = "sailing";
        else if (!gun && !chimney && !radar && !bridge) this.status = "sunk";
        else this.status = "hit";

    }

}

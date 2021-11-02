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
            if (dstr.getRow() < 3 && dstr.getColumn() < 3 && dstr.position.equals("vertical")) {
                dsbrd[dstr.getRow() + i][dstr.getColumn()]= 'X';
            } else if (dstr.getRow() < 3 && dstr.getColumn() < 3 && dstr.position.equals("horizontal")) {
                dsbrd[dstr.getRow()][dstr.getColumn() + i]= 'X';
            } else if (dstr.getRow() > 6 && dstr.getColumn() < 3 && dstr.position.equals("vertical")) {
                dsbrd[dstr.getRow() - i][dstr.getColumn()]= 'X';
            } else if (dstr.getRow() > 6 && dstr.getColumn() < 3 && dstr.position.equals("horizontal")) {
                dsbrd[dstr.getRow()][dstr.getColumn() + i]= 'X';
            } else if (dstr.getRow() < 3 && dstr.getColumn() > 6 && dstr.position.equals("vertical")) {
                dsbrd[dstr.getRow() + i][dstr.getColumn()]= 'X';
            } else if (dstr.getRow() < 3 && dstr.getColumn() > 6 && dstr.position.equals("horizontal")) {
                dsbrd[dstr.getRow()][dstr.getColumn() - i]= 'X';
            } else if (dstr.getRow() > 6 && dstr.getColumn() > 6 && dstr.position.equals("vertical")) {
                dsbrd[dstr.getRow() - i][dstr.getColumn()]= 'X';
            } else if (dstr.getRow() > 6 && dstr.getColumn() > 6 && dstr.position.equals("horizontal")) {
                dsbrd[dstr.getRow()][dstr.getColumn() - i]= 'X';
            } else {
                if (dstr.position.equals("vertical")) dsbrd[dstr.getRow() + i][dstr.getColumn()]= 'X';
                else dsbrd[dstr.getRow()][dstr.getColumn()+i]= 'X';
            }
        }
    }

    public static int[][] defineDestroyerLocation(int n1, int n2, String position, char[][] dsbrd) {
        boolean collision;
        do {
            collision = false;
            if (position.equals("vertical")) {
                for (int j = -1; j < 5; j++) {
                    for (int i = -1; i < 2; i++) {
                        try {
                            if (dsbrd[n1 + j][n2 + i] == 'X') {
                                if (n1 < 7) {
                                    n1++;
                                } else {
                                    n1 = 0;
                                    n2++;
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
                            if (dsbrd[n1 + i][n2 + j] == 'X') {
                                if (n1 < 9) {
                                    n1++;
                                } else {
                                    n1 = 0;
                                    n2++;
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
        if (position.equals("vertical")) dstrLoc =
                new int[][]{{n1, n2}, {n1 + 1, n2}, {n1 + 2, n2}, {n1 + 3, n2}};
        else dstrLoc = new int[][] {{n1, n2}, {n1, n2+1}, {n1, n2+2}, {n1, n2+3}};
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

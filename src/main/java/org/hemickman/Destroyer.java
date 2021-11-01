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

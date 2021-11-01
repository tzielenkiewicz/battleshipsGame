package org.hemickman;

public class Battleship extends Destroyer {
    public static void inputBattleshipIntoDashboard(Battleship btls, char[][] dsbrd) {
        for (int i = 0; i < 5; i++) {
            if (btls.getRow() < 4 && btls.getColumn() < 4 && btls.position.equals("vertical")) {
                dsbrd[btls.getRow() + i][btls.getColumn()]= 'X';
            } else if (btls.getRow() < 4 && btls.getColumn() < 4 && btls.position.equals("horizontal")) {
                dsbrd[btls.getRow()][btls.getColumn() + i]= 'X';
            } else if (btls.getRow() > 5 && btls.getColumn() < 4 && btls.position.equals("vertical")) {
                dsbrd[btls.getRow() - i][btls.getColumn()]= 'X';
            } else if (btls.getRow() > 5 && btls.getColumn() < 4 && btls.position.equals("horizontal")) {
                dsbrd[btls.getRow()][btls.getColumn() + i]= 'X';
            } else if (btls.getRow() < 4 && btls.getColumn() > 5 && btls.position.equals("vertical")) {
                dsbrd[btls.getRow() + i][btls.getColumn()]= 'X';
            } else if (btls.getRow() < 4 && btls.getColumn() > 5 && btls.position.equals("horizontal")) {
                dsbrd[btls.getRow()][btls.getColumn() - i]= 'X';
            } else if (btls.getRow() > 5 && btls.getColumn() > 5 && btls.position.equals("vertical")) {
                dsbrd[btls.getRow() - i][btls.getColumn()]= 'X';
            } else if (btls.getRow() > 5 && btls.getColumn() > 5 && btls.position.equals("horizontal")) {
                dsbrd[btls.getRow()][btls.getColumn() - i]= 'X';
            } else {
                if (btls.position.equals("vertical")) dsbrd[btls.getRow() + i][btls.getColumn()]= 'X';
                else dsbrd[btls.getRow()][btls.getColumn() + i]= 'X';
            }
        }
    }

    public boolean isRocketLauncher() {
        return rocketLauncher;
    }

    public boolean rocketLauncher = true;
    public Battleship(int row, int column, String position) {
        super(row, column, position);
    }

    public void changeStatus() {
        if (gun && chimney && radar && bridge && rocketLauncher) this.status = "sailing";
        else if (!gun && !chimney && !radar && !bridge && !rocketLauncher) this.status = "sunk";
        else this.status = "hit";

    }
}

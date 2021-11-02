package org.hemickman;

public class Battleship extends Destroyer {
    public boolean isRocketLauncher() {
        return rocketLauncher;
    }

    public static void inputBattleshipIntoDashboard(Battleship btls, char[][] dsbrd) {
        for (int i = 0; i < 5; i++) {
            if (btls.getPosition().equals("vertical")) dsbrd[btls.getRow()+i][btls.getColumn()]= 'X';
            else dsbrd[btls.getRow()][btls.getColumn()+i]= 'X';
        }
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

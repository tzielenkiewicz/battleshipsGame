package org.hemickman;

public class Battleship extends Destroyer {
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

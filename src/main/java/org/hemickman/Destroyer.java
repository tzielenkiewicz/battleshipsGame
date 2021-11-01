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

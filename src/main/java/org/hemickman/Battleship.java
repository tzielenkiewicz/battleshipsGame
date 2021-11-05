package org.hemickman;

import java.util.Random;

public class Battleship extends Destroyer {
    public shipPart rocketLauncher = new shipPart(true);

    public static void inputBattleshipIntoDashboard(Battleship btls, char[][] dsbrd) {
        switch (btls.getPosition()) {
            case "vertical" -> {
                for (int i = 0; i < 5; i++) {
                    dsbrd[btls.getRow() + i][btls.getColumn()] = 'X';
                }
                btls.bridge.locationX = btls.getRow();
                btls.bridge.locationY = btls.getColumn();
                btls.gun.locationX = btls.getRow()+1;
                btls.gun.locationY = btls.getColumn();
                btls.chimney.locationX = btls.getRow()+2;
                btls.chimney.locationY = btls.getColumn();
                btls.radar.locationX = btls.getRow()+3;
                btls.radar.locationY = btls.getColumn();
                btls.rocketLauncher.locationX = btls.getRow()+4;
                btls.rocketLauncher.locationY = btls.getColumn();
            }
            case "horizontal" -> {
                for (int i = 0; i < 5; i++) {
                    dsbrd[btls.getRow()][btls.getColumn()+i]= 'X';
                }
                btls.bridge.locationX = btls.getRow();
                btls.bridge.locationY = btls.getColumn();
                btls.gun.locationX = btls.getRow();
                btls.gun.locationY = btls.getColumn()+1;
                btls.chimney.locationX = btls.getRow();
                btls.chimney.locationY = btls.getColumn()+2;
                btls.radar.locationX = btls.getRow();
                btls.radar.locationY = btls.getColumn()+3;
                btls.rocketLauncher.locationX = btls.getRow();
                btls.rocketLauncher.locationY = btls.getColumn()+4;
            }
        }
    }


    public Battleship(int row, int column, String position) {
        super(row, column, position);
    }

    public void changeStatus(int x, int y) {
        if ((bridge.getLocationX() == x) && (bridge.getLocationY() == y)) bridge.active = false;
        if ((gun.getLocationX() == x) && (gun.getLocationY() == y)) gun.active = false;
        if ((chimney.getLocationX() == x) && (chimney.getLocationY() == y)) chimney.active = false;
        if ((radar.getLocationX() == x) && (radar.getLocationY() == y)) radar.active = false;
        if ((rocketLauncher.getLocationX() == x) && (rocketLauncher.getLocationY() == y))
            rocketLauncher.active = false;

        if (gun.isActive() && chimney.isActive() && radar.isActive()
                && bridge.isActive() && rocketLauncher.isActive()) this.status = "sailing";
        else if (!gun.isActive() && !chimney.isActive() && !radar.isActive()
                && !bridge.isActive() && !rocketLauncher.isActive()) this.status = "sunk";
        else this.status = "hit";

    }

    public static Battleship createBattleshipInRandomLocation() {
        Random generator = new Random();
        int number1 = Math.round(generator.nextInt(9));
        int number2 = Math.round(generator.nextInt(5));
        String position = Dashboard.generatePosition();
        Battleship btls = null;
        switch (position) {
            case "horizontal" -> btls = new Battleship(number1, number2, position);
            case "vertical" -> btls = new Battleship(number2, number1, position);
        }
        return btls;
    }
}

package org.hemickman;

import java.util.Random;

public class Fire {
    public static String fireAtComputer(Dashboard.GameDashboard dsbrd, int row, int column) {
        String report = null;
        if (dsbrd.dashboard[row][column] == ' ') {
            dsbrd.dashboard[row][column] = 'o';
            report = "You've missed!";
        }
        else if (dsbrd.dashboard[row][column] == 'X') {
            dsbrd.dashboard[row][column] = '*';
            dsbrd.battleship.changeStatus(row, column);
            dsbrd.destroyer1.changeStatus(row, column);
            dsbrd.destroyer2.changeStatus(row, column);
            report = "That's a hit!";
        }
        return report;
    }

    public static String switchPlayer(String current) {
        if (!current.equals("player")) current = "player";
        else current = "computer";
        return current;
    }

    public static int[] setFireCoordinates(int row, String col) {
        int[] coord = new int[2];
        coord[0] = row;
        switch(col) {
            case "A" -> coord[1] = 0;
            case "B" -> coord[1] = 1;
            case "C" -> coord[1] = 2;
            case "D" -> coord[1] = 3;
            case "E" -> coord[1] = 4;
            case "F" -> coord[1] = 5;
            case "G" -> coord[1] = 6;
            case "H" -> coord[1] = 7;
            case "I" -> coord[1] = 8;
            case "J" -> coord[1] = 9;
        }
        return coord;
    }

    public static boolean checkWinner(Dashboard.GameDashboard dsbrd) {
        return dsbrd.battleship.status.equals("sunk") && dsbrd.destroyer1.status.equals("sunk") &&
                dsbrd.destroyer2.status.equals("sunk");
    }

    public static String fireAtPlayer(Dashboard.GameDashboard dsbrd) {
        Random rnd = new Random();
        int x = rnd.nextInt(9);
        int y = rnd.nextInt(9);
        String report = null;
        if (dsbrd.dashboard[x][y] == ' ') {
            dsbrd.dashboard[x][y] = 'o';
            report = "You've missed!";
        }
        else if (dsbrd.dashboard[x][y] == 'X') {
            dsbrd.dashboard[x][y] = '*';
            dsbrd.battleship.changeStatus(x, y);
            dsbrd.destroyer1.changeStatus(x, y);
            dsbrd.destroyer2.changeStatus(x, y);
            report = "That's a hit!";
        }
        return report;
    }
}

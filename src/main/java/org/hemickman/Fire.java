package org.hemickman;

public class Fire {
    public static String fireAtComputer(Dashboard.GameDashboard dsbrd, int row, int column) {
        String report = null;
        if (dsbrd.dashboard[row][column] == ' ') {
            dsbrd.dashboard[row][column] = 'o';
            report = "You missed!";
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
}

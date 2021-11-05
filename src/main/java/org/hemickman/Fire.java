package org.hemickman;

public class Fire {
    public static void fireAtComputer(Dashboard.GameDashboard dsbrd, int row, int column) {
        if (dsbrd.dashboard[row][column] == ' ') dsbrd.dashboard[row][column] = 'o';
        else if (dsbrd.dashboard[row][column] == 'X') {
            dsbrd.dashboard[row][column] = '*';
            dsbrd.battleship.changeStatus(row, column);
            dsbrd.destroyer1.changeStatus(row, column);
            dsbrd.destroyer2.changeStatus(row, column);
        }
    }
}

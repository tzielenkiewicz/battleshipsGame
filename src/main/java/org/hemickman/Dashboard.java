package org.hemickman;

import static org.junit.Assert.assertEquals;

public class Dashboard {
    int amount;

    Dashboard(int amount) {
        this.amount = amount;
    }
    public static char[][] createDashboard_10Size() {
        return new char[10][10];
    }
    public static char[][] createDashboard_XSize(int amount) {
        return new char[amount][amount];
    }

    public static char[][] createEmptyDashboard(int amount) {
        char[][] dbrdSpace = new char[amount][amount];
        pushCharIntoDashboard(dbrdSpace, ' ');
        return dbrdSpace;
    }

    public static char[][] createDashboardOfA(int amount) {
        char[][] dbrdA = new char[amount][amount];
        pushCharIntoDashboard(dbrdA, 'A');
        return dbrdA;
    }

    public static char[][] createBattleshipInChosenGrid(int row, int column) {
        char[][] battleship = createDashboard_10Size();
        for (int i=0; i<5; i++) battleship[row][column+i] = 'X';
        return battleship;
    }

    public static char[][] createDashboardOfCharWith_XSize(int amount, char c) {
        char[][] dbrdXB = new char[amount][amount];
        pushCharIntoDashboard(dbrdXB, c);
        return dbrdXB;
    }

    private static void pushCharIntoDashboard(char[][] dbrd, char c) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                dbrd[row][col] = c;
            }
        }
    }


}

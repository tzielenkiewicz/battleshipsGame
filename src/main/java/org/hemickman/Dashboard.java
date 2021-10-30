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
        char dbrd[][] = new char[amount][amount];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                dbrd[row][col] = ' ';
            }
        }
        return dbrd;
    }

    public static char[][] createDashboardOfA(int amount) {
        char dbrdA[][] = new char[amount][amount];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                dbrdA[row][col] = 'A';
            }
        }
        return dbrdA;
    }
}

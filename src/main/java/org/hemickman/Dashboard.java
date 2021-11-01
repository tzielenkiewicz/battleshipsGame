package org.hemickman;

import java.util.Random;

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
        char[][] battleship = createEmptyDashboard(10);
        for (int i=0; i<5; i++) battleship[row-1][column-1+i] = 'X';
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


    public static void displayDashboard(char[][] dashboard) {
        System.out.println("     A   B   C   D   E   F   G   H   I   J");
        System.out.println("   -----------------------------------------");
        for (int i=0; i<10; i++) {
            System.out.println((i) + "  | " + dashboard[i][0] + " | " + dashboard[i][1] + " | " +
                    dashboard[i][2] + " | " + dashboard[i][3] + " | " + dashboard[i][4] + " | " +
                    dashboard[i][5] + " | " + dashboard[i][6] + " | " + dashboard[i][7] + " | " +
                    dashboard[i][8] + " | " + dashboard[i][9] + " |");
            System.out.println("   -----------------------------------------");
        }

    }

    public static char[][] createRandomGridDashboard(int number1, int number2) {
        char[][] chosenGrid = createEmptyDashboard(10);
        chosenGrid[number1][number2]='X';
        return chosenGrid;
    }

    public static char[][] createRandomGridBattleshipDashboard(int number1, int number2) {
        Random generator = new Random();
        char[][] randomGridBattleshipDash = createEmptyDashboard(10);
        for (int i=0; i<5; i++) {

            if (number1 < 4 && number2 < 4 && generator.nextBoolean()) {
                randomGridBattleshipDash[number1 + i][number2]= 'X';
            } else if (number1 < 4 && number2 < 4 && !generator.nextBoolean()) {
                randomGridBattleshipDash[number1][number2 + i]= 'X';
            } else if (number1 > 5 && number2 < 4 && generator.nextBoolean()) {
                randomGridBattleshipDash[number1 - i][number2]= 'X';
            } else if (number1 > 5 && number2 < 4 && !generator.nextBoolean()) {
                randomGridBattleshipDash[number1][number2 + i]= 'X';
            } else if (number1 < 4 && number2 > 5 && generator.nextBoolean()) {
                randomGridBattleshipDash[number1 + i][number2]= 'X';
            } else if (number1 < 4 && number2 > 5 && !generator.nextBoolean()) {
                randomGridBattleshipDash[number1][number2 - i]= 'X';
            } else if (number1 > 5 && number2 > 5 && generator.nextBoolean()) {
                randomGridBattleshipDash[number1 - i][number2]= 'X';
            } else if (number1 > 5 && number2 > 5 && !generator.nextBoolean()) {
                randomGridBattleshipDash[number1][number2 - i]= 'X';
            } else randomGridBattleshipDash[number1 + i][number2]= 'X';
        }
        return randomGridBattleshipDash;
    }
}

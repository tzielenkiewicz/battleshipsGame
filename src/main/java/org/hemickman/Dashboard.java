package org.hemickman;

import java.util.Random;

public class Dashboard {

    public static class GameDashboard {
        public char[][] dashboard = Dashboard.createEmptyDashboard();
        public Battleship battleship;
        public Destroyer destroyer1;
        public Destroyer destroyer2;

        public void inputShips() {
            battleship = Battleship.createBattleshipInRandomLocation();
            Battleship.inputBattleshipIntoDashboard(battleship, dashboard);
            destroyer1 = Destroyer.createDestroyerInRandomLocation();
            destroyer2 = Destroyer.createDestroyerInRandomLocation();
            int[][] destroyer1Location = Destroyer.defineDestroyerLocation(destroyer1, dashboard);
            destroyer1.row = destroyer1Location[0][0];
            destroyer1.column = destroyer1Location[0][1];
            Destroyer.inputDestroyerIntoDashboard(destroyer1, dashboard);
            int[][] destroyer2Location = Destroyer.defineDestroyerLocation(destroyer2, dashboard);
            destroyer2.row = destroyer2Location[0][0];
            destroyer2.column = destroyer2Location[0][1];
            Destroyer.inputDestroyerIntoDashboard(destroyer2, dashboard);
        }
    }

    public static char[][] createDashboard_10Size() {
        return new char[10][10];
    }

    public static char[][] createRandomGridDashboard(int number1, int number2) {
        char[][] chosenGrid = createEmptyDashboard();
        chosenGrid[number1][number2]='X';
        return chosenGrid;
    }

    public static char[][] createEmptyDashboard() {
        char[][] dbrdSpace = new char[10][10];
        pushCharIntoDashboard(dbrdSpace, ' ');
        return dbrdSpace;
    }

    public static char[][] createDashboardOfA(int amount) {
        char[][] dbrdA = new char[amount][amount];
        pushCharIntoDashboard(dbrdA, 'A');
        return dbrdA;
    }

    public static char[][] createBattleshipInChosenGrid(int row, int column) {
        char[][] battleship = createEmptyDashboard();
        for (int i=0; i<5; i++) battleship[row-1][column-1+i] = 'X';
        return battleship;
    }

    public static void pushCharIntoDashboard(char[][] dbrd, char c) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                dbrd[row][col] = c;
            }
        }
    }


    public static void displayDashboard(GameDashboard dsbrd) {
        System.out.println("      A   B   C   D   E   F   G   H   I   J");
        System.out.println("    -----------------------------------------");
        for (int i=0; i<9; i++) {
            System.out.println((i+1) + "   | " + dsbrd.dashboard[i][0] + " | " + dsbrd.dashboard[i][1] + " | " +
                    dsbrd.dashboard[i][2] + " | " + dsbrd.dashboard[i][3] + " | " + dsbrd.dashboard[i][4] + " | " +
                    dsbrd.dashboard[i][5] + " | " + dsbrd.dashboard[i][6] + " | " + dsbrd.dashboard[i][7] + " | " +
                    dsbrd.dashboard[i][8] + " | " + dsbrd.dashboard[i][9] + " |");
            System.out.println("    -----------------------------------------");
        }
        System.out.println("10  | " + dsbrd.dashboard[9][0] + " | " + dsbrd.dashboard[9][1] +
                " | " + dsbrd.dashboard[9][2] + " | " + dsbrd.dashboard[9][3] + " | " +
                dsbrd.dashboard[9][4] + " | " + dsbrd.dashboard[9][5] + " | " +
                dsbrd.dashboard[9][6] + " | " + dsbrd.dashboard[9][7] + " | " +
                dsbrd.dashboard[9][8] + " | " + dsbrd.dashboard[9][9] + " |");
        System.out.println("    -----------------------------------------");
        System.out.println();
        System.out.println("battleship status: " + dsbrd.battleship.status);
        System.out.println("destroyer1 status: " + dsbrd.destroyer1.status);
        System.out.println("destroyer2 status: " + dsbrd.destroyer2.status);
    }

    public static String generatePosition() {
        Random generator = new Random();
        String position;
        if (generator.nextBoolean()) position = "vertical";
        else position = "horizontal";
        return position;
    }
}


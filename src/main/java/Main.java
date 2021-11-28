import org.hemickman.Dashboard;
import org.hemickman.Fire;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String currentPlayer;
        int[] fireCoordinates;
        int tempX = 10;
        int tempY = 10;
        int count = 0;
        boolean outOfBounds;
        boolean outOfList;
        boolean playAgain;
        char direction = 'd';
        Scanner answer = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("Welcome to BattleshipsGame!");
            System.out.println("These are your ships...");
            System.out.println("-------------------------------------------------");
            delay(2000);

            Dashboard.GameDashboard playerDashboard = new Dashboard.GameDashboard();
            playerDashboard.inputShips();
            Dashboard.GameDashboard compDashboard = new Dashboard.GameDashboard();
            compDashboard.inputShips();
            currentPlayer = "computer";
            Dashboard.displayDashboard(playerDashboard);

            do {
                currentPlayer = Fire.switchPlayer(currentPlayer);
                if (currentPlayer.equals("player")) {
                    int X;
                    String Y;
                    delay(3000);
                    System.out.println();

                    boolean tryAgain;
                    do {
                        tryAgain = false;

                        System.out.println("Input coordinates to fire at computer ships, please:");

                        do {
                            outOfList = true;
                            System.out.print("Column (A-J): ");
                            Y = scanner.nextLine().toUpperCase();
                            for (String letter : letters) {
                                if (Y.equals(letter)) {
                                    outOfList = false;
                                    break;
                                }
                            }
                        } while (outOfList);

                        do {
                            outOfBounds = false;
                            System.out.print("Row (1-10): ");
                            X = scanner2.nextInt();
                            if (X > 10 || X < 1) {
                                System.out.println("Numbers between 1 and 10!");
                                outOfBounds = true;
                            }
                        } while (outOfBounds);

                        fireCoordinates = Fire.setFireCoordinates(X, Y);
                        if (compDashboard.dashboard[fireCoordinates[0]][fireCoordinates[1]] == 'o'
                            || compDashboard.dashboard[fireCoordinates[0]][fireCoordinates[1]] == '*') {
                            System.out.println("You have already fired at those coordinates! Try again!");
                            System.out.println();
                            tryAgain = true;
                        }
                    } while (tryAgain);

                    System.out.println();
                    String report = Fire.fireAtComputer(compDashboard, fireCoordinates[0], fireCoordinates[1]);
                    System.out.println(report);
                    delay(1000);
                    System.out.println();
                    Dashboard.displayDashboard(compDashboard);
                    if (report.equals("That's a hit!"))
                        currentPlayer = Fire.switchPlayer(currentPlayer);
                } else {
                    Random rnd = new Random();
                    int x = 0, y = 0;
                    if (count == 0 && direction == 'd') {
                        x = rnd.nextInt(9);
                        y = rnd.nextInt(9);
                    }
                    else if (count > 0 && direction =='d' && tempX < (10-count)) {
                        x = tempX + count;
                        y = tempY;
                    }

                    else if (direction == 'u' && tempX >= count) {
                        x = tempX - count;
                        y = tempY;
                    }

                    else if (direction == 'r' && tempY < (10-count)) {
                        x = tempX;
                        y = tempY + count;
                    }

                    else if (direction == 'l' && tempY >= count) {
                        x = tempX;
                        y = tempY - count;
                    }

                    System.out.println();
                    System.out.println("Now computer is going to attack your ships!");
                    delay(2000);
                    System.out.println();
                    String statusD1before = playerDashboard.destroyer1.getStatus();
                    String statusD2before = playerDashboard.destroyer2.getStatus();
                    String statusBbefore = playerDashboard.battleship.getStatus();

                    String report = Fire.fireAtPlayer(playerDashboard, x, y);

                    String statusD1after = playerDashboard.destroyer1.getStatus();
                    String statusD2after = playerDashboard.destroyer2.getStatus();
                    String statusBafter = playerDashboard.battleship.getStatus();
                    boolean sunk = (!statusBafter.equals(statusBbefore) && statusBafter.equals("sunk"))
                            || (!statusD1after.equals(statusD1before) && statusD1after.equals("sunk"))
                            || (!statusD2after.equals(statusD2before) && statusD2after.equals("sunk"));

                    System.out.println(report);
                    delay(1000);
                    Dashboard.displayDashboard(playerDashboard);

                    if (report.equals("That's a hit!") && direction == 'd' && tempX == 10) {
                        currentPlayer = Fire.switchPlayer(currentPlayer);
                        tempX = x;
                        tempY = y;
                        count ++;
                    }
                    else if (sunk) {
                        currentPlayer = Fire.switchPlayer(currentPlayer);
                        count = 0;
                        direction = 'd';
                        tempX = 10;
                        tempY = 10;
                    }
                    else if (report.equals("That's a hit!")) {
                        currentPlayer = Fire.switchPlayer(currentPlayer);
                        count ++;
                    }
                    else if (report.equals("Missed!") && direction =='d' && tempX <10 ) {
                        count = 1;
                        direction = 'u';
                    }
                    else if (report.equals("Missed!") && direction == 'u') {
                        count = 1;
                        direction = 'r';
                    }
                    else if (report.equals("Missed!") && direction == 'r') {
                        count = 1;
                        direction = 'l';
                    }

                }
            } while (!Fire.checkWinner(playerDashboard) && !Fire.checkWinner(compDashboard));

            if (Fire.checkWinner(playerDashboard)) System.out.println("Computer wins this time!");
            else System.out.println("Congrats! You win!");
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = answer.nextLine().equalsIgnoreCase("Y");
        } while (playAgain);
        answer.close();
        scanner.close();
        scanner2.close();
    }

    private static void delay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

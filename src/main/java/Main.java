import org.hemickman.Dashboard;
import org.hemickman.Fire;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean checkWinner;
        String currentPlayer;
        Scanner scanner = new Scanner(System.in);
        int X;
        String Y;
        int[] fireCoordinates;

        System.out.println("-------------------------------------------------");
        System.out.println("Welcome to BattleshipsGame!");
        System.out.println("These are your ships...");
        System.out.println("-------------------------------------------------");
        Dashboard.GameDashboard playerDashboard = new Dashboard.GameDashboard();
        playerDashboard.inputShips();
        Dashboard.GameDashboard compDashboard = new Dashboard.GameDashboard();
        compDashboard.inputShips();
        currentPlayer = "player";
        Dashboard.displayDashboard(playerDashboard);
        System.out.println();

        System.out.println("Input coordinates to fire at computer ships, please:");
        System.out.print("Column (A-Z): ");
        Y = scanner.nextLine();
        System.out.print("Row (1-10): ");
        X = scanner.nextInt();

        fireCoordinates = Fire.setFireCoordinates(X, Y);
        System.out.println();
        System.out.println(Fire.fireAtComputer(compDashboard, fireCoordinates[0], fireCoordinates[1]));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        Dashboard.displayDashboard(compDashboard);
        if (compDashboard.dashboard[fireCoordinates[0]][fireCoordinates[1]] == 'o')
            Fire.switchPlayer(currentPlayer);

        System.out.println();
        System.out.println("Now computer is going to attack your ships!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

    }





}

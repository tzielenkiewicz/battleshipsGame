import org.hemickman.Battleship;
import org.hemickman.Dashboard;
import org.hemickman.Destroyer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Dashboard.GameDashboard playerDashboard = new Dashboard.GameDashboard();
        playerDashboard.inputShips();
        Dashboard.displayDashboard(playerDashboard);
    }





}

import org.hemickman.Battleship;
import org.hemickman.Dashboard;
import org.hemickman.Destroyer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random generator = new Random();
        int number1 = Math.round(generator.nextInt(9));
        int number2 = Math.round(generator.nextInt(9));
        //System.out.println(number1 + " " + number2);
        Battleship btls = new Battleship(0, 0, "horizontal");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        //int[][] destroyerLocation = Destroyer.defineDestroyerLocation(1, 1, "vertical", dsbrd);
        //System.out.println(destroyerLocation[0][0] + " " + destroyerLocation[0][1]);
    }





}

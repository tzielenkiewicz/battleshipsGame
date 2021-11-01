import org.hemickman.Battleship;
import org.hemickman.Dashboard;
import org.hemickman.Destroyer;
import org.testng.annotations.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BattleshipsTest {
    Random generator = new Random();
    @Test
    public void canCreateDashboardWith_10Size() {
        char[][] ten = Dashboard.createDashboard_10Size();
        assertEquals(ten.length, 10);
    }

    @Test
    public void canCreateDashboardWith_XSize(){
        char[][] xSize = Dashboard.createDashboard_XSize(5);
        assertEquals(xSize.length, 5);
    }

    @Test
    public void canCreateEmptyDashboard() {
        char[][] empty = Dashboard.createEmptyDashboard(10);
        for (int row = 0; row <empty.length; row ++) {
            for (int col = 0; col < empty.length; col ++) {
                assertEquals(empty[row][col], ' ');
            }
        }
    }
   @Test
    public void canCreateDashboardOfA() {
        char[][] dbrdA = Dashboard.createDashboardOfA(10);
        for (int row = 0; row < dbrdA.length; row ++) {
            for (int col = 0; col < dbrdA.length; col ++) {
                assertEquals(dbrdA[row][col], 'A');
            }
        }
    }

    @Test
    public void canCreateDashboardOfChosenCharWith_XSize() {
        char[][] X_ChosenChar = Dashboard.createDashboardOfCharWith_XSize(10, 'B');
        for (int row = 0; row < X_ChosenChar.length; row++) {
            for (int col = 0; col < X_ChosenChar.length; col++) {
                assertEquals(X_ChosenChar[row][col], 'B');
            }
        }
    }
    @Test
    public void canCreateBattleship() {
        char[][] battleshipDash = Dashboard.createBattleshipInChosenGrid(4, 5);
        for (int i=0; i<5; i++) assertEquals(battleshipDash[3][4+i], 'X');
    }
    @Test
    public void canPushXIntoRandomGrid() {
        int number1 = Math.round(generator.nextInt(10));
        int number2 = Math.round(generator.nextInt(10));

        char[][] randomGridDash = Dashboard.createRandomGridDashboard(number1, number2);
        assertEquals(randomGridDash[number1][number2], 'X');
    }

    @Test
    public void canCreateVerticalDestroyer() {
        Destroyer HMSBtls = new Destroyer (0, 0, "vertical");
        assertEquals(HMSBtls.row, 0);
        assertEquals(HMSBtls.column, 0);
        assertEquals(HMSBtls.position, "vertical");
        assertEquals(HMSBtls.status, "sailing");
    }

    @Test
    public void canCreateHorizontalDestroyer() {
        Destroyer HMSDstr = new Destroyer (0, 0, "horizontal");
        assertEquals(HMSDstr.row, 0);
        assertEquals(HMSDstr.column, 0);
        assertEquals(HMSDstr.position, "horizontal");
        assertEquals(HMSDstr.status, "sailing");
    }

    @Test
    public void canCreateVerticalBattleship() {
        Battleship HMSBtls = new Battleship(4, 5, "vertical");
        assertEquals(HMSBtls.row, 4);
        assertEquals(HMSBtls.column, 5);
        assertEquals(HMSBtls.position, "vertical");
        assertEquals(HMSBtls.status, "sailing");
    }

    @Test
    public void canChangeDestroyerStatus() {
        Destroyer HMSDstr = new Destroyer(0, 0, "vertical");
        assertEquals(HMSDstr.getStatus(), "sailing");
        assertTrue(HMSDstr.isGun());
        HMSDstr.gun = false;
        HMSDstr.chimney = false;
        HMSDstr.radar = false;
        HMSDstr.bridge = false;
        HMSDstr.changeStatus();
        assertEquals(HMSDstr.getStatus(), "sunk");
    }

    @Test
    public void canChangeBattleshipStatus() {
        Battleship HMSBtls = new Battleship(0,0, "horizontal");
        assertEquals(HMSBtls.status, "sailing");
        assertTrue(HMSBtls.isRocketLauncher());
        HMSBtls.rocketLauncher = false;
        HMSBtls.changeStatus();
        assertEquals(HMSBtls.status, "hit");
    }

}
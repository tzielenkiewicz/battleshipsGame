import org.hemickman.Battleship;
import org.hemickman.Dashboard;
import org.hemickman.Destroyer;
import org.testng.annotations.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BattleshipsTest {
    Random generator = new Random();
    int number1 = Math.round(generator.nextInt(9));
    int number2 = Math.round(generator.nextInt(9));

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
        char[][] empty = Dashboard.createEmptyDashboard();
        for (char[] chars : empty) {
            for (int col = 0; col < empty.length; col++) {
                assertEquals(chars[col], ' ');
            }
        }
    }
   @Test
    public void canCreateDashboardOfA() {
        char[][] dbrdA = Dashboard.createDashboardOfA(10);
       for (char[] chars : dbrdA) {
           for (int col = 0; col < dbrdA.length; col++) {
               assertEquals(chars[col], 'A');
           }
       }
    }

    @Test
    public void canCreateDashboardOfChosenCharWith_XSize() {
        char[][] X_ChosenChar = Dashboard.createDashboardOfCharWith_XSize(10, 'B');
        for (char[] chars : X_ChosenChar) {
            for (int col = 0; col < X_ChosenChar.length; col++) {
                assertEquals(chars[col], 'B');
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

    @Test
    public void canCreateBattleshipInRandomLocation() {
        Battleship HMSBtls = new Battleship(number1, number2, "vertical");
        assertEquals(HMSBtls.row, number1);
        assertEquals(HMSBtls.column, number2);
        assertEquals(HMSBtls.position, "vertical");
        assertEquals(HMSBtls.status, "sailing");
    }

    @Test
    public void canCreateDestroyerInRandomLocation() {
        Destroyer HMSDstr = new Destroyer (number1, number2, "horizontal");
        assertEquals(HMSDstr.row, number1);
        assertEquals(HMSDstr.column, number2);
        assertEquals(HMSDstr.position, "horizontal");
        assertEquals(HMSDstr.status, "sailing");
    }

    @Test
    public void canInputHorizontalDestroyerIntoEmptyDashboard() {
        Destroyer HMSDstr = new Destroyer(0, 0, "horizontal");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Destroyer.inputDestroyerIntoDashboard(HMSDstr, dsbrd);
        for (int i = 0; i < 4; i++) assertEquals(dsbrd[0][i], 'X');
    }

    @Test
    public void canInputVerticalDestroyerIntoEmptyDashboard() {
        Destroyer HMSDstr = new Destroyer(7, 2, "vertical");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Destroyer.inputDestroyerIntoDashboard(HMSDstr, dsbrd);
        for (int i = 0; i < 4; i++) assertEquals(dsbrd[7-i][2], 'X');
    }

    @Test
    public void canInputHorizontalBattleshipIntoEmptyDashboard() {
        Battleship HMSBtls = new Battleship(8, 8, "horizontal");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(HMSBtls, dsbrd);
        for (int i = 0; i < 5; i++) assertEquals(dsbrd[8][8-i], 'X');
    }

    @Test
    public void canInputVerticalBattleshipIntoEmptyDashboard() {
        Battleship HMSBtls = new Battleship(5, 5, "vertical");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(HMSBtls, dsbrd);
        for (int i = 0; i < 5; i++) assertEquals(dsbrd[5-i][5], 'X');
    }

    @Test
    public void canInputBattleshipRandomPosition() {
        String position;
        if (generator.nextBoolean()) position = "vertical";
        else position = "horizontal";
        Battleship HMSBtls = new Battleship(1, 1, position);
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(HMSBtls, dsbrd);
        for (int i = 0; i<5; i++) {
            if (position.equals("vertical")) assertEquals(dsbrd[1+i][1], 'X');
            else assertEquals(dsbrd[1][1+i], 'X');
        }
    }

    @Test
    public void canCreateBattleshipRandomPositionAndLocation() {
        String position = Dashboard.generatePosition();
        Battleship btls = new Battleship(number1, number2, position);
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        for (int i = 0; i<5; i++) {
            if (btls.getRow() <= 4 && btls.getColumn() <= 4 && btls.position.equals("vertical")) {
                assertEquals(dsbrd[btls.getRow() + i][btls.getColumn()], 'X');
            } else if (btls.getRow() <= 4 && btls.getColumn() <= 4 && btls.position.equals("horizontal")) {
                assertEquals(dsbrd[btls.getRow()][btls.getColumn() + i], 'X');
            } else if (btls.getRow() >= 5 && btls.getColumn() <= 4 && btls.position.equals("vertical")) {
                assertEquals(dsbrd[btls.getRow() - i][btls.getColumn()], 'X');
            } else if (btls.getRow() >= 5 && btls.getColumn() <= 4 && btls.position.equals("horizontal")) {
                assertEquals(dsbrd[btls.getRow()][btls.getColumn() + i], 'X');
            } else if (btls.getRow() <= 4 && btls.getColumn() >= 5 && btls.position.equals("vertical")) {
                assertEquals(dsbrd[btls.getRow() + i][btls.getColumn()], 'X');
            } else if (btls.getRow() <= 4 && btls.getColumn() >= 5 && btls.position.equals("horizontal")) {
                assertEquals(dsbrd[btls.getRow()][btls.getColumn() - i], 'X');
            } else if (btls.getRow() >= 5 && btls.getColumn() >= 5 && btls.position.equals("vertical")) {
                assertEquals(dsbrd[btls.getRow() - i][btls.getColumn()], 'X');
            } else if (btls.getRow() >= 5 && btls.getColumn() >= 5 && btls.position.equals("horizontal")) {
                assertEquals(dsbrd[btls.getRow()][btls.getColumn() - i], 'X');
            }
        }
    }

    @Test
    public void canDefineDestroyerLocation() {
        int n1 = 0;
        int n2 = 0;
        Battleship btls = new Battleship(0, 0, "horizontal");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        int[][] destroyerLocation = Destroyer.defineDestroyerLocation(n1, n2, "vertical", dsbrd);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 5; j++) {
                try {
                    assertEquals(dsbrd[destroyerLocation[0][0] + i][destroyerLocation[0][1] + j], ' ');
                } catch (ArrayIndexOutOfBoundsException ignored){}
            }
        }
    }


    /*@Test
    public void canInputDestroyerAfterBattleship() {
    }*/






}
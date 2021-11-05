import org.hemickman.Battleship;
import org.hemickman.Dashboard;
import org.hemickman.Destroyer;
import org.hemickman.Fire;
import org.testng.annotations.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BattleshipsTest {
    Random generator = new Random();
    int number1 = generator.nextInt(9);
    int number2 = generator.nextInt(5);
    int number3 = generator.nextInt(6);
    int number4 = generator.nextInt(9);

    public Battleship createBattleshipInRandomLocation() {
        String position = Dashboard.generatePosition();
        Battleship btls = null;
        switch (position) {
            case "horizontal" -> btls = new Battleship(number1, number2, position);
            case "vertical" -> btls = new Battleship(number2, number1, position);
        }
        return btls;
    }

    public Destroyer createDestroyerInRandomLocation() {
        String position = Dashboard.generatePosition();
        Destroyer dstr = null;
        switch (position) {
            case "horizontal" -> dstr = new Destroyer(number1, number3, position);
            case "vertical" -> dstr = new Destroyer(number3, number1, position);
        }
        return dstr;
    }

    @Test
    public void canCreateDashboardWith_10Size() {
        char[][] ten = Dashboard.createDashboard_10Size();
        assertEquals(ten.length, 10);
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
    public void canCreateBattleship() {
        char[][] battleshipDash = Dashboard.createBattleshipInChosenGrid(4, 5);
        for (int i = 0; i < 5; i++) assertEquals(battleshipDash[3][4 + i], 'X');
    }

    @Test
    public void canPushXIntoRandomGrid() {

        char[][] randomGridDash = Dashboard.createRandomGridDashboard(number1, number2);
        assertEquals(randomGridDash[number1][number2], 'X');
    }

    @Test
    public void canCreateVerticalDestroyer() {
        Destroyer HMSBtls = new Destroyer(0, 0, "vertical");
        assertEquals(HMSBtls.row, 0);
        assertEquals(HMSBtls.column, 0);
        assertEquals(HMSBtls.position, "vertical");
        assertEquals(HMSBtls.status, "sailing");
    }

    @Test
    public void canCreateHorizontalDestroyer() {
        Destroyer HMSDstr = new Destroyer(0, 0, "horizontal");
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
    public void canCreateBattleshipInRandomLocation() {
        Battleship HMSBtls = new Battleship(number1, number2, "vertical");
        assertEquals(HMSBtls.row, number1);
        assertEquals(HMSBtls.column, number2);
        assertEquals(HMSBtls.position, "vertical");
        assertEquals(HMSBtls.status, "sailing");
    }

    @Test
    public void canCreateDestroyerInRandomLocation() {
        Destroyer HMSDstr = new Destroyer(number1, number2, "horizontal");
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
        Destroyer HMSDstr = new Destroyer(4, 2, "vertical");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Destroyer.inputDestroyerIntoDashboard(HMSDstr, dsbrd);
        for (int i = 0; i < 4; i++) assertEquals(dsbrd[7 - i][2], 'X');
    }

    @Test
    public void canInputHorizontalBattleshipIntoEmptyDashboard() {
        Battleship HMSBtls = new Battleship(8, 4, "horizontal");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(HMSBtls, dsbrd);
        for (int i = 0; i < 5; i++) assertEquals(dsbrd[8][4 + i], 'X');
    }

    @Test
    public void canInputVerticalBattleshipIntoEmptyDashboard() {
        Battleship HMSBtls = new Battleship(3, 4, "vertical");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(HMSBtls, dsbrd);
        for (int i = 0; i < 5; i++) assertEquals(dsbrd[3 + i][4], 'X');
    }

    @Test
    public void canInputBattleshipRandomPosition() {
        String position= Dashboard.generatePosition();
        Battleship HMSBtls = new Battleship(1, 1, position);
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(HMSBtls, dsbrd);
        for (int i = 0; i < 5; i++) {
            if (position.equals("vertical")) assertEquals(dsbrd[1 + i][1], 'X');
            else assertEquals(dsbrd[1][1 + i], 'X');
        }
    }

    @Test
    public void canInputBattleshipRandomPositionAndLocation() {
        Battleship btls = createBattleshipInRandomLocation();
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        for (int i = 0; i < 5; i++) {
            if (btls.getPosition().equals("vertical")) assertEquals(dsbrd[number2 + i][number1], 'X');
            else assertEquals(dsbrd[number1][number2 + i], 'X');
        }
    }

    @Test
    public void canDefineDestroyerLocation() {
        Battleship btls = new Battleship(number2, number1, "vertical");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        int[][] destroyerLocation = Destroyer.defineDestroyerLocation(createDestroyerInRandomLocation(), dsbrd);
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 5; j++) {
                try {
                    assertEquals(dsbrd[destroyerLocation[0][0] + i][destroyerLocation[0][1] + j], ' ');
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
    }

    @Test
    public void canInputDestroyerAfterBattleship() {
        Battleship btls = createBattleshipInRandomLocation();
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        Destroyer dstr = createDestroyerInRandomLocation();
        int[][] destroyerLocation = Destroyer.defineDestroyerLocation(dstr, dsbrd);
        int valueX = destroyerLocation[0][0];
        int valueY = destroyerLocation[0][1];
        Destroyer.inputDestroyerIntoDashboard(new Destroyer(valueX, valueY, dstr.getPosition()), dsbrd);
        for (int i = 0; i<4; i++) {
            if (dstr.getPosition().equals("vertical"))
                assertEquals(dsbrd[valueX+i][valueY], 'X');
            else assertEquals(dsbrd[valueX][valueY+i], 'X');
        }
    }

    @Test
    public void canInputSecondDestroyer() {
        Battleship btls = createBattleshipInRandomLocation();
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        Destroyer dstr = createDestroyerInRandomLocation();
        int[][] destroyerLocation = Destroyer.defineDestroyerLocation(dstr, dsbrd);
        int valueX = destroyerLocation[0][0];
        int valueY = destroyerLocation[0][1];
        Destroyer.inputDestroyerIntoDashboard(new Destroyer(valueX, valueY, dstr.getPosition()), dsbrd);
        Destroyer scndDstr = createDestroyerInRandomLocation();
        int[][] destroyerLocation2 = Destroyer.defineDestroyerLocation(scndDstr, dsbrd);
        int valueX2 = destroyerLocation2[0][0];
        int valueY2 = destroyerLocation2[0][1];
        Destroyer.inputDestroyerIntoDashboard(
                new Destroyer(valueX2, valueY2, scndDstr.getPosition()), dsbrd);
        for (int i = 0; i<4; i++) {
            if (scndDstr.getPosition().equals("vertical"))
                assertEquals(dsbrd[valueX2+i][valueY2], 'X');
            else assertEquals(dsbrd[valueX2][valueY2+i], 'X');
        }
    }

    @Test
    public void canInputLocationIntoDestroyerShipParts() {
        Destroyer dstr = new Destroyer(0, 0, "vertical");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Destroyer.inputDestroyerIntoDashboard(dstr, dsbrd);
        assertEquals(dstr.bridge.getLocationX(), 0);
        assertEquals(dstr.gun.getLocationX(), 1);
        assertEquals(dstr.chimney.getLocationX(), 2);
        assertEquals(dstr.radar.getLocationX(), 3);
    }

    @Test
    public void canInputLocationIntoBattleshipShipParts() {
        Battleship btls = new Battleship(0, 0, "horizontal");
        char[][] dsbrd = Dashboard.createEmptyDashboard();
        Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
        assertEquals(btls.bridge.getLocationY(), 0);
        assertEquals(btls.gun.getLocationY(), 1);
        assertEquals(btls.chimney.getLocationY(), 2);
        assertEquals(btls.radar.getLocationY(), 3);
        assertEquals(btls.rocketLauncher.getLocationY(), 4);
    }

    @Test
    public void canCreateDashboardWithThreeShips() {
            Battleship btls = createBattleshipInRandomLocation();
            char[][] dsbrd = Dashboard.createEmptyDashboard();
            Battleship.inputBattleshipIntoDashboard(btls, dsbrd);
            Destroyer dstr = createDestroyerInRandomLocation();
            int[][] destroyerLocation = Destroyer.defineDestroyerLocation(dstr, dsbrd);
            int valueX = destroyerLocation[0][0];
            int valueY = destroyerLocation[0][1];
            Destroyer.inputDestroyerIntoDashboard(new Destroyer(valueX, valueY, dstr.getPosition()), dsbrd);
            Destroyer scndDstr = createDestroyerInRandomLocation();
            int[][] destroyerLocation2 = Destroyer.defineDestroyerLocation(scndDstr, dsbrd);
            int valueX2 = destroyerLocation2[0][0];
            int valueY2 = destroyerLocation2[0][1];
            Destroyer.inputDestroyerIntoDashboard(
                    new Destroyer(valueX2, valueY2, scndDstr.getPosition()), dsbrd);
            int numberOfX = 0;
            for(char[] grids:dsbrd) {
                for(char grid:grids) {
                    if (grid == 'X') numberOfX++;
                }
            }
            assertEquals(numberOfX, 13);
    }

    @Test
    public void canDisplayCorrectDashboard () {
        Dashboard.GameDashboard playerDashboard = new Dashboard.GameDashboard();
        playerDashboard.inputShips();
        assertEquals(playerDashboard.dashboard[playerDashboard.battleship.getRow()]
                [playerDashboard.battleship.getColumn()], 'X');
        assertEquals(playerDashboard.dashboard[playerDashboard.destroyer1.chimney.getLocationX()]
                [playerDashboard.destroyer1.chimney.getLocationY()], 'X');
        assertEquals(playerDashboard.dashboard[playerDashboard.destroyer2.radar.getLocationX()]
                [playerDashboard.destroyer2.radar.getLocationY()], 'X');
    }

    @Test
    public void canDisplayShipPartsStatus() {
        Dashboard.GameDashboard playerDashboard = new Dashboard.GameDashboard();
        playerDashboard.inputShips();
        assertTrue(playerDashboard.battleship.bridge.active);
        assertTrue(playerDashboard.destroyer1.gun.active);
        assertTrue(playerDashboard.destroyer2.chimney.active);
    }

    @Test
    public void canDisplayShipStatus() {
        Dashboard.GameDashboard playerDashboard = new Dashboard.GameDashboard();
        playerDashboard.inputShips();
        assertEquals(playerDashboard.battleship.status, "sailing");
        assertEquals(playerDashboard.destroyer1.status, "sailing");
        assertEquals(playerDashboard.destroyer2.status, "sailing");
    }

    @Test
    public void canFireAt00Location() {
        Dashboard.GameDashboard dsbrd = new Dashboard.GameDashboard();
        dsbrd.dashboard = Dashboard.createEmptyDashboard();
        assertEquals(dsbrd.dashboard[0][0], ' ');
        Fire.fireAtComputer(dsbrd, 0, 0);
        assertEquals(dsbrd.dashboard[0][0], 'o');
    }

    @Test
    public void canFireAt84Location() {
        Dashboard.GameDashboard dsbrd = new Dashboard.GameDashboard();
        dsbrd.dashboard = Dashboard.createEmptyDashboard();
        assertEquals(dsbrd.dashboard[8][4], ' ');
        Fire.fireAtComputer(dsbrd, 8, 4);
        assertEquals(dsbrd.dashboard[8][4], 'o');
    }

    @Test
    public void canFireRandomLocation() {
        Dashboard.GameDashboard dsbrd = new Dashboard.GameDashboard();
        dsbrd.dashboard = Dashboard.createEmptyDashboard();
        assertEquals(dsbrd.dashboard[number1][number4], ' ');
        Fire.fireAtComputer(dsbrd, number1, number4);
        assertEquals(dsbrd.dashboard[number1][number4], 'o');
    }

    @Test
    public void canChangeCharAfterFireAtShip() {
        Dashboard.GameDashboard compDashboard = new Dashboard.GameDashboard();
        compDashboard.inputShips();
        assertEquals(compDashboard.dashboard[compDashboard.destroyer2.radar.getLocationX()]
                    [compDashboard.destroyer2.radar.getLocationY()], 'X');
        Fire.fireAtComputer(compDashboard, compDashboard.destroyer2.radar.getLocationX(),
                compDashboard.destroyer2.radar.getLocationY());
        assertEquals(compDashboard.dashboard[compDashboard.destroyer2.radar.getLocationX()]
                [compDashboard.destroyer2.radar.getLocationY()], '*');
    }
    @Test
    public void canChangeShipStatusAfterFireAtShip() {
        Dashboard.GameDashboard compDashboard = new Dashboard.GameDashboard();
        compDashboard.inputShips();
        assertEquals(compDashboard.battleship.getStatus(), "sailing");
        Fire.fireAtComputer(compDashboard,
                compDashboard.battleship.getRow(),compDashboard.battleship.getColumn());
        assertEquals(compDashboard.battleship.getStatus(), "hit");
    }
}

import org.hemickman.Dashboard;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class BattleshipsTest {
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
        for (int i=0; i<5; i++) assertEquals(battleshipDash[4][5+i], 'X');
    }
}
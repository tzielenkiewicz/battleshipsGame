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
        for (int row = 0; row <10; row ++) {
            for (int col = 0; col <10; col ++) {
                assertEquals(empty[row][col], ' ');
            }
        }
    }
   @Test
    public void canCreateDashboardOfA() {
        char[][] tenA = Dashboard.createDashboardOfA(10);
        for (int row = 0; row <10; row ++) {
            for (int col = 0; col <10; col ++) {
                assertEquals(tenA[row][col], 'A');
            }
        }
    }
}
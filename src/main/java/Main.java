import org.hemickman.Dashboard;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        for (int row = 0; row <10; row ++) {
            for (int col = 0; col < 10; col++) {
                System.out.println(Dashboard.createEmptyDashboard(10)[0][0]);
            }
        }
    }
}

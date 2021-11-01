import org.hemickman.Dashboard;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        Random generator = new Random();
        int number1 = Math.round(generator.nextInt(10));
        int number2 = Math.round(generator.nextInt(10));
        Dashboard.displayDashboard(Dashboard.createRandomGridDashboard(number1, number2));

    }





}

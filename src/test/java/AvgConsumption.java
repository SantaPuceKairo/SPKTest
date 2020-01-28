import org.junit.jupiter.api.Test;

public class AvgConsumption {
   @Test
    public void avgConsumption(){
       calculateConsumption(19.16,209);
    }
    private void calculateConsumption(double f, int d) {
        System.out.println("You used " + f + " liters of fuel.");
        System.out.println("You drove " + d + " km long distance.");
        System.out.println("Your average consumption is " + String.format("%.1f",(((f / d) * 100))) + " liters/100 km!");
    }
}
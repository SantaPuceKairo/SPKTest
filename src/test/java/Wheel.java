import org.junit.jupiter.api.Test;

public class Wheel {
    @Test
    public void wheelRevolutions() {
        amountOfRpm(40.64);
    }

    private void amountOfRpm(double r) {

        System.out.println("Wheel radius is: " + r + " cm.");
        System.out.println("Wheel circumference is: " + String.format("%.2f",(2 * Math.PI * r)) + " cm."); //C = 2 π R (in cm)
        System.out.println("Wheel circumference converting in km is: " + String.format("%.3f",(2 * Math.PI * r / 100000)) + " km.");
        System.out.println("Wheel revolutions in 1000 km is: " + String.format("%.2f", (1000 / (2 * Math.PI * r / 100000)))); //1 C = 1 revolution; distance/C

    }
}



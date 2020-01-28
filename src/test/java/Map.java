import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class Map {
    @Test
    public void distance(){

        distCalc(5, 11, 6, 8);
    }
    private void distCalc(int x1, int x2, int y1, int y2){

        System.out.println("Enter coordinate X1: " + x1);
        System.out.println("Enter coordinate X2: " + x2);
        System.out.println("Enter coordinate Y1: " + y1);
        System.out.println("Enter coordinate Y2: " + y2);
        System.out.println("Distance between both points is: " + String.format("%.2f",Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)))));

           }
}

import static java.lang.Math.cos;
import java.io.PrintStream;
import java.io.IOException;

public class math {
        public static void main(String args[]) throws IOException {
            // creates a file named equation.txt for saving our output
            PrintStream output = new PrintStream("equation.txt");
            System.setOut(output);

            // gets the total value that we need to maximize
            System.out.print("max: ");
            for (int i = 1; i <= 50; i++) {
                // gets value for each object
                double value = Math.floor(100 + 50 * cos(i));
                System.setOut(output);
                System.out.print("+" + value + " x\\_{" + i +"} ");
            }
            System.setOut(output);
            System.out.println(";");

            // first constraint: weight <= 1000
            for (int t = 1; t <= 50; t++){
                // gets weight for each object
                double weight = Math.floor(100 + 50 * cos(5 * t - 3));
                System.setOut(output);
                System.out.print("+" + weight + " x\\_{" + t + "} ");
            }
            System.out.println(" leq 1000" + ";");
            // second constraint: volume <= 1000
            for (int q = 1; q <= 50; q++){
                // gets volume for each object
                double volume = Math.floor(100 + 50 * cos(3 * q + 11));
                System.out.print("+" + volume + " x\\_{" + q + "} ");
            }
            System.out.println(" leq 1000" + ";");

            // third constraint: all the x should be binary integer, 0 or 1
            System.setOut(output);
            System.out.print("bin ");
            for (int n = 1; n <= 49; n++){
                System.setOut(output);
                System.out.print("x_{" + n + "}, ");
            }
            System.setOut(output);
            System.out.print("x_" + 50 +";");
        }
}




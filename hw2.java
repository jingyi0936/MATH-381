import static java.lang.Math.sin;
import java.io.PrintStream;
import java.io.IOException;

public class hw2 {
    public static void main(String args[]) throws IOException {
        // creates a file named hw2.txt for saving our output
        PrintStream output = new PrintStream("hw2.txt");

        int n = 4;

        // gets objective function
        System.setOut(output);
        System.out.print("min: ");
        for (int i = 1; i <= n; i++) {
            // gets value for each object
            System.setOut(output);
            System.out.print("+" + "y_" + i);
        }
        System.setOut(output);
        System.out.println(";");

        // first constraint: sum of x_i_k = 1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("+x_" + i + "_" + j);
            }
            System.out.print("= 1;");
        }
        System.out.println();

        // second constraint: x_i_k <= y_k
        for (int i = 1; i <= n; i++){
            System.setOut(output);
            for (int k = 1; k <= n; k++){
                System.out.print("x_" + i + "_" + k + "-y_"
                        + k + "<=0; ");
            }
            System.out.println();
        }
        System.out.println();



        // third constraint: x_i_k + x_j_k <= 1
        for (int i = 1; i <= n - 1; i++){
            for (int j = i + 1; j <= n; j++){
                double number;
                number = sin(i) + sin(j);
                // prints all the sin(i) + sin(j)
                // System.out.println("(" + i + ", " + j + ") and"
                // + number);

                // if sin(i) + sin(j) < 0
                if (number < 0){
                    for (int k = 1; k <= n; k++){
                        System.out.print("x_" + i + "_" + k
                                + "+x_" + j + "_" + k + "<= 1;");
                        System.out.println();
                    }
                }
            }
        }
        System.setOut(output);
        System.out.println();


        // forth constraint: y_k <= y_k-1 meaning y_k - y_k-1 <= 0
        for (int i = 2; i <= n; i++){
            System.setOut(output);
            System.out.print("y_" + i + "-y_" + (i - 1) + "<=0; " );
        }
        System.setOut(output);
        System.out.println();

        // fifth constraint: x_i_k and y_i are binary variables
        System.setOut(output);
        System.out.print("bin ");
        for (int i = 1; i <= n; i++) {
            System.setOut(output);
            System.out.print("y_" + i + ", ");
        }
        for(int i = 1; i <= n; i++){
            System.setOut(output);
            for (int m = 1; m <= n; m++){
                if(i == n && m == n){
                    System.out.print("x_" + n + "_" + n + "; ");
                }else {
                    System.out.print("x_" + i + "_" + m + ", ");
                }
            }
        }
    }
}

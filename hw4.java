import java.io.PrintStream;
import java.io.IOException;

public class hw4 {
    public static void main(String args[]) throws IOException {
        // creates a file named hw4.txt for saving our output
        PrintStream output = new PrintStream("hw4.txt");
        System.setOut(output);

        int total_city = 10;
        int step = 6;

        double[][] distance = new double[15][15];
        distance[1][2] = distance[2][1] = 2562.82; distance[1][3] = distance[3][1] = 1943.43;
        distance[1][4] = distance[4][1] = 1971.80; distance[1][5] = distance[5][1] = 2413.07;
        distance[1][6] = distance[6][1] = 807.96; distance[1][7] = distance[7][1] = 1028.52;
        distance[1][8] = distance[8][1] = 1723.40; distance[1][9] = distance[9][1] = 1459.04;
        distance[1][10] = distance[10][1] = 1054.80;
        distance[2][3] = distance[3][2] = 2421.32; distance[2][4] = distance[4][2] = 2431.94;
        distance[2][5] = distance[5][2] = 1604.21; distance[2][6] = distance[6][2] = 2649.19;
        distance[2][7] = distance[7][2] = 2825.08; distance[2][8] = distance[8][2] = 1952.25;
        distance[2][9] = distance[9][2] = 1493.32; distance[2][10] = distance[10][2] = 2227.47;

        distance[3][4] = distance[4][3] = 17.12; distance[3][5] = distance[5][3] = 3386.53;
        distance[3][6] = distance[6][3] = 1155.91; distance[3][7] = distance[7][3] = 1169.00;
        distance[3][8] = distance[8][3] = 490.37; distance[3][9] = distance[9][3] = 1082.52;
        distance[3][10] = distance[10][3] = 894.26;

        distance[4][5] = distance[5][4] = 3402.04; distance[4][6] = distance[6][4] = 1169.92;
        distance[4][7] = distance[7][4] = 1180.84; distance[4][8] = distance[8][4] = 504.23;
        distance[4][9] = distance[9][4] = 1097.67; distance[4][10] = distance[10][4] = 910.76;

        distance[5][6] = distance[6][5] = 3006.94; distance[5][7] = distance[7][5] = 3196.23;
        distance[5][8] = distance[8][5] = 2907.45; distance[5][9] = distance[9][5] = 2305.98;
        distance[5][10] = distance[10][5] = 2763.93;

        distance[6][7] = distance[7][6] = 191.57; distance[6][8] = distance[8][6] = 1119.64;
        distance[6][9] = distance[7][6] = 1199.72; distance[6][10] = distance[10][6] = 459.05;

        distance[7][8] = distance[8][7] = 1210.60; distance[7][9] = distance[9][7] = 1359.64;
        distance[7][10] = distance[10][7] = 608.96;

        distance[8][9] = distance[9][8] = 602.4; distance[8][10] = distance[10][8] = 707.23;
        distance[9][10] = distance[10][9] = 750.98;

        // gets objective function
        System.setOut(output);
        System.out.print("min: ");
        for (int a = 1; a <= total_city; a++) {
            for (int b = 1 + a; b <= total_city; b++) {
                System.out.print("+" + distance[a][b] + "e_" + a + "_" + b + "+" + distance[a][b] + "e_" + b + "_" + a);
            }
        }
        System.out.println(";");
        System.out.println();

        // first constraint
        System.setOut(output);
        for (int i = 1; i <= step; i++) {
            for (int j = 1; j <= total_city; j++) {
                System.out.print("+x_" + i + "_" + j);
            }
            System.out.println("= 1;");
        }
        System.out.println();

        // second constraint
        System.setOut(output);
        for (int i = 1; i <= total_city; i++) {
            for (int j = 1; j <= step; j++) {
                System.out.print("+x_" + j + "_" + i);
            }
            System.out.println(" <= 1;");
        }
        System.out.println();

        // third constraint
        for (int a = 1; a <= total_city; a++) {
            for (int b = a + 1; b <= total_city; b++) {
                for (int i = 1; i <= step - 1; i++) {
                    System.out.println("+e_" + a + "_" + b + " - x_" + i + "_" + a + " - x_" + (i + 1) + "_" + b + " + 1 >= 0;");
                    System.out.println("+e_" + b + "_" + a + " - x_" + i + "_" + b + " - x_" + (i + 1) + "_" + a + " + 1 >= 0;");
                }
            }
        }
        System.out.println();

        // forth constraint
        for (int i = 1; i <= step - 1; i++) {
            for (int a = 1; a <= total_city; a++) {
                for (int b = 1 + a; b <= total_city; b++) {
                    System.out.println("3f_" + i + "_" + a + "_" + b + " - 1 - x_" + i + "_" + a + " - x_" + (i + 1) + "_" + b + "<= 0;");
                    System.out.println("3f_" + i + "_" + b + "_" + a + " - 1 - x_" + i + "_" + b + " - x_" + (i + 1) + "_" + a + "<= 0;");
                }
            }
        }
        System.out.println();

        // fifth constraint
        for (int i = 1; i <= step - 1; i++) {
            for (int a = 1; a <= total_city; a++) {
                for (int b = 1 + a; b <= total_city; b++) {
                    System.out.println("3f_" + i + "_" + a + "_" + b + " + 1 - x_" + i + "_" + a + " - x_" + (i + 1) + "_" + b + ">= 0;");
                    System.out.println("3f_" + i + "_" + b + "_" + a + " + 1 - x_" + i + "_" + b + " - x_" + (i + 1) + "_" + a + ">= 0;");
                }
            }
        }
        System.out.println();

        // sixth constraint
        for (int a = 1; a <= total_city; a++) {
            for (int b = 1 + a; b <= total_city; b++) {
                for (int i = 1; i <= step - 1; i++) {
                    System.out.print(" +f_" + i + "_" + a + "_" + b);
                }
                System.out.println(" - e_" + a + "_" + b + ">= 0;");
            }
        }
        System.out.println();

        for (int b = 1; b <= total_city; b++) {
            for (int a = 1 + b; a <= total_city; a++) {
                for (int i = 1; i <= step - 1; i++) {
                    System.out.print(" +f_" + i + "_" + a + "_" + b);
                }
                System.out.println(" - e_" + a + "_" + b + ">= 0;");
            }
        }
        System.out.println();

        // seventh constraint
        System.out.print("bin ");
        for (int i = 1; i <= step; i++) {
            for (int j = 1; j <= total_city; j++) {
                System.out.print("x_" + i + "_" + j + ",");
            }
        }
        for (int a = 1; a <= total_city; a++){
            for (int b = 1 + a; b <= total_city; b++){
                System.out.print("e_"+ a + "_" + b + ",");
            }
        }
        for (int i = 1; i <= step-1; i++){
            for(int a = 1; a <= total_city; a++){
                for (int b = 1 + a; b <= total_city; b++){
                        System.out.print("f_" + i + "_" + a + "_" + b + ",");
                        System.out.print("f_" + i + "_" + b + "_" + a +",");
                    }
                }
            }
        }
    }




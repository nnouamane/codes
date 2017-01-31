package codingame.temperature;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Temperature {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = getTemps(in.nextLine()); // the number of temperatures to analyse

        if (n > 0 ) {
            String[] tempTab = in.nextLine().split("\\s");
            int min = getTemps(tempTab[0]);

            for (int i = 1; i < tempTab.length; i++) {
                int temps = getTemps(tempTab[i]);

                if (Math.abs(temps) == Math.abs(min) && temps != min) {
                    min = Math.abs(temps);
                }
                else if (Math.abs(temps) < Math.abs(min)) {
                    min = temps;
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.out.println(min);
        } else {
            System.out.println(0);
        }
    }

    private static int getTemps(String t) {
        int temps;
        if (t.equals("")) {
            temps = 0;
        } else {
            temps = Integer.valueOf(t); // the n temperatures expressed as integers ranging from -273 to 5526
        }
        return temps;
    }
}
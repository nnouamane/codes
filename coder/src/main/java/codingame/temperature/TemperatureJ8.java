package codingame.temperature;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.util.Arrays.stream;

/**
 * Created by nomane on 05/01/2017.
 */
public class TemperatureJ8 {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        if (n > 0 ) {
            String[] tempTab = in.nextLine().split("\\s");

            Integer min = stream(tempTab)
                    .map(t -> t.isEmpty() ? 0 : Integer.valueOf(t))
                    .reduce((x,y) -> getMin(x,y))
                    .get();

            System.out.println(min);
        } else {
            System.out.println(0);
        }
    }

    private static int getMin(int current, int closest) {
        if (abs(closest) == abs(current)) {
            current = max(current, closest);
        }
        else if (abs(closest) < abs(current)) {
            current = closest;
        }
        return current;
    }
}
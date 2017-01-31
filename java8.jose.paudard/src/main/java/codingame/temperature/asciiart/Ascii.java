package codingame.temperature.asciiart;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

public class Ascii {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        char[] chars = T.toCharArray();
       // printA(L, H);
        printE(L, H);
        System.out.print("    ");
       // printB(L, H);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }

    private static void printA(int l, int h) {
        if (l%2 == 0) l = l - 1;
        if (h%2 == 0) h = h - 1;
        printAtPosition(l/2);
        printExtremInColumn(l, h/2);
        printFull(l);
        printExtremInColumn(l, h/2 +1);

    }

    private static void printE(int l, int h) {
        if (l%2 == 0) l = l - 1;
        if (h%2 == 0) h = h - 1;
        printFull(l);
        for(int i = 1; i <= l/2; i++) printAtPosition(1);
        printAllMinusOn(l, false);
        for(int i = 1; i <= l/2; i++) printAtPosition(1);
        printFull(l);
    }

    private static void printExtremInColumn(int l, int c) {
        for(int i = 1; i < c; i++)
            printExtremity(l);
    }

    private static void printMinusOneInColumn(int l, int c) {
        for(int i = 1; i < c; i++)
            printAllMinusOn(l, false);
    }

    private static void printExtremity(int l) {
        printCharTimes('#', 1);
        printCharTimes(' ', l - 2);
        printCharTimes('#', 1);
        System.out.println();
    }
    private static void printAtPosition(int l, int position) {
        if (position > 1)
            printCharTimes(' ', position - 1);
        printCharTimes('#', 1);
        System.out.println();
    }

    private static void printAllMinusOn(int l, boolean blancFirst) {
        if(blancFirst)
            System.out.print(" ");
        printCharTimes('#', l - 1);
        System.out.println();
    }

    private static void printFull(int l) {
        printCharTimes('#', l);
        System.out.println();
    }

    private static void printB(int l, int h) {

        printCharTimes('#', 1);
        System.out.println();
        printCharTimes('#', 2);
        System.out.println();
        printCharTimes('#', 3);
        System.out.println();
        printCharTimes('#', 2);
        System.out.println();
        printCharTimes('#', 1);
    }

    private static void printCharTimes(char c, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(c);
        }
    }
}
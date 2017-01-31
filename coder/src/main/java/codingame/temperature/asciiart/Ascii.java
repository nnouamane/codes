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

        // printB(L, H);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }

    private static void printA(int largeur, int h) {
        boolean isLargeurPair = false;
        if (largeur%2 == 0) {
            largeur = largeur - 1;
            isLargeurPair = true;
        }
        if (h%2 == 0) h = h - 1;
        printOneAtPosition(largeur, largeur/2, isLargeurPair);
        printExtremInColumn(largeur, h/2);
        printFull(largeur, isLargeurPair);
        // System.out.println();
        printExtremInColumn(largeur, h/2 +1);
    }

    private static void printE(int largeur, int h) {
        boolean isLargeurPair = false;
        if (largeur%2 == 0) {
            largeur = largeur - 1;
            isLargeurPair = true;
        }
        if (h%2 == 0) {
            h = h - 1;
        }
        printFull(largeur, isLargeurPair);
        System.out.println();
        for(int i = 1; i <= largeur/2; i++)
            printOneAtPosition(largeur, 1, isLargeurPair);
        printAllMinusOn(largeur, false, isLargeurPair);
        for(int i = 1; i <= largeur/2; i++)
            printOneAtPosition(largeur, 1, isLargeurPair);
        printFull(largeur, isLargeurPair);
    }

    private static void printExtremInColumn(int l, int c) {
        for(int i = 1; i < c; i++)
            printExtremity(l);
    }

    private static void printMinusOneInColumn(int l, int c) {
        for(int i = 1; i < c; i++)
            printAllMinusOn(l, false, true);
    }

    private static void printExtremity(int l) {
        printCharTimes('#', 1);
        printCharTimes(' ', l - 2);
        printCharTimes('#', 1);
        System.out.println();
    }
    private static void printOneAtPosition(int largeur, int position, boolean isLargeurPair) {
        printCharTimes(' ', position - 1);
        printCharTimes('#', 1);
        printCharTimes(' ', largeur - position);
        if(isLargeurPair)
            System.out.print(' ');
        System.out.println();
    }

    private static void printAllMinusOn(int l, boolean blancFirst, boolean isLargeurPair) {
        if(blancFirst) {
            System.out.print(' ');
            printCharTimes('#', l - 1);
        } else {
            printCharTimes('#', l - 1);
            System.out.print(' ');
        }
        if(isLargeurPair)
            System.out.print(' ');
        System.out.println();
    }

    private static void printFull(int largeur, boolean isPair) {
        printCharTimes('#', largeur);
        if(isPair)
            System.out.print(' ');
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
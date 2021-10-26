package math;

import java.util.Scanner;

public class Main {

    public static float a, b, c, D, X1;
    public static double x1, x2, X;
    public static String symb;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("A = ");
        a = scan.nextFloat();
        scan.nextLine();

        System.out.print("B = ");
        b = scan.nextFloat();
        scan.nextLine();

        System.out.print("C = ");
        c = scan.nextFloat();
        scan.nextLine();

        printLineOrNot();
    }

    public static void printLineOrNot() {
        if (D >= 0) {
            if (a != 0) {
                System.out.println("Квадратная функция");
                printFunc();
                printDisc();
                printx1x2();
            } else {
                System.out.println("Линейная функция");
                printLineFunc();
            }
        } else {
            System.out.println("No answers");
        }
    }

    public static void printx1x2() {
        if (D == 0) {
            X = (-b) / (2 * a);
            System.out.printf("X = %.1f", X);
        } else {
            prx1();
            System.out.println("");
            prx2();
        }
    }

    public static void printFunc() {
        System.out.printf("y = %.1fx^2 + %.1fx + %.1f%n", a, b, c);
    }

    public static void printDisc() {
        D = (b * b - 4 * a * c);
        System.out.printf("D = %.1f * %.1f - 4 * %.1f * %.1f = %.1f%n", b, b, a, c, D);
    }

    public static void prx1() {
        x1 = (-b + Math.sqrt(D)) / (2 * a);
        System.out.printf("X1 = %.1f", x1);
    }

    public static void prx2() {
        x2 = (-b - Math.sqrt(D)) / (2 * a);
        System.out.printf("X2 = %.1f", x2);
    }

    public static void printLineFunc(){
        Scanner scan = new Scanner(System.in);

        System.out.printf("y = %.1fx + %.1f%n", b, c);
        System.out.printf("%.1fx + %.1f = 0%n", b, c);

        System.out.print("Symbol is: ");
        symb = scan.nextLine();
        System.out.printf("%.1fx + %.1f %s 0%n", b, c, symb);

        X1 = c/b;
        System.out.printf("x = %.1f", X1);
    }
}
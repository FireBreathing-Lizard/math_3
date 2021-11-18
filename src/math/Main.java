package math;

import java.util.Scanner;

public class Main {

    public static float a, b, c, D, mc, f1, f2;
    public static double x1, x2, X, kor, Minx, Maxx;
    public static String symb, convert;


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

        System.out.print("Symbol is: ");
        symb = scan.nextLine();

        D = (b * b - 4 * a * c);
        kor = Math.sqrt(D);

        printLineOrNot();
    }


    private static void printLineOrNot() {
        if (a == 0) {
            System.out.println("Линейное неравенство:\n ");

            System.out.printf("%.0fx + %.0f %s 0%n", b, c, symb);
            System.out.printf("%.0fx %s %.0f%n", b, symb, mc = c * -1);
            System.out.printf("x %s %.0f%n", change(b, symb), mc / b);

        } else {
            System.out.println("Квадратное неравенство:\n ");

            convert = String.format("%.0fx² + %.0fx + %.0f %s 0%n", a, b, c, symb);
            convert = convert.contains("+ -") ? convert.replace("+ -", "- ") : convert;
            System.out.println(convert);
            neravenstvo();

            printx1x2();
        }
    }


    private static void neravenstvo() {
        if (a < 0) {
            a = a * -1;
            b = b * -1;
            c = c * -1;
            symb = symb.contains(">") ? symb.replace(">", "<") : symb.replace("<", ">");
            convert = String.format("%.0fx² + %.0fx + %.0f %s 0%n", a, b, c, symb);
            convert = convert.contains("+ -") ? convert.replace("+ -", "- ") : convert;
            System.out.println(convert);
        }
    }

    public static String change(float num, String symbol) {
        if (num < 0) {
            symbol = symbol.contains(">") ? symbol.replace(">", "<") : symbol.replace("<", ">");
        } else {
            symbol = symbol.replace("<", ">");
        }
        return symbol;
    }

    public static void printx1x2() {
        if (D < 0) {
            System.out.println("Нет корней");
            return;
        }

        //DiscAndKor();
        if (D == 0) {

            X = (-b) / (2 * a);
            x1 = (X - 1);
            x2 = (X + 1);
            f1 = (float) (a * x1 * x1 + b * x1 + c);
            f2 = (float) (a * x2 * x2 + b * x2 + c);

            if ((symb.equals(">") && f1 < 0 && f2 < 0) || (symb.equals("<") && f1 > 0 && f2 > 0)) {
                System.out.println("Неравенство не имеет решений");
            }
            if ((symb.equals(">=") && f1 < 0 && f2 < 0) || (symb.equals("<=") && f1 > 0 && f2 > 0)) {
                System.out.printf("X = %.1f%n", X);
            }

            if ((symb.contains(">") && f1 > 0) || (symb.contains("<") && f1 < 0)) {
                System.out.printf("X %s %.1f%n", symb.contains("=") ? ">=" : ">", X);
            }
            if ((symb.contains(">") && f2 > 0) || (symb.contains("<") && f2 < 0)) {
                System.out.printf("X %s %.1f%n", symb.contains("=") ? "<=" : "<", X);
            }

        } else {
            prx12();
        }

    }

    public static void prx12() {
        x1 = (-b + Math.sqrt(D)) / (2 * a);
        x2 = (-b - Math.sqrt(D)) / (2 * a);

        Minx = Math.min(x1, x2);
        Maxx = Math.max(x1, x2);

        if (symb.contains(">")) {
            System.out.printf("X %s %.1f, X %s %.1f%n", change(a, symb), Minx, symb, Maxx);
        } else {
            System.out.printf("%.1f %s X %s %.1f%n", Minx, symb, symb, Maxx);
        }

    }

    public static void DiscAndKor() {
        System.out.println(D);
        System.out.println(kor);
    }
}

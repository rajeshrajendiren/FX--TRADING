// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Trading T = new Trading();
        do {
            System.out.println("---------------Welcome to FX Trading----------------");
            System.out.println("----------------------------------------------------");
            System.out.println("Book  Trade-1");
            System.out.println("Print Trade-2");
            System.out.println("Exit       -3");
            System.out.println("----------------------------------------------------");
            System.out.println("Enter Your Choice:");
            int opt = s.nextInt();
            if (opt == 1) {
                T.bookTrade();
            } else if (opt == 2) {
                T.printTrade();
            } else if (opt == 3) {
                System.out.println("Do you really want to exit(y/n):");
                char option = s.next().charAt(0);
                if (T.exit(option) == 0) {
                    System.out.println("return to trade");
                } else if (T.exit(option) == 1) {
                    System.out.println("bye-have a good day:");
                    break;
                } else {
                    System.out.println("Invalid Input");
                }
            } else {
                System.out.println("please,provide valid choice.");
            }


        } while (true);

    }
}
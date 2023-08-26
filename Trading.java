

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;

public class Trading implements FXtrading {
    static int TradeNo = 1;
    String Amt;
    ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
    Scanner s = new Scanner(System.in);
    NumberFormat numberformat = NumberFormat.getNumberInstance(Locale.US);
    double rate = 66.0;
    double TransferAmt;
    String name;
    String CurrencyPair;

    private double conversion(double t) {
        return rate * t;
    }


    private void currencyPair() {
        CurrencyPair = s.next();
        if (!(CurrencyPair.equalsIgnoreCase("USDINR"))) {
            System.out.println("Sorry,this trade based on only USDINR");
            currencyPair();
        }
    }


    private boolean isValidName(String n) {

        String regex = "^[a-zA-Z\\s]+$";
        if (n.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    private void getRateornot() {
        String opt = s.next();
        if (opt.equalsIgnoreCase("yes")) {

            System.out.println("you are transfering INR " + numberformat.format(conversion(TransferAmt)) + " to " + name + ".");
        } else if (opt.equalsIgnoreCase("no")) {
        } else {
            System.out.println("provide yes or no other inputs are invalid");
            getRateornot();
        }

    }

    private void getName() {
        name = s.next();
        if (!(isValidName(name))) {
            System.out.println("invalid,please provide name in alphabet");
            getName();
        }
    }


    private void bookorcancel() {
        String opt1 = s.next();
        if (opt1.equalsIgnoreCase("Book")) {
            ArrayList<Object> row = new ArrayList<Object>();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|Trade for USDINR has been booked with rate " + rate + ", The amount of Rs " + numberformat.format(conversion(TransferAmt)) + " will be transferred in 2 working days to " + name + ".|");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            row.add(TradeNo);
            row.add(this.CurrencyPair.toUpperCase());
            row.add(this.name);
            row.add("INR" + this.numberformat.format(conversion(this.TransferAmt)));
            row.add(this.rate);
            table.add(row);
            TradeNo++;
        } else if (opt1.equalsIgnoreCase("Cancel")) {
            System.out.println("trade is canceled");


        } else {
            System.out.println("provide book or date other inputs are invalid");
            bookorcancel();
        }
    }

    private void tranferAmt() {

        Amt = s.next();
        if (Amt.matches("^[0-9]+(\\.[0-9]*)?$")) {
            TransferAmt = Double.parseDouble(Amt);
        } else {
            System.out.println("Amount must be Number.");
            tranferAmt();
        }
    }

    public void bookTrade() {
        System.out.println("Enter Customer Name:");
        getName();
        System.out.println("Enter Currency Pair:");
        currencyPair();
        System.out.println("Enter amount to transfer:");
        tranferAmt();
        System.out.println("Do you want to get Rate?:");
        getRateornot();
        System.out.println("Book/Cancel this trade?:");
        bookorcancel();
    }


    public void printTrade() {
        System.out.println("TradeNo  CurrencyPair   CustomerName      Amount    Rate");
        for (ArrayList out : table) {
            for (Object in : out) {
                System.out.print(in + "          ");
            }
            System.out.println("\n");
        }
    }

    public int exit(char opt) {

        if (opt == 'y' || opt == 'Y') {
            return 1;
        } else if (opt == 'n' || opt == 'N') {
            return 0;
        } else {
            return -1;
        }
    }
}


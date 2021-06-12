/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0060.Bill;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static int checkIntInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int[] inputBill() {
        System.out.print("Input number of bill: ");
        int size = checkIntInput();
        int[] bill = new int[size];
        for (int i = 0; i < bill.length; i++) {
            System.out.print("Input value of bill " + (i + 1) + " : ");
            bill[i] = checkIntInput();
        }
        return bill;
    }

    public static int inputWallet() {
        System.out.print("Input value of wallet: ");
        int wallet = checkIntInput();
        return wallet;
    }

    public static int calcTotal(int[] bill) {
        int total = 0;
        for (int i = 0; i < bill.length; i++) {
            total += bill[i];
        }
        return total;
    }

    public static boolean payMoney(int total, int wallet) {
        if (wallet > total) {
            return false;
        } else {
            return true;
        }
    }

    public static void printTotalAndResult(int[] bill, int wallet) {
        int total = calcTotal(bill);
        System.out.println("This total of bill: " + total);
        if (!payMoney(total, wallet)) {
            System.err.println("You can buy it.");
        } else {
            System.err.println("You can't buy it.");
        }
    }

    public static void main(String[] args) {
        int []bill = inputBill();
        int wallet = inputWallet();
        printTotalAndResult(bill, wallet);
    }
}

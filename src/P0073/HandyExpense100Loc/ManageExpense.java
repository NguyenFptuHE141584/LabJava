/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0073.HandyExpense100Loc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ManageExpense {

    private static final Scanner sc = new Scanner(System.in);

    public int checkIntLimit(int min, int max) {

        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Re-input : ");
            }
        }
    }

    public String getDateString() {
        SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateOutput = new SimpleDateFormat("dd-MMM-yyyy");
        dateInput.setLenient(false);
        Date now = new Date();
        now.getTime();
        while (true) {
            try {
                System.out.print("Enter Date:");
                Date date = dateInput.parse(sc.nextLine());
                if (date.after(now)) {
                    System.out.println("Please input <= curent date!");
                    continue;
                }
                return dateOutput.format(date);
            } catch (Exception e) {
                System.err.println("Re-Input");

            }
        }
    }

    public double checkDoubleAmount() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (Exception e) {
                System.err.print("Re-Input : ");
            }
        }
    }

    public void addExpense(ArrayList<Expense> list) {
        int id = id(list);
        String date = getDateString();
        System.out.print("Enter Amount:");
        double amount = checkDoubleAmount();
        System.out.print("Enter Content:");
        String content = sc.nextLine();
        list.add(new Expense(id, date, amount, content));
    }

    public int checkIdExist(ArrayList<Expense> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int id(ArrayList<Expense> list) {
        int id = list.size() - 1;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(id).getId() + 1;

        }
        return id;
    }

    public void displayExpense(ArrayList<Expense> list) {
        if (list.size() == 0) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%s\n", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", list.get(i).getId(), list.get(i).getDate(),
                    list.get(i).getAmount(), list.get(i).getContent());
            total += list.get(i).getAmount();
        }
        System.out.printf("%15s:%10.0f\n", "Total", total);
    }

    public int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public void deleteExpense(ArrayList<Expense> list) {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        int checkIdExist = checkIdExist(list, id);
        if (checkIdExist != -1) {
            list.remove(checkIdExist);
            System.out.println("Delete an expense successful");
//            for (int i = id - 1; i < list.size(); i++) {
//                list.get(i).setId(list.get(i).getId() - 1);
//            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

    public void display() {
        ArrayList<Expense> le = new ArrayList<>();
        le.add(new Expense(1, "15-08-2000", 432, "dfaasddas"));
        le.add(new Expense(2, "15-08-2000", 432, "dfaasddas"));
        le.add(new Expense(3, "15-08-2000", 432, "dfaasddas"));
        int id = 0;
        while (true) {
            System.out.println("=====Handy Expense Program=====");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice : ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addExpense(le);
                    break;
                case 2:
                    displayExpense(le);
                    break;
                case 3:
                    deleteExpense(le);
                    break;
                case 4:
                    return;
            }
        }
    }
}

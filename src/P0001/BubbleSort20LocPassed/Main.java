/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0001.BubbleSort20LocPassed;

import java.util.Random;
import java.util.Scanner;
import sun.font.EAttribute;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static int checkIntInput() {
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

    public static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkIntInput();
        return n;
    }

    public static int[] inputValueOfArray(int n) {
        int[] arr = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arr[" + i + "]:");
            arr[i] = rd.nextInt(n);
        }
        return arr;
    }

    public static void sortArrayByBubbleSort(int[] arr) {
       
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("");

    }
    public static void display (int []arr){
        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int []arr = inputValueOfArray(n);
        System.out.print("Unsorted array: ");
        display(arr);
        sortArrayByBubbleSort(arr);
        System.out.print("Sorted array: ");
        display(arr);
    }
}

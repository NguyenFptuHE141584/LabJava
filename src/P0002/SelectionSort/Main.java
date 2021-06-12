/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0002.SelectionSort;

import java.util.Random;
import java.util.Scanner;

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
            arr[i] = rd.nextInt(n);
        }
        return arr;
    }

    public static void sortArrayBySelectionSort(int[] arr) {
          int n = arr.length;

        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
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
        sortArrayBySelectionSort(arr);
        System.out.println();
        System.out.print("Sorted array: ");
        display(arr);
    }
}

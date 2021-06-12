/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0010.LinearSearch50LocPassed;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class LinearSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of array:");
        int length = scanner.nextInt();
        scanner.nextLine();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        LinearSearch searcher = new LinearSearch();
        System.out.print("The array: ");
        searcher.displayArray(array);
        System.out.println("");
        System.out.print("Enter search value:");
        int search = scanner.nextInt();

        int foundIndex = searcher.linerSearch(array, search);
        System.out.println("\nFound " + search + " at index: " + foundIndex);
    }

    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public int linerSearch(int[] arr, int key) {

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}

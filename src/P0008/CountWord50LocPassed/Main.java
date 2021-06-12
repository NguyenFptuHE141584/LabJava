/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0008.CountWord50LocPassed;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input=Input.inputString();
        HashMap<String, Integer> word = Count.countWord(input);
        HashMap<Character, Integer> character=Count.countCharacter(input); 
        Count.display(word,character);
    }
}

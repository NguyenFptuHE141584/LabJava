/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0008.CountWord50LocPassed;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Input {
     public static String inputString(){
        Scanner in= new Scanner(System.in);
        System.out.println("Enter your content: ");
        while(true){      
            String str=in.nextLine().trim();
            if(str.isEmpty()){
                System.err.println("Can not be null!.");
                System.out.print("Try again: ");
                continue;
            }
            return str;
        }
    }
}

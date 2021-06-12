/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0011.Convert100Loc;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validate {

    public Scanner sc = new Scanner(System.in);

    public int getBase(String msg, String err) {

        while (true) {

            try {
                System.out.println(msg);
                int base = Integer.parseInt(sc.nextLine());
                if (base == 2 || base == 10 || base == 16) {
                    return base;
                }

            } catch (Exception e) {
                System.err.println(err);
            }
         //   System.err.println(err);
        }

    }

    public String getValue(String msg, String err, int base) {
        while (true) {
            try {
                System.out.println(msg);
                String value = sc.nextLine();
                switch (base) {
                    case 2:
                        if (value.matches("[0-1]+")) {
                            return value;
                        }
                        break;
                    case 10:
                        if (value.matches("[0-9]+")) {
                            return value;
                        }
                        break;
                    case 16:
                        if (value.matches("[0-9a-fA-F]+")) {
                            return value;
                        }
                }
            } catch (Exception e) {
                System.err.println(err);
            }
           // System.err.println(err);
        }
    }

}

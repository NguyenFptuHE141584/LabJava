/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0011.Convert100Loc;

/**
 *
 * @author ADMIN
 */
public class Convert {

    public int OtherToDec(String Other, int base) {
        int result = 0;
        // index của phần từ  = với giá trị của phần tử đó 
        String HEX = "0123456789ABCDEF";
        Other = Other.toUpperCase();
        for (int i = 0; i < Other.length(); i++) {
            result += HEX.indexOf(Other.charAt(i)) * Math.pow(base, Other.length() - 1 - i);
        }
        return result;
    }

    public StringBuilder DecToOther(int Dec, int base) {
        StringBuilder result = new StringBuilder("");
        String HEX = "0123456789ABCDEF";
        while (Dec > 0) {
            result.insert(0, HEX.charAt(Dec % base));
            Dec /= base;
        }
        return result;
    }
}

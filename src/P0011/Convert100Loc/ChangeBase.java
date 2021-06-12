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
public class ChangeBase {

    public static void main(String[] args) {
        Validate validate = new Validate();
        Convert convert = new Convert();
        while (true) {
            // NHAP INPUT BASE AND VALUE 
            int inBase = validate.getBase("Enter base input: ", "Base invalid , pls re-enter base input [2-10-16]!");
            String value = validate.getValue("Enter value input:", "Value invalid", inBase);

            // NHAP OUTPUT BASE 
            int outBase = validate.getBase("Enter base output", "Base invalid");
            System.out.println("------------------After change base------------------");
            System.out.println("The output:  ");

            //   System.out.print(value + " covert to " + outBase + " = ");
            if (inBase == 10) {
                System.out.println(convert.DecToOther(Integer.parseInt(value), outBase));
            } else {
                int decTmp = convert.OtherToDec(value, inBase);
                System.out.println(convert.DecToOther(decTmp, outBase));
            }
            System.out.println();

        }

    }
}

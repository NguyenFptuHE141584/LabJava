/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0074.Matrix100LocPassed;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Matrix {

    private static final Scanner sc = new Scanner(System.in);

    // hàm này để kiểm tra giá trị chọn chức năng cho chạy chương trình 
    private static int getIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Only 1 to 4 !!!");
            }
        }
    }
        // kiểm tra giá trị nếu bé thua hoặc bằng 0 thì không thể tạo được ma trận 
    private static int getSizeOfMatrix() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result <= 0) {
                    System.err.println("Can't create matrix");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Only natural number");
            }
        }
    }

    //
    private static int getInputElement(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Only nature number!!!");
            }
        }
    }


    // nhập giá trị của ma trận thứ nhất
    private static int[][] inputMatrix1(int n) {
        System.out.print("Enter Row Matrix " + n + ":");
        int row1 = getSizeOfMatrix();
        System.out.print("Enter Colum Matrix " + n + ":");
        int col1 = getSizeOfMatrix();
        int[][] matrix1 = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix1[i][j] = getInputElement("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            }

        }
        return matrix1;
    }


    private static int[][] inputMatrix2(int n, int[][] matrix1, String ope) {
        int row2;
        int col2;
        if (ope.equals("*")) {
            while (true) {
                System.out.print("Enter Row Matrix " + n + " : ");
                row2 = getSizeOfMatrix();
                if (row2 == matrix1[0].length) {
                    break;
                }
               
            }
             System.out.println("Enter Colum Matrix " + n + ":");
                col2 = getSizeOfMatrix();
        } else {
            while (true) {
                System.out.print("Enter Row Matrix " + n + " : ");
                row2 = getSizeOfMatrix();
                if (row2 == matrix1.length) {
                    break;
                }
            }
            while (true) {
                System.out.print("Enter Colum Matrix " + n + " : ");
                col2 = getSizeOfMatrix();
                if (col2 == matrix1[0].length) {
                    break;
                }
            }
        }
        int[][] matrix2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = getInputElement("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            }
        }
        return matrix2;
    }
    private static void displayMatrix(int[][] matrix){
        int row = matrix.length;
        int col =  matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("["+ matrix[i][j]+"]");
            }
            System.out.println("");
        }
        
    }
       private  static boolean checkMatrixAddition(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            return true;
        }
        return false;
    }

    private static void CalculatorMatrix(String ope) {
        int[][] matrix1 = inputMatrix1(1);
        int[][] matrix2 = null;
        //calculator multiplication
        if (ope.equals("*")) {
            matrix2 = inputMatrix2(2, matrix1, "*");
            multiplicationMatrix(matrix1, matrix2);
        } else {
            matrix2 = inputMatrix2(2, matrix1, "");
            //calculator addition
            if (ope.equals("+")) {
                additionMatrix(matrix1, matrix2);
            } //calculator subtraction
            else if (ope.equals("-")) {
                subtractionMatrix(matrix1, matrix2);
            }
        }
    }

    private static void additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("----------Result----------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        //run from first to last element in row
        for (int i = 0; i < row; i++) {
            //run from first to last element in col
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    private static void subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("----------Result----------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        //run from first to last element in row
        for (int i = 0; i < row; i++) {
            //run from first to last element in col
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    private static void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("----------Result----------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] matrixResult = new int[row1][col2];
        //run from fir
        for (int i = 0; i < row1; i++) {
            //run from first to last element in col
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        
        /*
              A[3][4]                      B[4][2]
        
        i..j 0 1 2 3               //0 1 
        0    2 5 4 9  
        1    3 3 2 0 
        2    4 3 6 8 
       
        
        */
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(matrixResult);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = getIntLimit(1, 4);
            switch (choice) {
                case 1:
                    CalculatorMatrix("+");
                    break;
                case 2:
                    CalculatorMatrix("-");
                    break;
                case 3:
                    CalculatorMatrix("*");
                    break;
                case 4:
                    return;
            }
        }
    }

}

package JavaBasics;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first Number");
        int num1 = scanner.nextInt();

        System.out.println("Enter secound number");
        int num2 = scanner.nextInt();

        /*int maximum = Math.max(num1,num2);*/
        int maximum = (num1 < num2) ? num1 : num2;
        /*int smaller ;
        if (num1 < num2){
        smaller =num1;
        }
        else {
        smaller = num2;
        }*/
        /*This line uses the ternary operator to compare num1 and num2. If num1 is
        greater than num2, then num1 is assigned to maximum; otherwise, num2 is assigned to maximum.*/
        System.out.println("maximun number is  :" + maximum);
        scanner.close();
    }
}

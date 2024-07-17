package JavaBasics;

import java.util.Scanner;

public class Ex6Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find Fibonacci series up to that number: ");
        int number = scanner.nextInt();

        int a= 0,b=1;
        System.out.println("Fibonacci series up to " + number + ":" + a + " " + b + " ");

        while (true){
        int nextfib = a+b;
        if (nextfib > number){
        break;
        }
            System.out.println(nextfib + " ");
            a =b;
            b=nextfib;

        }



    }
}

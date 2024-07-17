package JavaBasics;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter Number to check Armstrong");
        int num = scanner.nextInt();
        int a = num;
        int n = num;
        int r  = 0;
        int sum = 0;
        while ( n>0){
        r=n%10;
        sum=(sum*10)+r;
        n=n/10;
        }
        if (sum == a){
            System.out.println(a +" is palindrome number");
        }else {
            System.out.println("Not palindrome number");
        }




    }
}

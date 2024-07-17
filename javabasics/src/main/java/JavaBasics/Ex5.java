package JavaBasics;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number to reverse");
        int num = scanner.nextInt();
        int r = 0;
        int  sum =0;
        int n = num;
        while (n > 0){
        r=n%10;
        sum = (sum * 10) +r;
        n=n/10;

        }
        System.out.println("Revers number would be " + sum);


    }
}

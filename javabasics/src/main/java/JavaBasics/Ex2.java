package JavaBasics;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first Number");
        int num1 = scanner.nextInt();

        System.out.println("Enter Second Number");
        int num2 =scanner.nextInt();
int smaller;
        /*int smaller = (num1 < num2) ? num1 : num2;*/
        if (num1 < num2){
        smaller = num1;
        }else {
            smaller=num2;
        }
        System.out.println("smaller is : " + smaller);
        scanner.close();
    }
}

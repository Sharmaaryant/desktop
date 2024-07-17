package JavaBasics;

public class Ex10 {
    public static void main(String[] args) {
        int number = 153;

        int  originalNumber  = number;
        int sum = 0;
        int digits =String.valueOf(number).length();

        while (originalNumber > 0 ){
        int digit = originalNumber % 10 ;
        sum += Math.pow(digit,digits);
        originalNumber /= 10 ;
        }
        if (sum == number){
            System.out.println(number + "is armstrong number");
        }else {
            System.out.println(number +" is not a armstrong number");
        }
    }
}

package JavaBasics;

public class ForLoopOod {
    public static void main(String[] args) {
        int  sum;
        sum = 0;
        for (int i = 1;i<=100;i=i+2){
            System.out.println(i);
            sum = sum +i;
        }
        System.out.println("sum = " + sum);
    }
}

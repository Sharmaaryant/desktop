package JavaBasics;

public class ForLoopEven {
    public static void main(String[] args) {
        int sum;
        sum = 0;
        for (int i =0;i<=10;i=i+2){
            System.out.println(i);
            sum = sum =i;
        }
        System.out.println("Sum = "+ sum);
    }
}

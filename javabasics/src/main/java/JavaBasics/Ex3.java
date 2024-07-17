package JavaBasics;

import java.util.Random;

public class Ex3 {
    public static void main(String[] args) {
       /* Random random = new Random();*/
        System.out.println("Random number");
        for (int i = 0 ; i < 5; i++){
      /*  int randonNumber = (int)random.nextInt(100)+1;*/
        int randonNumber = (int) (Math.random()*100) + 1;
            /*In the Random class version, random.nextInt(100) generates a random integer
            between 0 (inclusive)and 99 (exclusive).Adding 1 to this range shifts
            it to 1 (inclusive) and 100 (exclusive), which is the desired range.*/
            System.out.println(randonNumber);
        }
    }
}

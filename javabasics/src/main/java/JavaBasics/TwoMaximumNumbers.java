package JavaBasics;

public class TwoMaximumNumbers {
    public static void main(String[] args) {
        int[] n = {1, 2, 4, 5, 3, 6, 7};
        int a = 0;
        int b = 0;
        for (int i = 0; i < n.length; i++) {
            if (a < n[i]) {
                b = a;
                a = n[i];
            }
            if (b < n[i] && n[i] < a) {
                b = n[i];
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
}

package in.co.basic;

public class TestMultidimensional {
public static void main(String[] args) {
	int[][] table;
	table = new int[10][10];
	for (int i = 1; i <=10; i++) {
		for (int j = 1; j <=10; j++) {
			int a=  i * j ;
			table[i -1][j-1]=a;
			System.out.println(table[i-1][j-1]);
		}
		System.out.println();
	}
	
}
}

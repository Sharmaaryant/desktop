package in.co.basic;

public class TestArray {
public static void main(String[] args) {
	int[] table;
	table = new int[10];
	float[] farray= new float[10];
	double[] darray  = new double[10];
	char[] carray = new char[10];
	String[] sarray = new String[10];
 	table[0]=2;
	table[1]=4;
	table[2]=6;
	table[3]=8;
	table[4]=10;
	table[5]=12;
	table[6]=14;
	table[7]=16;
	table[8]=18;
	table[9]=20;
	
	int ele = table[6];
	System.out.println(ele);
	int sizee = table.length;
	System.out.println(sizee);
	String name= table.getClass().getName();
	System.out.println(name);
	
	
	
}
}

import java.util.Scanner;

public class test{
	private static Scanner get = new Scanner(System.in);
	private static int soma(int a){
		return a+1;
	}
	public static void main(String[] args){
		double test = get.nextDouble();
		test = test+soma(3);
		System.out.println(""+test);
	}
}

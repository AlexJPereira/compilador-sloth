public class out{
	public static void main(String[] args){
		int a[] = new int[2],b = 3,c[] = new int[2];
		/* vetor nao pode ser inicializado */
		c[0] = 1;
		c[1] = 2;
		int d = c[1];
		a[0] = b+c[0];
		a[1] = b*c[1];
		for(int num : a){
			System.out.print(num+" "+d);
		}
	}
}

public class test{
	private static void a(){
		System.out.print("test = ");
	}
	private static int b(char c){
		return c*2;
	}
	private static double c(int d){
		for(int i = 0; i<3; i=i+1){
			d = d+i;
		}
		return d+b('b');
	}
	public static void main(String[] args){
		a();
		System.out.print(c('f')+"\n");
	}
}

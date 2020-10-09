
public class RecursionTask {
	
	public static int Summation(int n) {
		//Base case: we are at the end
		if(n<=0) {
			return 0;
		}else { //Recursive Case: Keep going
			return n+Summation(n-1);
		}
		
	}
	public static int Factorial(int n) {
		if(n<=1) {
			return 1;
		}else {
			return n*Factorial(n-1);
		}
	}
	//5^3=5*5*5
	//563=5*5^2=
	public static int exponentiation(int n,int p) {
		if(p<=0) {
			return 1;
		}else {
			return n*exponentiation(n, p-1);
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(Summation(3));
		System.out.println(Factorial(3));
		System.out.println(exponentiation(5, 3));
	}

}

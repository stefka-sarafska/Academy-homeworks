
public class FibonacciDemo {
	public static void main(String[] args) {
		//System.out.println(fib(3));
		System.out.println(fibLoop(6));
	}
//0 1 1 2 3 5 8 13......
//	private static int fib(int numberIndex) {
//
//		if(numberIndex==0) {
//			return 0;
//		}
//		if(numberIndex==1) {
//			return 1;
//		}
//		//numberIndex=numberIndex-1;
//		//System.out.print(numberIndex+" ");
//		return fib(numberIndex-2)+fib(numberIndex-1);
//	}
	
	private static int fibLoop(int numberIndex) {
		
		
	
			int currFib=1;
			int prevFib=0;
			for(int i=2;i<=numberIndex;i++) {
				currFib=currFib+prevFib;
				prevFib=currFib-prevFib;
			}
		return currFib;
		
		
	
	}

}

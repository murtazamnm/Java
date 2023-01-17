package testingg;

import java.util.Iterator;

public class Fib {
	public static int fib(int n){
		if (n < 0) throw new IllegalArgumentException("Negative...");
		if(n==0) return 1;
		if(n == 1) return 1;
		return fib(n-1)+fib(n-2);
	}
	
	public static int[] fibSereies(int n){
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = fib(i);
		}
		return result;
	}
}

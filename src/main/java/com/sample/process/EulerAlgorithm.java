package com.sample.process;

/* 
 * Single instance to calculate sum
 */
public class EulerAlgorithm {
	
	public static EulerAlgorithm instance = new EulerAlgorithm();
	
	private EulerAlgorithm() {
		
	}
	
	public static synchronized EulerAlgorithm getInstance() {
		if ( instance == null )
			instance = new EulerAlgorithm();
		
		return instance;
	}
	
	public long findSum(int seed) {
		Long sum = 0L;
		for (int i = 1; i < seed; i++) {
			long divSum = calculateDivisorSum(i);
			
			if ( divSum != i && i == calculateDivisorSum(divSum))
					sum = sum + i;
		}
		return sum;
	}
	
	private long calculateDivisorSum(long n) {
		long sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0)
				sum += i;
		}
		return sum;
	}
	
}


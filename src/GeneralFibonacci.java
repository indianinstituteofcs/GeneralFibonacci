import java.util.Arrays;

class GeneralFibonacci {
	private int termsToAdd = 2;
	private long[] firstNTerms;
	private long[] calcSpace;
    private static final Boolean DEBUG_PRINT_TERMS = false;
    private static final String TERMS_TO_ADD = "TooFewTermsToAdd";
    private static final String LENGTH_MISMATCH = "NumberOfTermsDoesNotMatchTermsToAdd";


	GeneralFibonacci(int inTermsToAdd, long [] inFirstNTerms) throws ConstructorException {
		if (inTermsToAdd < 2) {
			throw new ConstructorException(TERMS_TO_ADD, "In F(n) = Sum(n-k <= j <= n-1)F(j). k must be => 2.");
		}

		if (inTermsToAdd !=  inFirstNTerms.length) {
			throw new ConstructorException(LENGTH_MISMATCH, "The number of initial terms provided must be same as k in F(n) = Sum(n-k <= j <= n-1)F(j).");
		}

		termsToAdd = inTermsToAdd;
		firstNTerms = inFirstNTerms;
		calcSpace = new long[termsToAdd];
	}

	
	private void slideOne() {
		long tempSum = calcSpace[0];	

		for(int i = 1; i < termsToAdd; i++) {
			calcSpace[i-1] = calcSpace[i];
			tempSum += calcSpace[i];
		}
		calcSpace[termsToAdd-1] = tempSum;
	}
	
	
	private void calculateNthTermAux(int nthTerm) {
		if (nthTerm == (termsToAdd - 1)) {
			calcSpace = firstNTerms.clone();
			return;
		}
		
		calculateNthTermAux(nthTerm - 1);
		slideOne();
	}

	
	public long calculateNthTerm(int nthTerm) {
		Arrays.fill(calcSpace,0);
 
		if (nthTerm < termsToAdd) {
			if(DEBUG_PRINT_TERMS) {
				System.out.println("Terms is an Initial Value of the Fibonacci Definition");			
			}
			return firstNTerms[nthTerm];
		}
		
		calculateNthTermAux(nthTerm);

		if (DEBUG_PRINT_TERMS) {
			for(int i = 0; i < termsToAdd; i++) {
				System.out.println("Value number " + (nthTerm + i + 2 - termsToAdd ) + " is: " + calcSpace[i]);			
			}
		}

		return calcSpace[termsToAdd -1];
	}
	
	
	public long calculateNthTermExp(int nthTerm) {
		if (nthTerm < termsToAdd) {
			if(DEBUG_PRINT_TERMS) {
				System.out.println("Terms is an Initial Value of the Fibonacci Definition");
			}
			return firstNTerms[nthTerm];
		}
		
		long answer = 0;

		for(int i = 0; i < termsToAdd; i++) {
			answer += calculateNthTermExp(nthTerm - 1 -i);		
		}

		return answer;
	}
	
	
	public long calculateNthTermIterative(int nthTerm) {
		if (nthTerm < termsToAdd) {
			if(DEBUG_PRINT_TERMS) {
				System.out.println("Terms is an Initial Value of the Fibonacci Definition");
			}
			return firstNTerms[nthTerm];
		}
		
		calcSpace = firstNTerms.clone();
		
		long nextTerm = 0;
		int indexNextTerm = termsToAdd - 1;

		while(indexNextTerm < nthTerm) {
			nextTerm = calcSpace[0];
			
			for(int i = 1; i < termsToAdd; i++) {
				calcSpace[i-1] = calcSpace[i];		
				nextTerm += calcSpace[i];		
			}
			
			calcSpace[termsToAdd - 1] = nextTerm;			
			indexNextTerm++;
		}

		return nextTerm;
	}

}

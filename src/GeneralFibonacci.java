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
	
	
    void printFibonacciDefinition() {
    	System.out.println("***********************");
    	System.out.println("General Fibonacci definition");
    	System.out.println("k = " + termsToAdd);
    	System.out.print("Initial Values: [");
    	int size = firstNTerms.length;
    	for (int i = 0; i < size; i++) {
    		if (i < (size - 1)) {
    			System.out.print(firstNTerms[i] +", ");
    		} else { System.out.println(firstNTerms[i] + "]"); }
    	}
    	System.out.println("***********************");
    }
    

	public void resetGeneralFibonacci(int inTermsToAdd, long [] inFirstNTerms) throws ConstructorException {
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


	
	private Long slideOne() {
		long tempSum = calcSpace[0];	

		for(int i = 1; i < termsToAdd; i++) {
			calcSpace[i-1] = calcSpace[i];
			tempSum += calcSpace[i];
		}
		calcSpace[termsToAdd-1] = tempSum;
		
		Long time = 4L + (termsToAdd - 1)*4;
		return time;
	}
	
	
	private Long calculateNthTermAux(int nthTerm) {
		if (nthTerm == (termsToAdd - 1)) {
			calcSpace = firstNTerms.clone();
			return (1L + termsToAdd);
		}
		
		Long time = calculateNthTermAux(nthTerm - 1);
		time += slideOne() + 1;
		
		return time;
	}

	
	public Pair<Long,Long> calculateNthTerm(int nthTerm) {
		Long time = Long.valueOf(termsToAdd);

		Arrays.fill(calcSpace,0);
 
		if (nthTerm < termsToAdd) {
			if(DEBUG_PRINT_TERMS) {
				System.out.println("Terms is an Initial Value of the Fibonacci Definition");			
			}
			time += 2;
			Pair<Long,Long> pairValue = new Pair<Long,Long>(firstNTerms[nthTerm],time);
			return pairValue;
		}
		
		time += calculateNthTermAux(nthTerm);

		if (DEBUG_PRINT_TERMS) {
			for(int i = 0; i < termsToAdd; i++) {
				System.out.println("Value number " + (nthTerm + i + 2 - termsToAdd ) + " is: " + calcSpace[i]);			
			}
		}

		Pair<Long,Long> pairValue = new Pair<Long, Long>(calcSpace[termsToAdd -1],time);
		return pairValue;		
	}
	
	
	public Pair<Long,Long> calculateNthTermExp(int nthTerm) {
		if (nthTerm < termsToAdd) {
			if(DEBUG_PRINT_TERMS) {
				System.out.println("Terms is an Initial Value of the Fibonacci Definition");
			}			
			Pair<Long,Long> pairValue = new Pair<Long,Long>(firstNTerms[nthTerm],2L);
			return pairValue;
		}
		
		Long answer = 0L;
		Long time = 2L;

		for(int i = 0; i < termsToAdd; i++) {
			Pair<Long,Long> pairValue = calculateNthTermExp(nthTerm - 1 -i);
			answer += pairValue.first();	
			time += pairValue.second() + 3;		
		}

		Pair<Long,Long> pairValue = new Pair<Long, Long>(answer,time);
		return pairValue;
	}
	
	
	public Pair<Long,Long> calculateNthTermIterative(int nthTerm) {
		if (nthTerm < termsToAdd) {
			if(DEBUG_PRINT_TERMS) {
				System.out.println("Terms is an Initial Value of the Fibonacci Definition");
			}
			Pair<Long,Long> pairValue = new Pair<Long,Long>(firstNTerms[nthTerm],2L);
			return pairValue;
		}
		
		calcSpace = firstNTerms.clone();
		
		Long nextTerm = 0L;
		Long time = 2L + termsToAdd;
		int indexNextTerm = termsToAdd - 1;

		while(indexNextTerm < nthTerm) {
			nextTerm = calcSpace[0];
			
			for(int i = 1; i < termsToAdd; i++) {
				calcSpace[i-1] = calcSpace[i];		
				nextTerm += calcSpace[i];		
			}
			
			calcSpace[termsToAdd - 1] = nextTerm;			
			indexNextTerm++;
			time += 4*(termsToAdd - 1) + 5;
		}
		
		Pair<Long,Long> pairValue = new Pair<Long, Long>(nextTerm,time);
		return pairValue;
	}

}

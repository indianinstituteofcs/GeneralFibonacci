import java.util.*;

public class Drive {

    static final Boolean DEBUG_FIBONACCI_DEFN = true;
    
    private static void printFibonacciDefinition(int termsToAdd, long [] initialValues) {
		if (DEBUG_FIBONACCI_DEFN) {
			System.out.println("Let F(n) = Sum(n-k <= j <= n-1)F(j)");
			System.out.println("k = " + termsToAdd);
			System.out.print("Initial Values: [");
			int size = initialValues.length;
			for (int i = 0; i < size; i++) {
				if (i < (size - 1)) {
					System.out.print(initialValues[i] +", ");
				} else { System.out.print(initialValues[i] + "]"); }
			}
			System.out.println(" ");
		}
    }
    
	public static void main(String[] args) {
		Scanner inputScan = new Scanner(System.in);
		int termsToAdd = 0; 
		
		while (termsToAdd < 2) {
			System.out.print("Input k such that F(n) = Sum(n-k <= j <= n-1)F(j). Must be => 2: ");
			termsToAdd = inputScan.nextInt();
		}

		long [] initialValues = new long[termsToAdd];		
		System.out.print("Array of initial values. Number of initial values needed: " + termsToAdd);
		for(int i = 0; i < termsToAdd; i++) { initialValues[i] = inputScan.nextInt(); }
		
		printFibonacciDefinition(termsToAdd, initialValues);

		try {
			GeneralFibonacci gf4 = new GeneralFibonacci(termsToAdd,initialValues);

			int nthValue = 1;
			while (nthValue > 0) { 

				System.out.print("Which number element of the sequence do you want? ");
				nthValue = inputScan.nextInt();

				if (nthValue > 0) {
					long answer2 = gf4.calculateNthTerm(nthValue - 1);
					System.out.println("ANSWER(Clever Recursive Method): Value number "+ nthValue + " is: " + answer2);					
					answer2 = gf4.calculateNthTermIterative(nthValue - 1);
					System.out.println("ANSWER(Iterative Method): Value number "+ nthValue + " is: " + answer2);
					answer2 = gf4.calculateNthTermExp(nthValue - 1);
					System.out.println("ANSWER(Exp Method): Value number "+ nthValue + " is: " + answer2);
					
				} else {
					System.out.println("Exiting loop");										
				}
			}
		} catch (ConstructorException e) {
			System.out.println("Code: "+ e.getCode() + " Exception Message : " + e.getMessage());
			inputScan.close();
		}	
		
		inputScan.close();
	}
}






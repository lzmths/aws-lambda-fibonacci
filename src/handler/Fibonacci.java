package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import fibonacci.FibonacciInput;
import fibonacci.FibonacciOutput;

/**
 * Fibonacci run in AWS Lambda.
 * You need put this code in Amazon AWS Lambda.
 * @author Luiz Carvalho
 */
public class Fibonacci implements RequestHandler<FibonacciInput, FibonacciOutput>{
	
	/**
	 * Fibonacci
	 * @param number until this number
	 * @return fibonacci number
	 */
	private int calc(int number) {
		int f1 = 0;
		int f2 = 1;
		int fn = 0;
		for (int i = 0; i < number; ++i) {
			f1 = f2;
			f2 = fn;
			fn = f2 + f1;
		}
		return fn;
	}

	/**
	 * Handler request 
	 */
	@Override
	public FibonacciOutput handleRequest(FibonacciInput input, Context context) {
		FibonacciOutput output = new FibonacciOutput();
		output.setResult(calc(input.getNumber()));
		return output;
	}
	
}

package invoke;
import com.amazonaws.services.lambda.invoke.LambdaFunction;

import fibonacci.FibonacciInput;
import fibonacci.FibonacciOutput;

/**
 * Fibonacci Service
 * 
 * @author Luiz Carvalho
 *
 */
public interface FibonacciService {

	@LambdaFunction(functionName = "fibonacci")
	public FibonacciOutput fibonacci(FibonacciInput input);
	
}

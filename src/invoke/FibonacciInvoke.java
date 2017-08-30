package invoke;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

import fibonacci.FibonacciInput;
import fibonacci.FibonacciOutput;

/**
 * Invoke Fibonacci
 * 
 * You need replace ID, KEY and maybe region.
 * 
 * @author Luiz Carvalho
 *
 */
public class FibonacciInvoke {
	
	private final String id = "PUT_ID";
	private final String key = "PUT_KEY";
	
	public FibonacciOutput run(FibonacciInput input) {
		BasicAWSCredentials credentials = new BasicAWSCredentials(id, key);
		AWSLambdaClientBuilder builder = AWSLambdaClientBuilder.standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(credentials));
	    AWSLambda awsLambda = builder.build();
	    LambdaInvokerFactory.Builder lambdaBuilder = LambdaInvokerFactory.builder();
	    lambdaBuilder.lambdaClient(awsLambda);
	    FibonacciService fibService = lambdaBuilder.build(FibonacciService.class);
	    FibonacciOutput output = fibService.fibonacci(input);
	    return output;
	}
	
}

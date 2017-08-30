package main;

import fibonacci.FibonacciInput;
import fibonacci.FibonacciOutput;
import invoke.FibonacciInvoke;

public class Main {
	public static void main(String[] args) {
		FibonacciInvoke invoke = new FibonacciInvoke();
		FibonacciInput input = new FibonacciInput();
		input.setNumber(Integer.parseInt(args[0]));
		FibonacciOutput output = invoke.run(input);
		System.out.println(output.getResult());
	}
}

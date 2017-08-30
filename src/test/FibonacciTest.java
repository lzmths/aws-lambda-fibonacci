package test;

import static org.junit.Assert.*;
import invoke.FibonacciInvoke;

import org.junit.Before;
import org.junit.Test;

import fibonacci.FibonacciInput;
import fibonacci.FibonacciOutput;

public class FibonacciTest {

	FibonacciInvoke invoke;
	FibonacciInput input;
	FibonacciOutput fibonacciOutput;
	
	@Before
	public void start() {
		this.invoke = new FibonacciInvoke();
		this.input = new FibonacciInput();
	}
	
	private void runFibonacci(int number) {
		input.setNumber(number);
		this.fibonacciOutput = this.invoke.run(input);
	}
	
	@Test
	public void testFibonacci5() {
		runFibonacci(5);
		assertEquals(5, fibonacciOutput.getResult());
	}
	
	@Test
	public void testFibonacci0() {
		runFibonacci(0);
		assertEquals(0, fibonacciOutput.getResult());
	}
	
	@Test
	public void testFibonacci6() {
		runFibonacci(6);
		assertEquals(8, fibonacciOutput.getResult());
	}
	
	@Test
	public void testFibonacci15() {
		runFibonacci(15);
		assertEquals(610, fibonacciOutput.getResult());
	}

}

package br.com.paloma.math;

public class SimpleMath {
	 
	public Double sum(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	public Double sub(Double firstNumber, Double secondNumber) {
		return firstNumber - secondNumber;
	}
	
	public Double div(Double firstNumber, Double secondNumber) {
		return firstNumber / secondNumber;
	}
	
	public Double mult(Double firstNumber, Double secondNumber) {
		return (firstNumber * secondNumber)/2;
	}
	
	public Double media(Double firstNumber, Double secondNumber) {
		return (firstNumber + secondNumber)/2;
	}
	
	public Double raiz(Double firstNumber) {
		return (Double) Math.sqrt(firstNumber);
	}
}

package md.curs.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import md.curs.model.Calculator;

@Service
public class CalcService {
	
	
	/**
	 * Utility method to calculate result based on operation
	 * @param firstNumber
	 * @param secondNumber
	 * @param operation
	 * @return
	 */
	public String calculateResult(Calculator calcData) {
		
		double firstNumber = calcData.getFirstNumber();
		double secondNumber = calcData.getSecondNumber();
		String operation = calcData.getOperation();
		
		switch (operation) {
		case "plus":
			return formatDouble(firstNumber + secondNumber);
		case "minus":
			return formatDouble(firstNumber - secondNumber);
		case "multiply":
			return formatDouble(firstNumber * secondNumber);
		case "divide":
			return formatDouble(firstNumber / secondNumber);
		default: 
			return "Not a valid operation";
		}
	}
	
	/**
	 * Utility method that sets the format for a decimal number
	 * @param number
	 * @return
	 */
	public String formatDouble(double number) {
	
		DecimalFormat df = new DecimalFormat(".##");
		return df.format(number);
	}
}

package md.curs.servlets;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//Obtain numbers parameters and cast them to double
		double firstNumber = Double.parseDouble(req.getParameter("firstNumber"));
		double secondNumber = Double.parseDouble(req.getParameter("secondNumber"));
		
		//Obtain the operation parameter
		String operation = req.getParameter("operation");
		
		//Initialize a request dispatcher for the index.jsp page
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		
		//Check for division by 0 and display a error message
		if (operation.equals("divide") && secondNumber == 0) {
			
			req.setAttribute("result", "You can not divide a number by 0");
			rd.forward(req, resp);

		} else {
			//Calculate result
			String result = calculateResult(firstNumber, secondNumber, operation);
			//Set request attributes
			req.setAttribute("result", result);
			req.setAttribute("firstNumber", firstNumber);
			req.setAttribute("secondNumber", secondNumber);
			//Forward the request to index.jsp page
			rd.forward(req, resp);
		}
	}

	/**
	 * Utility method to calculate result based on operation
	 * @param firstNumber
	 * @param secondNumber
	 * @param operation
	 * @return
	 */
	private String calculateResult(double firstNumber, double secondNumber, String operation) {
		
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
	private String formatDouble(double number) {
	
		DecimalFormat df = new DecimalFormat(".##");
		return df.format(number);
	}
}

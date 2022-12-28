package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdditionPractice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * Generating two random numbers 1-9
		 */
		int rand1 = (int) ((Math.random() * 9) + 1);
		int rand2 = (int) ((Math.random() * 9) + 1);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		/**
		 * action is the URL of the server-side program that will process the request
		 * method is the method of request used to submit the form
		 * 
		 * The randomly generated integers are stored in hidden labels to be read in the
		 * doPost method
		 */
		out.println("<div>" + "<form action=AdditionPractice method=post>" + "<label >" + rand1 + "</label>"
				+ "&nbsp + &nbsp" + "<label >" + rand2 + "</label>" + "&nbsp = &nbsp"
				+ "<input name=num1 type=hidden value=" + rand1 + ">" + "<input name=num2 type=hidden value=" + rand2
				+ ">" + "<input type=text name=answer required> " + "<button type=submit> &nbsp Submit </button>"
				+ "</form>" + "</div>");
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		/**
		 * the randomly generated integers are passed to num1 and num2 using the name/
		 * parameter given in doGet
		 */
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		/**
		 * calculating the sum of the numbers
		 */
		int sum = num1 + num2;

		/**
		 * printing the numbers and the correct sum
		 */
		out.println("<div>" + "<p>" + num1 + "&nbsp + &nbsp" + num2 + "&nbsp = &nbsp" + sum + "</p>" + "</div");

		/**
		 * if the calculated sum equals the answer submitted, then a "correct" message
		 * is displayed.
		 * 
		 * The submitted answer is passed using the name/ parameter given in doGet and
		 * is parsed to an integer since it is received as a string
		 */
		if (sum == Integer.parseInt(request.getParameter("answer"))) {
			out.println("<div>" + "<p>Your answer " + request.getParameter("answer") + " is correct</p>"
					+ "<p> <a href=AdditionPractice>Try again</a> </p>" + "</div>");
			/**
			 * if the calculated sum does not equal the answer submitted, then an "incorrect" message
			 * is displayed.
			 */
		} else {
			out.println("<div>" + "<p>Your answer " + request.getParameter("answer") + " is incorrect</p>"
					+ "<p> <a href=AdditionPractice>Try again</a> </p>" + "</div>");
			out.println("</body></html>");
		}

	}

}
package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Poll;

/**
 * Servlet implementation class ListPolls
 */
@WebServlet("/ListPolls")
public class ListPolls extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListPolls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<Poll> polls = new ArrayList<Poll>();

		Poll poll = new Poll();
		poll.setQuestion("What programming languages do you know?");
		poll.getAnswers().add("Java");
		poll.getAnswers().add("Python");
		poll.setSingleChoice(false);

		polls.add(poll);

		getServletContext().setAttribute("polls", polls);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ListPolls.jsp").forward(request, response);
	}

}

package cs3220.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Poll;

/**
 * Servlet implementation class DisplayPoll
 */
@WebServlet("/DisplayPoll")
public class DisplayPoll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayPoll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));

		@SuppressWarnings("unchecked")
		List<Poll> polls = (List<Poll>) getServletContext().getAttribute("polls");

		Poll poll = null;

		for (Poll p : polls)
			if (p.getId() == id) {
				poll = p;
				break;
			}
		
		request.setAttribute("poll", poll);
		request.getRequestDispatcher("/WEB-INF/DisplayPoll.jsp").forward(request, response);;
	}

}

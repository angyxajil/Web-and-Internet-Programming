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
 * Servlet implementation class CreatePoll
 */
@WebServlet("/CreatePoll")
public class CreatePoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePoll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/CreatePoll.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Poll poll = new Poll();
		
		poll.setQuestion(request.getParameter("question"));
		poll.setSingleChoice(request.getParameter("single") != null);
		
		@SuppressWarnings("unchecked")
		List<Poll> polls = (List<Poll>) getServletContext().getAttribute("polls");

		polls.add(poll);
		
		response.sendRedirect("AddAnswers?id=" + poll.getId());
	}

}

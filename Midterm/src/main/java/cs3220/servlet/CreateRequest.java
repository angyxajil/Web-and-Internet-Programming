package cs3220.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Service;

/**
 * Servlet implementation class CreatePoll
 */
@WebServlet("/CreateRequest")
public class CreateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/CreateRequest.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Service serv = new Service();
		
		serv.gettime();
		serv.setName(request.getParameter("name"));
		serv.setType(request.getParameter("status"));
		
		@SuppressWarnings("unchecked")
		List<Service> services = (List<Service>) getServletContext().getAttribute("serv");

		services.add(serv);
		
		response.sendRedirect("AddAnswers?id=" + serv.getId());
	}

}

package cs3220.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Service;

/**
 * Servlet implementation class ListPolls
 */
@WebServlet("/DisplayRequests")
public class DisplayRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayRequests() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<Service> servs = new ArrayList<Service>();

		Service serv1 = new Service();

		serv1.settime();
		serv1.setName("John");
		serv1.setType("Phone");
		serv1.setStatus("Open");

		servs.add(serv1);
		
		getServletContext().setAttribute("servs", servs);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/DisplayService.jsp").forward(request, response);
	}

}

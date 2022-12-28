package cs3220.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewAttractionsEntry;

/**
 * Servlet implementation class AddAtraction
 */
@WebServlet("/AddAttraction")
public class AddAttraction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAttraction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/AddAttraction.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			c = DriverManager.getConnection(url, username, password);

			String sql = "insert into parks (name, phone) values (?, ?)";

			PreparedStatement pstmnt = c.prepareStatement(sql);
			pstmnt.setString(1, name);
			pstmnt.setString(2, phone);

			pstmnt.executeUpdate();

		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		
		response.sendRedirect("DisplayAttractions");

	}

}

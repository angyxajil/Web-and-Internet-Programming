package cs3220.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewCommentEntry;

/**
 * Servlet implementation class AddReview
 */
@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			c = DriverManager.getConnection(url, username, password);
			Statement stmnt1 = c.createStatement();

			ResultSet revResults = stmnt1.executeQuery("select * from reviews");

			List<NewCommentEntry> revEntries = new ArrayList<NewCommentEntry>();

			while (revResults.next()) {
				NewCommentEntry rev = new NewCommentEntry();
				rev.setName(revResults.getString("PersonName"));
				rev.setReview(revResults.getString("review"));
				rev.setParkName(revResults.getString("parkName"));
				
				revEntries.add(rev);
			}

			request.setAttribute("revEntries", revEntries);

			request.getRequestDispatcher("/WEB-INF/AddReview.jsp").forward(request, response);

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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String review = request.getParameter("review");
		String park = request.getParameter("review");

		Connection c = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			c = DriverManager.getConnection(url, username, password);

			String sql = "insert into reviews (personName, review, parkName) values (?, ?, ?)";

			PreparedStatement pstmnt = c.prepareStatement(sql);
			pstmnt.setString(1, name);
			pstmnt.setString(2, review);
			pstmnt.setString(3, park);

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

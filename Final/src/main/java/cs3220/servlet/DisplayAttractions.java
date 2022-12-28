package cs3220.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

import cs3220.model.NewAttractionsEntry;

/**
 * Servlet implementation class DisplayReservations
 */
@WebServlet("/DisplayAttractions")
public class DisplayAttractions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAttractions() {
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

			ResultSet attResults = stmnt1.executeQuery("select * from parks");

			List<NewAttractionsEntry> attEntries = new ArrayList<NewAttractionsEntry>();

			while (attResults.next()) {
				NewAttractionsEntry att = new NewAttractionsEntry();
				att.setName(attResults.getString("name"));
				att.setPhone(attResults.getString("phone"));
				
				attEntries.add(att);
			}

			request.setAttribute("attEntries", attEntries);

			request.getRequestDispatcher("/WEB-INF/DisplayAttractions.jsp").forward(request, response);

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

}

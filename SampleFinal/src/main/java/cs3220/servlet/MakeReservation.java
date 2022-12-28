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

import cs3220.model.NewReservationEntry;

/**
 * Servlet implementation class MakeReservation
 */
@WebServlet(urlPatterns = "/MakeReservation", loadOnStartup = 1)
public class MakeReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get all groups that are in the database and send to jsp
		Connection c = null;

		try {
			// info used for the database connection
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			// connect to database and then get all values from department table
			c = DriverManager.getConnection(url, username, password);
			Statement stmnt1 = c.createStatement();

			String chosenDay = request.getParameter("dayDropdown");
			String chosenTime = request.getParameter("timeDropdown");

			System.out.println(chosenDay);
			System.out.println(chosenTime);

			// check if there are any reservations with selected time and day
			ResultSet rs = stmnt1.executeQuery(
					"select name from reservations where time =\'" + chosenTime + "\' and weekDay=\'" + chosenDay + "\'");

			List<NewReservationEntry> resEntries = new ArrayList<NewReservationEntry>();

			if (rs != null) {
				
				
				System.out.println("nope");

			}

			else {
				NewReservationEntry res = new NewReservationEntry();

				res.setWeekDay(chosenDay);
				res.setTime(chosenTime);
				res.setName(request.getParameter("nameInput"));

				resEntries.add(res);
			}

			// pass the list of groups and students to view in jsp
			request.setAttribute("resEntries", resEntries);

		}
		// catch any problems with connecting to database
		catch (SQLException e) {
			throw new ServletException(e);
		}
		// if all went well, close off the connection to the mysql database
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		response.sendRedirect("DisplayReservations");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create a new student with correct group
		String name = request.getParameter("nameInput");
		String time = request.getParameter("timeDropdown");
		String day = request.getParameter("dayDropdown");

		// add group to database
		Connection c = null;
		try {
			// values to be passed to establish connection to the sql page
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			// connect to the database
			c = DriverManager.getConnection(url, username, password);

			// executes sql statement so no special characters affect database
			String sql = "insert into reservations (name, weekDay, time) values (?, ?, ?)";

			// set the values to be added to the database
			PreparedStatement pstmnt = c.prepareStatement(sql);
			pstmnt.setString(1, name);
			pstmnt.setString(2, day);
			pstmnt.setString(3, time);

			// execute the database update
			pstmnt.executeUpdate();

		}
		// catch any problems with connection to sql server
		catch (SQLException e) {
			throw new ServletException(e);
		}
		// if all went well, be sure to close off the connection
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		response.sendRedirect("DisplayReservations");

	}

}

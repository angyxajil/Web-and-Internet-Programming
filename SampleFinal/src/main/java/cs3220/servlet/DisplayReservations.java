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

import cs3220.model.NewReservationEntry;

/**
 * Servlet implementation class DisplayReservations
 */
@WebServlet(urlPatterns = "/DisplayReservations", loadOnStartup = 1)
public class DisplayReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public DisplayReservations() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get data from database
		Connection c = null;
		try {
			// info used for the database connection
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			// connect to database and then get all values from department table
			c = DriverManager.getConnection(url, username, password);
			Statement stmnt1 = c.createStatement();

			// execute first statement to get all values from hw3_students table
			ResultSet resResults = stmnt1.executeQuery("select * from reservations");


			// create a list of reservations
			List<NewReservationEntry> resEntries = new ArrayList<NewReservationEntry>();
			List<String> timeSlots = new ArrayList<String>();
			List<String> days = new ArrayList<String>();
			
			timeSlots.add("8:00am - 9:00am");
			timeSlots.add("9:00am - 10:00am");
			timeSlots.add("10:00am - 11:00am");
			timeSlots.add("11:00am - 12:00pm");
			timeSlots.add("12:00pm - 13:00pm");
			timeSlots.add("13:00pm - 14:00pm");
			timeSlots.add("14:00pm - 15:00pm");
			timeSlots.add("15:00pm - 16:00pm");
			timeSlots.add("16:00pm - 17:00pm");
			
			days.add("MON");
			days.add("TUE");
			days.add("WED");
			days.add("THR");
			days.add("FRI");
			
			//System.out.println(timeSlots);
			
			request.setAttribute("timeSlots", timeSlots);
			request.setAttribute("days", days);

			// while there are still students, create new student and add to arrayList
			while (resResults.next()) {
				// a student has: (name, birth_year, parent_name, parent_email, group_id)
				// create a NewGroupEntry and get the name to set for the group
				NewReservationEntry res = new NewReservationEntry();
				res.setName(resResults.getString("name"));
				res.setWeekDay(resResults.getString("weekDay"));
				res.setTime(resResults.getString("time"));

				//System.out.println(res.getName() + " " + res.getWeekDay() + " " + res.getTime());
				// add the group to arraylist of groups
				resEntries.add(res);
			}

			// pass the list of groups and students to view in jsp
			request.setAttribute("resEntries", resEntries);

			// redirect the user to the student listing page
			request.getRequestDispatcher("/WEB-INF/DisplayReservation.jsp").forward(request, response);

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

	}

}

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

import cs3220.model.NewGroupEntry;
import cs3220.model.NewStudentEntry;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the studentId parameter and save
		String studentId = request.getParameter("studentId");

		// get the student info and send it to the edit student page
		Connection c = null;
		try {
			// values to be passed to establish connection to the sql page
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			// find student with the studentId
			NewStudentEntry studentInfo = new NewStudentEntry();

			// connect to the database
			c = DriverManager.getConnection(url, username, password);

			// executes call to get the student with the id in the paramter
			Statement stmnt1 = c.createStatement();
			Statement stmnt2 = c.createStatement();
			ResultSet returnedStudent = stmnt1.executeQuery(" SELECT * FROM hw3_students where id =" + studentId);

			// execute second statement to get all values from hw3_groups table
			ResultSet groupsResults = stmnt2.executeQuery(
					"Select * from (Select sg.id, sg.name, sg.max_size as StudentLimit, IF(sg.name IS NULL, 0, count(s.id)) as NumOfStudents from hw3_groups sg left join hw3_students s on sg.id=s.group_id group by sg.id) as groupInfo where StudentLimit > NumOfStudents");

			// create a list of groups
			List<NewGroupEntry> groupEntries = new ArrayList<NewGroupEntry>();

			// while there are still groups, create new group and add to arrayList
			while (groupsResults.next()) {
				// create a NewGroupEntry and get the name to set for the group
				NewGroupEntry group = new NewGroupEntry();
				group.setId(groupsResults.getInt("id"));
				group.setName(groupsResults.getString("name"));
				group.setNumOfStudents(groupsResults.getInt("NumOfStudents"));

				// add the group to arraylist of groups
				groupEntries.add(group);
			}

			// set the values of the student to be added
			while (returnedStudent.next()) {
				// get the all the correct values to add to the student info
				studentInfo.setStudentId(returnedStudent.getInt("id"));
				studentInfo.setName(returnedStudent.getString("name"));
				studentInfo.setBirthYear(returnedStudent.getInt("birth_year"));
				studentInfo.setParentName(returnedStudent.getString("parent_name"));
				studentInfo.setParentEmail(returnedStudent.getString("parent_email"));
				studentInfo.setGroupName(returnedStudent.getString("group_name"));

			}

			// pass the list of groups and students to view in jsp
			request.setAttribute("groupEntries", groupEntries);

			// pass the student info to view in jsp
			request.setAttribute("studentInfo", studentInfo);

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

		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// find student with the studentId
		int studentId = Integer.parseInt(request.getParameter("studentId"));

		// get all values in the jsp and set the data in the arrayList
		String name = request.getParameter("nameInput");
		int birthYear = Integer.parseInt(request.getParameter("birthYearInput"));
		String parentName = request.getParameter("parentNameInput");
		String parentEmail = request.getParameter("parentEmailInput");

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
			String sql = "update hw3_students set name=?, birth_year=?, parent_name=?, parent_email=?, group_id=?, group_name=? where id="
					+ studentId;

			// set the values to be added to the database
			PreparedStatement pstmnt = c.prepareStatement(sql);

			pstmnt.setString(1, name);
			pstmnt.setInt(2, birthYear);
			pstmnt.setString(3, parentName);
			pstmnt.setString(4, parentEmail);

			// execute another statement to get the group id and the group name below given
			// the correct id
			Statement stmnt1 = c.createStatement();
			ResultSet returnedGroup = stmnt1.executeQuery(
					" SELECT * FROM hw3_groups where id =" + Integer.parseInt(request.getParameter("groupDropdown")));

			// check to see if the user has selected no group
			if (Integer.parseInt(request.getParameter("groupDropdown")) == 0) {
				// if no group selected, set id to null and name to "No Group"
				pstmnt.setNull(5, Types.NULL);
				pstmnt.setString(6, "No Group");
			} else {
				// if a group was selected, get the name and id of the group
				while (returnedGroup.next()) {
					pstmnt.setString(5, returnedGroup.getString("id"));
					pstmnt.setString(6, returnedGroup.getString("name"));
				}
			}

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

		// redirect the user to the studentListing page
		response.sendRedirect("ListStudent");
	}

}

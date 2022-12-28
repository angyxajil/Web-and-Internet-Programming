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

import cs3220.model.NewGroupEntry;
import cs3220.model.NewStudentEntry;


@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the groupId parameter and save
		String groupId = request.getParameter("groupId");
		
    	//save group id to use in the jsp
		request.setAttribute("groupId", groupId);
		
    	// get data from database
    	Connection c = null;
        try {
        	// info used for the database connection
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";
        	
        	// connect to database and create statements to execute
        	c = DriverManager.getConnection(url, username, password);
        	Statement stmnt1 = c.createStatement();
        	Statement stmnt2 = c.createStatement();
        	
        	// execute first statement to get all values from hw3_students table
        	ResultSet studentsResults = stmnt1.executeQuery("select * from hw3_students");
        	
        	// execute second statement to get the correct group from hw3_groups table with the group id
        	ResultSet returnedGroup = stmnt2.executeQuery("select * from hw3_groups where id="+groupId);
        	
        	// create a NewGroupEntry to set all the values of the correct group to edit
    		NewGroupEntry groupInfo = new NewGroupEntry();
    		
    		// saves all the students in the database
        	List<NewStudentEntry> studentEntries = new ArrayList<NewStudentEntry>();
        	
        	
        	// while there are still groups, create new group and add to arrayList (should only have one group if done correctly)
        	while(returnedGroup.next()) {
        		// get the name to set for the group
        		groupInfo.setId(returnedGroup.getInt("id"));
        		groupInfo.setName(returnedGroup.getString("name"));
        	}
        	
        	// while there are still students, create new student and add to arrayList
        	while(studentsResults.next()) {
        		// a student should have: (name, birth_year, parent_name, parent_email, group_id)
        		// create a NewGroupEntry and get the name to set for the group
        		NewStudentEntry student = new NewStudentEntry();
        		student.setStudentId(studentsResults.getInt("id"));
        		student.setName(studentsResults.getString("name"));
        		student.setBirthYear(studentsResults.getInt("birth_year"));
        		student.setParentName(studentsResults.getString("parent_name"));
        		student.setParentEmail(studentsResults.getString("parent_email"));
        		student.setGroupName(studentsResults.getString("group_name"));
        		
        		// add the group to arraylist of groups
        		studentEntries.add(student);
        	}
        	
        	// pass the list of students and groupInfo to view in jsp
        	request.setAttribute("groupInfo", groupInfo);
        	request.setAttribute("studentEntries", studentEntries);
        	
        }
        // catch any problems with connecting to database
        catch( SQLException e) {
        	throw new ServletException(e);
        }
        // if all went well, close off the connection to the mysql database
        finally {
        	try {
        		if(c!=null) c.close();
        	}
        	catch(SQLException e) {
        		throw new ServletException(e);
        	}
        }
		
		// send the user to the EditGroupPage in the jsp
		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// save the group id to edit
		int groupId = Integer.parseInt(request.getParameter("groupId"));

		// if the user changed the name of group, save it
		String name = request.getParameter("groupNameInput");
		
		// string to save the old name of the group
		String oldName = null;
		
		// add group to database
        Connection c = null;
        try {
        	// values to be passed to establish connection to the sql page
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";
        	
        	// connect to the database and create statement to execute
        	c = DriverManager.getConnection(url, username, password);
        	Statement stmnt1 = c.createStatement();
        	
        	// get the old name of the group with current groupId
        	ResultSet returnedGroup = stmnt1.executeQuery("select * from hw3_groups where id = "+groupId);
        	
        	// get the returned group and save the old name of the group
        	while(returnedGroup.next()) {
        		oldName = returnedGroup.getString("name");
        	}
        	
        	// executes sql statement so no special characters affect database
        	String sql = "update hw3_groups set name=? where id="+groupId;
     	        	
        	// set the name of group to be updated to the database
        	PreparedStatement pstmnt = c.prepareStatement(sql);
        	pstmnt.setString(1, name);
        	
        	//update the name of all students where the groupName is the old value
        	String sql2 = "update hw3_students set group_name=? where group_name=?";
        	
        	// set the group name of students that need to be changed
        	PreparedStatement pstmnt2 = c.prepareStatement(sql2);
        	pstmnt2.setString(1, name);
        	pstmnt2.setString(2, oldName);
        	
        	// execute the database updates
        	pstmnt2.executeUpdate();
        	pstmnt.executeUpdate();
        }
        // catch any problems with connection to sql server
        catch( SQLException e) {
        	throw new ServletException(e);
        }
        // if all went well, be sure to close off the connection
        finally {
        	try {
        		if(c!=null) c.close();
        	}
        	catch(SQLException e) {
        		throw new ServletException(e);
        	}
        }
		
		// redirect the user to the GroupListing page
		response.sendRedirect("ListGroups");
		
	}

}

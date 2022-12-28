package cs3220.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Question;

@WebServlet(urlPatterns = "/DrivingTestBrowser", loadOnStartup = 1)
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DrivingTestBrowser() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<Question> questionsList = new ArrayList<Question>();

		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt"))));

			@SuppressWarnings("unused")
			String tracker, quest, ansA, ansB, ansC;
			int rightAns;

			while ((quest = in.readLine()) != null) {

				ansA = in.readLine();
				ansB = in.readLine();
				ansC = in.readLine();
				rightAns = Integer.parseInt(in.readLine());

				tracker = in.readLine();

				Question newQuestion = new Question(quest, ansA, ansB, ansC, rightAns);

				questionsList.add(newQuestion);
			}

			in.close();

			getServletContext().setAttribute("questionsList", questionsList);

		}

		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		ArrayList<Question> questionsList = (ArrayList<Question>) getServletContext().getAttribute("questionsList");

		int currentIndex = 0;

		request.setAttribute("currentIndex", currentIndex);
		request.setAttribute("questionsList", questionsList);
		
		if (request.getParameter("currentIndex") != null) {
			currentIndex = Integer.parseInt(request.getParameter("currentIndex"));
		}

		if (currentIndex == questionsList.size()) {
			request.getRequestDispatcher("/DrivingTestBrowser?currentIndex=0").forward(request, response);
			currentIndex = 0;
			return;
		}

		else {

			request.getRequestDispatcher("/WEB-INF/lab8.jsp").forward(request, response);
		}

	}

}
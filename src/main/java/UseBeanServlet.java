import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Student;

@WebServlet(urlPatterns = "/useBean")
public class UseBeanServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setName("Mg Mg");
		student.setEmail("mgmg@gmail.com");
		
		Student student1 = new Student();
		student1.setName("Kyaw Kyaw");
		student1.setEmail("kyawkyaw@gmail.com");
		
		request.setAttribute("student", student);
		request.getSession().setAttribute("student1", student1);
		request.getRequestDispatcher("useBean.jsp").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}

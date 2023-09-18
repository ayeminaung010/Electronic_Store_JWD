

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.User;
import com.servlet.ai.services.UserSrevice;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginUserName") != null) {
			UserSrevice userSrevice = new UserSrevice();
			List<User> users = userSrevice.findAll();
			
			request.setAttribute("users", users);
			request.getRequestDispatcher("user.jsp").include(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}

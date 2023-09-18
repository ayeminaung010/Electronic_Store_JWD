import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.User;
import com.servlet.ai.services.UserSrevice;

@WebServlet(urlPatterns = "/updateUser")
public class UserUpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("user_id"));
		String name =  request.getParameter("name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		
		UserSrevice userSrevice = new UserSrevice();
		if(userSrevice.checkEmailAlreadyExistAtUpdate(email,id)) {
			//return error 
			request.setAttribute("errorMessage", "Email already exits....!");
			request.getRequestDispatcher("error.jsp").include(request, response);
		}else {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPhoneNumber(phone_number);
			userSrevice.updateUser(user);
			request.getRequestDispatcher("/user").forward(request, response);
		}
	}

}

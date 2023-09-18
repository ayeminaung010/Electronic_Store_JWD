

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.coyote.RequestGroupInfo;

import com.ace.ai.web.User;
import com.servlet.ai.services.UserSrevice;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet(urlPatterns = "/userCreate")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.getRequestDispatcher("/user").forward(request, response);
		response.sendRedirect("user");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  request.getParameter("name");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String email = request.getParameter("email");
		String phone_number =  request.getParameter("phone_number");
		
		if(!password.equals(confirm_password)) {
			request.setAttribute("errorMessage", "Password and confirm password are not match..!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			UserSrevice userSrevice = new UserSrevice();
			if(userSrevice.checkEmailAlreadyExist(email)) {
				request.setAttribute("errorMessage", "Email already Exits");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}else {
				User user = new User();
				user.setEmail(email);
				user.setName(name);
				user.setPassword(confirm_password);
				user.setPhoneNumber(phone_number);
			   	boolean status = userSrevice.addUser(user);
			   	if (status) {
			   		request.getRequestDispatcher("/user").forward(request, response);
				}else { 
					request.setAttribute("errorMessage", "Something Wrong!");
					request.getRequestDispatcher("error.jsp").include(request, response);
				}
				
			}
		}
	}

}

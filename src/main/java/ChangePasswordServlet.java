

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.User;
import com.servlet.ai.services.UserSrevice;


/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("loginUserName") == null) {
			response.sendRedirect("login");
		} else {

			String id = request.getParameter("user_id");
			
			request.setAttribute("updateUser", id);
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserSrevice userSrevice  = new UserSrevice();
		User user = userSrevice.findById(id);
		if(user.getPassword().equals(oldPassword)) {
			if(!newPassword.equals(confirmPassword)) {
				request.setAttribute("errorMessage", "New Password does not match..!");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}else {
				userSrevice.changePassword(id, confirmPassword);
				request.getRequestDispatcher("/user").forward(request, response);
			}
		}else {
			request.setAttribute("errorMessage", "Old Password wrong..!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}

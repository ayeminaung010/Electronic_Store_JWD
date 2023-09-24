
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ace.ai.web.User;
import com.servlet.ai.services.UserSrevice;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("loginUserName") != null) {
			UserSrevice userSrevice = new UserSrevice();
			List<User> users = userSrevice.findAll();

			request.setAttribute("users", users);
			request.getRequestDispatcher("user.jsp").include(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();
		
		UserSrevice userSrevice = new UserSrevice();
		if(path == null) {
			doGet(request, response);
		}else {
			switch (path) {
			case "/add":
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String confirm_password = request.getParameter("confirm_password");
				String email = request.getParameter("email");
				String phone_number = request.getParameter("phone_number");
				if (!password.equals(confirm_password)) {
					request.setAttribute("errorMessage", "Password and confirm password are not match..!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} else {
					if (userSrevice.checkEmailAlreadyExist(email)) {
						request.setAttribute("errorMessage", "Email already Exits");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					} else {
						User user = new User();
						user.setEmail(email);
						user.setName(name);
						user.setPassword(confirm_password);
						user.setPhoneNumber(phone_number);
						boolean status = userSrevice.addUser(user);
						if (status) {
							response.sendRedirect(request.getContextPath() + "/user");
						} else {
							request.setAttribute("errorMessage", "Something Wrong!");
							request.getRequestDispatcher("error.jsp").include(request, response);
						}

					}
				}
				
				break;
			case "/update":
				int id = Integer.parseInt(request.getParameter("user_id"));
				String update_name = request.getParameter("name");
				String update_email = request.getParameter("email");
				String update_phone_number = request.getParameter("phone_number");
				
				if (userSrevice.checkEmailAlreadyExistAtUpdate(update_email, id)) {
					// return error
					request.setAttribute("errorMessage", "Email already exits....!");
					request.getRequestDispatcher("error.jsp").include(request, response);
				} else {
					User user = new User();
					user.setId(id);
					user.setName(update_name);
					user.setEmail(update_email);
					user.setPhoneNumber(update_phone_number);
					userSrevice.updateUser(user);
					response.sendRedirect(request.getContextPath() + "/user");
				}
				break;
			case "/delete":
				int delete_id = Integer.parseInt(request.getParameter("user_id"));
				userSrevice.deleteUser(delete_id);
				response.sendRedirect(request.getContextPath() + "/user");
				
				break;
			case "/changePassword":
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				String confirmPassword = request.getParameter("confirmPassword");
				int change_user_id = Integer.parseInt(request.getParameter("id"));
				
				User user = userSrevice.findById(change_user_id);
				if (user.getPassword().equals(oldPassword)) {
					if (!newPassword.equals(confirmPassword)) {
						request.setAttribute("errorMessage", "New Password does not match..!");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					} else {
						userSrevice.changePassword(change_user_id, confirmPassword);
						response.sendRedirect(request.getContextPath() + "/user");
					}
				} else {
					request.setAttribute("errorMessage", "Old Password wrong..!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
				break;
			}	

		
		}
	}
}

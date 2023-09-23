import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.ai.services.UserSrevice;

@WebServlet(name = "Login", urlPatterns = { "/login", "/" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().setAttribute("applicationName", "ACE  Electronic System");
		String message = getServletConfig().getInitParameter("message");

		if (request.getCookies() != null) {
			for (Cookie ck : request.getCookies()) {
				if (ck.getName().equals("rememberUser")) {
					message += "Welome back !!";
					request.setAttribute("rememberUser", ck.getValue());
				}
			}
		}
		request.setAttribute("message", message);

		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String isRememberUser = request.getParameter("isRememberUser");
		String loginDateTime = request.getParameter("loginDateTime");

		UserSrevice userService = new UserSrevice();

		if (userService.checkEmailAndPassword(email, password)) {
			// forward welcome
			if (isRememberUser != null && isRememberUser.equals("on")) {
				Cookie ck = new Cookie("rememberUser", email);
				response.addCookie(ck);
			}

			request.getSession().setAttribute("loginDateTime", loginDateTime);
			request.getSession().setAttribute("loginUserName", email);
			request.getRequestDispatcher("/home").forward(request, response);
		} else {
			// include error
			request.setAttribute("errorMessage", "Email and password are wrong");
			request.getRequestDispatcher("error.jsp").include(request, response);
		}

	}
}

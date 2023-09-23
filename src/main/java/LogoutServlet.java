
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns =  "/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = getServletConfig().getInitParameter("message");
		request.setAttribute("message", message);

//		Cookie ck = new Cookie("rememberUser", "");
//		ck.setMaxAge(0);
//		response.addCookie(ck);
		if (request.getCookies() != null) {
			for (Cookie ck : request.getCookies()) {
				if (ck.getName().equals("rememberUser")) {
					request.setAttribute("rememberUser", ck.getValue());
				}
			}
		}

		request.getSession().invalidate();

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

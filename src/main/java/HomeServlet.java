

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//    public int count = 0;
  
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginUserName") != null) {
			int count= 0;
			if(request.getSession().getAttribute("count") != null) {
				count = (int) request.getSession().getAttribute("count") + 1;
			}
			request.getSession().setAttribute("count", count);
			request.getRequestDispatcher("welcome.jsp").include(request, response);
		}else {
			response.sendRedirect("login");
		}
	}   


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("welcome.jsp").include(request, response);
	}

}

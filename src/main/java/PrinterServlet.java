

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ace.ai.web.Printer;
import com.ace.ai.web.Product;
import com.servlet.ai.services.PrinterService;
import com.servlet.ai.services.ProductService;


/**
 * Servlet implementation class PrinterServlet
 */
@WebServlet( urlPatterns =  "/printers")
public class PrinterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrinterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loginUserName") != null) {
			PrinterService printerService = new PrinterService();
			List<Printer> printers = printerService.findAll();
			
			ProductService productService = new ProductService();
			List<Product> products = productService.findAll();

			request.setAttribute("printers", printers);
			request.setAttribute("products", products);
			request.getRequestDispatcher("printer.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Printer;
import com.servlet.ai.services.PrinterService;

/**
 * Servlet implementation class PrinterCreateServlet
 */
@WebServlet( urlPatterns = "/createPrinter")
public class PrinterCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrinterCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("product_id"));
		String color = request.getParameter("color");
		Double price = Double.parseDouble(request.getParameter("price"));
		System.out.println(productId + color + price);
		PrinterService printerService = new PrinterService();
		try {
			Printer printer = new Printer();
			printer.setProduct_id(productId);
			printer.setColor(color);
			printer.setPrice(price);
			printerService.addPrinter(printer);
			request.getRequestDispatcher("/printers").include(request, response);
		}catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Printer;
import com.servlet.ai.services.PrinterService;

/**
 * Servlet implementation class PrinterUpdateServlet
 */
@WebServlet(urlPatterns = "/updatePrinter")
public class PrinterUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PrinterUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("product_id"));
		String color = request.getParameter("color");
		Double price = Double.parseDouble(request.getParameter("price"));
		int printerId = Integer.parseInt(request.getParameter("printer_id"));
		
		PrinterService printerService = new PrinterService();
		try {
			Printer printer = new Printer();
			printer.setProduct_id(productId);
			printer.setColor(color);
			printer.setPrice(price);
			printer.setId(printerId);
			printerService.updatePrinter(printer);
			request.getRequestDispatcher("/printers").include(request, response);
		}catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}

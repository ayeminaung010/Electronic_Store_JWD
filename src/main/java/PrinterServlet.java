
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
@WebServlet(urlPatterns = "/printers/*")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();

		PrinterService printerService = new PrinterService();
		if (path == null) {
			doGet(request, response);
		} else {
			switch (path) {
			case "/add":
				System.out.println("add method");
				int productId = Integer.parseInt(request.getParameter("product_id"));
				String color = request.getParameter("color");
				Double price = Double.parseDouble(request.getParameter("price"));
				System.out.println(productId + color + price);

				try {
					Printer printer = new Printer();
					printer.setProduct_id(productId);
					printer.setColor(color);
					printer.setPrice(price);
					printerService.addPrinter(printer);

					response.sendRedirect(request.getContextPath() + "/printers");
				} catch (Exception e) {
					request.setAttribute("errorMessage", e.getMessage());
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				break;
			case "/update":
				System.out.println("update method");
				int update_productId = Integer.parseInt(request.getParameter("product_id"));
				String update_color = request.getParameter("color");
				Double update_price = Double.parseDouble(request.getParameter("price"));
				int printerId = Integer.parseInt(request.getParameter("printer_id"));

				try {
					Printer printer = new Printer();
					printer.setProduct_id(update_productId);
					printer.setColor(update_color);
					printer.setPrice(update_price);
					printer.setId(printerId);
					printerService.updatePrinter(printer);

					response.sendRedirect(request.getContextPath() + "/printers");
				} catch (Exception e) {
					request.setAttribute("errorMessage", e.getMessage());
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}

				break;
			case "/delete":
				System.out.println("delete method");
				int id = Integer.parseInt(request.getParameter("printer_id"));

				try {
					printerService.deletePrinter(id);

					response.sendRedirect(request.getContextPath() + "/printers");
				} catch (Exception e) {
					request.setAttribute("errorMessage", e.getMessage());
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}

				break;
			}
		}
	}

}

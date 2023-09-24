
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Product;
import com.servlet.ai.services.ProductService;

/**
 * Servlet implementation class CreateProduct
 */
@WebServlet("/productCreate")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int maker_id = Integer.parseInt(request.getParameter("maker_id"));
		String model = request.getParameter("model");

		ProductService productService = new ProductService();
		if (!productService.checkModel(model)) {
			Product product = new Product();
			product.setMaker_id(maker_id);
			product.setModel(model);
			boolean status = productService.addProduct(product);

			if (status) {
				request.getRequestDispatcher("/products").include(request, response);
			} else {
				request.setAttribute("errorMessage", "Model Name Already exits...!");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Model Name Already exits...!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}

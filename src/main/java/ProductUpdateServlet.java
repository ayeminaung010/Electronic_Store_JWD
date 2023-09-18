
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Product;
import com.servlet.ai.services.ProductService;

@WebServlet("/updateProduct")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductUpdateServlet() {
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
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int maker_id = Integer.parseInt(request.getParameter("maker_id"));
		String model = request.getParameter("model");

		ProductService productService = new ProductService();
		
		Product new_p = new Product();
		
		if (!productService.checkUpdateModel(model,product_id)) {
			new_p.setId(product_id);
			new_p.setMaker_id(maker_id);
			new_p.setModel(model);
			productService.updateProduct(new_p);
			request.getRequestDispatcher("/products").include(request, response);
		} else {
			request.setAttribute("errorMessage", "Model Name Already exits...!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}

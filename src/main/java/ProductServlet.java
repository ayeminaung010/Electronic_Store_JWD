
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Make;
import com.ace.ai.web.Product;
import com.servlet.ai.services.MakeService;
import com.servlet.ai.services.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products/*")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("loginUserName") != null) {
			ProductService productService = new ProductService();
			List<Product> products = productService.findAll();

			MakeService makeService = new MakeService();
			List<Make> makes = makeService.findAll();

			request.setAttribute("products", products);
			request.setAttribute("makes", makes);
			request.getRequestDispatcher("products.jsp").include(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getPathInfo();
		
		ProductService productService = new ProductService();
		if(path == null) {
			doGet(request, response);
		}else {
			switch (path) {
			case "/add":
				int maker_id = Integer.parseInt(request.getParameter("maker_id"));
				String model = request.getParameter("model");
				
				if (!productService.checkModel(model)) {
					Product product = new Product();
					product.setMaker_id(maker_id);
					product.setModel(model);
					boolean status = productService.addProduct(product);

					if (status) {
						response.sendRedirect(request.getContextPath() +"/products");
					} else {
						request.setAttribute("errorMessage", "Model Name Already exits...!");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("errorMessage", "Model Name Already exits...!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
				break;
			case "/update":
				
				int product_id = Integer.parseInt(request.getParameter("product_id"));
				int update_maker_id = Integer.parseInt(request.getParameter("maker_id"));
				String update_model = request.getParameter("model");
				Product new_p = new Product();
				if (!productService.checkUpdateModel(update_model, product_id)) {
					new_p.setId(product_id);
					new_p.setMaker_id(update_maker_id);
					new_p.setModel(update_model);
					productService.updateProduct(new_p);
					response.sendRedirect(request.getContextPath() +"/products");
				} else {
					request.setAttribute("errorMessage", "Model Name Already exits...!");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
				break;
			case "/delete":
				int id = Integer.parseInt(request.getParameter("product_id"));
				productService.deleteProduct(id);
				response.sendRedirect(request.getContextPath() +"/products");
				break;
			}	
		}

	}

}

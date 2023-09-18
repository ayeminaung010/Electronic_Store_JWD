

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
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginUserName") != null) {
			ProductService productService = new ProductService();
			List<Product> products = productService.findAll();
			
			MakeService makeService = new MakeService();
			List<Make> makes = makeService.findAll();
			
			request.setAttribute("products", products);
			request.setAttribute("makes", makes);
			request.getRequestDispatcher("products.jsp").include(request, response);
		}else {
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
 
}

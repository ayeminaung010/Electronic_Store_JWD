

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Computer;
import com.ace.ai.web.Product;
import com.ace.ai.web.ResponseHelper;
import com.ace.ai.web.TypeComputer;
import com.google.gson.Gson;
import com.servlet.ai.services.ComputerService;
import com.servlet.ai.services.ProductService;
import com.servlet.ai.services.TypeComputerService;




/**
 * Servlet implementation class ComputerServlet
 */
@WebServlet( urlPatterns = "/computers/*")
public class ComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComputerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loginUserName") != null) {

			ComputerService computerService = new ComputerService();
			List<Computer> computers = computerService.findAll();
			
			TypeComputerService typeComputerService = new TypeComputerService();
			List<TypeComputer> typeComputers = typeComputerService.findAll();
			
			ProductService productService = new ProductService();
			List<Product> products = productService.findAll();
			
			request.setAttribute("computers", computers);
			request.setAttribute("type_computers", typeComputers);
			request.setAttribute("products", products);
			request.getRequestDispatcher("computer.jsp").include(request, response);
		} else {
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		ComputerService computerService = new ComputerService();
		if(path == null) {
			doGet(request, response);
		}else {
			switch (path) {
			case "/add":
				int product_id = Integer.parseInt(request.getParameter("product_id"));
				int type_computer_id = Integer.parseInt(request.getParameter("type_computer_id"));
				String speed = request.getParameter("speed");
				String ram = request.getParameter("ram");
				String hdd = request.getParameter("hdd");
				String price = request.getParameter("price");
				
				try {
					Computer computer = new Computer();
					computer.setProduct_id(product_id);
					computer.setType_computer_id(type_computer_id);
					computer.setSpeed(speed);
					computer.setRam(ram);
					computer.setHd(hdd);
					computer.setPrice(price);
					computerService.addComputer(computer);

					response.sendRedirect(request.getContextPath() + "/computers");
				} catch (Exception e) {
					request.setAttribute("errorMessage", e.getMessage());
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				break;
			case "/update":
				String update_computer_id = request.getParameter("update_computer_id");
		        String update_computer_product_id = request.getParameter("update_computer_product_id");
		        String update_type_computer_id = request.getParameter("update_type_computer_id");
		        String update_speed = request.getParameter("update_speed");
		        String update_ram = request.getParameter("update_ram");
		        String update_hdd = request.getParameter("update_hdd");
		        String update_price = request.getParameter("update_price");
		        
		        try {
		        	Computer computer = new Computer();
					computer.setId(Integer.parseInt(update_computer_id));
					computer.setProduct_id(Integer.parseInt(update_computer_product_id));
					computer.setType_computer_id(Integer.parseInt(update_type_computer_id));
					computer.setSpeed(update_speed);
					computer.setRam(update_ram);
					computer.setHd(update_hdd);
					computer.setPrice(update_price);
					computerService.updateComputer(computer);
					
					
					response.setContentType("application/json");
			        PrintWriter out = response.getWriter();
			        ResponseHelper responseHelper = new ResponseHelper();
			        responseHelper.setStatus(true);
			        responseHelper.setMessage("Computer data successfully updated..");
			        responseHelper.setData(computer);
			        Gson gson = new Gson();
			        String statuData = gson.toJson(responseHelper);
			        String jsonData = gson.toJson(computer);
			        out.println(statuData);
					 
				} catch (Exception e) {
					request.setAttribute("errorMessage", e.getMessage());
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
		        
				break;
			case "/delete":
				int id = Integer.parseInt(request.getParameter("computer_id"));
				try {
					computerService.deleteComputer(id);

					response.sendRedirect(request.getContextPath() + "/computers");
				} catch (Exception e) {
					request.setAttribute("errorMessage", e.getMessage());
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
				break;
			}	

		
		}
	}

}

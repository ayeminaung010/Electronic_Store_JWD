
import com.ace.ai.web.Class;
import com.ace.ai.web.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet( urlPatterns = "/class")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginUserName") != null) {
			
			File file = new File("Class.txt");
			FileWriter writer = new FileWriter(file);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write("Java,Thukha PyaeSone,12-5-2023\n");
			bWriter.write("dotNet,Thukha PyaeSone,18-7-2023\n");
			bWriter.write("C#,Thukha PyaeSone,10-6-2023\n");
			bWriter.write("React,Thukha,10-6-2020\n");
			bWriter.close();
			writer.close();
			
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			String classData =bReader.readLine();
			
			List<Class> classes = new ArrayList<>();
			while (classData != null) {
				String[] data = classData.split(",");
				classes.add(new Class(data[0], data[1], data[2]));
				classData =bReader.readLine();
			}
			
			
//			classes.add(new Class("Java","Thukha PyaeSone","12-5-2023"));
//			classes.add(new Class("dotNet","Thukha PyaeSone","18-7-2023"));
//			classes.add(new Class("C#","Thukha PyaeSone","10-6-2023"));
			request.setAttribute("classes", classes);
			
			PrintWriter out  = response.getWriter();
			request.getRequestDispatcher("class.jsp").include(request, response);
		}else {
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

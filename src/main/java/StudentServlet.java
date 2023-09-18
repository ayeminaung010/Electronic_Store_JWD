

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ace.ai.web.Student;

@WebServlet( urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginUserName") != null) {
			File file = new File("Students.txt");
			FileWriter writer = new FileWriter(file);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write("Mg Mg,0912345678,mgmg@gmail.com,20,Java\n");
			bWriter.write("Kyaw Kyaw,09123456453,kyawkyaw@gmail.com,25,DotNet\n");
			bWriter.write("Hla Hla,09149345678,hlahla@gmail.com,21,Java\n");
			bWriter.write("Ko Linn,0945345678,kolinn@gmail.com,25,dotNet\n");
			bWriter.close();
			writer.close();
			
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			String studentData =bReader.readLine();
			
			List<Student> students = new ArrayList<>();
			while (studentData != null) {
				String[] data = studentData.split(",");
				students.add(new Student(data[0],data[1],data[2],Integer.parseInt(data[3]),data[4]));
				studentData =bReader.readLine();
			}
			
//			students.add(new Student("Mg Mg", "0912345678", "mgmg@gmail.com", 20, "Java"));
//			students.add(new Student("Kyaw Kyaw", "09123456453", "kyawkyaw@gmail.com", 25, "DotNet"));
//			students.add(new Student("Hla Hla", "09149345678", "hlahla@gmail.com", 21, "Java"));
//			students.add(new Student("Ko Linn", "0945345678", "kolinn@gmail.com", 26, "dotNet"));
			
			request.setAttribute("students", students);
			request.getRequestDispatcher("student.jsp").include(request, response);
		}else {
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

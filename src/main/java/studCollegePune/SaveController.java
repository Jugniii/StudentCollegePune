package studCollegePune;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/save")
public class SaveController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		String fname= req.getParameter("fname");
		String mname= req.getParameter("mname");
		int age=Integer.parseInt(req.getParameter("age"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setFname(fname);
		student.setMname(mname);
		student.setAge(age);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);

	      StudentCRUD crud=new StudentCRUD();
	      try {
	    	  int count=crud.signUp(student);
	    	  PrintWriter out=res.getWriter();
	    	  if(count!=0) {
	    		  out.print("SignUp Success");
	    	  }else {
	    		  out.print("SignUp Fail");
	    	  }
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
		
		
	}

}

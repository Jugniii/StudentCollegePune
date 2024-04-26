package studCollegePune;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginController extends HttpServlet {

	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String email= req.getParameter("email");
			String password= req.getParameter("password");
			
			StudentCRUD crud=new StudentCRUD();
			try {
				String dbPassword=crud.login(email);
				PrintWriter out=resp.getWriter();
				if(dbPassword!=null)
				{
					if(dbPassword.equals(password))
					{
						out.print("Login Success");
						 RequestDispatcher dispatcher=	req.getRequestDispatcher("success.html");
				          dispatcher.forward(req, resp);
					}else {
						out.print("Login Fail");
						 RequestDispatcher dispatcher=	req.getRequestDispatcher("login.html");
				          dispatcher.forward(req, resp);
						
					}
				}else {
					System.out.println("User not login");
          RequestDispatcher dispatcher=	req.getRequestDispatcher("sign.html");
          dispatcher.forward(req, resp);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


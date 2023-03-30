package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.UserDao;
import dto.User_info;
@WebServlet("/login")
public class Log_in extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String emph=req.getParameter("emph");
		String password=req.getParameter("password");
		
		UserDao dao=new UserDao();
		List<User_info> infos=dao.fetchAll();
		
		try{
			long mobile=Long.parseLong(emph);
			User_info info=dao.fetch(mobile);
			if(info==null){
				res.getWriter().print("<h1> Invalid Mobile Number </h1>");	
				req.getRequestDispatcher("LogIn.html").include(req, res);
			}
			
			else{
				if(info.getPassword().equals(password))
				{
					res.getWriter().print("<h1> Log in Success </h1>");
//					res.getWriter().print("<table border='1'>");
//					res.getWriter().print("<tr>");
//					res.getWriter().print("<th>Id</th>");
//					res.getWriter().print("<th>Name</th>");
//					res.getWriter().print("<th>Mobile</th>");
//					res.getWriter().print("<th>Email</th>");
//					res.getWriter().print("<th>Password</th>");
//					res.getWriter().print("<th>date of birth</th>");
//					res.getWriter().print("<th>Gender</th>");
//					res.getWriter().print("<th>Address</th>");
//					res.getWriter().print("<th>Country</th>");
//					res.getWriter().print("<th>Skills</th>");
//					res.getWriter().print("</tr>");
//					
//					
//					for(User_info y:infos)
//					{
//						res.getWriter().print("<tr>");
//						res.getWriter().print("<th>"+y.getId()+"</th>");
//						res.getWriter().print("<th>"+y.getName()+"</th>");
//						res.getWriter().print("<th>"+y.getMobile()+"</th>");
//						res.getWriter().print("<th>"+y.getEmail()+"</th>");
//						res.getWriter().print("<th>"+y.getPassword()+"</th>");
//						res.getWriter().print("<th>"+y.getDate()+"</th>");
//						res.getWriter().print("<th>"+y.getGender()+"</th>");
//						res.getWriter().print("<th>"+y.getAddress()+"</th>");
//						res.getWriter().print("<th>"+y.getCountry()+"</th>");
//						res.getWriter().print("<th>"+Arrays.toString(y.getSkills())+"</th>");
//						res.getWriter().print("</tr>");
					res.getWriter().print("Log in successfully");
					req.setAttribute("list", infos);
					req.getRequestDispatcher("Home.jsp").include(req, res);
				}
//					res.getWriter().print("</table>");
				
				else{
					res.getWriter().print("<h1> invalid password </h1>");
					req.getRequestDispatcher("LogIn.html").include(req, res);
				}
			}
		}
		
		catch(NumberFormatException e){
			String email=emph;
			User_info info=dao.fetch(email);
			if(info==null){
				res.getWriter().print("<h1> Invalid email </h1>");
				req.getRequestDispatcher("LogIn.html").include(req, res);
			}
			
			else{
				if(info.getPassword().equals(password)){
					res.getWriter().print("<h1> Log in Success </h1>");
					
		
					req.setAttribute("list", infos);
					req.getRequestDispatcher("Home.jsp").include(req, res);
				}
				else{
					res.getWriter().print("<h1> invalid password </h1>");
					req.getRequestDispatcher("LogIn.html").include(req, res);
				}
			}
			
		}
	}

}

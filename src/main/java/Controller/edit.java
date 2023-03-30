package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.UserDao;
import dto.User_info;
@WebServlet("/edit")
public class edit extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Date date=Date.valueOf(req.getParameter("date of birth"));
		
		  User_info info=new User_info();
		 info.setName(req.getParameter("name"));
		 info.setMobile( Long.parseLong(req.getParameter("number")));
		 info.setEmail(req.getParameter("email"));
		 info.setPassword(req.getParameter("password"));
		 info.setGender(req.getParameter("gender"));
		 info.setAddress(req.getParameter("address"));
		 info.setCountry(req.getParameter("country"));
		 info.setSkills(req.getParameterValues("skills"));
		 info.setDate(Date.valueOf(req.getParameter("date of birth")));
		 
		 info.setAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());
		 
			UserDao dao=new UserDao();
		    info.setId(Integer.parseInt(req.getParameter("id")));
			dao.Update(info);
		
			req.setAttribute("list", dao.fetchAll());
			res.getWriter().print("<h1>data updated successfully</h1>");
			req.getRequestDispatcher("Home.jsp").include(req, res);
			}
		
	}



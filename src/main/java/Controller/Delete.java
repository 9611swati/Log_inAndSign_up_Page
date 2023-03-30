package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User_info;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		UserDao dao=new UserDao();
		
		User_info info=dao.fetch(id);
	     
		dao.delete(info);
	
		req.setAttribute("list", dao.fetchAll());
		res.getWriter().print("<h1>data deleted successfully</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, res);
		
	}
}

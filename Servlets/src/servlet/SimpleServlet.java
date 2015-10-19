package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/simple","*.lt"}, initParams = {@WebInitParam(name="ProductName", value = "WelcomeApplication")})
public class SimpleServlet extends HttpServlet {
	
	String appName = "My application";
	
	public void init() throws ServletException{
		appName = getServletContext().getInitParameter("ProductName");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name = req.getParameter("name");
		if (name != null){
			resp.setContentType("text/xml");
			resp.getWriter().printf("<application>" +
					 "<name>Hello %s<name/>" +
					 "<product>%s<product/>" +
					 "<application/>", name, appName);
		}else {
			throw new ServletException("A name should be entered");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name = req.getParameter("name");
		if (name != null && name != ""){
			resp.getWriter().printf("Hello %s", name);
		}else {
			resp.getWriter().write("Please enter a name");
		}
	}

}

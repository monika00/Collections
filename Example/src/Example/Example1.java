package Example;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class Example1 extends HttpServlet { 
	
	
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    
    request.getRequestDispatcher("link.html").include(request,response);
          
    HttpSession session = request.getSession();
    session.invalidate();
    
    out.print("you are successfuly loged out"); 
    }  
}  
package Example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);

		HttpSession session = request.getSession();

		if (session != null) {
			String name = (String)session.getAttribute("name");
			if (name != null) {
				out.print("<b>Welcome to profile</b>");
				out.print("<br>Welcome " + name);
			} else {
				out.print("Please login first");
				request.getRequestDispatcher("Login.html").include(request,
						response);
			}
			out.close();

		}
	}
}

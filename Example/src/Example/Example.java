package Example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Example extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("admin123")) {
			out.print("You are successfully loged in");
			out.print("<br>Welcome, " + name);

			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		} else {
			out.print("Sorry, Username or Password ERROR");
			request.getRequestDispatcher("Login.html").include(request,
					response);
		}

		out.close();
	}
}
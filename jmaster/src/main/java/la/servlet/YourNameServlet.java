package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourNameServlet
 */
@WebServlet("/YourNameServlet")
public class YourNameServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		response.setContentType("text/html;charaset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><titele>YourName</title></head><body>");
		out.println("あなたの名前は「"+name+"」です。");
		out.println("</body></html>");
	}

}

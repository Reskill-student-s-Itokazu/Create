package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final String USER = "jack";
	private static final String PASS = "abc";	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
			
				String action = request.getParameter("action");
				if(action.equals("login")) {
					String name = request.getParameter("name");
					String passWord = request.getParameter("pw");
					
					if(name.equals(USER)&&passWord.equals(PASS)) {
						HttpSession session = request.getSession();
						session.setAttribute("isLogin","true");
						out.println("<html><head><titele>ShowCart</title></head><body>");
						out.print("<h1>ログイン成功！</h1>");
						out.print("</body></html>");
					}else {
						out.println("<html><head><titele>ShowCart</title></head><body>");
						out.print("<h1>ユーザー名またはパスワードが違います</h1>");
						out.print("</body></html>");
					}
				}else if(action.equals("logout")) {
					HttpSession session = request.getSession(false);
					if(session != null) {
						session.invalidate();
						out.println("<html><head><titele>ShowCart</title></head><body>");
						out.print("<h1>ログアウトしました</h1>");
						out.print("</body></html>");
					}
				}
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

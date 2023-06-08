package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.PlusBean;
/**
 * Servlet implementation class PlusServlet4
 */
@WebServlet("/PlusServlet4")
public class PlusServlet4 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			
		String num1 = request.getParameter("number1");
		String num2 = request.getParameter("number2");

			int i1 = Integer.parseInt(num1);
			int i2 = Integer.parseInt(num2);
			int answer = i1 + i2 ;
		
			PlusBean bean = new PlusBean(i1,i2,answer);
			
			request.setAttribute("plus", bean);
			
			RequestDispatcher rd = request.getRequestDispatcher("/answer.jsp");
			rd.forward(request, response);
	}
}

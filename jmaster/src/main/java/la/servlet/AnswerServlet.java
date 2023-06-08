package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.PlusBean;

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		PlusBean bean = (PlusBean)request.getAttribute("plus");
		
		out.println("<html><head><title>Plus</title></head><body>");
		out.println(bean.getNumber1()+"+"+bean.getNumber2()+"="+bean.getAnswer());
		out.println("</body></html>");
	}

}

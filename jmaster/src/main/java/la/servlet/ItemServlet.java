package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO2;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			ItemDAO2 dao = new ItemDAO2();
			
			if (action == null || action.length()==0) {
				List<ItemBean>list = dao.findAll();
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}
			else if(action.equals("add")) {
				String name = request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				dao.addItem(name, price);
				List<ItemBean>list = dao.findAll();
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}
			else if(action.equals("sort")) {
				String key = request.getParameter("key");
				List<ItemBean>list;
				if(key.equals("price_asc")) {
					list = dao.sortPrice(true);
				}else {
					list = dao.sortPrice(false);
				}
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}
			else if(action.equals("search")) {
				int price =Integer.parseInt(request.getParameter("price"));
				List<ItemBean>list =dao.findByPrice(price);
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}
			else if(action.equals("delete")) {
				int code =Integer.parseInt(request.getParameter("code"));
				dao.deleteByPrimaryKey(code);
				List<ItemBean> list = dao.findAll();
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}else if(action.equals("modify")) {
				int code =Integer.parseInt(request.getParameter("code"));
				int price =Integer.parseInt(request.getParameter("price"));
				dao.modyfiByPrice(price, code);
				List<ItemBean> list = dao.findAll();
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}else {
				List<ItemBean>list =dao.findAll();
				request.setAttribute("items", list);
				gotoPage(request,response,"/errInternal.jsp");
			}
			}catch(DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				gotoPage(request,response,"/errInternal.jsp");
			}
		}
	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response ,String page) throws ServletException,
			IOException{
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

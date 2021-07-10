package cybersoft.java12.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.crmapp.util.JspConst;
import cybersoft.java12.crmapp.util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = {
		UrlConst.USER_DASHBOARD,
		UrlConst.USER_PROFILE,
		UrlConst.USER_ADD,
		UrlConst.USER_UPDATE,
		UrlConst.USER_DELETE,
})
public class UserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()){
			case UrlConst.USER_DASHBOARD:
				getDashboard(req,resp);
				break;
			
			case UrlConst.USER_PROFILE:
				
				break;
				
			case UrlConst.USER_ADD:
				
				break;
				
			case UrlConst.USER_UPDATE:
				
				break;
				
			case UrlConst.USER_DELETE:
				
				break;
				
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()){
			case UrlConst.USER_DASHBOARD:
				
				break;
			
			case UrlConst.USER_PROFILE:
				
				break;
				
			case UrlConst.USER_ADD:
				
				break;
				
			case UrlConst.USER_UPDATE:
				
				break;
				
			case UrlConst.USER_DELETE:
				
				break;
				
		}
	}
	
	private void getDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
	}
}

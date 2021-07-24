package cybersoft.java12.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.java12.crmapp.service.AuthService;
import cybersoft.java12.crmapp.util.JspConst;
import cybersoft.java12.crmapp.util.ServletConst;
import cybersoft.java12.crmapp.util.UrlConst;

@WebServlet(name = ServletConst.AUTH, urlPatterns = {
		UrlConst.AUTH_LOGIN,
		UrlConst.AUTH_LOGOUT,
		UrlConst.AUTH_FORGOT_PASSWORD,
		UrlConst.AUTH_SIGNUP
})
public class AuthServlet extends HttpServlet {
	private AuthService service;
	
	@Override
	public void init() throws ServletException {
		service = new AuthService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		
			case UrlConst.AUTH_LOGIN: 
				// cookie demo
				Cookie cookie = new Cookie("firstcookie", "Thisisthefirstcookie");
				cookie.setMaxAge(60);
				resp.addCookie(cookie);
				
				// kiem tra cookie - email - nếu có thì auto import email vào field mỗi khi vào trang
				Cookie[] cookies = req.getCookies();
				int cookiesCount = cookies == null ? 0 : cookies.length;
				for (int i = 0; i < cookiesCount; i++) {
					if(cookies[i].getName().equals("email")) {
						String email = cookies[i].getValue();
						req.setAttribute("email", email);
					}
				}
				
				// session demo
//				HttpSession currentSession = req.getSession();
//				currentSession.setAttribute("pingo", "This is the first session attribute");
//				currentSession.setMaxInactiveInterval(60 * 60);
				
				// check login status
				String status = String.valueOf(req.getSession().getAttribute("status"));
				if(!status.equals("null"))
					resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
				else
					req.getRequestDispatcher(JspConst.LOGIN)
						.forward(req, resp);
				
				break;
				
			case UrlConst.AUTH_LOGOUT: 
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + UrlConst.AUTH_LOGIN);
				break;
				
//			case UrlConst.AUTH_FORGOT_PASSWORD: 
//				req.getRequestDispatcher(JspConst.LOGIN)
//				.forward(req, resp);
//				break;
//				
//			case UrlConst.AUTH_SIGNUP: 
//				req.getRequestDispatcher(JspConst.LOGIN)
//				.forward(req, resp);
//				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		
		case UrlConst.AUTH_LOGIN: 
			// cookie demo
			String email = req.getParameter("email");
			String remember = req.getParameter("rememberUsername");
			String password = req.getParameter("password");
			boolean isLogin = true;
			
			if(remember != null) {
				Cookie cookie = new Cookie("email", email);
				cookie.setMaxAge(60 * 60 * 24);
				resp.addCookie(cookie);
			}
			
			// section demo
			HttpSession currentSession = req.getSession();
//			String pingo = (String) currentSession.getAttribute("pingo");
//			
//			System.out.printf("Pingo: %s\n", pingo);
			
			// login dang nhap
			if(email == null || password == null)
				isLogin = false;
//			else if(!email.equals("admin@gmail.com") || !password.equals("1234"))
			else if(!service.login(email, password)) 
				isLogin = false;
			
			if(isLogin) {
				currentSession.setAttribute("status", "Logged in successfully");
				resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
			}
			else
				resp.sendRedirect(req.getContextPath() + UrlConst.AUTH_LOGIN);
			break;
			
//		case UrlConst.AUTH_LOGOUT: 
//			req.getRequestDispatcher(JspConst.LOGIN)
//			.forward(req, resp);
//			break;
//			
//		case UrlConst.AUTH_FORGOT_PASSWORD: 
//			req.getRequestDispatcher(JspConst.LOGIN)
//			.forward(req, resp);
//			break;
//			
//		case UrlConst.AUTH_SIGNUP: 
//			req.getRequestDispatcher(JspConst.LOGIN)
//			.forward(req, resp);
//			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		
	}
	}
}

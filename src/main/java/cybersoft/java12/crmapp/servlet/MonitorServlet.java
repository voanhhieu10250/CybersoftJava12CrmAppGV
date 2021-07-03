package cybersoft.java12.crmapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.crmapp.dbconnection.MySQLConnection;
import cybersoft.java12.crmapp.util.ServletConst;
import cybersoft.java12.crmapp.util.UrlConst;

@WebServlet(name = ServletConst.MONITOR, urlPatterns = {
		UrlConst.HEALTH
})
public class MonitorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
			case UrlConst.HEALTH: {
				if(MySQLConnection.getConnection() != null)
					resp.getWriter().append("Database connection has been established");
				else
					resp.getWriter().append("Datebase connection could not be established");
				break;
			}
		}
	}
}

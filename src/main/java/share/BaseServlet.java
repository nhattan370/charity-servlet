package share;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void view(String name, HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
		String path = "/WEB-INF/view/" + name +".jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, res);
	}
}
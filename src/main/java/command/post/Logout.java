package command.post;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.CommandGet;
import enums.Message;
import share.BaseServlet;
import share.Color;

public class Logout extends BaseServlet implements CommandGet{
	private static final long serialVersionUID = 1L;
	
	private final Logger logger = Logger.getLogger(Logout.class.getName());
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse reqs) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		
		if(session!=null && session.getAttribute("user")!=null) {
			logger.info(Color.CYAN + "IN" + session.getAttribute("user") + Color.RESET);
			
			session.removeAttribute("user");
			session.setAttribute(Message.MESSAGE.getKey(), "Đăng xuất thành công");
			session.setAttribute(Message.STATUS.getKey(), true);
			reqs.sendRedirect(req.getContextPath());
		}
		logger.info(Color.CYAN + "OUT" + session.getAttribute("user") + Color.RESET);
	}

}

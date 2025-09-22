package controller;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandGet;
import command.CommandPost;
import command.get.DetailPage;
import command.get.HomePage;
import command.get.LoginPage;
import command.get.TestAccount;
import command.get.TestPage;
import command.post.DonatePage;
import command.post.Authenticated;
import command.post.Logout;
import share.BaseServlet;
import share.Color;

@WebServlet({"/home","/detail","", "/auth/donate","/login", "/logout", "/login-page", "/test-account"})
public class UserController extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserController.class.getName());
	private Map<String, CommandGet> routeGets = new HashMap<String, CommandGet>();
	private Map<String, CommandPost> routePosts = new HashMap<String, CommandPost>();
	
	@Override
	public void init() throws ServletException {
		routeGets.put("", new HomePage());
		routeGets.put("/home", new HomePage());
		routeGets.put("/detail", new DetailPage());
		routeGets.put("/test", new TestPage());
		routeGets.put("/login-page", new LoginPage());
		routeGets.put("/logout", new Logout());
		routeGets.put("/test-account", new TestAccount());
		routePosts.put("/auth/donate", new DonatePage());
		routePosts.put("/login", new Authenticated());
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		CommandGet cmd = routeGets.get(path);
		if(cmd!=null) {
			cmd.execute(req, resp);
		}else {
			logger.info(Color.GREEN+"Another path get: "+ path + Color.RESET);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		CommandPost cmd = routePosts.get(path);
		if(cmd!=null) {
			cmd.execute(req, resp);
		}else {
			logger.info(Color.GREEN+"Another path post: "+ path + Color.RESET);
		}
	}
}
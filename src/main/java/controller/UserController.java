package controller;

import java.awt.Color;
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
import command.get.TestPage;
import command.post.DonatePage;
import share.BaseServlet;

@WebServlet({"/home","/detail","/test","", "/donate"})
public class UserController extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserController.class.getName());
	private Map<String, CommandGet> routeGets = new HashMap<String, CommandGet>();
	private Map<String, CommandPost> routePosts = new HashMap<String, CommandPost>();
	
	@Override
	public void init() throws ServletException {
		routeGets.put("/home", new HomePage());
		routeGets.put("", new HomePage());
		routeGets.put("/detail", new DetailPage());
		routeGets.put("/test", new TestPage());
		routePosts.put("/donate", new DonatePage());
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		CommandGet cmd = routeGets.get(path);
		if(cmd!=null) {
			cmd.execute(req, resp);
		}else {
			logger.info(Color.GREEN+"Another path: "+ path + Color.GREEN);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		CommandPost cmd = routePosts.get(path);
		if(cmd!=null) {
			cmd.execute(req, resp);
		}else {
			logger.info(Color.GREEN+"Another path: "+ path + Color.GREEN);
		}
	}
}
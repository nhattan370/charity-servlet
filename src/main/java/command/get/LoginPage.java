package command.get;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandGet;
import share.BaseServlet;

public class LoginPage extends BaseServlet implements CommandGet{

	private static final long serialVersionUID = 1L;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		view("login", req, resp);
	}

}

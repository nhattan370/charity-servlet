package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandPost{
	void execute(HttpServletRequest req, HttpServletResponse reqs) throws IOException, ServletException;
}
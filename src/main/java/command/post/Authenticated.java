package command.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandPost;
import dto.UserDTO;
import enums.Message;
import model.User;
import service.UserService;
import service.UserServiceImpl;

public class Authenticated implements CommandPost {
	private final UserService userService = new UserServiceImpl();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse reqs) throws IOException, ServletException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = userService.authenticated(email, password);
		if(user!=null) {
			//Save user's information into session
			UserDTO userDTO = new UserDTO(user.getId(), user.getUserName(), user.getRole().getRoleName());
			req.getSession().setAttribute("user", userDTO);
			//Announced successfully login in toast
			req.getSession().setAttribute(Message.MESSAGE.getKey(), "Đăng nhập thành công!");
			req.getSession().setAttribute(Message.STATUS.getKey(), true);
			reqs.sendRedirect(req.getContextPath());			
		}else {
			req.getSession().setAttribute(Message.ERROR.getKey(), true);
			reqs.sendRedirect("login-page");
		}
	}

}

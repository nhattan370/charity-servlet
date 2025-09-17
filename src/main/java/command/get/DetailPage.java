package command.get;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandGet;
import model.Donation;
import model.User;
import service.DonationService;
import service.DonationServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import share.BaseServlet;
import share.Color;

public class DetailPage extends BaseServlet implements CommandGet {
	private static final long serialVersionUID = 1L;
	private final DonationService donationService = new DonationServiceImpl();
	private final UserService userService = new UserServiceImpl();
	private static final Logger logger = Logger.getLogger(DetailPage.class.getName());

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Donation donation = donationService.findById(id);
		req.setAttribute("donation", donation);
		
		List<User> users = userService.findByDonationId(id);
		
		req.getSession().setAttribute("usersForDonation", users);
		
		logger.info(Color.BRIGHT_CYAN + users);
		
		view("detail", req, resp);
	}
	
}

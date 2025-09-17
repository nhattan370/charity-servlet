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
import model.UserDonation;
import service.DonationService;
import service.DonationServiceImpl;
import service.UserDonationService;
import service.UserDonationServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import share.BaseServlet;

public class DetailPage extends BaseServlet implements CommandGet {
	private static final long serialVersionUID = 1L;
	private final DonationService donationService = new DonationServiceImpl();
//	private final UserService userService = new UserServiceImpl();
	private final UserDonationService userDonationService = new UserDonationServiceImpl();
	private static final Logger logger = Logger.getLogger(DetailPage.class.getName());

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<UserDonation> userDonations = userDonationService.findByDonationId(id);
		
		Donation donation = (!userDonations.isEmpty() ? userDonations.get(0).getDonation() : donationService.findById(id));
		
		req.setAttribute("userDonations", userDonations);
		req.setAttribute("donation", donation);
		
		view("detail", req, resp);
	}
	
}

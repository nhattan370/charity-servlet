package command.post;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandPost;
import model.UserDonation;
import service.DonationService;
import service.DonationServiceImpl;
import service.UserDonationService;
import service.UserDonationServiceImpl;
import share.BaseServlet;
import share.Color;

public class DonatePage extends BaseServlet implements CommandPost {
	private static final long serialVersionUID = 1L;
	private final UserDonationService userDonationService = new UserDonationServiceImpl();
	private final DonationService donationService = new DonationServiceImpl();
	private static final Logger logger = Logger.getLogger(DonatePage.class.getName());

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		int idDonation=0, idUser, money;
		String path = req.getContextPath();
		try {
			idUser = Integer.parseInt(req.getParameter("idUser"));
			idDonation = Integer.parseInt(req.getParameter("idDonation"));
			money = Integer.parseInt(req.getParameter("money"));
			String name = req.getParameter("name").trim();
			String text = req.getParameter("text").trim();
			path = req.getParameter("path").trim();
			
			UserDonation userDonation = new UserDonation(name, text, money, idDonation, idUser);
			
			//Save data into a table which connects User and Donation
			userDonationService.save(userDonation);
			//Update money in specific Donation
			donationService.updateMoney(money, idDonation);
			//Show toast when a donate successes	
			req.getSession().setAttribute("donate", true);			
		}catch(Exception e) {
			req.getSession().setAttribute("donate", false);
		}

		if(path.equals("detail")) {
			resp.sendRedirect(path + "?id=" + idDonation);
		}else {
			resp.sendRedirect(path);			
		}
	}
}

package command.get;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandGet;
import model.Donation;
import service.DonationService;
import service.DonationServiceImpl;
import share.BaseServlet;
import share.Color;

public class DetailPage extends BaseServlet implements CommandGet {
	private static final long serialVersionUID = 1L;
	private final DonationService donationService = new DonationServiceImpl();
	private static final Logger logger = Logger.getLogger(DetailPage.class.getName());

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Donation donation = donationService.findById(id);
		req.setAttribute("donation", donation);
		
		
		
		view("detail", req, resp);
	}
	
}

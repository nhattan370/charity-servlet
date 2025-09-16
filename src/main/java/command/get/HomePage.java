package command.get;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandGet;
import model.Donation;
import service.DonationService;
import service.DonationServiceImpl;
import share.BaseServlet;

public class HomePage extends BaseServlet implements CommandGet {
	private static final long serialVersionUID = 1L;
	private final DonationService donationService = new DonationServiceImpl();

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Donation> donations = donationService.findAll();
		req.setAttribute("donations", donations);
		view("home", req, resp);
	}
}

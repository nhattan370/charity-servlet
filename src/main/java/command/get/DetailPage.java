package command.get;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandGet;
import model.Donation;
import service.DonationService;
import service.DonationServiceImpl;
import share.BaseServlet;

public class DetailPage extends BaseServlet implements CommandGet {
	private static final long serialVersionUID = 1L;
	private final DonationService donationService = new DonationServiceImpl();

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Donation donation = donationService.finById(id);
		req.setAttribute("donation", donation);
		
		view("detail", req, resp);
	}
	
}

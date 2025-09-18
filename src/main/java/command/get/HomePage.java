package command.get;

import java.io.IOException;
import java.util.List;
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

public class HomePage extends BaseServlet implements CommandGet {
	private static final long serialVersionUID = 1L;
	private final DonationService donationService = new DonationServiceImpl();
	private final Logger logger = Logger.getLogger(HomePage.class.getName());

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNoString = req.getParameter("pageNo");
		int pageNo = (pageNoString!=null) ? Integer.parseInt(pageNoString) : 1;
		
		List<Donation> donations = donationService.handlePagination(pageNo);
		
		req.setAttribute("donations", donations);
		req.setAttribute("totalPage", donationService.getTotalPage());
		req.setAttribute("currentPage", pageNo);
		
		view("home", req, resp);
	}
}

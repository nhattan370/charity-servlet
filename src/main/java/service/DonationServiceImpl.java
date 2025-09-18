package service;

import java.util.List;
import java.util.logging.Logger;

import dao.DonationDAO;
import dao.DonationDAOImpl;
import enums.PageSize;
import enums.Table;
import model.Donation;
import pagination.Pagination;
import pagination.PaginationImpl;
import share.Color;

public class DonationServiceImpl implements DonationService{
	private final DonationDAO donationDAO = new DonationDAOImpl();
	private final Pagination<Donation> paginatedDonation = 
					new PaginationImpl<Donation>(Table.DONATION.getTableName(),
					PageSize.SMALL.getSize(),
					rs -> {
						return new Donation(
			                    rs.getInt("id"),
								rs.getString("code"),
								rs.getTimestamp("created").toLocalDateTime(),
			                    rs.getString("description"),
			                    rs.getString("end_date"),
			                    rs.getInt("money"),
			                    rs.getString("name"),
			                    rs.getString("organization_name"),
			                    rs.getString("phone_number"),
			                    rs.getString("start_date"),
			                    rs.getInt("status")
								);
						}
					);
	
	private final Logger logger = Logger.getLogger(DonationServiceImpl.class.getName());
	private int totalPage = paginatedDonation.getTotalPage();

	@Override
	public List<Donation> findAll() {
		return donationDAO.findAll();
	}

	@Override
	public Donation findById(int id) {
		return donationDAO.findById(id);
	}

	@Override
	public Donation save(Donation d) {
		return donationDAO.save(d);
	}

	@Override
	public void updateMoney(int id, int amount) {
		donationDAO.updateMoney(id, amount);
	}
	
	@Override
	public int getTotalPage() {
		return totalPage;
	}

	@Override
	public List<Donation> handlePagination(int pageNo) {
		pageNo = (pageNo>=1) ? pageNo : 1;
		pageNo = (pageNo<=totalPage) ? pageNo : totalPage;
		
		return paginatedDonation.getPageData(pageNo);
	}
}

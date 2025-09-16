package service;

import java.util.List;

import dao.DonationDAO;
import dao.DonationDAOImpl;
import model.Donation;

public class DonationServiceImpl implements DonationService{
	
	private final DonationDAO donationDAO = new DonationDAOImpl();
	
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
}

package service;

import java.util.List;

import model.Donation;

public interface DonationService {
	List<Donation> findAll();
	Donation finById(int id);
	Donation save(Donation d);
	void updateMoney(int id, int amount);
}

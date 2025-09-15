package dao;

import java.util.List;

import model.Donation;

public interface DonationDAO {
	List<Donation> findAll();
	Donation findById(int id);
	Donation save(Donation d);
	void updateMoney(int id, int amount);
}

package dao;

import java.util.List;

import model.UserDonation;

public interface UserDonationDAO {
	UserDonation save(UserDonation ud);
	List<UserDonation> findByDonationId(int donationId);
}
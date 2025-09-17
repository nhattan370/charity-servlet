package service;

import java.util.List;

import model.UserDonation;

public interface UserDonationService {
	UserDonation save(UserDonation ud);
	List<UserDonation> findByDonationId(int donationId);
}

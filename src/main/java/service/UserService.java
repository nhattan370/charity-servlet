package service;

import java.util.List;

import model.User;

public interface UserService {
	User save(User user);
	List<User> findAll();
	User findById(int id);
	List<User> findByDonationId(int donationId);
	User authenticated(String email, String password);
}

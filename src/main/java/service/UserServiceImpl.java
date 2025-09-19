package service;

import java.util.List;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

public class UserServiceImpl implements UserService{
	
	private final UserDAO userDAO = new UserDAOImpl();

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByDonationId(int donationId) {
		return userDAO.findByDonationId(donationId);
	}

	@Override
	public User authenticated(String email, String password) {
		return userDAO.findByUsernamePassword(email, password);
	}

}

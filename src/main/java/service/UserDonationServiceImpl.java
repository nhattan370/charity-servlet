package service;

import dao.UserDonationDAO;
import dao.UserDonationDAOImpl;
import model.UserDonation;

public class UserDonationServiceImpl implements UserDonationService{
	
	private final UserDonationDAO userDonationDAO = new UserDonationDAOImpl(); 

	@Override
	public UserDonation save(UserDonation ud) {
		return userDonationDAO.save(ud);
	}

}

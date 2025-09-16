package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	User save(User user);
	List<User> findAll();
	User findById(int id);
}

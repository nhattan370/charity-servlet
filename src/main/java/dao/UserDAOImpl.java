package dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import config.DBConnection;
import model.Role;
import model.User;

public class UserDAOImpl implements UserDAO{
	
	private final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByDonationId(int idDonation) {
//		String query = "SELECT u.* FROM user u"
//					 + " JOIN user_donation ud ON u.id=ud.user_id"
//					 + " WHERE ud.donation_id = ?";
		List<User> users = new ArrayList<User>();
//		try(Connection con = DBConnection.getConnection();
//			PreparedStatement ps = con.prepareStatement(query)){
//			
//			ps.setInt(1, idDonation);
//			
//			try(ResultSet rs = ps.executeQuery()){
//				while(rs.next()) {
//					Role role = new Role(rs.getInt("r.id"), rs.getString("role_name"));
//					
//					User user = new User(rs.getInt("id"), 
//							rs.getString("email"),
//							rs.getString("password"), 
//							rs.getString("user_name"), 
//							role, 
//							rs.getString("address"), 
//							rs.getString("full_name"), 
//							rs.getString("phone_number"), 
//							rs.getString("note"), 
//							rs.getTimestamp("created").toLocalDateTime(), 
//							rs.getInt("status"));
//					users.add(user);
//				}
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
		return users;
	}

	@Override
	public User findByUsernamePassword(String email, String password) {
		String query = "SELECT u.*, r.id AS role_id, r.role_name"
				+ " FROM user u"
				+ " JOIN role r ON u.role_id = r.id"
				+ " WHERE u.email=? AND u.password=?";
		User user = null;
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			ps.setString(1, email);
			ps.setString(2, password);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					Role role = new Role(rs.getInt("role_id"), rs.getString("role_name"));
					user = new User(rs.getInt("id"), 
							rs.getString("email"),
							rs.getString("password"), 
							rs.getString("user_name"), 
							role, 
							rs.getString("address"), 
							rs.getString("full_name"), 
							rs.getString("phone_number"), 
							rs.getString("note"), 
							rs.getTimestamp("created").toLocalDateTime(), 
							rs.getInt("status"));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info(share.Color.GREEN+ user.toString() +share.Color.RESET);
		return user;
	}

}

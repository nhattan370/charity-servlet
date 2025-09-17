package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import model.Donation;
import model.Role;
import model.User;
import model.UserDonation;

public class UserDonationDAOImpl implements UserDonationDAO{
	@Override
	public UserDonation save(UserDonation ud) {
		String query = "INSERT INTO user_donation (money, name, text, donation_id, user_id)"
				+ "VALUES(?,?,?,?,?)";
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			
			ps.setInt(1, ud.getMoney());
			ps.setString(2,ud.getName());
			ps.setString(3, ud.getText());
			ps.setInt(4, ud.getDonation().getId());
			ps.setInt(5, ud.getUser().getId());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ud;
	}

	@Override
	public List<UserDonation> findByDonationId(int donationId) {
		String query = "SELECT"
				+ " u.id AS user_id,"
				+ " u.address,"
				+ " u.email,"
				+ " u.full_name,"
				+ " u.note,"
				+ " u.password,"
				+ " u.phone_number AS user_phone,"
				+ " u.status AS user_status,"
				+ " u.user_name,"
				+ " u.created AS user_created,"
				
				+ " r.id AS role_id,"
				+ " r.role_name,"

				+ " d.id AS donation_id,"
				+ " d.code,"
				+ " d.created AS donation_created,"
				+ " d.description,"
				+ " d.end_date,"
				+ " d.money AS donation_money,"
				+ " d.name AS donation_name,"
				+ " d.organization_name,"
				+ " d.phone_number AS donation_phone,"
				+ " d.start_date,"
				+ " d.status AS donation_status,"

				+ " ud.id AS user_donation_id,"
				+ " ud.created AS user_donation_created,"
				+ " ud.money AS user_donation_money,"
				+ " ud.name AS user_donation_name,"
				+ " ud.status AS user_donation_status,"
				+ " ud.text AS user_donation_text"

				+ " FROM user u"
				+ " JOIN role r ON u.role_id = r.id"
				+ " JOIN user_donation ud ON u.id = ud.user_id"
				+ " JOIN donation d ON d.id = ud.donation_id"
				+ " WHERE ud.donation_id = 2;";
		List<UserDonation> userDonations = new ArrayList<>();
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			 ps.setInt(1,donationId);
			 
			 try(ResultSet rs = ps.executeQuery()){
				 while(rs.next()) {
					 Role role = new Role(rs.getInt("role_id"), rs.getString("role_name"));
					 
					 User user = new User(rs.getInt("user_id"), 
								rs.getString("email"),
								rs.getString("password"), 
								rs.getString("user_name"), 
								role, 
								rs.getString("address"), 
								rs.getString("full_name"), 
								rs.getString("user_phone"), 
								rs.getString("note"), 
								rs.getTimestamp("user_created").toLocalDateTime(), 
								rs.getInt("user_status"));
					Donation donation = new Donation(
			                    rs.getInt("donation_id"),
								rs.getString("code"),
								rs.getTimestamp("donation_created").toLocalDateTime(),
			                    rs.getString("description"),
			                    rs.getString("end_date"),
			                    rs.getInt("donation_money"),
			                    rs.getString("donation_name"),
			                    rs.getString("organization_name"),
			                    rs.getString("donation_phone"),
			                    rs.getString("start_date"),
			                    rs.getInt("donation_status"));
					UserDonation userDonation = new UserDonation(
								rs.getInt("user_donation_id"), 
								rs.getTimestamp("user_donation_created").toLocalDateTime(), 
								rs.getString("user_donation_name"), 
								rs.getString("user_donation_text"), 
								rs.getInt("user_donation_money"), 
								donation, 
								user);
					userDonations.add(userDonation);
				 }
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return userDonations;
	}
}

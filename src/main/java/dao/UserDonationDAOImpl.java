package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBConnection;
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
			ps.setInt(4, ud.getIdDonation());
			ps.setInt(5, ud.getIdUser());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ud;
	}
}

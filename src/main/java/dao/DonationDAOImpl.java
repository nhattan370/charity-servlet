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

public class DonationDAOImpl implements DonationDAO{

	@Override
	public List<Donation> findAll() {
		List<Donation> donations = new ArrayList<Donation>();
		String query = "SELECT * FROM donation";
		try(Connection con = DBConnection.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query)){
			while(rs.next()) {
				Donation donation = new Donation(
	                    rs.getInt("id"),
	                    rs.getString("description"),
	                    rs.getString("end_date"),
	                    rs.getInt("money"),
	                    rs.getString("name"),
	                    rs.getString("organization_name"),
	                    rs.getString("phone_number"),
	                    rs.getString("start_date"),
	                    rs.getInt("status"),
	                    null
						);
				donations.add(donation);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return donations;
	}

	@Override
	public Donation findById(int id) {
		Donation donation = null;
		String query = "SELECT * FROM donation WHERE id = ?";
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, id);
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					donation = new Donation(
							rs.getInt("id"),
							rs.getString("description"),
							rs.getString("end_date"),
							rs.getInt("money"),
							rs.getString("name"),
							rs.getString("organization_name"),
							rs.getString("phone_number"),
							rs.getString("start_date"),
							rs.getInt("status"),
							null
					);				
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return donation;
	}

	@Override
	public Donation save(Donation d) {
	    String query = "INSERT INTO donation "
	            + "(description, end_date, money, name, organization_name, phone_number, start_date, status) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	        
	        ps.setString(1, d.getDescription());
	        ps.setString(2, d.getEndDate());
	        ps.setInt(3, d.getMoney());
	        ps.setString(4, d.getName());
	        ps.setString(5, d.getOrganizationName());
	        ps.setString(6, d.getPhoneNumber());
	        ps.setString(7, d.getStartDate());
	        ps.setInt(8, d.getStatus());
	        
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return d;
	}
	
	@Override
	public void updateMoney(int amount, int id) {
		String query = "UPDATE donation SET money = money + ? WHERE id = ?";
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, amount);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

package pagination;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import config.DBConnection;

public class PaginationImpl<T> implements Pagination<T>{
	private final Logger logger = Logger.getLogger(PaginationImpl.class.getName());
	
	private final String tableName;
	private final RowMapper<T> mapper;

	public PaginationImpl(String tableName, RowMapper<T> mapper) {
		this.tableName = tableName;
		this.mapper = mapper;
	}

	@Override
	public int getTotalRecord() {
		logger.info(Color.GRAY + "PaginationImpl" + tableName);
		String query = "SELECT COUNT(*) AS count_ele FROM " + tableName;
		int totalRecord = 0;
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			
			try(ResultSet rs = ps.executeQuery()){
				totalRecord = rs.next() ? rs.getInt("count_ele") : totalRecord;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return totalRecord;
	}

	@Override
	public List<T> getPageData(int pageSize, int start) {
		String query = "SELECT * FROM " + tableName + " LIMIT ? OFFSET ?";
		List<T> list = new ArrayList<>();
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, pageSize);
			ps.setInt(2, start);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					list.add(mapper.mapRow(rs));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

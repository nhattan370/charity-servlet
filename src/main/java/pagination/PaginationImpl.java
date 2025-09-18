package pagination;

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
	private final int PAGE_SIZE; 
	private final RowMapper<T> mapper;
	
	public PaginationImpl(String tableName, int pageSize, RowMapper<T> mapper) {
		this.tableName = tableName;
		this.PAGE_SIZE = pageSize;
		this.mapper = mapper;
	}

	@Override
	public List<T> getPageData(int pageNo) {
		int start = (pageNo-1)*PAGE_SIZE;
		String query = "SELECT * FROM " + tableName + " LIMIT ? OFFSET ?";
		List<T> list = new ArrayList<>();
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
		        ps.setInt(1, PAGE_SIZE);
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
	
	@Override
	public int getTotalPage() {
		String query = "SELECT CEIL(COUNT(*)/?) AS total_page FROM " + tableName;
		int totalPage = 0;
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, PAGE_SIZE);
			try(ResultSet rs = ps.executeQuery()){
				totalPage = rs.next() ? rs.getInt("total_page") : totalPage;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return totalPage;
	}
}

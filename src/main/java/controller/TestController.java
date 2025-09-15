package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.DBConnection;

@WebServlet("/test-db")
public class TestController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html; charset=UTF-8");
	    try (Connection conn = DBConnection.getConnection()) {
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
	        PrintWriter out = resp.getWriter();
	        while (rs.next()) {
	            out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + "<br>");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
package com.hostmdy.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.crypto.PasswordEncoder;
import com.hostmdy.crypto.PasswordValidator;

public class UserDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	public UserDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public boolean validateUser(String email,String password) {
		
		User user = getUserByEmail(email);
		if(user!=null) {
			try {
				if(PasswordValidator.validatePassword(password,user.getPassword()) && !user.isLocked()) {
					return true;
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
		
		return false;
	}
	
	public List<User> getAllUser(){
		List<User> userList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user;");
			while(rs.next()) {
				userList.add(new User(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("nickname"), rs.getString("email"), rs.getString("password"),rs.getString("role"), rs.getBoolean("locked")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return userList;
	}
	
	public User getUserById(Long id) {
		User user = null;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from user where id=?;");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user =new User(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("nickname"), rs.getString("email"), rs.getString("password"), rs.getString("role"), rs.getBoolean("locked"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return user;
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from user where email=?;");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user =new User(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("nickname"), rs.getString("email"), rs.getString("password"), rs.getString("role"),rs.getBoolean("locked"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return user;
	}
	
	public boolean addUser(User user) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into user (firstname, lastname, nickname, email, password, role, locked) values (?,?,?,?,?,?,?);");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getNickName());
			pstmt.setString(4, user.getEmail());
			try {
				pstmt.setString(5, PasswordEncoder.encode(user.getPassword()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt.setString(6, user.getRole());
			pstmt.setBoolean(7, false);
			
			int effectedRows = pstmt.executeUpdate();
			
			success = effectedRows>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return success;
	}
	
	public boolean updateUser(User user) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update set user firstname=?, lastname=?, nickname=?, email=?, password=?, locked=? where id=?;");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getNickName());
			pstmt.setString(4, user.getEmail());
			try {
				pstmt.setString(5, PasswordEncoder.encode(user.getPassword()));
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pstmt.setBoolean(6, user.isLocked());
			pstmt.setLong(7, user.getId());
			
			int effectedRows = pstmt.executeUpdate();
			
			success = effectedRows>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return success;
	}
	
	public boolean deleteUser(Long id) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from user where id=?;");
			pstmt.setLong(1, id);
			int effectedRows = pstmt.executeUpdate();
			success = effectedRows>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return success;
	}

	private void close() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

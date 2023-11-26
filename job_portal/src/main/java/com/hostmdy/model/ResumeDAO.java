package com.hostmdy.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ResumeDAO {

	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;

	public ResumeDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	// Resume id and User id are same...
	public Resume getResumeById(Long id) {

		Resume resume = null;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from resume where id=?;");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resume = new Resume(rs.getLong("id"), rs.getString("name"), rs.getString("gender"),
						rs.getDate("dateofbirth").toLocalDate(), rs.getString("phone"), rs.getString("email"),
						rs.getString("address"), rs.getString("about"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return resume;

	}

	public boolean addResume(Resume resume) {
		boolean success = false;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(
					"insert into resume (id, name, gender, dateofbirth, phone, email, address, about) values (?,?,?,?,?,?,?,?);");
			pstmt.setLong(1, resume.getId());
			pstmt.setString(2, resume.getName());
			pstmt.setString(3, resume.getGender());
			pstmt.setDate(4, Date.valueOf(resume.getDateOfBirth()));
			pstmt.setString(5, resume.getPhone());
			pstmt.setString(6, resume.getEmail());
			pstmt.setString(7, resume.getAddress());
			pstmt.setString(8, resume.getAbout());

			int eff = pstmt.executeUpdate();

			success = eff > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return success;
	}

	public boolean updateResume(Resume resume) {
		boolean success = false;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(
					"update resume set name=?,gender=?,dateofbirth=?,phone=?,email=?,address=?,about=? where id=?;");
			
			pstmt.setString(1, resume.getName());
			pstmt.setString(2, resume.getGender());
			pstmt.setDate(3, Date.valueOf(resume.getDateOfBirth()));
			pstmt.setString(4, resume.getPhone());
			pstmt.setString(5, resume.getEmail());
			pstmt.setString(6, resume.getAddress());
			pstmt.setString(7, resume.getAbout());
			pstmt.setLong(8, resume.getId());

			int eff = pstmt.executeUpdate();

			success = eff > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return success;
	}
	
	public boolean deleteResume(Long id) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from resume where id=?;");
			pstmt.setLong(1, id);
			
			int eff = pstmt.executeUpdate();
			
			success = eff>0;
			
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

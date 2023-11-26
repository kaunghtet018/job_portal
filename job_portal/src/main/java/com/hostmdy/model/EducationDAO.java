package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EducationDAO {

	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public EducationDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Education> getEducation(Long id) {
		List<Education> educationList = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from education where resumeid=?;");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				educationList.add(new Education(rs.getLong("id"), rs.getString("certificate"),
						rs.getString("institution"), rs.getString("daterange"), id));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return educationList;
	}

	public boolean addEducation(Education education) {
		boolean success = false;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(
					"insert into education (certificate,institution,daterange,resumeid) values (?,?,?,?);");
			pstmt.setString(1, education.getCertificate());
			pstmt.setString(2, education.getInstitution());
			pstmt.setString(3, education.getDateRange());
			pstmt.setLong(4, education.getResumeId());

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

	public boolean updateEducation(Education education) {
		boolean success = false;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(
					"update education set certificate=?,institution=?,daterange=?,resumeid=? where id=?;");
			pstmt.setString(1, education.getCertificate());
			pstmt.setString(2, education.getInstitution());
			pstmt.setString(3, education.getDateRange());
			pstmt.setLong(4, education.getResumeId());
			pstmt.setLong(5, education.getId());

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

	public boolean deleteEducation(Long id) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from education where resumeid=?;");
			pstmt.setLong(1, id);
			int eff = pstmt.executeUpdate();
			success=eff>0;
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

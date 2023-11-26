package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ExperienceDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public ExperienceDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	
	public List<Experience> getExperience(Long id){
		List<Experience> experienceList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from experience where resumeid=?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				experienceList.add(new Experience(rs.getLong("id"), rs.getString("company"), rs.getString("location"), rs.getString("position"), rs.getString("daterange"), rs.getString("task"), id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return experienceList;
	}
	
	public boolean addExperience(Experience experience) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into experience (company, location, position, daterange, task, resumeid) values (?,?,?,?,?,?);");
			pstmt.setString(1, experience.getCompany());
			pstmt.setString(2, experience.getLocation());
			pstmt.setString(3, experience.getPosition());
			pstmt.setString(4, experience.getDateRange());
			pstmt.setString(5, experience.getTask());
			pstmt.setLong(6, experience.getResumeId());
			
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
	
	public boolean updateExperience(Experience experience) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update experience set company=?, location=?, position=?, daterange=?, task=?, resumeid=? where id=?;");
			pstmt.setString(1, experience.getCompany());
			pstmt.setString(2, experience.getLocation());
			pstmt.setString(3, experience.getPosition());
			pstmt.setString(4, experience.getDateRange());
			pstmt.setString(5, experience.getTask());
			pstmt.setLong(6, experience.getResumeId());
			pstmt.setLong(7, experience.getId());
			
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
	
	public boolean deleteExperience(Long id) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from experience where resumeid=?;");
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
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

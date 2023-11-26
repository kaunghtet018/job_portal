package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class RequirementDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public RequirementDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<Requirement> getRequirementsByJobPostId(Long jobPostId) {
		List<Requirement> requirements = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from requirements where jobpostid=?;");
			pstmt.setLong(1, jobPostId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				requirements.add(new Requirement(rs.getLong("id"), rs.getString("requirement"), rs.getLong("jobpostid")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return requirements;
	}

	public boolean addRequirement(Requirement requirement) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into requirements (requirement, jobpostid) values (?,?);");
			pstmt.setString(1, requirement.getRequirement());
			pstmt.setLong(2, requirement.getJobPostId());

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

	public boolean updateRequirement(Requirement requirement) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update requirements set requirement=?,jobpostid=? where id=?;");
			pstmt.setString(1, requirement.getRequirement());
			pstmt.setLong(2, requirement.getJobPostId());
			pstmt.setLong(3, requirement.getId());
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

	public boolean deleteRequirement(Long jobPostId) {
		boolean success = false;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from requirements where jobpostid=?;");
			pstmt.setLong(1, jobPostId);
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

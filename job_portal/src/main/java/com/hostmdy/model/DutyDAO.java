package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DutyDAO {

	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public DutyDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Duty> getDutiesByJobPostId(Long jobPostId) {
		List<Duty> duties = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from duties where jobpostid=?;");
			pstmt.setLong(1, jobPostId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				duties.add(new Duty(rs.getLong("id"), rs.getString("duty"), rs.getLong("jobpostid")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return duties;
	}

	public boolean addDuty(Duty duty) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into duties (duty, jobpostid) values (?,?);");
			pstmt.setString(1, duty.getDuty());
			pstmt.setLong(2, duty.getJobPostId());

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

	public boolean updateDuty(Duty duty) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update duties set duty=?,jobpostid=? where id=?;");
			pstmt.setString(1, duty.getDuty());
			pstmt.setLong(2, duty.getJobPostId());
			pstmt.setLong(3, duty.getId());
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

	public boolean deleteDuty(Long jobPostId) {
		boolean success = false;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from duties where jobpostid=?;");
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

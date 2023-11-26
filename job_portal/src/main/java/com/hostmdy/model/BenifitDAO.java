package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BenifitDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	public BenifitDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Benifit> getBenifitsByJobPostId(Long jobPostId) {
		List<Benifit> benifits = new ArrayList<>();

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from benifits where jobpostid=?;");
			pstmt.setLong(1, jobPostId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				benifits.add(new Benifit(rs.getLong("id"), rs.getString("benifit"), rs.getLong("jobpostid")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return benifits;
	}

	public boolean addBenifit(Benifit benifit) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into benifits (benifit, jobpostid) values (?,?);");
			pstmt.setString(1, benifit.getBenifit());
			pstmt.setLong(2, benifit.getJobPostId());

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

	public boolean updateBenifit(Benifit benifit) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update benifits set benifit=?,jobpostid=? where id=?;");
			pstmt.setString(1, benifit.getBenifit());
			pstmt.setLong(2, benifit.getJobPostId());
			pstmt.setLong(3, benifit.getId());
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

	public boolean deleteBenifit(Long jobPostId) {
		boolean success = false;

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from benifits where jobpostid=?;");
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

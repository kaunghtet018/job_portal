package com.hostmdy.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JobApplyDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public JobApplyDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<JobApply> getJobApplyByJobPostId(Long jobPostId){
		List<JobApply> jobApplyList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from jobapply where jobpostid=?;");
			pstmt.setLong(1, jobPostId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jobApplyList.add(new JobApply(rs.getLong("id"),rs.getLong("userid"), rs.getLong("jobpostid"), rs.getDate("applydate").toLocalDate(), rs.getTime("applytime").toLocalTime()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return jobApplyList;
	}
	
	public List<JobApply> getJobApplyByUserId(Long userId){
		List<JobApply> jobApplyList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from jobapply where userid=?;");
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jobApplyList.add(new JobApply(rs.getLong("id"),rs.getLong("userid"), rs.getLong("jobpostid"), rs.getDate("applydate").toLocalDate(), rs.getTime("applytime").toLocalTime()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return jobApplyList;
	}
	
	public JobApply checkJobApply(Long userId, Long jobPostId){
		JobApply jobApply =  null;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from jobapply where userid=? and jobpostid=?;");
			pstmt.setLong(1, userId);
			pstmt.setLong(2, jobPostId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jobApply = new JobApply(rs.getLong("id"),rs.getLong("userid"), rs.getLong("jobpostid"), rs.getDate("applydate").toLocalDate(), rs.getTime("applytime").toLocalTime());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return jobApply;
	}
	
	public boolean addJobApply(JobApply jobApply) {
		boolean success = false;
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into jobapply (userid,jobpostid,applydate,applytime) values (?,?,?,?);");
			pstmt.setLong(1, jobApply.getUserId());
			pstmt.setLong(2, jobApply.getJobPostId());
			pstmt.setDate(3, Date.valueOf(jobApply.getApplyDate()));
			pstmt.setTime(4, Time.valueOf(jobApply.getApplyTime()));
			
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

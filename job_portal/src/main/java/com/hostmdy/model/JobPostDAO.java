package com.hostmdy.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JobPostDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	
	public JobPostDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public boolean closeJobPost(Long id) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update jobpost set status='closed' where id=?;");
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
	
	public List<JobPost> getAllJobPost(){
		List<JobPost> jobPostList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from jobpost order by id desc;");
			while(rs.next()) {
				jobPostList.add(new JobPost(rs.getLong("id"), rs.getString("title"), rs.getDate("duedate").toLocalDate(), rs.getString("employer"), rs.getString("location"), rs.getString("type"), rs.getString("industry"), rs.getInt("salary"), rs.getString("description"),rs.getString("status")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return jobPostList;
	}
	
	//
	public List<JobPost> getAllOpenJobPost(){
		List<JobPost> jobPostList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from jobpost where status='open' order by id desc;");
			while(rs.next()) {
				jobPostList.add(new JobPost(rs.getLong("id"), rs.getString("title"), rs.getDate("duedate").toLocalDate(), rs.getString("employer"), rs.getString("location"), rs.getString("type"), rs.getString("industry"), rs.getInt("salary"), rs.getString("description"),rs.getString("status")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return jobPostList;
	}
	
	
	public JobPost getJobPostById(Long id){
		JobPost jobPost = null;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from jobpost where id=? order by id desc;");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jobPost = new JobPost(rs.getLong("id"), rs.getString("title"), rs.getDate("duedate").toLocalDate(), rs.getString("employer"), rs.getString("location"), rs.getString("type"), rs.getString("industry"), rs.getInt("salary"), rs.getString("description"),rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return jobPost;
	}
	
	public boolean addJobPost(JobPost jobPost) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into jobpost (title, duedate, employer, location, type, industry, salary, description,status) values (?,?,?,?,?,?,?,?,'open');");
			pstmt.setString(1, jobPost.getTitle());
			pstmt.setDate(2, Date.valueOf(jobPost.getDueDate()));
			pstmt.setString(3, jobPost.getEmployer());
			pstmt.setString(4, jobPost.getLocation());
			pstmt.setString(5, jobPost.getType());
			pstmt.setString(6, jobPost.getIndustry());
			pstmt.setInt(7, jobPost.getSalary());
			pstmt.setString(8, jobPost.getDescription());
			
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
	
	public boolean updateJobPost(JobPost jobPost) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update jobpost set title=?, duedate=?, employer=?, location=?, type=?, industry=?, salary=?, description=? where id=?;");
			pstmt.setString(1, jobPost.getTitle());
			pstmt.setDate(2, Date.valueOf(jobPost.getDueDate()));
			pstmt.setString(3, jobPost.getEmployer());
			pstmt.setString(4, jobPost.getLocation());
			pstmt.setString(5, jobPost.getType());
			pstmt.setString(6, jobPost.getIndustry());
			pstmt.setInt(7, jobPost.getSalary());
			pstmt.setString(8, jobPost.getDescription());
			
			pstmt.setLong(9, jobPost.getId());
			
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

	public boolean deleteJobPost(Long id) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from jobpost where id=?;");
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
	
	public List<JobPost> searchJobPost(String search) {
		List<JobPost> jobPostList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from jobpost where title like ? or employer like ? or location like ? or industry like ?;");
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setString(3, "%"+search+"%");
			pstmt.setString(4, "%"+search+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jobPostList.add(new JobPost(rs.getLong("id"), rs.getString("title"), rs.getDate("duedate").toLocalDate(), rs.getString("employer"), rs.getString("location"), rs.getString("type"), rs.getString("industry"), rs.getInt("salary"), rs.getString("description")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobPostList;
		
	}
	
	
	public Long getLastId() {
		Long id = 0L;
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("select max(id) as maxid from jobpost;");
			while(rs.next()) {
				id = rs.getLong("maxid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return id;
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

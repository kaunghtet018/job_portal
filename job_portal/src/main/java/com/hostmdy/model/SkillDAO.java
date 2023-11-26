package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SkillDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public SkillDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<Skill> getSkill(Long id){
		List<Skill> skillList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("select * from skills where resumeid=?;");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				skillList.add(new Skill(rs.getLong("id"), rs.getString("skill"), id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return skillList;
	}
	
	public boolean addSkill(Skill skill) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("insert into skills (skill,resumeid) values (?,?);");
			pstmt.setString(1, skill.getSkill());
			pstmt.setLong(2, skill.getResumeId());
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
	
	public boolean updateSkill(Skill skill) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("update skills set skill=?,resumeid=? where id=?;");
			pstmt.setString(1, skill.getSkill());
			pstmt.setLong(2, skill.getResumeId());
			pstmt.setLong(3, skill.getId());
			
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
	
	public boolean deleteSkill(Long id) {
		boolean success = false;
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement("delete from skills where resumeid=?;");
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

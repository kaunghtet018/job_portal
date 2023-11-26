package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.AppliedJob;
import com.hostmdy.model.JobApply;
import com.hostmdy.model.JobApplyDAO;
import com.hostmdy.model.JobPost;
import com.hostmdy.model.JobPostDAO;
import com.hostmdy.model.User;

/**
 * Servlet implementation class JobApplyController
 */
public class JobApplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/job_portal")
	private DataSource dataSource;
	private JobApplyDAO jobApplyDAO;
	private JobPostDAO jobPostDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		jobApplyDAO = new JobApplyDAO(dataSource);
		jobPostDAO = new JobPostDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		if(mode==null) {
			mode = "DEFAULT";
		}
		switch(mode) {
		case "ADDAPPLY":{
			addJobApply(request,response);
			break;
		}
		case "SHOWAPPLY":{
			showJobApply(request,response);
			break;
		}
		case "SHOWAPPLIEDJOBS":{
			showAppliedJobs(request,response);
			break;
		}
		default:{
			goIndex(request,response);
			break;
		}
		}
	}

	private void showAppliedJobs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<JobApply> jobApplyList = jobApplyDAO.getJobApplyByUserId(user.getId());
		List<AppliedJob> appliedJobList = new ArrayList<>();
		for(JobApply jobApply:jobApplyList) {
			JobPost jobPost = jobPostDAO.getJobPostById(jobApply.getJobPostId());
			appliedJobList.add(new AppliedJob(jobPost.getId(), jobPost.getTitle(), jobPost.getStatus(), jobApply.getApplyDate(), jobApply.getApplyTime()));
		}
		
		request.setAttribute("total", appliedJobList.size());
		request.setAttribute("appliedJobList", appliedJobList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/appliedjobs.jsp");
		dispatcher.forward(request, response);
	}

	private void showJobApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		List<JobApply> applyList = jobApplyDAO.getJobApplyByJobPostId(id);
		
		request.setAttribute("applyList", applyList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login?mode=APPLYINFO");
		dispatcher.forward(request, response);
	}

	private void addJobApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		User user = (User)request.getSession().getAttribute("user");
		Long userid = user.getId();
		boolean success = jobApplyDAO.addJobApply(new JobApply(userid, id, LocalDate.now(), LocalTime.now()));
		
		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jobpost?mode=JOBDETAIL&id="+id);
		dispatcher.forward(request, response);
	}

	private void goIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("jobpost");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

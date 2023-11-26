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
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Benifit;
import com.hostmdy.model.BenifitDAO;
import com.hostmdy.model.Duty;
import com.hostmdy.model.DutyDAO;
import com.hostmdy.model.JobApply;
import com.hostmdy.model.JobApplyDAO;
import com.hostmdy.model.JobPost;
import com.hostmdy.model.JobPostDAO;
import com.hostmdy.model.Requirement;
import com.hostmdy.model.RequirementDAO;
import com.hostmdy.model.User;

/**
 * Servlet implementation class JobPostController
 */
public class JobPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	@Resource(name="jdbc/job_portal")
	private DataSource dataSource;
	private JobPostDAO jobPostDAO;
	private DutyDAO dutyDAO;
	private RequirementDAO requirementDAO;
	private BenifitDAO benifitDAO;
	private JobApplyDAO jobApplyDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		jobPostDAO = new JobPostDAO(dataSource);
		dutyDAO = new DutyDAO(dataSource);
		requirementDAO = new RequirementDAO(dataSource);
		benifitDAO = new BenifitDAO(dataSource);
		jobApplyDAO = new JobApplyDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		if(mode==null) {
			mode = "SHOWINDEX";
		}
		
		switch (mode) {
		case "SHOWINDEX": {
			showIndex(request,response);
			break;
		}
		case "SHOWADDJOB": {
			showAddJob(request,response);
			break;
		}
		case "ADDJOB": {
			addJob(request,response);
			break;
		}
		case "JOBDETAIL":{
			showJobDetail(request,response);
			break;
		}
		case "DELETE":{
			delete(request,response);
			break;
		}
		case "SHOWUPDATE":{
			showUpdateJob(request,response);
			break;
		}
		case "UPDATE":{
			updateJob(request,response);
			break;
		}
		case "SEARCH":{
			searchJob(request,response);
			break;
		}
		case "CLOSE":{
			closeJob(request,response);
			break;
		}
		default:
			showIndex(request, response);
			break;
		}
		
	}

	private void closeJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("jobPostId"));
		jobPostDAO.closeJobPost(id);
		JobPost jobPost = jobPostDAO.getJobPostById(id);
		List<Requirement> reqs = requirementDAO.getRequirementsByJobPostId(id);
		List<Duty> duties = dutyDAO.getDutiesByJobPostId(id);
		List<Benifit> benis = benifitDAO.getBenifitsByJobPostId(id);
		
		request.setAttribute("jobPost", jobPost);
		
		request.setAttribute("reqs", reqs);
		request.setAttribute("duties", duties);
		request.setAttribute("benis", benis);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/jobdetail.jsp");
		dispatcher.forward(request, response);
	}

	private void searchJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("jobsearch");
		
		List<JobPost> jobPostList = jobPostDAO.searchJobPost(search);
		request.setAttribute("jobPostList", jobPostList);
		request.setAttribute("resultsize", jobPostList.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/index.jsp");
		dispatcher.forward(request, response);
	}

	private void updateJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		String employer = request.getParameter("employer");
		Integer salary = Integer.parseInt(request.getParameter("salary"));
		String location = request.getParameter("location");
		String type = request.getParameter("type");
		String industry = request.getParameter("industry");
		LocalDate duedate = LocalDate.parse(request.getParameter("duedate"));
		String description = request.getParameter("description");
		
		String [] requirements = request.getParameterValues("requirement");
		String [] duties = request.getParameterValues("duty");
		String [] benifits = request.getParameterValues("benifit");
		
		boolean success = false;
		boolean successI = jobPostDAO.updateJobPost(new JobPost(id, title, duedate, employer, location, type, industry, salary, description));
		if(successI) {
			benifitDAO.deleteBenifit(id);
			dutyDAO.deleteDuty(id);
			requirementDAO.deleteRequirement(id);
			boolean successII = true;
			for(String requirement:requirements) {
				successII = successII && requirementDAO.addRequirement(new Requirement(requirement, id));
			}
			if(successII) {
				boolean successIII = true;
				for(String duty:duties) {
					successII = successII && dutyDAO.addDuty(new Duty(duty, id));
				}
				if(successIII) {
					boolean successIV = true;
					for(String benifit:benifits) {
						successIV = successIV && benifitDAO.addBenifit(new Benifit(benifit, id));
					}
					if(successIV) {
						success = true;
					}
					else {
						benifitDAO.deleteBenifit(id);
						dutyDAO.deleteDuty(id);
						requirementDAO.deleteRequirement(id);
						jobPostDAO.deleteJobPost(id);
					}
				}
				else {
					dutyDAO.deleteDuty(id);
					requirementDAO.deleteRequirement(id);
					jobPostDAO.deleteJobPost(id);
				}
				
			}
			else {
				requirementDAO.deleteRequirement(id);
				jobPostDAO.deleteJobPost(id);
			}
		}
		
		JobPost jobPost = jobPostDAO.getJobPostById(id);
		List<Duty> dutie = dutyDAO.getDutiesByJobPostId(id);
		List<Requirement> reqs = requirementDAO.getRequirementsByJobPostId(id);
		List<Benifit> benis = benifitDAO.getBenifitsByJobPostId(id);
		
		request.setAttribute("jobPost", jobPost);
		request.setAttribute("duties", dutie);
		request.setAttribute("reqs", reqs);
		request.setAttribute("benis", benis);
		
		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/updatejob.jsp");
		dispatcher.forward(request, response);
	}

	private void showUpdateJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		
		JobPost jobPost = jobPostDAO.getJobPostById(id);
		List<Duty> duties = dutyDAO.getDutiesByJobPostId(id);
		List<Requirement> reqs = requirementDAO.getRequirementsByJobPostId(id);
		List<Benifit> benis = benifitDAO.getBenifitsByJobPostId(id);
		
		request.setAttribute("jobPost", jobPost);
		request.setAttribute("duties", duties);
		request.setAttribute("reqs", reqs);
		request.setAttribute("benis", benis);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/updatejob.jsp");
		dispatcher.forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		boolean success = jobPostDAO.deleteJobPost(id);
		if(success) {
			dutyDAO.deleteDuty(id);
			requirementDAO.deleteRequirement(id);
			benifitDAO.deleteBenifit(id);
		}
		response.sendRedirect("jobpost");
	}

	private void showJobDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		JobPost jobPost = jobPostDAO.getJobPostById(id);
		List<Requirement> reqs = requirementDAO.getRequirementsByJobPostId(id);
		List<Duty> duties = dutyDAO.getDutiesByJobPostId(id);
		List<Benifit> benis = benifitDAO.getBenifitsByJobPostId(id);
		
		request.setAttribute("jobPost", jobPost);
		
		request.setAttribute("reqs", reqs);
		request.setAttribute("duties", duties);
		request.setAttribute("benis", benis);
		
		if(user!=null) {
			JobApply applied = jobApplyDAO.checkJobApply(user.getId(), id);
			request.setAttribute("isapplied", applied!=null);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/jobdetail.jsp");
		dispatcher.forward(request, response);

	}

	private void addJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		String employer = request.getParameter("employer");
		Integer salary = Integer.parseInt(request.getParameter("salary"));
		String location = request.getParameter("location");
		String type = request.getParameter("type");
		String industry = request.getParameter("industry");
		LocalDate duedate = LocalDate.parse(request.getParameter("duedate"));
		String description = request.getParameter("description");
		
		String [] requirements = request.getParameterValues("requirement");
		String [] duties = request.getParameterValues("duty");
		String [] benifits = request.getParameterValues("benifit");
		
		boolean success = false;
		boolean successI = jobPostDAO.addJobPost(new JobPost(title, duedate, employer, location, type, industry, salary, description));
		if(successI) {
			boolean successII = true;
			Long id = jobPostDAO.getLastId();
			for(String requirement:requirements) {
				successII = successII && requirementDAO.addRequirement(new Requirement(requirement, id));
			}
			if(successII) {
				boolean successIII = true;
				for(String duty:duties) {
					successII = successII && dutyDAO.addDuty(new Duty(duty, id));
				}
				if(successIII) {
					boolean successIV = true;
					for(String benifit:benifits) {
						successIV = successIV && benifitDAO.addBenifit(new Benifit(benifit, id));
					}
					if(successIV) {
						success = true;
					}
					else {
						benifitDAO.deleteBenifit(id);
						dutyDAO.deleteDuty(id);
						requirementDAO.deleteRequirement(id);
						jobPostDAO.deleteJobPost(id);
					}
				}
				else {
					dutyDAO.deleteDuty(id);
					requirementDAO.deleteRequirement(id);
					jobPostDAO.deleteJobPost(id);
				}
				
			}
			else {
				requirementDAO.deleteRequirement(id);
				jobPostDAO.deleteJobPost(id);
			}
		}
		
		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/addjob.jsp");
		dispatcher.forward(request, response);
	}

	private void showAddJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/addjob.jsp");
		dispatcher.forward(request, response);
		
	}

	private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		List<JobPost> jobPostList = null;
		
		if(user!=null && user.getRole().equals("admin")) {
			jobPostList = jobPostDAO.getAllJobPost();
		}
		else {
			jobPostList = jobPostDAO.getAllOpenJobPost();
		}
		request.setAttribute("jobPostList", jobPostList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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

import com.hostmdy.model.Education;
import com.hostmdy.model.EducationDAO;
import com.hostmdy.model.Experience;
import com.hostmdy.model.ExperienceDAO;
import com.hostmdy.model.Resume;
import com.hostmdy.model.ResumeDAO;
import com.hostmdy.model.Skill;
import com.hostmdy.model.SkillDAO;
import com.hostmdy.model.User;

/**
 * Servlet implementation class ResumeController
 */
public class ResumeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/job_portal")
	private DataSource dataSource;
	private ResumeDAO resumeDAO;
	private EducationDAO educationDAO;
	private ExperienceDAO experienceDAO;
	private SkillDAO skillDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResumeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		resumeDAO = new ResumeDAO(dataSource);
		educationDAO = new EducationDAO(dataSource);
		experienceDAO = new ExperienceDAO(dataSource);
		skillDAO = new SkillDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String mode = request.getParameter("mode");

		if (mode == null) {
			mode = "SHOWADDRESUME";
		}

		switch (mode) {

		case "CHECK":{
			check(request, response);
			break;
		}
		case "SHOWRESUME": {
			show(request, response);
			break;
		}

		case "SHOWADDRESUME": {
			showAddResume(request, response);
			break;
		}
		case "ADDRESUME": {
			addResume(request, response);
			break;
		}
		case "SHOWUPDATERESUME": {
			showUpdateResume(request, response);
			break;
		}
		case "UPDATERESUME": {
			updateResume(request, response);
			break;
		}
		default: {
			showAddResume(request, response);
			break;
		}
		}

	}

	private void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Long id = ((User) session.getAttribute("user")).getId();
		
		boolean exit = resumeDAO.getResumeById(id)!=null;
		session.setAttribute("exit", exit);
		
		response.sendRedirect("jobpost");
		
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Long id = Long.parseLong(request.getParameter("id"));

		request.setAttribute("resume", resumeDAO.getResumeById(id));
		request.setAttribute("eduList", educationDAO.getEducation(id));
		request.setAttribute("expList", experienceDAO.getExperience(id));
		request.setAttribute("skillList", skillDAO.getSkill(id));

		RequestDispatcher dispatcher = request.getRequestDispatcher("view/resumedetail.jsp");
		dispatcher.forward(request, response);
	}

	private void updateResume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		LocalDate dateofbirth = LocalDate.parse(request.getParameter("dateofbirth"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		String about = request.getParameter("about");

		String[] certificates = request.getParameterValues("certificate");
		String[] institutions = request.getParameterValues("institution");
		String[] daterange1 = request.getParameterValues("daterange1");

		String[] companies = request.getParameterValues("company");
		String[] locations = request.getParameterValues("location");
		String[] positions = request.getParameterValues("position");
		String[] daterange2 = request.getParameterValues("daterange2");

		String[] skills = request.getParameterValues("skill");

		Resume resume = new Resume(user.getId(), name, gender, dateofbirth, phone, email, address, about);
		boolean success = false;
		boolean successI = resumeDAO.updateResume(resume);

		if (successI) {

			skillDAO.deleteSkill(user.getId());
			experienceDAO.deleteExperience(user.getId());
			educationDAO.deleteEducation(user.getId());

			int length1 = certificates.length;
			boolean successII = true;
			for (int i = 0; i < length1; i++) {
				successII = successII && educationDAO
						.addEducation(new Education(certificates[i], institutions[i], daterange1[i], user.getId()));
			}
			if (successII) {
				int length2 = companies.length;
				boolean successIII = true;
				for (int j = 0; j < length2; j++) {
					successIII = successIII && experienceDAO.addExperience(
							new Experience(companies[j], locations[j], positions[j], daterange2[j], "", user.getId()));
				}
				if (successIII) {
					boolean successIV = true;
					for (String skill : skills) {
						successIV = successIV && skillDAO.addSkill(new Skill(skill, user.getId()));
					}
					if (successIV) {
						success = true;
					}
				}
			}

		}
		
		request.setAttribute("resume", resumeDAO.getResumeById(user.getId()));
		request.setAttribute("educationList", educationDAO.getEducation(user.getId()));
		request.setAttribute("experienceList", experienceDAO.getExperience(user.getId()));
		request.setAttribute("skillList", skillDAO.getSkill(user.getId()));

		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/updateresume.jsp");
		dispatcher.forward(request, response);
	}

	private void showUpdateResume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Resume resume = resumeDAO.getResumeById(user.getId());
		List<Education> educationList = educationDAO.getEducation(user.getId());
		List<Experience> experienceList = experienceDAO.getExperience(user.getId());
		List<Skill> skillList = skillDAO.getSkill(user.getId());

		request.setAttribute("resume", resume);
		request.setAttribute("educationList", educationList);
		request.setAttribute("experienceList", experienceList);
		request.setAttribute("skillList", skillList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("view/updateresume.jsp");
		dispatcher.forward(request, response);
	}

	private void addResume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		LocalDate dateofbirth = LocalDate.parse(request.getParameter("dateofbirth"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		String about = request.getParameter("about");

		String[] certificates = request.getParameterValues("certificate");
		String[] institutions = request.getParameterValues("institution");
		String[] daterange1 = request.getParameterValues("daterange1");

		String[] companies = request.getParameterValues("company");
		String[] locations = request.getParameterValues("location");
		String[] positions = request.getParameterValues("position");
		String[] daterange2 = request.getParameterValues("daterange2");

		String[] skills = request.getParameterValues("skill");

		Resume resume = new Resume(user.getId(), name, gender, dateofbirth, phone, email, address, about);
		boolean success = false;
		boolean successI = resumeDAO.addResume(resume);

		if (successI) {

			int length1 = certificates.length;
			boolean successII = true;
			for (int i = 0; i < length1; i++) {
				successII = successII && educationDAO
						.addEducation(new Education(certificates[i], institutions[i], daterange1[i], user.getId()));
			}
			if (successII) {
				int length2 = companies.length;
				boolean successIII = true;
				for (int j = 0; j < length2; j++) {
					successIII = successIII && experienceDAO.addExperience(
							new Experience(companies[j], locations[j], positions[j], daterange2[j], "", user.getId()));
				}
				if (successIII) {
					boolean successIV = true;
					for (String skill : skills) {
						successIV = successIV && skillDAO.addSkill(new Skill(skill, user.getId()));
					}
					if (successIV) {
						success = true;
					} else {
						skillDAO.deleteSkill(user.getId());
						experienceDAO.deleteExperience(user.getId());
						educationDAO.deleteEducation(user.getId());
						resumeDAO.deleteResume(user.getId());
					}
				} else {
					experienceDAO.deleteExperience(user.getId());
					educationDAO.deleteEducation(user.getId());
					resumeDAO.deleteResume(user.getId());
				}
			} else {
				educationDAO.deleteEducation(user.getId());
				resumeDAO.deleteResume(user.getId());
			}

		}
		
		
		session.setAttribute("exit", success);

		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/addresume.jsp");
		dispatcher.forward(request, response);
	}

	private void showAddResume(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/addresume.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.JobApply;
import com.hostmdy.model.User;
import com.hostmdy.model.UserDAO;
import com.hostmdy.model.UserInfo;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Resource(name="jdbc/job_portal")
	private DataSource dataSource;
	private UserDAO userDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userDAO = new UserDAO(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		if(mode==null) {
			mode="SHOWLOGIN";
		}
		switch(mode) {
		case "SHOWLOGIN":{
			showLogin(request,response);
			break;
		}
		case "LOGIN":{
			login(request,response);
			break;
		}
		case "SHOWSIGNUP":{
			showSignup(request,response);
			break;
		}
		case "SIGNUP":{
			signup(request,response);
			break;
		}
		case "LOGOUT":{
			logout(request,response);
			break;
		}
		case "APPLYINFO":{
			showApplyList(request,response);
			break;
		}
		default:{
			showLogin(request,response);
			break;
		}
		}
	}

	private void showApplyList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		ArrayList<JobApply> applyList = (ArrayList<JobApply>)request.getAttribute("applyList");
		int total = applyList.size();
		
		List<UserInfo> userInfoList = new ArrayList<>();
		
		if(applyList!=null) {
			for(JobApply jobApply : applyList) {
				User user = userDAO.getUserById(jobApply.getUserId());
				userInfoList.add(new UserInfo(jobApply.getUserId(), jobApply.getJobPostId() , user.getNickName(), user.getEmail(), jobApply.getApplyDate(), jobApply.getApplyTime()));
			}
		}
		
		request.setAttribute("total", total);
		request.setAttribute("userInfoList", userInfoList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/applylist.jsp");
		dispatcher.forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("login");
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String nickName = request.getParameter("nickname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(firstName, lastName, nickName, email, password,"user", false);
		
		boolean success = userDAO.addUser(user);
		request.setAttribute("success", success);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/signup.jsp");
		dispatcher.forward(request, response);
	}

	private void showSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/signup.jsp");
		dispatcher.forward(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(userDAO.validateUser(email, password)) {
			
			User user = userDAO.getUserByEmail(email);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(3600);
			
			response.sendRedirect("resume?mode=CHECK");
		}
		else {
			request.setAttribute("success", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.jsp");
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

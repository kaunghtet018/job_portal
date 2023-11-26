<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<nav class="navbar  navbar-expand-md navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">JobSearch</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="jobpost">Home</a>
              </li>
              <li class="nav-item dropdown">
                <c:if test="${not empty user}">
                	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  ${user.nickName}
                	</a>
                </c:if>
                <c:if test="${empty user}">
                	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Your Account
                	</a>
                
                </c:if>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <c:if test="${empty user}">
                	<li><a href="login?mode=SHOWSIGNUP" class="dropdown-item">Sign Up</a></li>
                	<li><a href="login?mode=SHOWLOGIN" class="dropdown-item">Login</a></li>
                </c:if>
                <c:if test="${fn:contains(user.role,'admin')}">
					<li><a href="jobpost?mode=SHOWADDJOB" class="dropdown-item">Post A Job</a></li>
					<li><a class="dropdown-item" href="login?mode=LOGOUT">Logout</a></li>
				</c:if>
				<c:if test="${fn:contains(user.role,'user')}">
					
					<c:choose>
						<c:when test="${exit}">
							<li><a href="resume?mode=SHOWUPDATERESUME" class="dropdown-item">Update Your Resume</a></li>
							<li><a href="resume?mode=SHOWRESUME&id=${user.id}" class="dropdown-item">View Your Resume</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="resume?mode=SHOWADDRESUME" class="dropdown-item">Add Your Resume</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="jobapply?mode=SHOWAPPLIEDJOBS" class="dropdown-item">Your Applied Jobs</a></li>
					<li><a class="dropdown-item" href="login?mode=LOGOUT">Logout</a></li>
				</c:if>
                  
                </ul>
              </li>
            </ul>
          </div>

    </div>
  </nav>
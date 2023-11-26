<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Detail Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">

</head>
<body>
	<c:import url="../common/nav.jsp" />
	<section>
		<div class="container-lg">
			<div class="row justify-content-center my-3">
				<div class="col-10 bg-light p-5" style="border:1px solid black;border-radius: 10px;">
					<div class="row my-3 text-center">
						<div class="col-2">
							<div class="btn-group">
							  <c:choose>
							  <c:when test="${user.role eq 'admin' and jobPost.status eq 'open'}">
							  	<button type="button" class="btn btn-${(jobPost.status eq 'open')?'success':'danger'}" data-bs-toggle="modal" data-bs-target="#exampleModal" style="font-weight: bold;font-size: large;">
								  ${jobPost.status }
								</button>
								
								<!-- Modal -->
								<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="exampleModalLabel">JobPost close confirm</h5>
								        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								      </div>
								      <div class="modal-body">
								        Do you want to close this job?
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
								        <a class="btn btn-danger" href="jobpost?mode=CLOSE&jobPostId=${jobPost.id }">Close</a>
								      </div>
								    </div>
								  </div>
								</div>
							  
							  </c:when>
							  <c:otherwise>
								  
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-${(jobPost.status eq 'open')?'success':'danger'}" style="font-weight: bold;font-size: large;">
								  ${jobPost.status }
								</button>
								
								
							  
							  </c:otherwise>
							  
							  </c:choose>
							</div>
						</div>
						<div class="col">
							<c:if test="${not empty success }">
								<c:choose>
									<c:when test="${success}">
										<h3 class="text-success">Applied Successfully. </h3>
									</c:when>
									<c:otherwise>
										<h3 class="text-danger">Fail to Apply. Please try Again..</h3>
									</c:otherwise>
									
								</c:choose>
							
							</c:if>
							<h2 style="color: blue;">${jobPost.title}</h2>
							<h3>Due Date : ${jobPost.dueDate}</h3>
						</div>
						<div class="col-2">
							
						</div>
						
					</div>
					<div class="row my-3">
						<div class="col">
							<p>
								<strong>Employer : </strong>${jobPost.employer}</p>
							<p>
								<strong>Job Type : </strong>${jobPost.type}</p>
							<p>
								<strong>Salary : </strong>${jobPost.salary}Ks</p>
						</div>
						<div class="col">
							<p>
								<strong>Job Location : </strong>${jobPost.location}</p>
							<p>
								<strong>Industry : </strong>${jobPost.industry}</p>
						</div>
					</div>
					<div class="row my-3">
						<div class="col">
							<h5>Job Description :</h5>
							<p>${jobPost.description}</p>
						</div>
					</div>
					<div class="row my-3">
						<h5>Job Duties :</h5>
						<div class="col">
							<ul>
								<c:forEach var="duty" items="${duties}">
									<li>${duty.duty }</li>
								</c:forEach>
							</ul>
						</div>

					</div>
					<div class="row my-3">
						<h5>Job Requirements :</h5>
						<div class="col">
							<ul>
								<c:forEach var="req" items="${reqs}">
									<li>${req.requirement}</li>
								</c:forEach>
							</ul>
						</div>

					</div>
					<div class="row my-3">
						<h5>Benifits :</h5>
						<div class="col">
							<ul>
								<c:forEach var="beni" items="${benis}">
									<li>${beni.benifit }</li>
								</c:forEach>
							</ul>
						</div>

					</div>
					<c:if test="${fn:contains(user.role,'user')}">
						<div class="row my-3 p-1">
							<div class="col text-end">
								<c:if test="${not isapplied and (jobPost.status eq 'open')}">
									<a href="jobapply?mode=ADDAPPLY&id=${jobPost.id}" class="btn btn-primary">Apply Now</a>
								</c:if>
								<c:if test="${isapplied or (jobPost.status eq 'closed')}">
									<button class="btn btn-primary" disabled="disabled">Apply Now</button>
								</c:if>
							</div>
						</div>
					</c:if>
					<c:if test="${fn:contains(user.role,'admin')}">
						<div class="row my-3 p-1">
							<div class="col text-end">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal1">
								  Delete
								</button>
								
								<!-- Modal -->
								<div class="modal fade" id="modal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="exampleModalLabel">Deleting JobPost</h5>
								        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								      </div>
								      <div class="modal-body text-center">
								        Are you sure you want to delete jobpost?
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cancel</button>
								        <a href="jobpost?mode=DELETE&id=${jobPost.id}"
									class="btn btn-danger mx-2">Delete</a>
								      </div>
								    </div>
								  </div>
								</div>
								
								<a href="jobapply?mode=SHOWAPPLY&id=${jobPost.id}"
									class="btn btn-secondary mx-2">View Apply List</a> <a
									href="jobpost?mode=SHOWUPDATE&id=${jobPost.id}"
									class="btn btn-primary mx-2">Update</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
<c:import url="../common/footer.jsp"/>

</body>
</html>
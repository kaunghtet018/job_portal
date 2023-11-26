<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
		<div class="container-fluid" style="min-height:82vh;">
			<div class="row">
				
				<div class="col-2 my-3 text-center"></div>
				<div class="col-8 my-3">
					<form class="d-flex" action="jobpost" method="post">
						<input type="hidden" name="mode" value="SEARCH"/>
						<input class="form-control me-2" type="text" name="jobsearch"
							placeholder="Search Jobs" aria-label="Search"/>
						<button class="btn btn-outline-success" type="submit">
							<i class="bi bi-search"></i>
						</button>
					</form>
					<div class="text-center">
						<c:if test="${not empty resultsize}">
							<c:if test="${resultsize eq 0 }">
								<h2>No jobposts are found.</h2>
							
							</c:if>
							<c:if test="${resultsize gt 0 }">
								<h2>Search Result :</h2>
							
							</c:if>
						
						</c:if>
					</div>
					<c:forEach var="jobPost" items="${jobPostList}">
						<div class="row p-3">
							<div class="col p-auto">
								<div class="card bg-light m-auto">
									<div class="card-body px-5">
										<h4 class="card-title text-center">${jobPost.title}</h4>
										<h5 class="card-title text-center">${jobPost.employer}</h5>
										<h6 class="card-title text-center">Salary :
											${jobPost.salary}KS</h6>
										<div class="row mb-2">
											<div class="col">Location : ${jobPost.location}</div>
											<div class="col">Duedate : ${jobPost.dueDate}</div>
										</div>
										<div class="row mb-2">
											<div class="col">Job Type : ${jobPost.type}</div>
											<div class="col">Industry : ${jobPost.industry}</div>
										</div>
										<h5 class="card-title">Description :</h5>
										<p class="card-text">${(fn:length(jobPost.description) le 100)?jobPost.description:fn:substring(jobPost.description,0,100) }</p>
										<div class="row">
											<a href="jobpost?mode=JOBDETAIL&id=${jobPost.id}"
												class="btn btn-primary">View detail</a>
										</div>
									</div>
								</div>
							</div>

						</div>
					</c:forEach>
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
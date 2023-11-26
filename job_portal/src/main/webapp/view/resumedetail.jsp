<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resume Detail Page</title>
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
			<div class="row justify-content-center my-5">
				<div class="col-9 bg-light p-5" style="border:1px solid black;border-radius: 10px;">
					<div class="row my-3 text-center">
						<div class="col">
							<h2 style="color: blue;">Resume Details</h2>
						</div>
					</div>
					<div class="row my-3">
						<div class="col-5">

							<div class="row mb-5">
								<div class="col">
									<h4>Personal Details</h4>
									<ul>
										<li><div class="m-2">Name : ${resume.name }</div></li>
										<li><div class="m-2">Gender : ${resume.gender }</div></li>
										<li><div class="m-2">Date of Birth : ${resume.dateOfBirth }</div></li>
									</ul>
								</div>
							</div>

							<div class="row mb-5">
								<div class="col">
									<h4>Conatct</h4>
									<ul>
										<li><div class="m-2">Phone : ${resume.phone }</div></li>
										<li><div class="m-2">Email : ${resume.email }</div></li>
										<li><div class="m-2">Address : ${resume.address }</div></li>
									</ul>
								</div>
							</div>

							<div class="row mb-5">
								<div class="col">
									<h4>Skills</h4>
									<ul>
										<c:forEach var="skill" items="${skillList }">
											<li><div class="m-2">${skill.skill}</div></li>
										</c:forEach>
									</ul>
								</div>
							</div>

						</div>
						<div class="col-7">
							<div class="row mb-5">
								<div class="col">
									<h4>About Me</h4>
									<p><div class="m-2">${resume.about }</div></p>
								</div>
							</div>

							<div class="row mb-5">
								<div class="col">
									<h4>Educations</h4>
									<ul>
										<c:forEach var="edu" items="${eduList }">
											<li>
												<div class="m-1">
													<h6>${edu.institution }</h6>
													<i><h5>${edu.certificate }</h5></i>
													<h6 class="lead">${edu.dateRange }</h6>
												</div>
											</li>
										</c:forEach>


									</ul>
								</div>
							</div>

							<div class="row mb-5">
								<div class="col">
									<h4>Work Experience</h4>
									<ul>
										<c:forEach var="exp" items="${expList }">
											<li>
												<div class="m-1">
													<h5>${exp.position}</h5>
													<i><h6>${exp.company } | ${exp.location }</h6></i>
													<h6 class="lead">${exp.dateRange }</h6>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
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
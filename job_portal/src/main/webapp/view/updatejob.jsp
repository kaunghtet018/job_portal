<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Update Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <style>
        .title{
            font-size: large;
            font-weight: 485;
        }


    </style>
    
    <script>
        const add = function(id, name, placeholder) {
            const desc_box = document.getElementById(id);
    
            const div = document.createElement("div");
            div.className = "row mb-3";
            const req = document.createElement("div");
            req.className = "col-9";
            const rem = document.createElement("div");
            rem.className = "col";
    
            const input = document.createElement("input");
            input.type = "text";
            input.className = "form-control";
            input.name = name;
            input.placeholder = placeholder;

            req.appendChild(input)
    
            const button = document.createElement("button");
            button.type = "button";
            button.className = "btn btn-danger";
            button.innerHTML = "Remove"
            button.onclick = function() {
                div.remove();
            }

            rem.appendChild(button)

            div.appendChild(req)
            div.appendChild(rem)

            desc_box.appendChild(div)
    
        }
    </script>

</head>
<body>
	<c:import url="../common/nav.jsp" />
	<section>
		<div class="container-lg">
			<div class="row justify-content-center my-5">
				<div class="col-10 bg-light" style="border:1px solid black;border-radius: 10px;">
					<form action="jobpost?mode=UPDATE&id=${jobPost.id}" method="post">
						<div class="contanier p-3">
							<div class="row mb-3">

								<c:if test="${not empty success}">
									<c:choose>
										<c:when test="${success}">
											<h5 class="text-center text-success my-4">JobPost is
												updated successfully!</h5>
										</c:when>

										<c:otherwise>
											<h5 class="text-center text-danger my-4">JobPost
												is failed to update!</h5>
										</c:otherwise>
									</c:choose>
								</c:if>
								<h2 class="text-center mb-4">Job Post Update</h2>


								<div class="col-5">
									<label for="title" class="form-label"><span class="title">Job Title : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> T </span> <input type="text"
											class="form-control" name="title" placeholder="Title" value="${jobPost.title}"
											required="required">
									</div>

									<label for="employer" class="form-label"><span class="title">Employer : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> E </span> <input type="text"
											class="form-control" name="employer" placeholder="Employer" value="${jobPost.employer}"
											required="required">
									</div>

									<label for="salary" class="form-label"><span class="title">Salary : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> S </span> <input type="number"
											class="form-control" name="salary" placeholder="Salary" value="${jobPost.salary}"
											required="required">
									</div>

									
									<label for="location" class="form-label"><span class="title">Work Location : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> WL </span> <input type="text"
											class="form-control" name="location"
											placeholder="Work Location"  value="${jobPost.location}" required="required">
									</div>

									<label for="type" class="form-label"><span class="title">Job Type : </span></label>
									<div class="mb-2 input-group">
										
									<div class="mb-2 input-group">
										<span class="input-group-text"> JT </span>
											<select
											name="type" class="form-select" >
											<option value="Full Time">Full Time</option>
											<option value="Part Time">Part Time</option>
											<option value="Remote Work">Remote Work</option>
											<option value="Internship">Internship</option>
											<option value="Other">Other</option>
										</select>
									</div>
									</div>

								</div>

								<div class="col-7">


									<label for="industry" class="form-label"><span class="title">Industry : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> I </span> <input type="text"
											class="form-control" name="industry" placeholder="Industry" value="${jobPost.industry}"
											required="required">
									</div>

									<label for="duedate" class="form-label"><span class="title">Due Date : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> DD </span> <input type="date"
											class="form-control" name="duedate" placeholder="Due Date" value="${jobPost.dueDate}"
											required="required">
									</div>
									<label for="description" class="form-label"><span class="title">Job
										Description : </span></label>
									<div>
										<textarea class="form-control" rows="8" name="description"
											required="required">${jobPost.description}</textarea>
									</div>

								</div>



							</div>
							<div class="row mb-4">
								<div class="col">
									<div class="my-4">
										<label for="requirement" class="form-label"><span class="title">Job
											Requirement : </span></label>
										<div class="contanier mb-3" id="requ_box">
											<c:set var="check" value="first" />
											<c:forEach var="req" items="${reqs}">
												<div class="row mb-3">
                                                <div class="col-9">
                                                    <input type="text" class="form-control" name="requirement" value="${req.requirement }"
													placeholder="Requirement">
                                                </div>
                                                <div class="col">
                                                    <c:choose>
                                                    	<c:when test="${check eq 'first'}">
                                                    		<button type="button" class="btn btn-primary" onclick="add('requ_box','requirement','Requirement')">Add</button>
                                                    		<c:set var="check" value="notfirst" />
                                                    	</c:when>
                                                    	<c:otherwise>
                                                    		<button type="button" class="btn btn-danger"
																onclick="this.parentNode.parentNode.remove()">Remove</button>
                                                    		
                                                    	
                                                    	</c:otherwise>                                                    
                                                    </c:choose>
                                                </div>
                                            	</div>
											</c:forEach>
										</div>

									<div class="my-4">
										<label for="duty" class="form-label">Job Duty : </label>
										<div class="contanier mb-4" id="duty_box">
											<c:set var="check" value="first" />
											<c:forEach var="duty" items="${duties}">
												<div class="row mb-3">
                                                <div class="col-9">
                                                    <input type="text" class="form-control" name="duty" value="${duty.duty }"
													placeholder="Duty">
                                                </div>
                                                <div class="col">
                                                    <c:choose>
                                                    	<c:when test="${check eq 'first'}">
                                                    		<button type="button" class="btn btn-primary" onclick="add('duty_box','duty','Duty')">Add</button>
                                                    		<c:set var="check" value="notfirst" />
                                                    	</c:when>
                                                    	<c:otherwise>
                                                    		<button type="button" class="btn btn-danger"
																onclick="this.parentNode.parentNode.remove()">Remove</button>
                                                    	</c:otherwise>                                                    
                                                    </c:choose>
                                                </div>
                                            	</div>
											
											</c:forEach>
										</div>
									</div>

									<div class="my-4">
										<label for="benifit" class="form-label">Benifit : </label>
										<div class="contanier mb-4" id="beni_box">
											<c:set var="check" value="first" />
											<c:forEach var="beni" items="${benis}">
												<div class="row mb-3">
                                                <div class="col-9">
                                                    <input type="text" class="form-control" name="benifit" value="${beni.benifit }"
													placeholder="Benifit">
                                                </div>
                                                <div class="col">
                                                    <c:choose>
                                                    	<c:when test="${check eq 'first'}">
                                                    		<button type="button" class="btn btn-primary" onclick="add('beni_box','benifit','Benifit')">Add</button>
                                                    		<c:set var="check" value="notfirst" />
                                                    	</c:when>
                                                    	<c:otherwise>
                                                    		<button type="button" class="btn btn-danger"
																onclick="this.parentNode.parentNode.remove()">Remove</button>
                                                    	</c:otherwise>                                                    
                                                    </c:choose>
                                                </div>
                                            	</div>
											
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="mt-2 mb-5 text-center">
							<button type="submit" class="btn btn-primary">Update Job Post</button>
						</div>
						</div>
					</form>
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
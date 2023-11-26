<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add JobPage</title>
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
    <c:import url="../common/nav.jsp"/>
    <section>
		<div class="container-lg">
			<div class="row justify-content-center my-5">
				<div class="col-10 bg-light" style="border:1px solid black;border-radius: 10px;">
					<form action="jobpost?mode=ADDJOB" method="post">
						<div class="contanier p-4">
							<div class="row mb-3">

								<c:if test="${not empty success}">
									<c:choose>
										<c:when test="${success}">
											<h5 class="text-center text-success my-4">JobPost is
												created successfully!</h5>
										</c:when>

										<c:otherwise>
											<h5 class="text-center text-danger my-4">JobPost
												creation is failed!</h5>
										</c:otherwise>
									</c:choose>
								</c:if>
								<h2 class="text-center mb-4">Job Post</h2>


								<div class="col-5">
									<label for="title" class="form-label"><span class="title">Job Title : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> T </span> <input type="text"
											class="form-control" name="title" placeholder="Title"
											required="required">
									</div>

									<label for="employer" class="form-label"><span class="title">Employer : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> E </span> <input type="text"
											class="form-control" name="employer" placeholder="Employer"
											required="required">
									</div>

									<label for="salary" class="form-label"><span class="title">Salary : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> S </span> <input type="number"
											class="form-control" name="salary" placeholder="Salary"
											required="required">
									</div>

									<label for="location" class="form-label"><span class="title">Work Location : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> WL </span> <input type="text"
											class="form-control" name="location"
											placeholder="Work Location" required="required">
									</div>

									<label for="type" class="form-label"><span class="title">Job Type : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> JT </span>
											<select
											name="type" class="form-select">
											<option value="Full Time">Full Time</option>
											<option value="Part Time">Part Time</option>
											<option value="Remote Work">Remote Work</option>
											<option value="Internship">Internship</option>
											<option value="Other">Other</option>
										</select>
									</div>

								</div>

								<div class="col-7">


									<label for="industry" class="form-label"><span class="title">Industry : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> I </span>
											<select
											name="industry" class="form-select">
											<option value="Transport Industry">Transport Industry</option>
											<option value="Agriculture Industry">Agriculture Industry</option>
											<option value="IT Industry">IT Industry</option>
											<option value="Education Industry">Education Industry</option>
											<option value="Construction Industry">Construction Industry</option>
											<option value="Electronic Industry">Electronic Industry</option>
											<option value="Health Care Industry">Health Care Industry</option>
											<option value="Food Industry">Food Industry</option>
											<option value="Entertainment Industry">Entertainment Industry</option>
											<option value="News Media Industry">News Media Industry</option>
											<option value="Hospitality Industry">Hospitality Industry</option>
											<option value="Other">Other</option>
										</select>
									</div>

									<label for="duedate" class="form-label"><span class="title">Due Date : </span></label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> DD </span> <input type="date"
											class="form-control" name="duedate" placeholder="Due Date"
											required="required">
									</div>
									<label for="description" class="form-label"><span class="title">Job Description : </span></label>
									<div>
										<textarea class="form-control" rows="8" name="description"
											required="required"></textarea>
									</div>

								</div>



							</div>
							<div class="row mb-4">
								<div class="col">
									<div class="my-4">
										<label for="requirement" class="form-label"><span class="title">Job Requirement : </span></label>
										<div class="contanier mb-3" id="requ_box">
											<div class="row mb-3">
                                                <div class="col-9">
                                                    <input type="text" class="form-control" name="requirement"
													placeholder="Requirement">
                                                </div>
                                                <div class="col">
                                                    <button type="button" class="btn btn-primary" onclick="add('requ_box','requirement','Requirement')">Add</button>
                                                </div>
                                            </div>	
										</div>
										
									</div>

									<div class="my-4">
										<label for="duty" class="form-label"><span class="title">Job Duty : </span></label>
										<div class="contanier mb-3" id="duty_box">
											<div class="row mb-3">
                                                <div class="col-9">
                                                    <input type="text" class="form-control" name="duty"
													placeholder="Duty">
                                                </div>
                                                <div class="col">
                                                    <button type="button" class="btn btn-primary" onclick="add('duty_box','duty','Duty')">Add</button>
                                                </div>
                                            </div>	
										</div>
										
									</div>

									<div class="my-4">
										<label for="benifit" class="form-label"><span class="title">Benifit : </span></label>
										<div class="contanier mb-3" id="beni_box">
											<div class="row mb-3">
                                                <div class="col-9">
                                                    <input type="text" class="form-control" name="benifit"
													placeholder="Benifit">
                                                </div>
                                                <div class="col">
                                                    <button type="button" class="btn btn-primary" onclick="add('beni_box','benifit','Benifit')">Add</button>
                                                </div>
                                            </div>	
										</div>
										
									</div>
								</div>
							</div>
						</div>
						<div class="mt-2 mb-5 text-center">
							<button type="submit" class="btn btn-primary">Add Job Post</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

<c:import url="../common/footer.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
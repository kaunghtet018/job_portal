<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Resume Page</title>
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
		<div class="container">
			<div class="row justify-content-center my-5">
				<div class="col-10 bg-light" style="border:1px solid black;border-radius: 10px;">
					<form action="resume?mode=ADDRESUME" method="post">
						<div class="contanier p-3">
							<div class="row mb-3">

								<c:if test="${not empty success}">
									<c:choose>
										<c:when test="${success}">
											<h5 class="text-center text-success my-4">Resume is
												added successfully!</h5>
										</c:when>

										<c:otherwise>
											<h5 class="text-center text-danger my-4">Resume is
												failed to add!</h5>
										</c:otherwise>
									</c:choose>
								</c:if>
								<h2 class="text-center mb-4">Resume</h2>


								<div class="col-6">
									<label for="name" class="form-label">Name : </label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> N </span> <input type="text"
											class="form-control" name="name" placeholder="Name"
											required="required">
									</div>

									<label for="gender" class="form-label">Gender : </label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> G </span> <select
											name="gender" class="form-select">
											<option value="male">Male</option>
											<option value="female">Female</option>
											<option value="other">Other</option>
										</select>
									</div>

									<label for="dateofbirth" class="form-label">Date of
										Birth : </label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> BD </span> <input type="date"
											class="form-control" name="dateofbirth"
											placeholder="Date of Birth" required="required">
									</div>



								</div>

								<div class="col-6">

									<label for="phone" class="form-label">Phone : </label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> P </span> <input type="text"
											class="form-control" name="phone" placeholder="Phone Number"
											required="required">
									</div>

									<label for="email" class="form-label">Email : </label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> E </span> <input type="text"
											class="form-control" name="email" placeholder="Email"
											required="required">
									</div>

									<label for="address" class="form-label">Address : </label>
									<div class="mb-2 input-group">
										<span class="input-group-text"> A </span> <input type="text"
											class="form-control" name="address" placeholder="Address"
											required="required">
									</div>




								</div>




							</div>
							<div class="row mb-3">
								<div class="col">

									<label for="about" class="form-label">About You : </label>
									<div>
										<textarea class="form-control" rows="4" name="about"
											required="required"></textarea>
									</div>
								</div>

							</div>
							<div class="row mb-3">
								<div class="col mb-3">

									<label for="requirement" class="form-label">Education :
									</label>
									<div class="row mb-2">
										<div class="col-3">
											<strong>Degree</strong>
										</div>
										<div class="col-3">
											<strong>Institution</strong>
										</div>
										<div class="col-3">
											<strong>Graduation Period</strong>
										</div>
									</div>

									<div class="contanier" id="edu_box">
										<div class="row mb-3">
											<div class="col-3">
												<input type="text" class="form-control" name="certificate"
													placeholder="Certificate">
											</div>
											<div class="col-3">
												<input type="text" class="form-control" name="institution"
													placeholder="Institution">
											</div>
											<div class="col-4">
												<input type="text" class="form-control" name="daterange1"
													placeholder="Graduation Period">
											</div>
											<div class="col-2">
												<button type="button" class="btn btn-primary"
													onclick="addEdu()">Add</button>
											</div>
										</div>
									</div>

								</div>
							</div>
							<div class="row mb-3">
								<div class="col mb-3">
									<label for="requirement" class="form-label">Work
										Experience : </label>
									<div class="row mb-2">
										<div class="col-2">
											<strong>Company</strong>
										</div>
										<div class="col-2">
											<strong>Location</strong>
										</div>
										<div class="col-3">
											<strong>Position</strong>
										</div>
										<div class="col-3">
											<strong>Worked Period</strong>
										</div>
									</div>
									<div class="contanier" id="work_box">
										<div class="row mb-3">
											<div class="col-2">
												<input type="text" class="form-control" name="company"
													placeholder="Company">
											</div>
											<div class="col-2">
												<input type="text" class="form-control" name="location"
													placeholder="Location">
											</div>
											<div class="col-3">
												<input type="text" class="form-control" name="position"
													placeholder="Position">
											</div>
											<div class="col-3">
												<input type="text" class="form-control" name="daterange2"
													placeholder="Worked Period">
											</div>
											<div class="col-2">
												<button type="button" class="btn btn-primary"
													onclick="addExp()">Add</button>
											</div>
										</div>
									</div>

								</div>
							</div>

							<div class="row mb-3">
								<div class="col mb-3">
									<label for="requirement" class="form-label">Skill : </label>
									<div class="contanier" id="skill_box">
										<div class="row mb-3">
											<div class="col-6">
												<input type="text" class="form-control" name="skill"
													placeholder="Skill">
											</div>

											<div class="col-6">
												<button type="button" class="btn btn-primary"
													onclick="addSkill()">Add</button>
											</div>
										</div>
									</div>

								</div>
							</div>

						</div>
						<div class="mt-2 mb-5 text-center">
							<button type="submit" class="btn btn-primary">Add Resume</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- <script>


		function addEdu() {
			
			const div = document.createElement("div")
			div.className="row mb-3"
			div.innerHTML = `
				<div class="col">
					<input type="text" class="form-control" name="certificate">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="institution">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="daterange">
				</div>
				<div class="col">
					<button type="button" class="btn btn-danger"
					onclick="remove()">Remove</button>
				</div>`
			document.getElementById("edu_box").appendChild(div)



		}

		function remove(){
			 let hello=this.parent.parent
			
			console.log(hello)
		}


	</script> -->
	<script>
		const addEdu = function() {
			const edu_div = document.getElementById("edu_box")
			const div_row = document.createElement("div")
			div_row.className = "row mb-3"

			const certi_div = document.createElement("div")
			certi_div.className = "col-3"
			const certi_inp = document.createElement("input")
			certi_inp.type = "text"
			certi_inp.className = "form-control"
			certi_inp.name = "certificate"
			certi_inp.placeholder = "Certificate"

			certi_div.appendChild(certi_inp)
			div_row.appendChild(certi_div)

			const inst_div = document.createElement("div")
			inst_div.className = "col-3"
			const inst_inp = document.createElement("input")
			inst_inp.type = "text"
			inst_inp.className = "form-control"
			inst_inp.name = "institution"
			inst_inp.placeholder = "Institution"

			inst_div.appendChild(inst_inp)
			div_row.appendChild(inst_div)

			const date_div = document.createElement("div")
			date_div.className = "col-4"
			const date_inp = document.createElement("input")
			date_inp.type = "text"
			date_inp.className = "form-control"
			date_inp.name = "daterange1"
			date_inp.placeholder = "Graduation Period"

			date_div.appendChild(date_inp)
			div_row.appendChild(date_div)

			const btn_div = document.createElement("div")
			btn_div.className = "col-2"
			const btn = document.createElement("button")
			btn.className = "btn btn-danger"
			btn.type = "button"
			btn.onclick = function() {
				div_row.remove()
			}
			btn.innerHTML = "Remove"

			btn_div.appendChild(btn)
			div_row.appendChild(btn_div)

			edu_div.appendChild(div_row)

		}

		const addExp = function() {
			const exp_div = document.getElementById("work_box")
			const div_row = document.createElement("div")
			div_row.className = "row mb-3"

			const company_div = document.createElement("div")
			company_div.className = "col-2"
			const company_inp = document.createElement("input")
			company_inp.type = "text"
			company_inp.className = "form-control"
			company_inp.name = "company"
			company_inp.placeholder = "Company"

			company_div.appendChild(company_inp)
			div_row.appendChild(company_div)

			const location_div = document.createElement("div")
			location_div.className = "col-2"
			const location_inp = document.createElement("input")
			location_inp.type = "text"
			location_inp.className = "form-control"
			location_inp.name = "location"
			location_inp.placeholder = "Location"

			location_div.appendChild(location_inp)
			div_row.appendChild(location_div)

			const position_div = document.createElement("div")
			position_div.className = "col-3"
			const position_inp = document.createElement("input")
			position_inp.type = "text"
			position_inp.className = "form-control"
			position_inp.name = "position"
			position_inp.placeholder = "Position"

			position_div.appendChild(position_inp)
			div_row.appendChild(position_div)

			const daterange_div = document.createElement("div")
			daterange_div.className = "col-3"
			const daterange_inp = document.createElement("input")
			daterange_inp.type = "text"
			daterange_inp.className = "form-control"
			daterange_inp.name = "daterange2"
			daterange_inp.placeholder = "Worked Period"

			daterange_div.appendChild(daterange_inp)
			div_row.appendChild(daterange_div)

			const btn_div = document.createElement("div")
			btn_div.className = "col-2"
			const btn = document.createElement("button")
			btn.className = "btn btn-danger"
			btn.type = "button"
			btn.onclick = function() {
				div_row.remove()
			}
			btn.innerHTML = "Remove"

			btn_div.appendChild(btn)
			div_row.appendChild(btn_div)

			exp_div.appendChild(div_row)
		}

		const addSkill = function() {
			const skills_div = document.getElementById("skill_box")
			const div_row = document.createElement("div")
			div_row.className = "row mb-3"

			const skill_div = document.createElement("div")
			skill_div.className = "col-6"
			const skill_inp = document.createElement("input")
			skill_inp.type = "text"
			skill_inp.className = "form-control"
			skill_inp.name = "skill"
			skill_inp.placeholder = "Skill"

			skill_div.appendChild(skill_inp)
			div_row.appendChild(skill_div)

			const btn_div = document.createElement("div")
			btn_div.className = "col-6"
			const btn = document.createElement("button")
			btn.className = "btn btn-danger"
			btn.type = "button"
			btn.onclick = function() {
				div_row.remove()
			}
			btn.innerHTML = "Remove"

			btn_div.appendChild(btn)
			div_row.appendChild(btn_div)

			skills_div.appendChild(div_row)
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
<c:import url="../common/footer.jsp"/>
</body>
</html>
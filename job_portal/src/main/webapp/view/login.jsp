<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">

</head>
<body>
<c:import url="../common/nav.jsp"/>
	<section>
		<div class="container-lg">
			<div class="row justify-content-center my-5">
				<div
					class="col-5 col-xl-3 col-lg-4 col-md-4 col-sm-5 bg-light mt-4 p-4 " style="border: 1px solid black; border-radius:10px;">
					<form action="login?mode=LOGIN" method="post">
						<h3 class="text-center mb-4">Login Form</h3>
						<c:if test="${not empty success and not success}">
							<h6 class="text-center text-danger">
								Email or password is wrong, <br>please try again.
							</h6>
						</c:if>

						<label for="email" class="form-label">Email : </label>
						<div class="mb-3 input-group">
							<span class="input-group-text"> <i
								class="bi bi-envelope-at-fill"></i>
							</span> <input type="email" class="form-control" name="email"
								placeholder="Email" required="required">
						</div>
						<label for="password" class="form-label">Password : </label>
						<div class="mb-4 input-group">
							<span class="input-group-text"> <i class="bi bi-lock-fill"></i>
							</span> <input type="password" class="form-control" name="password"
								placeholder="Password" required="required">
						</div>

						<div class="mb-3 text-center">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>

						<div class="col-12">
							<p class="text-center fst-italic mb-0">
								Do you already have account? <a href="login?mode=SHOWSIGNUP">Signup</a>
							</p>
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
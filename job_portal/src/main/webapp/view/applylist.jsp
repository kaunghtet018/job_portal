<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply List Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">


</head>
<body>
    <c:import url="../common/nav.jsp" />
    <section>
		<div class="container-lg" style="min-height:76vh;">
			<div class="row my-5">
				<div class="col-11 bg-light p-3 m-auto" style="border: 1px solid black; border-radius: 10px;">
                    
					<div class="row my-2 text-center">
                        <div class="col">
                            <h3 style="color: blue;">Apply List</h3>
                        </div>
                    </div>

                    <div class="row my-2 px-5">
                        <div class="col">
                            <span style="font-size: larger;font-weight: bolder;">Total Applicants : <i>${total }</i></span>
                        </div>
                    </div>

                    <div class="contanier p-4">
                        <div class="row my-2 p-1">
                            <div class="col">
                                <span style="font-weight: bolder; font-style: italic;">No.</span>
                            </div>
                            <div class="col">
                                <span style="font-weight: bolder; font-style: italic;">Apply Date and Time</span>
                            </div>
                            <div class="col">
                                <span style="font-weight: bolder; font-style: italic;">Username</span>
                            </div>
<!--                             <div class="col"> -->
<!--                                 <span style="font-weight: bolder; font-style: italic;">Email</span> -->
<!--                             </div> -->
                            <div class="col">
                                <span style="font-weight: bolder; font-style: italic;">Resume Details</span>
                            </div>
                        </div>

                        <c:choose>
                        	<c:when test="${total gt 0 }">
                        		<c:set var="count" value="${1 }"/>
                        		<c:forEach var="userinfo" items="${userInfoList }">
			                        <div class="row p-1" style="border-top: 2px solid blueviolet;">
			                            <div class="col my-auto">
			                                <span>${count }</span>
			                                <c:set var="count" value="${count+1 }"/>
			                            </div>
			                            <div class="col my-auto">
			                                <span>${userinfo.applyDate } | ${userinfo.applyTime } </span>
			                            </div>
			                            <div class="col my-auto">
			                                <span>${userinfo.nickName }</span>
			                            </div>
<!-- 			                            <div class="col my-auto"> -->
<%-- 			                                <span>${userinfo.email }</span> --%>
<!-- 			                            </div> -->
			                            <div class="col my-auto">
			                                <span><a href="resume?mode=SHOWRESUME&id=${userinfo.userId }" class="btn btn-primary" type="button">View Detail</a></span>
			                            </div>
			                        </div>
		                        </c:forEach>
                        	</c:when>
                        	<c:otherwise>
                        		 <div class="row p-2" style="border-top: 2px solid blueviolet;">
                        			<div class="col" style="text-align: center;">
                        				
                        				<span style="font-size:larger;font-weight: light; font-style: italic;">No Job Applications available...</span>
                        			</div>
                        		 </div>
                        	</c:otherwise>
                        </c:choose>

                    </div>
               </div>
			</div>
		</div>
	</section>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <c:import url="../common/footer.jsp"/>
</body>
</html>
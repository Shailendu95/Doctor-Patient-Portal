<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px maroon;
	/box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);/
}
</style>
<!-- end of customs css for this page -->

<head>
<meta charset="UTF-8">
<title>Doctor Login</title>
<%@include file="component/allcss.jsp"%>
</head>
<body>
	<!-- navbar -->
	<%@include file="component/navbar.jsp"%>
	<!-- end navbar -->


	<!-- <h1>Doctor Login</h1> -->
	<!-- Doctor Login -->
<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card my-card">
                <div class="card-header text-center text-white" style="background-color: #007bff;"> <!-- Blue background -->
                    <p class="fs-4 text-center mt-2">
                        <i class="fa-solid fa-stethoscope"></i> Doctor Login
                    </p>
                </div>

                <div class="card-body">
                    <!-- Optional message section -->
                    <!--
                    <c:if test="${not empty successMsg }">
                        <p class="text-center text-success fs-5">${successMsg}</p>
                        <c:remove var="successMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty errorMsg }">
                        <p class="text-center text-danger fs-5">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    -->

                    <!-- Bootstrap form -->
                    <form action="doctorLogin" method="post">
                        <div class="mb-3">
                            <label class="form-label">Email address</label>
                            <input name="email" type="email" placeholder="Enter Email" class="form-control" required>
                            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input name="password" type="password" placeholder="Enter password" class="form-control" required>
                        </div>

                        <button type="submit" class="btn text-white col-md-12" style="background-color: #007bff;">Login</button> <!-- Blue button -->
                    </form>
                    <!-- End of Bootstrap form -->
                </div>
            </div>
        </div>
    </div>
</div>

	<!-- End of Doctor Login -->





</body>
</html>

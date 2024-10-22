<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>

    <!-- Bootstrap CSS -->
    <%@ include file="component/allcss.jsp" %>
    <!-- End of Bootstrap CSS -->

    <!-- Custom CSS for this page -->
    <style type="text/css">
        .my-card {
            box-shadow: 0px 0px 10px 1px maroon;
        }
    </style>
    <!-- End of Custom CSS -->
</head>
<body>
    <!-- Navbar -->
    <%@ include file="component/navbar.jsp" %>
    <!-- End Navbar -->

    <!-- Admin Login -->
    <div class="container p-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card my-card">
                    <div class="card-header text-center text-white" style="background-color: #007bff;">
                        <p class="fs-4 mt-2">
                            <i class="fa fa-universal-access"></i> Admin Login
                        </p>
                    </div>
                    <div class="card-body">

                        <!-- Optional message section -->
                        <c:if test="${not empty successMsg}">
                            <p class="text-center text-success fs-3">${successMsg}</p>
                            <c:remove var="successMsg" scope="session" />
                        </c:if>

                        <c:if test="${not empty errorMsg}">
                            <p class="text-center text-danger fs-5">${errorMsg}</p>
                            <c:remove var="errorMsg" scope="session" />
                        </c:if>

                        <!-- Bootstrap Form -->
                        <form action="adminLogin" method="post">
                            <div class="mb-3">
                                <label class="form-label">Email address</label>
                                <input name="email" type="email" placeholder="Enter Email" class="form-control" required>
                                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Password</label>
                                <input name="password" type="password" placeholder="Enter password" class="form-control" required>
                            </div>

                            <button type="submit" class="btn text-white col-md-12" style="background-color: #007bff;">Submit</button>
                        </form>
                        <!-- End of Bootstrap Form -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End of Admin Login -->
</body>
</html>

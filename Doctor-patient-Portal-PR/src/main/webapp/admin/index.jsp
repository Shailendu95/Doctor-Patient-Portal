<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Include Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <!-- Custom CSS -->
    <style type="text/css">
        .my-card {
            box-shadow: 0px 0px 10px 1px maroon;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">
                <i class="fa-sharp fa-solid fa-hospital"></i> Doctor Patient Portal
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp">
                            <i class="fa fa-home"></i> HOME
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="doctor.jsp">
                            <i class="fa-solid fa-user-doctor"></i> DOCTOR
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="view_doctor.jsp">
                            <i class="fa-solid fa-list"></i> VIEW DOCTOR
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="patient.jsp">
                            <i class="fa fa-wheelchair"></i> PATIENT
                        </a>
                    </li>
                </ul>
                <div class="dropdown">
                    <button class="btn btn-light dropdown-toggle" type="button"
                        id="dropdownMenuButton1" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        <i class="fa fa-universal-access"></i> Admin
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="../AdminLogout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    <!-- Admin Session Check -->
    <c:if test="${empty adminObj}">
        <c:redirect url="../admin_login.jsp"></c:redirect>
    </c:if>

    <div class="container p-5">
        <p class="text-center text-danger fs-3">Admin Dashboard</p>

        <!-- Messages -->
        <c:if test="${not empty successMsg}">
            <p class="text-center text-success fs-5">${successMsg}</p>
            <c:remove var="successMsg" scope="session" />
        </c:if>
        <c:if test="${not empty errorMsg}">
            <p class="text-center text-danger fs-5">${errorMsg}</p>
            <c:remove var="errorMsg" scope="session" />
        </c:if>

        <!-- Cards -->
        <div class="row">
            <div class="col-md-4">
                <div class="card my-card">
                    <div class="card-body text-center text-danger">
                        <i class="fa-solid fa-user-doctor fa-3x"></i><br>
                        <p class="fs-4">Doctor <br> 5</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card my-card">
                    <div class="card-body text-center text-danger">
                        <i class="fas fa-user-circle fa-3x"></i><br>
                        <p class="fs-4">User <br> 10</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card my-card">
                    <div class="card-body text-center text-danger">
                        <i class="fa-solid fa-calendar-check fa-3x"></i><br>
                        <p class="fs-4">Total Appointment <br> 500</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mt-2">
                <div class="card my-card" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    <div class="card-body text-center text-danger">
                        <i class="fa-solid fa-user-doctor fa-3x"></i><br>
                        <p class="fs-4">Specialist <br> 200</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Specialist Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLabel">Add Specialist</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="../addSpecialist" method="post">
                        <div class="form-group">
                            <label class="form-label">Enter Specialist Name</label>
                            <input type="text" name="specialistName" placeholder="Enter Specialist Name" class="form-control" />
                        </div>
                        <div class="text-center mt-2">
                            <button type="submit" class="btn btn-outline-danger">Add</button>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <!-- End of Specialist Modal -->

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
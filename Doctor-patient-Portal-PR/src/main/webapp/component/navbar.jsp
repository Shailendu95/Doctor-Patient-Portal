<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<nav class="navbar navbar-expand-lg navbar-dark"style="background-color: #4568dc;">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-house-chimney-medical"></i> DOCTOR PATIENT PORTAL</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      <c:if test="${empty userObj}">
      
       <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="admin-login.jsp"><i class="fa-solid fa-right-to-bracket"></i> ADMIN</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="doctor-login.jsp">DOCTOR</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">APPOTTMENT</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user-login.jsp">USER</a>
        </li>
      
      </c:if>
      
       
        
       <c:if test="${not empty userObj }">
       <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">APPOTTMENT</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"> VIEW APPOTTMENT</a>
        </li>
        
      <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    <i class="fa-solid fa-circle-user"></i> ${userObj.fullName}
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1" >
    <li><a class="dropdown-item" href="#" >Change Password</a></li>
    <li><a class="dropdown-item" href="userLogout" >Logout</a></li>
  </ul>
</div>
        
        
       </c:if>

       
       
        
        
      </ul>
      
    </div>
  </div>
</nav>

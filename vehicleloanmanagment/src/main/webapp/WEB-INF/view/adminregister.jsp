<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd">
    <a class="navbar-brand">Vehicle Loan Management System</a>
    </nav>

        <h2>Enter admin Registration details :</h2>
        <form action="/api/vehicleloans/admin/r" method="post">
        
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br>
            
            <label for="email">Admin Email</label><br>
            <input type="text" id="email" name="email"><br>
            
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password">
            <br>
            <br>
          <button type="submit" value="Submit">Submit</button>
          <br>
          </form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">
    <title>Loan Application</title>
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd">
    <a class="navbar-brand">Vehicle Loan Management System</a>
    </nav>
  <h1>Loan Application</h1>
  <form action="/api/vechileloans/loanapplications/{userId}" method="post">
  <fieldset>
   <legend>Information</legend>
 <label for="chassisNo">chassisNo</label>
    <input type="text" name=chassisNo/>   
 <br/>
 <label for="existingEMI">existingEMI</label>
    <input type="number" name=existingEMI/>
 <label for="tenure">tenure</label>
    <input type="number" name=tenure/>
   <label for="interest">interest</label>
    <input type="number" name=interest/>
    <br/>
    <label for="amount">amount</label>
    <input type="number" name=amount/>
    <label for="appdate">appdate</label>
    <input type="datetime-local" name=appdate/>
     <label for="status">status</label>
    <input type="text" name=status placeholder="pending" />
<br/>

 <label for="brand">brand</label>
    <input type="text" name=brand/>
<label for="color">color</label>
    <input type="text" name=color/>
<label for="model">model</label>
    <input type="text" name=model/>
<br/>
    <label for="type">type</label>
    <input type="number" name=type/>
<label for="exShowprice">exShowprice</label>
    <input type="text" name=exShowprice/>
<label for="onRoadPrice">onRoadPrice</label>
    <input type="text" name=onRoadPrice/>
    </fieldset>
    <button type="submit">Submit</button>
</form>
</body>
</html>




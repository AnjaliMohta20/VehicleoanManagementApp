<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

       <h1>User logged in Successfully</h1>

    <h2>Enter the user details :</h2>
     
    
     
    <form action="/api/vehicleloans/userdetails/{email}" method="post">
    
    <label for="userId">User Id:</label><br>
    <input type="number" id="userId" name="userId"><br>
    
    <label for="address">Address:</label><br>
    <input type="text" id="address" name="address"><br>
    
    <label for="state">State</label><br>
    <input type="text" id="state" name="state"><br>
    
    <label for="city">City </label><br>
    <input type="text" id="city" name="city"><br> <br>
    
     <label for="pin">Pin </label><br>
    <input type="text" id="pin" name="pin"><br> <br>
    
     <label for="emptype">Employee type </label><br>
    <input type="text" id="emptype" name="emptype"><br> <br>
    
     <label for="salary">Salary </label><br>
    <input type="number" id="salary" name="salary"><br> <br>
     
    <label for="aadhar">Aadhar:</label><br>
    <input type="text" id="aadhar" name="aadhar"><br>
    
    <label for="pan">Pan </label><br>
    <input type="text" id="pan" name="pan"><br>
    
        <label for="salarySlip">Salary Slip </label><br>
    <input type="text" id="salarySlip" name="salarySlip"><br>
    
        <label for="addressProof">Address Proof </label><br>
    <input type="text" id="addressProof" name="addressProof"><br>

    <br>
    <input type="submit" id="sub" name="sub"><br>

</form>

</body>
</html>
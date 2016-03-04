<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="http://localhost:8080/classpro/jsp/register.jsp">Register</a><br>
<br>
${message}
<h3><br>Login</h3><br>
<form action= "/classpro/jsp/login.html" method ="post">
Enter User Name <input type="text" name ="name" maxlength="20" required><br>
Enter Password <input type ="password" name="password" maxlength="20" required><br>
<input type="submit" value= "submit"><br> 
</form>

</body>
</html>
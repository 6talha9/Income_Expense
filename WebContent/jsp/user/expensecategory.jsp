<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><a href="home.jsp">Back</a><br>
<h3><br>Income Category</h3>
<form action= "/classpro/jsp/user/expensecat.html" method="post">
Enter Reason <input type="text" name ="reason" maxlength="20"required><br>
Enter Description<br><textarea rows="3" cols="24" name ="desc" maxlength="200" required></textarea><br>
<input type="submit" value= "submit"><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="home.jsp">Back</a><br>
<h3><br>Income Category</h3>
<form action= "/classpro/jsp/user/incomecat.html" method="post">
Enter Source <input type="text" name ="source" maxlength="20" required><br>
Enter Description<br><textarea rows="3" cols="24" name ="desc" maxlength="200"  required></textarea><br>
<input type="submit" value= "submit"><br>

</form>
</body>
</html>
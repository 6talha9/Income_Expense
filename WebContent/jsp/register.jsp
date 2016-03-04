
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>


</head>
<body>
<h1>Income and Expense Record Management</h1>
<h3>Register </h3>
<form action= "/classpro/jsp/register.html" method="post">
Enter User Name <input type="text" name ="name" id="n1" maxlength="20" required><br>
Enter Password <input type ="password" name="password" id="p1" maxlength="20" required><br>
ReEnter Password <input type= "password" name="password2" id="p2" maxlength="20"required><br>
Enter Email address <input type="email" name="email" maxlength="30"required><br>
<input type="submit" value= "submit" ><br>
<br>
<% try{
	String msg= (String)request.getAttribute("message");
	if (msg!=null){
	%>
	<p  id="w1">${message}</p>
	<%
	}
	}catch(Exception e){}
	
	%>


</form>
<br>already have account <a href="/classpro/jsp/login.jsp"> Login</a>


</body><br>
</html>
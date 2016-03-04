<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.util.Iterator;"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<a href="home.jsp">Back</a><br>
<h3><br>Income Details</h3>
<form action= "/classpro/jsp/user/income.html" method="post">

Enter Category <select id="selectbasic" name="catid" required>
<option value="default"  >Select</option>
<%
ArrayList <String> source=(ArrayList<String>)request.getAttribute("source");
Iterator<String> i= source.iterator();
String temp;
while(i.hasNext() ){
//i.next();
	%>
	
	<option value="<%=i.next()%>"><%=i.next()%></option>
	<%
	}
%>
</select>
<br>
Enter Amount <input type ="text" name="amount" maxlength="15" required><br>
Enter Date(mm/dd/yyyy) <input type ="date" name="date" required><br>
<input type="submit" value= "submit"><br>

</form>
</body>
</html>
 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.ArrayList,java.util.Iterator,model.Transaction;"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<spring:url value="/resources/css/jquery.dataTables.css" var="jqtblcss" />
<spring:url value="/resources/js/jquery-1.11.1.min.js" var="jqry" />
<spring:url value="/resources/js/jquery.dataTables.min.js" var="jqtbl" />
<link href="${jqtblcss}" rel="stylesheet" />
<script src="${jqry}"></script>
<script src="${jqtbl}"></script>
<!-- <script -->
<!-- 	src="/resources/js/jquery-1.11.1.min.js"></script> -->
<!-- <script -->
<!-- 	src="/resources/js/jquery.dataTables.min.js"></script> -->
<!-- 	<link rel="stylesheet" type="text/css" -->
<!-- 	href="/resources/css/jquery.dataTables.css"> -->
<script type="text/javascript">
$(document).ready(function() {
    $('#example').dataTable( {
        "pagingType": "full_numbers",
        "order":[[0,"desc"]]
    } );
} );
</script>
</head>
<body>
<a href="home.jsp">Back</a><br>
<h3>Transaction Report</h3>

	

<table id='example' class='display' cellspacing='0' width='100%'> 

   <thead>
<tr>
<th>T.id</th><th>type</th><th>income/expense id</th><th>Source/Reason</th><th>Description</th><th>Amount</th>
<th>Date</th>
</tr> </thead>
   <tfoot>
<tr>
<th>T.id</th><th>type</th><th>income/expense id</th><th>Source/Reason</th><th>Description</th><th>Amount</th>
<th>Date</th>
</tr> </tfoot>
<tbody>

   <% 
 ArrayList <Transaction> trans=(ArrayList<Transaction>)request.getAttribute("trans"); 
 Iterator<Transaction> i= trans.iterator();
 //System.out.println(i.next().getType());
 String temp; 
 while(i.hasNext() ){ 
 Transaction t= i.next(); 
	%> 
   
  <tr> 
 <td><%=t.getTid()%></td><td><%=t.getType()%></td><td><%=t.getIncOrExpId()%></td><td><%=t.getSrcOrresn()%></td><td><%=t.getDesc()%></td><td><%=t.getAmount()%></td>
 <td><%=t.getDate()%></td>
 </tr> 



 	<% 
	} 
 %> 
 
   </tbody> 



</table>
</body>
</html>




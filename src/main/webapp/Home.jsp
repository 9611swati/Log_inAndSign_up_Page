<%@page import="java.util.Arrays"%>
<%@page import="dto.User_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to home</h1>
<table border="1">
<tr>
<td>Id</td>
<td>name</td>
<td>email</td>
<td>Gender</td>
<td>mobile</td>
<td>password</td>
<td>address</td>
<td>Country</td>
<td>date of birth</td>
<td>Skills</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<%List<User_info> list=(List<User_info>)request.getAttribute("list"); 

for(User_info info:list)
{%>
<tr>
	<th><%=info.getId() %></th>
	<th><%=info.getName() %></th>
	<th><%=info.getEmail() %></th>
	<th><%=info.getGender() %></th>
	<th><%=info.getMobile()%></th>
	<th><%=info.getPassword()%></th>
	<th><%=info.getAddress() %></th>
	<th><%=info.getCountry()%></th>
	<th><%=info.getDate()%></th>
	<th><%=Arrays.toString(info.getSkills()) %></th>
	<th><a href="edit.jsp?id=<%=info.getId() %>"><button>Edit</button></a></th>
	<th><a href="delete?id=<%=info.getId() %>"><button>Delete</button></a></th>
</tr>
<% }%>
	
	
</table>
</body>
</html>
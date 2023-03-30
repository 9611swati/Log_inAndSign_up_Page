<%@page import="dao.UserDao"%>
<%@page import="dto.User_info"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int id=Integer.parseInt(request.getParameter("id"));
UserDao dao=new UserDao();
User_info user=dao.fetch(id);
%>
<h1>Enter your details</h1>
<form action="edit" method="post">
<table>
<tr>
<th>Id:</th>
<td><input type="text" value="<%=user.getId() %>" name="id" ></td>
</tr>


<tr>
<th>Name:</th>
<td><input type="text" value="<%=user.getName() %>" name="name" ></td>
</tr>

<tr>
<th>Mobile:</th>
<td><input type="tel" value="<%=user.getMobile() %>" name="number"  pattern="[0-9]{10}"></td>
</tr>

<tr>
<th>Email:</th>
<td><input type="email" value="<%=user.getEmail() %>"  name="email" placeholder="Enter your email" ></td>
</tr>

<tr>
<th>Password:</th>
<td><input type="password"  value="<%=user.getPassword() %>" name="password"></td>
</tr>

<tr>
<th>Date of birth:</th>
<td><input type="date" value="<%=user.getDate() %>" name="date of birth" ></td>
</tr>
<%if(user.getGender().equals("male")){ %>
<td></td>

<tr>
<th>Gender:</th>
<td><input type="radio" name="gender"  value="male" checked="checked">male 

<input type="radio" name="gender" value="info.getGender" value="female">female </td>
<%}
else{%>
<td><input type="radio" name="gender"  value="male" >male 

<input type="radio" name="gender" value="info.getGender" value="female"checked="checked">female </td>
<%} %>
</tr>

<tr>
<th>Address:</th>
<td><textarea rows="5" cols="20"  name="address" ><%=user.getAddress() %></textarea></td>
</tr>


<tr>
<th>Country:</th>
<td>
<select name="country" value="<%=user.getCountry() %>">
<option >Select an option</option>
<option>India</option>
<option>UAE</option>
<option>Nepal</option>
<option>Japan</option>
</select>
</td>
</tr>

<tr>
<th>Skills:</th>

<%String[] skills=user.getSkills();
for(String string:skills)
{
if(string.equals("Team player"))
{
%>
<td>
<input type="checkbox" name="skills" value="Team player" checked="checked">Team Player
<%} else{%>
<input type="checkbox" name="skills" value="Team player">Team Player
<%} %>

<% if(string.equals("Quick lerner"))
{
%>
<input type="checkbox" name="skills" value="Quick lerner" checked="checked">Quick lerner
<%} else{%>
<input type="checkbox" name="skills" value="Quick lerner">Quick lerner
<%} %>

<% if(string.equals("singer"))
{
%>
<input type="checkbox" name="skills" value="singer"checked="checked">singer
<%} else{%>
<input type="checkbox" name="skills" value="singer">singer
<%} %>

<% if(string.equals("dancer"))
{
%>
<input type="checkbox" name="skills" value="dancer" checked="checked">dancer
<%} else{%>
<input type="checkbox" name="skills" value="dancer">dancer
<%} %>

<%} %>

</td>
</tr>


<tr>
<td><button >Update</button></td>
</tr>

</table>
</form>

</body>
</html>
<%@page import="entidades.*"%>
<%@page import="negocio.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.:Usuario:.</title>
</head>
<body>

<% Usuario u = (Usuario)request.getAttribute("user");
//aquí leo los demás params 
Usuario usuarioSession = (Usuario)session.getAttribute("userSession");%>
<h1 aligne="center" style="font-weight:bold"> Usuario: <%=u.getNombre()%></h1> 

<div>
	<form class="form-redirect" name="redirect" action="redirected2.java" method="post" >
	<table aligne="center">
	<br>
	<tr>
	<td aligne="right"> dni del contrincante: </td>
	<td><input type="text" name="dnicont" id="dnicont"></td>
	</tr>
	
	<tr><input type="submit" value="nueva partida"></tr>
	</table>
	</form>
</div>
		

</body>
</html>
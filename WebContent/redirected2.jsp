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
	<form class="form-redirect" name="redirect" action="<%//debería llamar a partida.html si no estoy mal %>" method="post" >
	<table aligne="center">
	<br>
	<tr>
	<td aligne="right"> dni del contrincante: </td>
	<td><input type="text" name="idcont" id="idcont"></td>
	</tr>
	<tr><input type="submit" value="nueva partida"></tr>
	</table>
	</form>
</div>
		
<div style="margin: auto">
	<% ArrayList<Partida> p = new ArrayList<Partida>(); %>
	<% //p =cont.buscarpartida(dni1);                           cambiar por el request necesario %>
	<p aligne="center" color="blue"> Partidas en curso: </p>
	<form class="form-redirect" name="redirectpart" action="<%//debería llamar a partida.html si no estoy mal %>" method="post">
	<table aligne="center">
	<select name="partidas">
	<% if (p!=null){ %>
	<% for(int i = 0; i < p.size() + 1; i++) { %>
	<option value="<%= p.get(i) %>"></option>
	<% } %>
	<% } %>
	</select>
	<% if (p == null) { %>
	<p aligne="center" color="red"> No tiene partidas en curso </p>
	<% } %>
	</table>
	</form>
</div>	

</body>
</html>
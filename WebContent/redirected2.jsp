<%@page import="entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.:Usuario:.</title>
<!-- Bootstrap core CSS -->
    <link href="signin_files/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin_files/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<table aligne="center">
	<%
		Usuario u = (Usuario)request.getAttribute("user");
		//aquí leo los demás params 
		Usuario usuarioSession = (Usuario)session.getAttribute("userSession");
	%>
	<tr> 
	<td aligne="center" style="font-weight:bold"> 
	Usuario: <%=u.getNombre()%>
	</td>
	</tr>
	<tr>
	<td>
	<div>
	Partidas en curso:
		<form class="form-redirect" name="redirectpart" action="" method="post">
		<select name="partidas" size="15">
		<%if (p!=null){ %>
		<%for(int i = 0; i < p.size() + 1; i++) { %>
		<%model.addElement(p.get(i));%>
		<% return model;%>
		<%} %>
		<%} %>
		<%else {JOptionPane.showMessageDialog(null, "No hay partidas cargadas");return null;} %>
		<option value="<%= t %>"> <%= t %> </option>
		</select>
		</form>
	</div>	
	</td>
	<td>
	<div class="partida">
		<form class="form-redirect" name="redirect" action="" method="post" >
		<table aligne="rigth">
		<input type="submit" value="nueva partida">
		<br>
		Ingrese el dni del contrincante
		<br>
		</form>
		<form class="form-redirect" name="redirect2" action="" method="post">
		<input type="text" name="idcont" id="idcont">
		<br>
		<br>
		<br>
		<input type="submit" value="continuar partida">
		</table>
		</form>
	</div>
	</td>
	</tr>	
	</table>
	</div>
</body>
</html>
<%@page import="entidades.Usuario"%>
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
<div class="partida">
	<form class="form-redirect" name="redirect" action="" method="post" >
	<table aligne="center">
	<br>
	<tr>
	<td> dni del contrincante: </td>
	<td><input type="text" name="idcont" id="idcont"></td>
	</tr>
	<tr><input type="submit" value="nueva partida"></tr>
	</table>
	</form>
</div>		
<div style="margin: auto"> Partidas en curso:
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

</body>
</html>
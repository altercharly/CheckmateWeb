<%@page import="entidades.*"%>
<%@page import="negocio.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.:Partida:.</title>
</head>
<body>
<% Usuario u = (Usuario)session.getAttribute("userSession");
 %>
<% Usuario cont = (Usuario)session.getAttribute("jug2"); %>
<% Partida p = (Partida)session.getAttribute("partida"); %>
<h1 aligne="center" style="font-weight:bold"> IdPartida: <%=p.getid() %></h1> 
<p aligne="center" color="red"> Turno jugador: <%=cont.getApellido()%> <%=cont.getNombre() %></p>
<tr>
<p aligne="center"> Tablero: </p>
<td>
<ul>
<p aligne="left"> J1: <%= u.getApellido() %> <%= u.getNombre() %></p>
<% u = p.getjugador(1);
ArrayList<Pieza> piezas = u.getpiezas();
for (int i = 0; i < 16; i++) {
	if ((piezas.get(i)).getestado() == 1) {%>
		<li><%=(piezas.get(i)).getname()%> ("<%=(piezas.get(i)).getposx()%> ,<%=(piezas.get(i)).getposy()%> )</li>   
		<%}
	}%> 
</ul>
</td>
<td>
<p aligne="rigth"> J2: <%=cont.getApellido() %> <%=cont.getNombre()%></p>
<% cont = p.getjugador(2);
ArrayList<Pieza> piezas2 = u.getpiezas();
for (int i = 0; i < 16; i++) {
	if ((piezas2.get(i)).getestado() == 1) {%>
		<li><%=(piezas2.get(i)).getname()%> ("<%=(piezas2.get(i)).getposx()%> ,<%=(piezas2.get(i)).getposy()%> )</li>   
		<%}
	}%>
</td>
</tr>
<div>
<form class="form-partida" name="partida" action="Partidaservlet" method="post" >
	<table aligne="center">
	<br>
	<tr>
	<p> Realizar movimiento </p>
	<% if(p.getjugact() == 1){ %>
	<td aligne="right"> Ficha(letra inicial): </td>
	<td><input type="text" name="nombreficha" id="nombreficha"></td>
	<td aligne="right"> Posición X: </td>
	<td><input type="text" name="posx" id="posx"></td>
	<td aligne="right"> Posición Y: </td>
	<td><input type="text" name="posy" id="posy"></td>
	<br>
	<td aligne="right"> Nueva posición X: </td>
	<td><input type="text" name="newposx" id="newposx"></td>
	<td aligne="right"> Nueva posición Y: </td>
	<td><input type="text" name="newposy" id="newposy"></td>
	<td><input type="submit" value="Realizar jugada" aligne="center"></td>
	</tr>
	</table>
</form>
<% };%>
</div>	

</body>
</html>
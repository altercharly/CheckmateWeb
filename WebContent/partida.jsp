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
	<!-- Bootstrap core CSS -->
    <link href="signin_files/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin_files/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="signin_files/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<% Usuario u = (Usuario)session.getAttribute("userSession");
 %>
<% Usuario cont = (Usuario)session.getAttribute("jug2"); %>
<% Partida p = (Partida)session.getAttribute("partida"); %>
<h1 aligne="center" style="font-weight:bold"> IdPartida: <%=p.getid() %></h1> 
<p aligne="center" color="red"> Turno jugador: J<%=p.getjugact()%></p>
<tr>
<p aligne="center"> Tablero: </p>
<td>
<ul>
<p aligne="right"> J1: <%= u.getApellido() %> <%= u.getNombre() %></p>
<% u = p.getjugador(1);
ArrayList<Pieza> piezas = u.getpiezas();
for (int i = 0; i < 16; i++) {
	if ((piezas.get(i)).getestado() == 1) {%>
		<li><%=(piezas.get(i)).getname()%> (<%=(piezas.get(i)).getposx()%> ,<%=(piezas.get(i)).getposy()%> )</li>   
		<%}
	}%> 
</ul>
</td>
<td>
<ul>
<p aligne="rigth"> J2: <%=cont.getApellido() %> <%=cont.getNombre()%></p>
<% cont = p.getjugador(2);
ArrayList<Pieza> piezas2 = cont.getpiezas();
for (int j = 0; j < 16; j++) {
	if ((piezas2.get(j)).getestado() == 1) {%>
		<li><%=(piezas2.get(j)).getname()%> (<%=(piezas2.get(j)).getposx()%> ,<%=(piezas2.get(j)).getposy()%> )</li>   
		<%}
	}%>
</ul>	
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
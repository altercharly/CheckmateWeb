<%@page import="entidades.*"%>
<%@page import="negocio.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.:Mensaje:.</title>
</head>
<body>
<form class="form-mensaje" action="Partida2.java" method="post">
<% boolean resp = (boolean)request.getAttribute("valido"); %>
<%if(true == resp){%>
	<%//completar con la muestra si el movimiento fue valido y generar un bton para volver a la "partida.java"%>
<%}%>

</form>
</body>
</html>
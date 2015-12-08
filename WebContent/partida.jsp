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
<% Usuario u = (Usuario)request.getAttribute("user");
 Usuario usuarioSession = (Usuario)session.getAttribute("userSession");%>
<% Partida p = (Partida)request.getAttribute("partidaselect"); %>
<h1 aligne="center" style="font-weight:bold"> IdPartida: <%=p.getid()%></h1> 
<form class="form-partida" name="partida" action="" method="get">


</form>

</body>
</html>
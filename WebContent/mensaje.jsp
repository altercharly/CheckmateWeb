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
<form class="form-mensaje" action="Partida2.java" method="post">
<% boolean resp = (Boolean) session.getAttribute("valido"); %>
<%if(true == resp){%>
	<p aligne="center" style="font-weight:bold"> El movimiento fue valido y guardado. </p>
<%}%>
<%if(false == resp){ %>
	<p aligne="center" style="font-weight:bold"> El movimiento fue invalido, vuelva a intentarlo. </p>
	<input type="submit" value="Volver" aligne="center">
<%} %>
</form>
</body>
</html>
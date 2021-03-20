<%@page import="com.educacionit.curso.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
			<%
			/*out.print( request.getAttribute("alerta"));*/
			Usuario usuario=(Usuario)session.getAttribute("usuario");
			if(usuario == null){
				response.sendRedirect("index.jsp");
			}else{ //Mostamos los atributos si esta el usuario
						
			%>
			<h1>Bienvenido</h1>
			<h2><%usuario.getCorreo();%>  </h2>
			<a href="Home?accion=true">Home -Cierra session</a><!--  Apuntamos el name del SERVLET ANOTACION-->
			<%} %>
</body>
</html>
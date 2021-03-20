<%@page import="com.educacionit.curso.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta charset="ISO-8859-1">
	</head>
	<body>
	<% out.print("<h1> Formulario JSP </h1><br>"); %>
	
	
		 <%
		 	String alerta=(String) request.getAttribute("alerta");
		 	Usuario usuario= (Usuario)session.getAttribute("usuario");
		 	if(usuario != null){// SI hay sesion iniciada
		 		response.sendRedirect("bienvenido.jsp");
		 	}
		 %>
	
		
	
			<form action="Home" method="post">
				<input type="text" id="correo" name="correo"placeholder="email@email">
				<input type="password" id="clave" name="clave"placeholder="Insert Password">
			
				<button type="submit">Enviar</button>
				<button type="reset">Limpiar</button>
			</form>
	</body>
	<%if(alerta != null){ %>
	<h1 style="color:red;"> <%=alerta%> </h1>
	<%} %>
	<footer>	</footer>
</html>
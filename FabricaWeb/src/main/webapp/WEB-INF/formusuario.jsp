<%@page import="br.com.fabricadeprogramador.percistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Formulario Usuario</title>
	</head>
	<body>
		<%@include file="menu.jsp" %>
		
		<%
			Usuario u = (Usuario)request.getAttribute("usu"); 
    	%>
		<form action="UsuarioController" method="post">
		    ID: <input type="number" name="id" value="<%=u.getIdUsuario()%>"/>
			Nome: <input type="text" name="nome" value="<%=u.getNome()%>"/>
			login: <input type="text" name="login" value="<%=u.getLogin()%>"/>
			senha: <input type="text" name="senha" value="<%=u.getSenha()%>"/>
			
			<input type="submit" value="Salvar"> 
	</body>
</html>
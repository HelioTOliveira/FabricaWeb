<%@page import="br.com.fabricadeprogramador.percistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de Usuários</title>
		<script type="text/javascript">
			function confirmaExclusao(id) {
				if(window.confirm('Tem Certeza que deseja exclui?')){
					location.href="UsuarioController?acao=exc&id="+id;
				}
			}
		</script>
	</head>
	<body>
		<%
			List <Usuario> lista= (List<Usuario>)request.getAttribute("lista");
		%>
		<table border=1>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Ação</th>
		</tr>
		<%for(Usuario u: lista){%>
		    <tr>
		    	<td><%=u.getIdUsuario() %></td>
		    	<td><%=u.getNome()%></td>
		    	<td> <a href="javascript:confirmaExclusao(<%=u.getIdUsuario()%>)">excluir | </a> 
		    	<a href="UsuarioController?acao=alt&id=<%=u.getIdUsuario()%>">alterar</a></td>
			</tr>
			<%} %>
		</table>
	</body>
</html>
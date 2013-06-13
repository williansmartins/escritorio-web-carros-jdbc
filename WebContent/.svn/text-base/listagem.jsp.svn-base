<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="modelo.Carro"%>
<%@page import="controle.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Listagem</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Fabricante</th>
			<th>Modelo</th>
			<th>Ano</th>
			<th colspan="2">Ações</th>
		</tr>
	<%
		for(Carro carro : DAO.listagem()) {
	%>
		<tr>
			<td><%= carro.getId() %></td>
			<td><%= carro.getFabricante() %></td>
			<td><%= carro.getModelo() %></td>
			<td><%= carro.getAno() %></td>
			<td><a href="layout-editar.jsp?id=<%= carro.getId() %>"  >Editar</a></td>
			<td><a href="excluir.jsp?id=<%= carro.getId() %>"  >Excluir</a></td>
		</tr>
	<%} %>
	</table>
	<input type="button" value="Inserir" onclick="location.href='layout-inserir.jsp'"/>

</body>
</html>
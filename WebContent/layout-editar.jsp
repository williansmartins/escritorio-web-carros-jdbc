<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="controle.DAO"%>
<%@page import="modelo.Carro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Layout Editar</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		Carro carro = new Carro();
		carro = DAO.prepararCarro(idInt);
	%>
	<form action="captura-editar.jsp">
		<h1>Editar</h1>
		Id:	     	<input type="text" 		name="id"         value="<%= carro.getId()%>" />		<br />
		Fabricante:	<input type="text" 		name="fabricante" value="<%= carro.getFabricante()%>"/>	<br />
		Modelo:		<input type="text" 		name="modelo"     value="<%= carro.getModelo()%>"/>		<br />
		Ano:		<input type="text" 		name="ano"        value="<%= carro.getAno()%>" />		<br />
					<input type="submit" 	value="salvar"/>
					<input type="button" 	value="voltar" onclick="location.href='listagem.jsp'"/>
	</form>
</body>
</html>
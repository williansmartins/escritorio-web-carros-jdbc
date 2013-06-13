<%@page import="controle.DAO"%>
<%
	String fabricante = request.getParameter("fabricante");
	String modelo = request.getParameter("modelo");
	String ano = request.getParameter("ano");
	
	DAO.inserir(fabricante, modelo, ano);
	response.sendRedirect("listagem.jsp");
%>
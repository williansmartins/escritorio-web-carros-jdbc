<%@page import="modelo.Carro"%>
<%@page import="controle.DAO"%>
<%
	String id = request.getParameter("id");
	int idInt = Integer.parseInt(id);	

	String fabricante = request.getParameter("fabricante");
	String modelo = request.getParameter("modelo");
	String ano = request.getParameter("ano");
	
	Carro carro = new Carro();
	carro.setId( idInt );
	carro.setFabricante( fabricante );
	carro.setModelo(modelo );
	carro.setAno( ano );
	
	DAO.atualizar(carro);
	response.sendRedirect("listagem.jsp");
%>
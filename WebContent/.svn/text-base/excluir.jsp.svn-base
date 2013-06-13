<%@page import="controle.DAO"%>

<%
	String id = request.getParameter("id");
	int idInt = Integer.parseInt(id);	

	DAO.excluir(idInt); 
	response.sendRedirect("listagem.jsp?acao='excluir'");
	
%>
	<script>
		alert("Ecluído com sucesso!");
	</script>
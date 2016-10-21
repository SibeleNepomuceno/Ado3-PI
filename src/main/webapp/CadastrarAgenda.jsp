<%-- 
    Document   : CadastrarAgenda
    Created on : 20/10/2016, 07:14:45
    Author     : Sibele nepomuceno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar agenda</title>
    </head>
    <body>
        <h1>Adicione um pessoa</h1>
    <c:url value="cadastrar-Agenda" var="urlFormulario" />
    <form action="${urlFormulario}" method="post" enctype="application/x-www-form-urlencoded">
      <input type="hidden" name="id" value="99" />
      <div>
	<label for="txtnome">Nome:</label>
	<input type="text" name="nome" id="txtnome" placeholder="Digite o nome completo" />
      </div>
      <div>
	<label for="txtdtnasc">Data nascimento:</label>
	<input type="text" name="dtnasc" id="txtdtnasc"
	       placeholder="Digite no formato dd/MM/aaaa"
	       maxlength="10"/>
      </div>
      <div>
	<label for="txtTelefone">Telefone:</label>
	<input type="text" name="Telefone" id="txtTelefone"
	       placeholder="Digite seu telefone"
	       maxlength="10"/>
      </div>
      <div>
	<label for="txtemail">E-mail:</label>
	<input type="email" name="email" id="txtemail" />
      </div>
      <div>
	<input type="submit" value="Enviar" />
	<input type="reset" value="Valores iniciais" />
      </div>
    </form>
    </body>
</html>

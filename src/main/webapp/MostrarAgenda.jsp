<%-- 
    Document   : MostrarAgenda
    Created on : 20/10/2016, 07:37:59
    Author     : dgm19
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listando contatos</title>
    </head>
    <body>
        <h1>lista de contatos da agenda</h1>
        <br>
        <table border="1">
            <tr>
                <th>Codigo</th>
                <th>Nome</th>
                <th>Data Nascimento</th>
                <th>Telefone</th>
                <th>e-mail</th>
                <th>Data Cadastro</th>
            </tr>
            <c:forEach var="item" items="${listaPessoas}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nome}</td>
                    <td>${item.dataNascimento}</td>
                    <td>${item.telefone}</td>
                    <td>${item.email}</td>   
                    <td>${item.dataCadastro}</td>   
                </tr>
            </c:forEach>
        </table>
        <br>
        <button onclick="window.location.href='CadastrarAgenda.jsp'">Cadastrar Novo</button>
        <br>
        <c:url value="Mostrar-Agenda" var="urlFormulario" />
        <form action="${urlFormulario}" method="post">
            <br>
            <input type="submit" value="Excluir todos" />
        </form>
    </body>
</html>

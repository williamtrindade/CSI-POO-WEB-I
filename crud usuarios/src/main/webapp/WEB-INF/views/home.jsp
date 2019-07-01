<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='/resources/css/projeto.css'/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='/resources/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:if  test="${sessionScope['logado'] != null}">
            <div class="container">
                <h1>Bem Vindo  <strong> ${logado.nome}</strong></h1> 
                <br>
                <h3>Cadastrar Usuário</h3>
                <div class="row">
                    <form action="salvarUsuario" method="post">
                        <label>Nome:</label>
                        <input type="text" name="nome"><br>
                        <label>Sobrenome:</label>
                        <input type="text" name="sobrenome"><br>
                        <label>E-mail:</label>
                        <input type="email" name="email"><br>
                        <label>Senha:</label>
                        <input type="text" name="senha"><br>
                        <button type="submit" >Salvar</button>
                    </form>
                </div>
                <div class="row">
                    <c:if test="${erro!=null}">
                        <div class="text-center"> ${erro}</div>
                    </c:if>
                    <c:if test="${ok!=null}">
                        <div class="text-center"> ${ok}</div>
                    </c:if>
                </div>
                <br>
                <div class="row">
                    <table>
                        <thead>
                            <tr>
                                <th class="text-center">Nome</th>
                                <th class="text-center">Sobrenome</th>
                                <th class="text-center">E-mail</th>
                                <th class="text-center">Senha</th>
                                <th class="text-center">Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="usuario" items="${usuarios}">
                                <tr>
                                    <td class="text-center">${usuario.nome}</td>
                                    <td class="text-center">${usuario.sobrenome}</td>
                                    <td class="text-center">${usuario.email}</td>
                                    <td class="text-center">${usuario.senha}</td>
                                    <td class="text-center">
                                        <a href="redirectEditarUsuario?idUsuario=${usuario.id}" title="Editar usuário">
                                            <i class="fa fa-edit btn text-info"></i>
                                        </a>
                                        <a href="deletarUsuario?idUsuario=${usuario.id}" title="Deletar usuário">
                                            <i class="fa fa-trash btn text-danger"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>
    </body>
</html>

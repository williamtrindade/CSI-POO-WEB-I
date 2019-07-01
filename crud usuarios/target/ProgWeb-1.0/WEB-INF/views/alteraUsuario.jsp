<%-- 
    Document   : alteraUsuario
    Created on : 05/06/2019, 16:46:35
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar usuário</title>
    </head>
    <body>
        
        <h3>Editar Usuário</h3>
            <div class="row">
                <form action="salvarUsuario" method="post">
                    <input type="hidden" name="id" value="${usuario.id}">
                    <label>Nome:</label>
                    <input type="text" name="nome" value="${usuario.nome}"><br>
                    <label>Sobrenome:</label>
                    <input type="text" name="sobrenome" value="${usuario.sobrenome}"><br>
                    <label>E-mail:</label>
                    <input type="email" name="email" value="${usuario.email}"><br>
                    <label>Senha:</label>
                    <input type="text" name="senha" value="${usuario.senha}"><br>
                    <button type="submit" >Editar</button>
                </form>
            </div>
        
    </body>
</html>

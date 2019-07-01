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
    <div class="main">
        <div class="content">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-offset-3 col-md-6 text-center col-lg-offset-3">
                        <center><img class="img img-responsive text-center" src="<c:url value='/resources/imagens/logo-curso.PNG'/>" alt="logo-curso"/></center>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-offset-4 col-md-4 col-md-offset-4 jumbotron">
                        <c:if test="${erro!=null}">
                            <div class="alert alert-danger fade in">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong><div class="text-center"> ${erro}</div></strong>
                            </div>
                        </c:if>

                        <form action="login" autocomplete="off" method="post">
                            <h3 class="title">
                                <strong>Login</strong><i class="glyphicon glyphicon-lock pull-right"></i>
                            </h3>
                            <h5 class="title"> Informe os seguintes dados:</h5>

                            <!--EMAIL--->
                            <div class="form-group">
                                <label>E-mail:</label>
                                <input type="email" class="form-control" name="email" required>
                            </div>
                            <!--SENHA--->
                            <div class="form-group">
                                <label>Senha:</label>
                                <input type="password" class="form-control" name="senha" required>
                            </div>
                            <center>
                                <button type="submit" class="btn btn-info" name="opcao">Acessar minha conta</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>

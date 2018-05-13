<%-- 
    Document   : listarPessoa
    Created on : 01/05/2018, 18:10:49
    Author     : Luiz myguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="index.jsp">Sistema de Controle</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="FrontController?action=ListarPessoas">Pessoas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?action=LerPropostas">Propostas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FrontController?action=ListarEventos">Eventos</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row col-lg-10 text-center" style="padding-top: 100px">
            <div class="row col-lg-10">
                <h5 class="col-lg-10">Pessoas</h5>
            </div>
            <div class="row col-lg-10">
                <table class="col-lg-10 table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Usuario</th>
                        <th colspan=2>Ação</th>
                    </tr>
                    <c:forEach items="${pessoas}" var="pessoa">
                        <tr>
                            <td><c:out value="${pessoa.id}"/></td>
                            <td><c:out value="${pessoa.nome}"/></td>
                            <td><c:out value="${pessoa.email}"/></td>
                            <td><c:out value="${pessoa.tipoUsuario}"/></td>
                            <td><a href="FrontController?action=LerPessoa&nome=<c:out value="${pessoa.id}"/>"> <button class="btn btn-info btn-sm">Ver Pessoa</button> </a></td>
                            <td><a href="FrontController?action=LerDados&nome=<c:out value="${pessoa.id}"/>"> <button class="btn btn-info btn-sm">Ver Dados</button> </a></td>
                        </tr>   
                    </c:forEach>
                </table>
            </div>  
        </div>
        <div class="row col-lg-10 text-center form-group">
            <div class="row col-lg-10">
                <h5 class="text-center">Acessos :</h5>
            </div>
            <div class="row col-lg-10 form-group">
            <div class="col-lg-2">
                <a href="FrontController?action=VerificarAcesso&acesso=Matricula"><button class="btn btn-primary">Ver Acesso matricula</button></a>
            </div>  
            <div class="col-lg-2">
                <a href="FrontController?action=VerificarAcesso&acesso=Proposta"><button class="btn btn-primary">Ver Acesso propostas</button></a>
            </div>  
            <div class="col-lg-2">
                <a href="FrontController?action=VerificarAcesso&acesso=Evento"><button class="btn btn-primary">Ver Acesso eventos</button></a>
            </div>  
        </div>
        </div>
        <div class="row col-lg-10 text-center">
            <a href="manterPessoa.jsp"><button>Incluir</button></a>
        </div>    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
</body>
</html>

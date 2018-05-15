<%-- 
    Document   : listarProposta
    Created on : 01/05/2018, 18:11:06
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
            <div class="row col-lg-10 text-center">
                <h5 class="col-lg-10">Propostas</h5>
            </div>
            <div class="row col-lg-10">
                <table class="col-lg-10 table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Titulo</th>
                        <th>Finalidade</th>
                        <th>Carga Horária</th>
                        <th>Status</th>
                        <th colspan=7>Ação</th>
                    </tr>
                    <c:forEach items="${propostas}" var="proposta">
                        <tr>
                            <td><c:out value="${proposta.id}"/></td>
                            <td><c:out value="${proposta.tituloAtividade}"/></td>
                            <td><c:out value="${proposta.finalidadeAtividade}"/></td>
                            <td><c:out value="${proposta.cargaHoraria}"/></td>
                            <td><c:out value="${proposta.estado.getEstado()}"/></td>
                            <td><a href="FrontController?action=LerProposta&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-default btn-sm">Editar</button> </a></td>
                            <td><a href="FrontController?action=DesfazerAlteracaoProposta&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-default btn-sm">Desfazer Alteração</button> </a></td>
                            <td><a href="FrontController?action=LerPropostaAlteracaoTitulo&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-default btn-sm">Alteracao Finalidade</button> </a></td>
                            <td><a href="FrontController?action=PropostaAprovado&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-info btn-sm">Ver siuação aprovada</button> </a></td>
                            <td><a href="FrontController?action=PropostaCancelado&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-info btn-sm">Ver siuação cancelada</button> </a></td>
                            <td><a href="FrontController?action=PropostaConcluido&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-info btn-sm">Ver siuação concluida</button> </a></td>
                            <td><a href="FrontController?action=PropostaEmAnalise&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-info btn-sm">Ver siuação em analise</button> </a></td>
                            <td><a href="FrontController?action=PropostaReprovado&id=<c:out value="${proposta.id}"/>"> <button class="btn btn-info btn-sm">Ver siuação reprovada</button> </a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>  
        </div>
        <div class="row col-lg-10 text-center">
            <a href="manterProposta.jsp"><button>Incluir</button></a>
        </div>  

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    </body>
</html>

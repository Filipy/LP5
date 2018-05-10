<%-- 
    Document   : pesquisaPropostas
    Created on : 01/05/2018, 17:47:34
    Author     : Luiz myguel
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
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
                        <a class="nav-link" href="ler.jsp">Eventos</a>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>

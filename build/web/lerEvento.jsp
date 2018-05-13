<%-- 
    Document   : lerEvento
    Created on : 13/05/2018, 16:51:54
    Author     : Luiz myguel
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                        <a class="nav-link" href="FrontController?action=ListarEventos">Eventos</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row col-lg-10 text-center" style="padding-top: 100px">
            <div class="row col-lg-12 text-center">
                <h1>Cadastro Evento</h1>
            </div>
            <form id="formCadastro" action="FrontController?action=ManterEvento" method="post" name="frmManterLocal">
                <div class="col-lg-12">
                    <div cclass="col-lg-12">
                        <label>Id</label>
                    </div>
                    <input name="textId" type="text" class="form-control" aria-label="Default">
                </div>
                <div class="col-lg-12">
                    <div class="col-lg-12">
                        <label>Titulo</label>
                    </div>
                    <input name="textTitulo" type="text" class="form-control" aria-label="Default">
                </div>
                <div class="col-lg-12">
                    <div class="col-lg-12">
                        <label>Quantidade</label>
                    </div>
                    <input name="textQuantidade" type="text" class="form-control" aria-label="Default">
                </div>

                <div class="col-lg-12">
                    <div class="col-lg-12">
                        <label>TipoEvento</label>
                    </div>
                    <select name="textTipo" type="text" class="form-control" aria-label="Default">
                        <option value="Minicurso">Minicurso</option>
                        <option value="Workshop">Workshop</option>     
                        <option value="Palestra">Palestra</option>
                    </select>
                </div>

                <div class="col-lg-12">
                    <div class="col-lg-12">
                        <label>Escolha o palestrante</label>
                    </div>
                    <div >
                        <select class="form-control" name="textPalestrante"> 
                            <c:forEach items="${pessoas}" var="pessoa">
                                <option value="${pessoa.id}">${pessoa.nome}</option>  
                            </c:forEach>
                        </select><br/>
                    </div>
                </div> 
                <button type="submit">Enviar</button>
            </form>
        </div>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    </body>
</html>

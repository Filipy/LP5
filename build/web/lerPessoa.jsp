<%-- 
    Document   : LerPessoa
    Created on : 01/05/2018, 19:10:02
    Author     : Luiz myguel
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
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
             <div class="row col-lg-12">
                <h1>Cadastro Pessoa</h1>
            </div>
                <form id="formCadastro" action="FrontController?action=ManterPessoa" method="post" name="frmManterLocal">
                    <div>
                        <div>
                            <label>Id</label>
                        </div>
                        <input name="textId" type="text" value="${pessoa.id}" disabled="true" class="form-control" aria-label="Default">
                    </div>
                    <div>
                        <div>
                            <label>Nome</label>
                        </div>
                        <input name="textNome" type="text" value="${pessoa.nome}" class="form-control" aria-label="Default">
                    </div>
                    <div>
                        <div>
                        <label>Email</label>
                        </div>
                        <input name="textEmail" type="text" value="${pessoa.email}" class="form-control" aria-label="Default">
                    </div>
                    
                     <div>
                        <div>
                        <label>TipoUsuario</label>
                        </div>
                        <select name="textUsuario" type="text" value="${pessoa.tipoUsuario}" class="form-control" aria-label="Default">
                            <option value="Aluno" <c:if test="${pessoa.tipoUsuario == 'Aluno'}"> selected</c:if >>Aluno</option>
                            <option value="Professor" <c:if test="${pessoa.tipoUsuario == 'Professor'}"> selected</c:if >>Professor</option>
                            <option value="Diretor" <c:if test="${pessoa.tipoUsuario == 'Diretor'}"> selected</c:if >>Diretor</option>
                        </select>
                    </div>
                </form>
        </div>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    </body>
</html>

<%-- 
    Document   : lerProposta
    Created on : 02/05/2018, 21:58:49
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
                        <a class="nav-link" href="FrontController?action=ListarEventos">Eventos</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row col-lg-10 text-center" style="padding-top: 100px">
            <div class="row col-lg-12">
                <h1>Cadastro Proposta</h1>
            </div>
            <form id="formCadastro" action="FrontController?action=EditarProposta" method="post" name="frmManterLocal">
                <div>
                    <div>
                        <label>Id</label>
                    </div>
                    <input name="textId" type="text" value="${proposta.id}" class="form-control" aria-label="Default">
                </div>
                <div>
                    <div>
                        <label>Titulo</label>
                    </div>
                    <input name="textTitulo" type="text" value="${proposta.tituloAtividade}" class="form-control" aria-label="Default">
                </div>
                <div>
                    <div>
                        <label>Finalidade</label>
                    </div>
                    <input name="textFinalidade" type="text" value="${proposta.finalidadeAtividade}" class="form-control" aria-label="Default">
                </div>

                <div>
                    <div>
                        <label>Carga hóraria</label>
                    </div>
                    <input name="textCarga" type="text" value="${proposta.cargaHoraria}" class="form-control" aria-label="Default">
                </div>
                <div>
                    <div>
                        <label>Estado</label>
                    </div>
                    <select name="textEstado" type="text" value="${proposta.nomeEstado}" class="form-control" aria-label="Default">
                        <option value="EmAnalise">Analise</option>
                        <option value="Cancelado">Cancelado</option>
                        <option value="Reprovado">Reprovado</option>
                        <option value="Aprovado">Aprovado</option>
                        <option value="Concluido">Concluido</option>
                    </select>
                </div>
                <button type="submit">Enviar</button>
            </form>
        </div>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    </body>
</html>

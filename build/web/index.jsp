<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Inicio</title>
        <link href="starter-template.css" rel="stylesheet">
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
        <main role="main" class="container">
            <div class="starter-template">

                <h1>Sistema de Controle</h1>
                <p class="lead"></p>
                
                <div class="row">
                    <div class="col-lg-3">
                      <form action="FrontController?action=ListarPessoas" method="post">
                       <button type="submit" class="btn btn-primary" name="btnRelatorio" value="Exibir">Pessoa</button>                
                      </form>
                    </div>
                    <div class="col-lg-3">
                      <form action="FrontController?action=LerPropostas" method="post">
                       <button type="submit" class="btn btn-primary" name="btnRelatorio" value="Exibir">Proposta</button>                
                      </form>
                    </div>
                    <div class="col-lg-3">
                      <form action="FrontController?action=ListarEventos" method="post">
                       <button type="submit" class="btn btn-primary" name="btnRelatorio" value="Exibir">Eventos</button>                
                      </form>
                    </div>
                </div>

            </div>
        </main><!-- /.container -->

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    </body>
</html>

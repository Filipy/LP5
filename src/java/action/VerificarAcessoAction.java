/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.PessoaAluno;
import model.PessoaDiretor;
import model.PessoaProfessor;
import persistence.PessoaDAO;

/**
 *
 * @author Luiz myguel
 */
public class VerificarAcessoAction  implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String acesso = request.getParameter("acesso");
        Pessoa pessoaResponseAluno = new PessoaAluno();
        Pessoa pessoaResponseProfessor = new PessoaProfessor();
        Pessoa pessoaResponseDiretor = new PessoaDiretor();
        pessoaResponseAluno.setPessoaComAcessoSuperior(pessoaResponseProfessor);
        pessoaResponseProfessor.setPessoaComAcessoSuperior(pessoaResponseDiretor);
        pessoaResponseDiretor.setPessoaComAcessoSuperior(null);
        
        response.sendRedirect("erro.jsp?erro=" + pessoaResponseAluno.verificarAcesso(acesso));
    }
    
}

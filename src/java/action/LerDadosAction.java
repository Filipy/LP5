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
import persistence.PessoaDAO;

/**
 *
 * @author Luiz myguel
 */
public class LerDadosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        Pessoa pessoaResponse = null;
        
        try {
            pessoaResponse = PessoaDAO.getInstance().get(nome);
            request.setAttribute("pessoa", pessoaResponse);    
            response.sendRedirect("erro.jsp?erro=" + pessoaResponse.getDados());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
    }
    
}

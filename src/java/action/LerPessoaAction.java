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
public class LerPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Pessoa pessoaResponse = null;
        
        try {
            pessoaResponse = PessoaDAO.getInstance().get(id);
            request.setAttribute("pessoa", pessoaResponse);    
            RequestDispatcher view = request.getRequestDispatcher("lerPessoa.jsp");
            view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            } catch (ServletException ex) {
            Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

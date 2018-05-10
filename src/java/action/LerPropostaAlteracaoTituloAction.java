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
import model.Proposta;
import persistence.PropostaDAO;

/**
 *
 * @author Luiz myguel
 */
public class LerPropostaAlteracaoTituloAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tituloAtividade = request.getParameter("tituloAtividade");
        Proposta propostaResponse = new Proposta();
        propostaResponse.setTituloAtividade(tituloAtividade);
        
        try {
            propostaResponse = PropostaDAO.getInstance().get(propostaResponse);
            request.setAttribute("proposta", propostaResponse);    
            RequestDispatcher view = request.getRequestDispatcher("alterarTituloProposta.jsp");
            view.forward(request, response);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            } catch (ServletException ex) {
            Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

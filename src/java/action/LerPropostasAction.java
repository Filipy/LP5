/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class LerPropostasAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
       ArrayList<Proposta> propostaResponse = new ArrayList<Proposta>();
            try {
                propostaResponse = PropostaDAO.getInstance().getALL();
                request.setAttribute("propostas", propostaResponse);       
                RequestDispatcher view = request.getRequestDispatcher("listarProposta.jsp");
                view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarPessoasAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ListarPessoasAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}

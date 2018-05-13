/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AvisarParticipante;
import model.Evento;
import model.Pessoa;
import model.PessoaAluno;
import model.Proposta;
import model.PropostaMemento;
import persistence.EventoDAO;
import persistence.PessoaDAO;
import persistence.PropostaDAO;

/**
 *
 * @author Luiz myguel
 */
public class AvisarParticipanteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("textId"));
        
        String quant = request.getParameter("textQuantidade");
        Evento eventoResponse = new Evento();
        try {
            eventoResponse = EventoDAO.getInstance().get(id);
            
            Pessoa pessoaInteressada = PessoaDAO.getInstance().get(eventoResponse.getId_palestrante());
            pessoaInteressada.setEventoInteresse(eventoResponse);
            eventoResponse.setQuantAlunos(quant);  
            
            if (Integer.parseInt(quant) > eventoResponse.getEvento().maxVagas()) {
                    response.sendRedirect("erro.jsp?erro=" + "A quantidade de pessoas é superior ao maximo permitido de: " + eventoResponse.getEvento().maxVagas() + "");
                    return;
                }
            
            response.sendRedirect("erro.jsp?erro=" + AvisarParticipante.getInstance().getAvisos().get(0));
                              
            
        
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp?erro=" + ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

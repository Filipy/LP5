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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AvisarParticipante;
import model.PessoaAluno;
import model.Proposta;
import model.PropostaMemento;
import persistence.PropostaDAO;

/**
 *
 * @author Luiz myguel
 */
public class AvisarParticipanteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tituloAtividade = request.getParameter("textTitulo");
        String finalidade = request.getParameter("textFinalidade");
        Proposta propostaResponse = new Proposta();
        propostaResponse.setTituloAtividade(tituloAtividade);
        try {
            propostaResponse = PropostaDAO.getInstance().get(propostaResponse);
            PessoaAluno aluno = new PessoaAluno(propostaResponse);
            aluno.setNome("Marco");
            
            propostaResponse.setFinalidadeAtividade(finalidade);
            
            response.sendRedirect("erro.jsp?erro=" + AvisarParticipante.getInstance().getAvisos().get(0));
        
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp?erro=" + ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

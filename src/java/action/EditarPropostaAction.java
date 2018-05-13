/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.PessoaAluno;
import model.Proposta;
import model.PropostaMemento;
import persistence.PessoaDAO;
import persistence.PropostaDAO;

/**
 *
 * @author Luiz myguel
 */
public class EditarPropostaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("textId"));
        String tituloAtividade = request.getParameter("textTitulo");
        String finalidade = request.getParameter("textFinalidade");
        String carga = request.getParameter("textCarga");
        String estado = request.getParameter("textEstado");
        ArrayList<PropostaMemento> mementos = new ArrayList<PropostaMemento>();
        Proposta propostaResponse = new Proposta();
        propostaResponse.setTituloAtividade(tituloAtividade);
        try {
            propostaResponse = PropostaDAO.getInstance().get(propostaResponse);
            mementos.add(new PropostaMemento(propostaResponse.getEstado()));
            propostaResponse = new Proposta(id, tituloAtividade, finalidade, carga, estado);
            mementos.add(new PropostaMemento(propostaResponse.getEstado()));
            propostaResponse.restoreFromMemento(mementos.get(0));
            String estadoAnterior = propostaResponse.getEstado().getEstado();
            response.sendRedirect("erro.jsp?erro=" + "O estado anterior da proposta era: " + estadoAnterior);
        
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp?erro=" + ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
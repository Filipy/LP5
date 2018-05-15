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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.PessoaAluno;
import model.Proposta;
import model.PropostaMemento;
import persistence.PessoaDAO;
import persistence.PropostaDAO;
import persistence.PropostaMementoDAO;

/**
 *
 * @author Luiz myguel
 */
public class EditarPropostaAction implements Action {        
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("textId"));
        String tituloAtividade = request.getParameter("textTitulo");
        String finalidadeAtividade = request.getParameter("textFinalidade");
        String cargaHoraria = request.getParameter("textCarga");
        
        Proposta propostaResponse = new Proposta();
        propostaResponse.setId(id);
        
        Proposta propostaMementoResponse = new Proposta();
        propostaMementoResponse.setId(id);
        
        try {
            propostaResponse = PropostaDAO.getInstance().get(propostaResponse);
            Proposta proposta = new Proposta(id, tituloAtividade, finalidadeAtividade, cargaHoraria, propostaResponse.getNomeEstado());
            propostaMementoResponse = propostaResponse;
            if(PropostaMementoDAO.getInstance().get(propostaResponse)!=null){
                PropostaMementoDAO.getInstance().update(propostaMementoResponse);
            }else{
                PropostaMementoDAO.getInstance().save(propostaMementoResponse);
            }
            
            PropostaDAO.getInstance().update(proposta);
            RequestDispatcher view = request.getRequestDispatcher("sucessoProposta.jsp");
            view.forward(request, response);
            
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp?erro=" + ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EditarPropostaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
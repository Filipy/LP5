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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proposta;
import persistence.PropostaDAO;

/**
 *
 * @author Luiz myguel
 */
public class ManterPropostaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("textId"));
        String tituloAtividade = request.getParameter("textTitulo");
        String finalidadeAtividade = request.getParameter("textFinalidade");
        String cargaHoraria = request.getParameter("textCarga");
        String estado = request.getParameter("textEstado");
        if (tituloAtividade.equals("") || finalidadeAtividade.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            Proposta proposta = new Proposta(id, tituloAtividade, finalidadeAtividade, cargaHoraria, estado);
            try {
                PropostaDAO.getInstance().save(proposta);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManterPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}

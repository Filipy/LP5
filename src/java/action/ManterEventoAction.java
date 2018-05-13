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
import model.Evento;
import model.Minicurso;
import model.Palestra;
import model.Pessoa;
import model.PessoaAluno;
import model.PessoaDiretor;
import model.PessoaProfessor;
import model.Workshop;
import persistence.EventoDAO;
import persistence.PessoaDAO;

/**
 *
 * @author Luiz myguel
 */
public class ManterEventoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Evento evento = null;
        int id = Integer.parseInt(request.getParameter("textId"));
        String titulo = request.getParameter("textTitulo");
        String quantidade = request.getParameter("textQuantidade");
        String tipo = request.getParameter("textTipo");
        int tipoUsuario = Integer.parseInt(request.getParameter("textPalestrante"));

        Pessoa pessoaResponseAluno = new PessoaAluno();
        Pessoa pessoaResponseProfessor = new PessoaProfessor();
        Pessoa pessoaResponseDiretor = new PessoaDiretor();
        pessoaResponseAluno.setPessoaComAcessoSuperior(pessoaResponseProfessor);
        pessoaResponseProfessor.setPessoaComAcessoSuperior(pessoaResponseDiretor);
        pessoaResponseDiretor.setPessoaComAcessoSuperior(null);

        try {
            Pessoa pessoaResponsavel = PessoaDAO.getInstance().get(tipoUsuario);
            if (!pessoaResponsavel.getDescricaTipo().equals(pessoaResponseAluno.verificarAcesso(tipo))) {
                response.sendRedirect("erro.jsp?erro=" + "O palestrante escolhido não pode realizar esse tipo de evento apenas usuarios do tipo: " + pessoaResponseAluno.verificarAcesso(tipo) + "");
            } else {
                if (tipo.equals("Minicurso")) {
                    evento = new Minicurso(id, pessoaResponsavel.getNome(), titulo, quantidade, tipoUsuario, tipo);
                } else if (tipo.equals("Workshop")) {
                    evento = new Workshop(id, pessoaResponsavel.getNome(), titulo, quantidade, tipoUsuario, tipo);
                } else {
                    evento = new Palestra(id, pessoaResponsavel.getNome(), titulo, quantidade, tipoUsuario, tipo);
                }
                
                if (Integer.parseInt(quantidade) > evento.getEvento().maxVagas()) {
                    response.sendRedirect("erro.jsp?erro=" + "A quantidade de pessoas é superior ao maximo permitido de: " + evento.getEvento().maxVagas() + "");
                    return;
                }
                               
                EventoDAO.getInstance().save(evento);
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp?erro=" + ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

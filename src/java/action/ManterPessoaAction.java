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
import model.Pessoa;
import model.PessoaAluno;
import persistence.PessoaDAO;

/**
 *
 * @author Luiz myguel
 */
public class ManterPessoaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("textId"));
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        String tipoUsuario = request.getParameter("textUsuario");

        if (nome.equals("") || email.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            Pessoa pessoa = new PessoaAluno(id, nome, email, tipoUsuario);
            try {
                PessoaDAO.getInstance().save(pessoa);
                response.sendRedirect("index.jsp");
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManterPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

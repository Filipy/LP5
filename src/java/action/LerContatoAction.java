package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;

/**
 *
 * @author DualLayer
 */
public class LerContatoAction implements Action {

    public LerContatoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("textId");
        Contato contatoResponse = new Contato();

        if (id.equals("")) {
            response.sendRedirect("ler.jsp");
        } else {
            Contato contato = new Contato(Integer.parseInt(id));
            try {
                contatoResponse = ContatoDAO.getInstance().get(contato);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            }
        }

    }

}

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
import model.Evento;
import model.Minicurso;
import model.Palestra;
import model.Pessoa;
import model.Workshop;
import persistence.EventoDAO;
import persistence.PessoaDAO;

/**
 *
 * @author Luiz myguel
 */
public class LerEventoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Evento evento = null;
        
        try {
            evento = EventoDAO.getInstance().get(id); 
            response.sendRedirect("erro.jsp?erro=" + "O tipo de evento é: " + evento.getEvento().tipoEvento());    
//            RequestDispatcher view = request.getRequestDispatcher("lerPessoa.jsp");
//            view.forward(request, response);
            } catch (SQLException ex) {
                response.sendRedirect("erro.jsp?erro=" + ex);
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerPessoaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Evento evento = new Evento();
//        if(tituloAtividade.equals("Workshop")){
//        evento = new  Workshop();
//        evento.setId(1);
//        evento.setPalestrante("Marco");
//        evento.setTitulo("Workshop");
//        }else if(tituloAtividade.equals("Minicurso")){
//        evento = new  Minicurso();
//        evento.setId(1);
//        evento.setPalestrante("Maria");
//        evento.setTitulo("Minicurso");
//        }else{
//        evento = new  Palestra();
//        evento.setId(1);
//        evento.setPalestrante("Hilton");
//        evento.setTitulo("Palestra");   
//        }   
      //response.sendRedirect("erro.jsp?erro=" + "O tipo de evento é: " + evento.getEvento().tipoEvento());     
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;
import model.Minicurso;
import model.Palestra;
import model.Workshop;

/**
 *
 * @author Luiz myguel
 */
public class LerEventoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tituloAtividade = request.getParameter("titulo");
        Evento evento = new Evento();
        if(tituloAtividade.equals("Workshop")){
        evento = new  Workshop();
        evento.setId(1);
        evento.setPalestrante("Marco");
        evento.setTitulo("Workshop");
        }else if(tituloAtividade.equals("Minicurso")){
        evento = new  Minicurso();
        evento.setId(1);
        evento.setPalestrante("Maria");
        evento.setTitulo("Minicurso");
        }else{
        evento = new  Palestra();
        evento.setId(1);
        evento.setPalestrante("Hilton");
        evento.setTitulo("Palestra");   
        }   
      response.sendRedirect("erro.jsp?erro=" + "O tipo de evento é: " + evento.getEvento().tipoEvento());     
    }
    
}

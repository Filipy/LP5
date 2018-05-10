/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
public class ListarEventosAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        Evento evento1 = new  Workshop();
        evento1.setId(1);
        evento1.setPalestrante("Marco");
        evento1.setTitulo("Workshop");
        Evento evento2 = new  Minicurso();
        evento2.setId(1);
        evento2.setPalestrante("Maria");
        evento2.setTitulo("Minicurso");
        Evento evento3 = new  Palestra();
        evento3.setId(1);
        evento3.setPalestrante("Hilton");
        evento3.setTitulo("Palestra");     
        
        eventos.add(evento3);
        eventos.add(evento2);
        eventos.add(evento1);
        request.setAttribute("eventos", eventos);       
                RequestDispatcher view = request.getRequestDispatcher("pesquisaEventos.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ListarEventosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

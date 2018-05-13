/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luiz myguel
 */
public class EventoMedio implements DivulgacaoEvento {

    @Override
    public String tipoEvento() {
        return "Evento Medio";
    }
    
     @Override
    public int maxVagas() {
        return 20;
    }
    
}

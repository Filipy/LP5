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
public class EventoPequeno implements DivulgacaoEvento{

    @Override
    public String tipoEvento() {
        return "Evento Pequeno";
    }
    
     @Override
    public int maxVagas() {
        return 10;
    }
    
}

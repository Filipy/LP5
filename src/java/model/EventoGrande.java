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
public class EventoGrande implements DivulgacaoEvento  {

    @Override
    public String tipoEvento() {
        return "Evento Grande";
    }

    @Override
    public int maxVagas() {
        return 40;
    }
    
}

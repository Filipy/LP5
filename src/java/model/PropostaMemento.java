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
public class PropostaMemento {
    private PropostaEstado estado;
    
    public PropostaMemento(PropostaEstado estadoSalvar){
        estado = estadoSalvar;
    }
    
    public PropostaEstado getEstadoSalvo(){
        return estado;
    }
    
    public String toString(){
        return estado.getEstado();
    }
}

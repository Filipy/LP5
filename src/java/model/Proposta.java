/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author Luiz myguel
 */
public class Proposta extends java.util.Observable{
    private String tituloAtividade;
    private String finalidadeAtividade;
    private String cargaHoraria;
    private String nomeEstado;
    private PropostaEstado estado;

    public Proposta() {
    }
    
   
    public Proposta(String tituloAtividade, String finalidadeAtividade, String cargaHoraria, String nomeEstado) {
        this.tituloAtividade = tituloAtividade;
        this.finalidadeAtividade = finalidadeAtividade;
        this.cargaHoraria = cargaHoraria;
        this.nomeEstado = nomeEstado;
        this.estado = montarEstado();
    }

    public PropostaEstado getEstado() {
        return estado;
    }

    public void setEstado(PropostaEstado estado) {
        this.estado = estado;
    }

    public String getTituloAtividade() {
        return tituloAtividade;
    }

    public void setTituloAtividade(String tituloAtividade) {
        this.tituloAtividade = tituloAtividade;
        
    }

    public String getFinalidadeAtividade() {
        return finalidadeAtividade;
    }

    public void setFinalidadeAtividade(String finalidadeAtividade) {
        this.finalidadeAtividade = finalidadeAtividade;
        setChanged();
        notifyObservers();
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
    
    private PropostaEstado montarEstado(){
     if(this.nomeEstado.equals("EmAnalise")){
        return new PropostaEstadoEmAnalise();
     }else if(this.nomeEstado.equals("Cancelado")){
        return new PropostaEstadoCancelado();
     }
     else if(this.nomeEstado.equals("Reprovado")){
        return new PropostaEstadoReprovado();
     }
     else if(this.nomeEstado.equals("Aprovado")){
        return new PropostaEstadoAprovado();
     }
     return new PropostaEstadoConcluido();
    }
    
    
    public PropostaMemento saveMemento(){
        return new PropostaMemento(estado);
    }
    
    public void restoreFromMemento(PropostaMemento memento){
        estado = memento.getEstadoSalvo();
    }
}

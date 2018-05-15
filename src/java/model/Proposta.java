/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import persistence.PropostaMementoDAO;

/**
 *
 * @author Luiz myguel
 */
public class Proposta extends java.util.Observable{
    private int id;
    private String tituloAtividade;
    private String finalidadeAtividade;
    private String cargaHoraria;
    private String nomeEstado;
    private PropostaEstado estado;

    public Proposta() {
    }
    
    
   
    public Proposta(int id, String tituloAtividade, String finalidadeAtividade, String cargaHoraria, String nomeEstado) {
        this.id = id;
        this.tituloAtividade = tituloAtividade;
        this.finalidadeAtividade = finalidadeAtividade;
        this.cargaHoraria = cargaHoraria;
        this.nomeEstado = nomeEstado;
        this.estado = montarEstado();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
     if(this.nomeEstado.equals("Em Analise")){
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
    
    public void PersistirAlteracaoSituacao() throws SQLException, ClassNotFoundException{
        this.setNomeEstado(this.estado.getEstado());
        if(PropostaMementoDAO.getInstance().get(this)!=null){
                PropostaMementoDAO.getInstance().update(this);
            }else{
                PropostaMementoDAO.getInstance().save(this);
            }
    }  
}

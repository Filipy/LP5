/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Math
 */
public class Evento extends java.util.Observable {
    
    int id;
    String palestrante;
    String titulo;
    String quantAlunos;
    DivulgacaoEvento evento;
    int id_palestrante;
    Pessoa palestrante_Evento;
    String tipoEvento;

    public Evento() {
    }

    public Evento(int id, String palestrante, String titulo, String quantAlunos, int id_palestrante, String tipoEvento) {
        this.id = id;
        this.palestrante = palestrante;
        this.titulo = titulo;
        this.quantAlunos = quantAlunos;
        this.id_palestrante = id_palestrante;
        this.tipoEvento = tipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Pessoa getPalestrante_Evento() {
        return palestrante_Evento;
    }

    public void setPalestrante_Evento(Pessoa palestrante_Evento) {
        this.palestrante_Evento = palestrante_Evento;
    }

    public int getId_palestrante() {
        return id_palestrante;
    }

    public void setId_palestrante(int id_palestrante) {
        this.id_palestrante = id_palestrante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getQuantAlunos() {
        return quantAlunos;
    }

    public void setQuantAlunos(String quantAlunos) {
        this.quantAlunos = quantAlunos;
        setChanged();
        super.notifyObservers();
    }

    public DivulgacaoEvento getEvento() {
        return evento;
    }

    public void setEvento(DivulgacaoEvento evento) {
        this.evento = evento;
    }
    @Override
    public boolean hasChanged() {
        return true; //super.hasChanged();
    }
}

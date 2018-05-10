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
public class Evento {
    
    int id;
    String palestrante;
    String titulo;
    String quantAlunos;
    DivulgacaoEvento evento;

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
    }

    public DivulgacaoEvento getEvento() {
        return evento;
    }

    public void setEvento(DivulgacaoEvento evento) {
        this.evento = evento;
    }
    
}

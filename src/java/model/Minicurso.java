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
public class Minicurso extends Evento{

    public Minicurso(int id, String palestrante, String titulo, String quantAlunos, int id_palestrante, String tipoEvento) {
        super(id, palestrante, titulo, quantAlunos, id_palestrante, tipoEvento);
        titulo = "Minicurso";
        evento = new EventoPequeno();
    }  
}

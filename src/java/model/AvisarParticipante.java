/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Luiz myguel
 */
public class AvisarParticipante {
    private static AvisarParticipante avisarParticipante = new AvisarParticipante();
    
    private static ArrayList<String> avisos = new ArrayList<String>();
    
    private AvisarParticipante() {
    }
  
    public static AvisarParticipante getInstance() {
        return avisarParticipante;
    }
    public ArrayList<String> getAvisos() {
        return avisos;
    }
     public void addAviso(String aviso) {
        avisos.add(aviso);
    }
    
    
}

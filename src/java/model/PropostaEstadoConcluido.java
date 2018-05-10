/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import model.Proposta;
/**
 *
 * @author Aluno
 */
public class PropostaEstadoConcluido implements PropostaEstado {

    @Override
    public String getEstado() {
        return "Concluido";
    }

    @Override
    public String emAnalise(Proposta a) {
        return "Proposta não pode ser analisada se ja for concluida";
    }

    @Override
    public String aprovada(Proposta a) {
        return "Proposta não pode ser aprovada se ja for concluida";
    }

    @Override
    public String cancelada(Proposta a) {
        return "Proposta não pode ser cancelada se ja for concluida";
    }

    @Override
    public String reprovada(Proposta a) {
       return "Proposta não pode ser reprovada se ja for concluida";
    }

    @Override
    public String concluida(Proposta a) {
        return "Proposta não pode ser concluida se ja for concluida";
    }
    
}

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
public class PropostaEstadoReprovado implements PropostaEstado {

    @Override
    public String getEstado() {
        return "Reprovado";
    }

    @Override
    public String emAnalise(Proposta a) {
        return "Proposta nao pode ser analisada se ja for reprovada";
    }

    @Override
    public String aprovada(Proposta a) {
        return "Proposta nao pode ser aprovada se ja for reprovada";
    }

    @Override
    public String cancelada(Proposta a) {
        return "Proposta nao pode ser cancelada se ja for reprovada";
    }

    @Override
    public String reprovada(Proposta a) {
        return "Proposta nao pode ser reprovada se ja for reprovada";
    }

    @Override
    public String concluida(Proposta a) {
        return "Proposta nao pode ser concluida se ja for reprovada";
    }
    
}

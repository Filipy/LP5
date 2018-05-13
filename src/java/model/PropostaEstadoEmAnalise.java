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
public class PropostaEstadoEmAnalise implements PropostaEstado{

    @Override
    public String getEstado() {
        return "Em analise";
    }

    @Override
    public String emAnalise(Proposta a) {
        return "Proposta nao pode ser analisada se ja for analisada";
    }

    @Override
    public String aprovada(Proposta a) {
        a.setEstado(new PropostaEstadoAprovado());
        return "Proposta pode ser aprovada";
    }

    @Override
    public String cancelada(Proposta a) {
        return "Proposta nao pode ser cancelada se ja for analisada";
    }

    @Override
    public String reprovada(Proposta a) {
        a.setEstado(new PropostaEstadoReprovado());
        return "Proposta pode ser reprovada";
    }

    @Override
    public String concluida(Proposta a) {
        return "Proposta nao pode ser concluida se for analisada";
    }
    
}

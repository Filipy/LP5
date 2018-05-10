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
public class PropostaEstadoAprovado implements PropostaEstado {

    @Override
    public String getEstado() {
        return "Aprovado";
    }

    @Override
    public String aprovada(Proposta proposta) {
        return "Proposta não pode ser aprovada se ja for aprovada";
    }

    @Override
    public String cancelada(Proposta proposta) {
        proposta.setEstado(new PropostaEstadoCancelado());
        return "Proposta pode ser cancelada se ja for aprovada";
    }

    @Override
    public String reprovada(Proposta proposta) {
        return "Proposta não pode ser reprovada se ja for aprovada";
    }

    @Override
    public String concluida(Proposta proposta) {
        proposta.setEstado(new PropostaEstadoConcluido());
        return "Proposta pode ser concluida se ja for aprovada";
    }

    @Override
    public String emAnalise(Proposta proposta) {
        return "Proposta não pode ser analisada se ja for aprovada";
    }
    
}

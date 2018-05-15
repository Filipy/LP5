/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        return "Proposta nao pode ser aprovada se ja for aprovada";
    }

    @Override
    public String cancelada(Proposta proposta) {
        proposta.setEstado(new PropostaEstadoCancelado());
        try {
            proposta.PersistirAlteracaoSituacao();
        } catch (SQLException ex) {
            Logger.getLogger(PropostaEstadoAprovado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropostaEstadoAprovado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Proposta foi cancelada.";
    }

    @Override
    public String reprovada(Proposta proposta) {
        return "Proposta nao pode ser reprovada se ja for aprovada";
    }

    @Override
    public String concluida(Proposta proposta) {
        proposta.setEstado(new PropostaEstadoConcluido());
        try {
            proposta.PersistirAlteracaoSituacao();
        } catch (SQLException ex) {
            Logger.getLogger(PropostaEstadoAprovado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PropostaEstadoAprovado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Proposta foi concluida.";
    }

    @Override
    public String emAnalise(Proposta proposta) {
        return "Proposta nao pode ser analisada se ja for aprovada";
    }
    
}

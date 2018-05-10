/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Luiz myguel
 */
public class PessoaAluno extends Pessoa implements Observer {

    Observable propostaInteresse;
    @Override
    public String getDescricaTipo() {
        return "Aluno";
    }

    public PessoaAluno(String nome, String email, String tipoUsuario) {
        super(nome, email, tipoUsuario);
        this.acesso = "Matricula";
    }

    public PessoaAluno() {
        this.acesso = "Matricula";
    }
    
    public PessoaAluno(Observable propostaInteresse) {
        this.propostaInteresse = propostaInteresse;
        this.propostaInteresse.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Proposta) {
            Proposta proposta = (Proposta) o;
            AvisarParticipante.getInstance().addAviso(getNome() +", foi avisado que " + proposta.getTituloAtividade()+ " teve sua finalidade alterada para: " + proposta.getFinalidadeAtividade());
        }
    }
    
}

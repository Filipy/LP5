/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luiz myguel
 */
public class PessoaDiretor extends Pessoa {
    
    @Override
    public String getDescricaTipo() {
        return "Diretor";
    }

    public PessoaDiretor() {
        this.acesso = "Workshop";
    }

    public PessoaDiretor(int id, String nome, String email, String tipoUsuario) {
        super(id, nome, email, tipoUsuario);
        this.acesso = "Workshop";
    }
    
    
}

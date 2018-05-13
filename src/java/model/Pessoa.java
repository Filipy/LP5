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
public abstract class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String tipoUsuario;
    protected Pessoa pessoaComAcessoSuperior;
    
    protected String acesso; 
    
    public Pessoa() {
    }

    public Pessoa(int id, String nome, String email, String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Pessoa getPessoaComAcessoSuperior() {
        return pessoaComAcessoSuperior;
    }

    public void setPessoaComAcessoSuperior(Pessoa pessoaComAcessoSuperior) {
        this.pessoaComAcessoSuperior = pessoaComAcessoSuperior;
    }
    
    public abstract String getDescricaTipo();
    
     public String getDados(){
        return getDescricaTipo() + ": " + " - Nome: " + getNome() + " Email:" +  getEmail();
    }
     
     public String verificarAcesso(String acessoProposto) {
        if (this.acesso.equals(acessoProposto)) {
            return "Apenas usuarios do tipo: " + getDescricaTipo() + " tem acesso a: " + acessoProposto;
        } else {
            if (pessoaComAcessoSuperior != null) {
                return pessoaComAcessoSuperior.verificarAcesso(acessoProposto);
            } else {
                return "Sem acesso";
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

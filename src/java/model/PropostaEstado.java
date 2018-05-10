/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.Proposta;
/**
 *
 * @author Math
 */
public interface PropostaEstado {
    public String getEstado();
    public String emAnalise(Proposta proposta);
    public String aprovada(Proposta proposta);
    public String reprovada(Proposta proposta);
    public String cancelada(Proposta proposta);
    public String concluida(Proposta proposta);
}

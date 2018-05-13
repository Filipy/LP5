/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Proposta;

/**
 *
 * @author Luiz myguel
 */
public class PropostaDAO {
    
    private static PropostaDAO instance = new PropostaDAO();

    public static PropostaDAO getInstance() {
        return instance;
    }

    private PropostaDAO() {
    }
    
    public void save(Proposta proposta) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO PROPOSTA (id, tituloAtividade, finalidadeAtividade, cargaHoraria, nomeEstado) "
                    + "VALUES ('" + proposta.getId() + "', '" +  proposta.getTituloAtividade()+ "', '" + proposta.getFinalidadeAtividade()+ "', '" + proposta.getCargaHoraria()+ "', '" + proposta.getNomeEstado() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void delete(Proposta proposta) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM proposta WHERE id = " + proposta.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public Proposta get(Proposta proposta) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Proposta propostaResult = new Proposta();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM proposta AS c WHERE c.id = '" + proposta.getId()+ "'");
            while (rs.next()) {              
                propostaResult = new Proposta(rs.getInt("id"), rs.getString("tituloAtividade"), rs.getString("finalidadeAtividade"), rs.getString("cargaHoraria"), rs.getString("nomeEstado"));
            }
            return propostaResult;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }
    
    
    public ArrayList<Proposta> getALL() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Proposta> propostasResponse = new ArrayList<Proposta>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM proposta");
            while (rs.next()) {   
                Proposta propostaResult = new Proposta(rs.getInt("id"), rs.getString("tituloAtividade"), rs.getString("finalidadeAtividade"), rs.getString("cargaHoraria"), rs.getString("nomeEstado"));
                propostasResponse.add(propostaResult);
            }
            return propostasResponse;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void closeResourcer(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }
    
}

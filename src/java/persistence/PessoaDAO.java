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
import model.Pessoa;
import model.PessoaAluno;
import model.PessoaDiretor;
import model.PessoaProfessor;

/**
 *
 * @author Luiz myguel
 */
public class PessoaDAO {
    
    
    private static PessoaDAO instance = new PessoaDAO();

    public static PessoaDAO getInstance() {
        return instance;
    }

    private PessoaDAO() {
    }
    
    public void save(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO PESSOA (id, nome, email, tipoUsuario) "
                    + "VALUES ('" + pessoa.getId() + "', '" + pessoa.getNome() + "', '" + pessoa.getEmail() + "', '" + pessoa.getTipoUsuario() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void delete(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM pessoa WHERE id = " + pessoa.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public Pessoa get(String id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Pessoa pessoaResult = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pessoa AS c WHERE c.id = '" + id + "'");
            while (rs.next()) {
                if(rs.getString("tipoUsuario").equals("Aluno")){
                    pessoaResult = new PessoaAluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("tipoUsuario"));
                }
                if(rs.getString("tipoUsuario").equals("Professor")){
                    pessoaResult = new PessoaProfessor(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("tipoUsuario"));
                }
                if(rs.getString("tipoUsuario").equals("Diretor")){
                    pessoaResult = new PessoaDiretor(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("tipoUsuario"));
                }
            }
            return pessoaResult;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }
    
    
    public ArrayList<Pessoa> getALL() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Pessoa> pessoasResponse = new ArrayList<Pessoa>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pessoa");
            while (rs.next()) {  
                Pessoa eee = new PessoaAluno(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("tipoUsuario"));
                pessoasResponse.add(eee);
            }
            return pessoasResponse;
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

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
import model.Evento;
import model.Minicurso;
import model.Palestra;
import model.Pessoa;
import model.PessoaAluno;
import model.PessoaDiretor;
import model.PessoaProfessor;
import model.Workshop;

/**
 *
 * @author Luiz myguel
 */
public class EventoDAO {
    private static EventoDAO instance = new EventoDAO();

    public static EventoDAO getInstance() {
        return instance;
    }

    private EventoDAO() {
    }
    
    public void save(Evento evento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO evento (id, palestrante, titulo, quantAlunos, id_palestrante, tipoEvento) "
                    + "VALUES (" + evento.getId() + ",'" + evento.getPalestrante()+ "', '" + evento.getTitulo()+ "', '" + evento.getQuantAlunos()+ "'," + evento.getId_palestrante() + ",'" + evento.getTipoEvento()+ "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }
    
    public Evento get(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Evento eventoResult = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM evento AS c WHERE c.id = " + id + "");
            while (rs.next()) {   
                
                 if (rs.getString("tipoEvento").equals("Minicurso")) {
                    eventoResult = new Minicurso(rs.getInt("id"), rs.getString("palestrante"), rs.getString("titulo"), rs.getString("quantAlunos"), rs.getInt("id_palestrante"), rs.getString("tipoEvento"));
                } else if (rs.getString("tipoEvento").equals("Workshop")) {
                    eventoResult = new Workshop(rs.getInt("id"), rs.getString("palestrante"), rs.getString("titulo"), rs.getString("quantAlunos"), rs.getInt("id_palestrante"), rs.getString("tipoEvento"));
                } else {
                    eventoResult = new Palestra(rs.getInt("id"), rs.getString("palestrante"), rs.getString("titulo"), rs.getString("quantAlunos"), rs.getInt("id_palestrante"), rs.getString("tipoEvento"));
                }
            }
            return eventoResult;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }
    
    
    public ArrayList<Evento> getALL() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Evento> eventosResponse = new ArrayList<Evento>();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM evento");
            while (rs.next()) {  
                Evento evento = new Evento(rs.getInt("id"), rs.getString("palestrante"), rs.getString("titulo"), rs.getString("quantAlunos"), rs.getInt("id_palestrante"), rs.getString("tipoEvento"));
                eventosResponse.add(evento);
            }
            return eventosResponse;
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

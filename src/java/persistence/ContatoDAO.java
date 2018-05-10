package persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Contato;

public class ContatoDAO {

    private static ContatoDAO instance = new ContatoDAO();

    public static ContatoDAO getInstance() {
        return instance;
    }

    private ContatoDAO() {
    }

    public void save(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO CONTATO (nome, email) "
                    + "VALUES ('" + contato.getNome() + "', '" + contato.getEmail() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public void delete(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM contato WHERE id = " + contato.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResourcer(conn, st);
        }
    }

    public Contato get(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Contato contatoResult = new Contato();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            if (!st.execute("SELECT * FROM contato AS c WHERE c.id = " + contato.getId())) {
                //lançar erro
            }

            ResultSet rs = st.executeQuery("SELECT * FROM contato AS c WHERE c.id = " + contato.getId());
            while (rs.next()) {
                contatoResult.setId(rs.getInt("c.id"));
                contatoResult.setNome(rs.getString("c.nome"));
                contatoResult.setEmail(rs.getString("c.email"));
            }

            return contatoResult;
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

package DAO;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class MusicaDao {

    public void carregarMusicas(JTable tabela) {
        String sql = "SELECT * FROM alb_musicas";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código");
            modelo.addColumn("Nome da Música");
            modelo.addColumn("Artista");
            modelo.addColumn("Gênero");

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("cod_musica"),
                    rs.getString("nome_musica"),
                    rs.getString("artista"),
                    rs.getString("genero")
                });
            }

            tabela.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao carregar músicas.");
        }
    }
}

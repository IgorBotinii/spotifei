package DAO;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MusicaDao {

    public void carregarMusicas(JTable tabela) {
        String sql = "SELECT * FROM cd_musicas";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código");
            modelo.addColumn("Nome da Música");
            modelo.addColumn("Artista");
            modelo.addColumn("Gênero");
            modelo.addColumn("Tempo");
            modelo.addColumn("Data");

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("cod_musica"),
                    rs.getString("nome_musica"),
                    rs.getString("artista"),
                    rs.getString("genero"),
                    rs.getString("tempo_total_musica"),
                    rs.getDate("data_lancamento").toString()
                });
            }

            tabela.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao carregar músicas.");
        }
    }

    // Filtrando
    public void filtrarMusicas(JTable tabela, String nome, String artista, String genero) {
        String sql = "SELECT * FROM cd_musicas " +
                     "WHERE nome_musica ILIKE ? AND artista ILIKE ? AND genero ILIKE ?";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + artista + "%");
            stmt.setString(3, "%" + genero + "%");

            ResultSet rs = stmt.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Código");
            modelo.addColumn("Nome da Música");
            modelo.addColumn("Artista");
            modelo.addColumn("Gênero");
            modelo.addColumn("Tempo");
            modelo.addColumn("Data");

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("cod_musica"),
                    rs.getString("nome_musica"),
                    rs.getString("artista"),
                    rs.getString("genero"),
                    rs.getString("tempo_total_musica"),
                    rs.getDate("data_lancamento").toString()
                });
            }

            tabela.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

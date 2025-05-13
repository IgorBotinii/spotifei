package DAO;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaPlaylist {

    public void CarregarListaPlaylists(JTable tabela) {
        String sql = "SELECT * FROM playlists";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("nome");


            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("nome")
                });
            }
            tabela.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao carregar músicas.");
        }
    }
}

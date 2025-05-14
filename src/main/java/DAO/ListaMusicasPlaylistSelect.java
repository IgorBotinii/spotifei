/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author igorb
 */
public class ListaMusicasPlaylistSelect {
    
    public void CarregarMusicasPlaylistSelect(JTable tabela, String nomePlaylist){
    String sql = "SELECT nome_musica FROM playlist_musicas WHERE nome_playlist = ?";

    try (Connection conn = ConectarDB.conectar()) {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomePlaylist);
        ResultSet rs = stmt.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nome_musica");

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getString("nome_musica")
            });
        }

        tabela.setModel(modelo);

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao carregar músicas.");
    }

    }
}

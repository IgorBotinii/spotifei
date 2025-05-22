/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Playlist;


public class ExcluirPlaylist {
    
public void DeletarPlayList(Playlist pllgerais) {
    String deletarMusicas = "DELETE FROM playlist_musicas WHERE nome_playlist = ?";
    String deletarPlaylist = "DELETE FROM playlists WHERE nome = ?";

    try (Connection conn = ConectarDB.conectar()) {

        try (PreparedStatement stmtMusicas = conn.prepareStatement(deletarMusicas)) {
            stmtMusicas.setString(1, pllgerais.getNome());
            stmtMusicas.executeUpdate();
        }

        try (PreparedStatement stmtPlaylist = conn.prepareStatement(deletarPlaylist)) {
            stmtPlaylist.setString(1, pllgerais.getNome());
            stmtPlaylist.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "Playlist Excluida com Sucesso!");

    } catch (SQLException e) {
        System.err.println("Erro ao excluir playlist:");
        e.printStackTrace();
    }
}


}

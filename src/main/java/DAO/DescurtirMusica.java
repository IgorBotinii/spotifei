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
import model.LkMusic;


public class DescurtirMusica {
    
    public void descurtirMusicaCL(LkMusic musicaCurtida) {
    String sql = "DELETE FROM cd_musicas_curtidas WHERE nome_musica = ? AND artista = ?";

        try (Connection conn = ConectarDB.conectar();
         PreparedStatement insertStmt = conn.prepareStatement(sql)) {

        insertStmt.setString(1, musicaCurtida.getNomeMusica());
        insertStmt.setString(2, musicaCurtida.getNomeArtista());

        int rowsAffected = insertStmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Musica descurtida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma musica encontrada para descurtir.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao descurtir música:");
        e.printStackTrace();
    }
}

}

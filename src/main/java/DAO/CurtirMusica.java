package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.LkMusic;
import javax.swing.JOptionPane;

public class CurtirMusica {

    public void curtirMusicaSave(LkMusic musicaCurtida) {
        String verificaSql = "SELECT 1 FROM cd_musicas_curtidas WHERE nome_musica = ? AND artista = ?";
        String insertSql = "INSERT INTO cd_musicas_curtidas (nome_musica, artista, genero, tempo_total_musica, data_lancamento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement verificaStmt = conn.prepareStatement(verificaSql)) {

            verificaStmt.setString(1, musicaCurtida.getNomeMusica());
            verificaStmt.setString(2, musicaCurtida.getNomeArtista());
            ResultSet rs = verificaStmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Esta musica já foi curtida!");
                return;
            }


            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, musicaCurtida.getNomeMusica());
                insertStmt.setString(2, musicaCurtida.getNomeArtista());
                insertStmt.setString(3, musicaCurtida.getGenero());
                insertStmt.setString(4, musicaCurtida.getTempoTotMusica());
                insertStmt.setString(5, musicaCurtida.getDtLancamento());

                insertStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Musica curtida com sucesso!");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao curtir Musica:");
            e.printStackTrace();
        }
    }
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddNovMusicPlaylistSelect {

    public void adicionarMusicaNaPlaylist(String nomePlaylist, String nomeMusica) {
        String sql = "INSERT INTO playlist_musicas (nome_playlist, nome_musica) VALUES (?, ?)";

        try (Connection conn = ConectarDB.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomePlaylist);
            stmt.setString(2, nomeMusica);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Musica adicionada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao adicionar música na playlist.");
        }
    }
}

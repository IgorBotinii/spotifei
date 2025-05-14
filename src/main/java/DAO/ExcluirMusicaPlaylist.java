package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ExcluirMusicaPlaylist {

    public void ExcluirMscPll(String nomePlaylist, String nomeMusica) {
        String sql = "DELETE FROM playlist_musicas WHERE nome_musica = ? AND nome_playlist = ?";

        try (Connection conn = ConectarDB.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeMusica); 
            stmt.setString(2, nomePlaylist);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Musica removida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao remover música da playlist.");
        }
    }
}

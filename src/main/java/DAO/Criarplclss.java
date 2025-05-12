package DAO;
import DAO.ConectarDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Playlist;

public class Criarplclss {
     public void inserirPlaylist(Playlist playlist) {
        String sql = "INSERT INTO playlists (nome) VALUES (?)";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, playlist.getNome());

        stmt.executeUpdate();   
        System.out.println("Usuário inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário:");
            e.printStackTrace();
        }
    }
}

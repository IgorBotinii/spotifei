/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author igorb
 */

public class PlaylistMusicaDAO {

    public void adicionarMusica(PlaylistMusica musica) {
        String sql = "INSERT INTO playlist_musicas (playlist_id, nome_musica, artista, genero, tempo, data_lancamento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, musica.getPlaylistId());
            stmt.setString(2, musica.getNomeMusica());
            stmt.setString(3, musica.getArtista());
            stmt.setString(4, musica.getGenero());
            stmt.setString(5, musica.getTempo());
            stmt.setString(6, musica.getDataLancamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PlaylistMusica> listarMusicas(int playlistId) {
        List<PlaylistMusica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM playlist_musicas WHERE playlist_id = ?";
        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PlaylistMusica musica = new PlaylistMusica();
                musica.setId(rs.getInt("id"));
                musica.setPlaylistId(rs.getInt("playlist_id"));
                musica.setNomeMusica(rs.getString("nome_musica"));
                musica.setArtista(rs.getString("artista"));
                musica.setGenero(rs.getString("genero"));
                musica.setTempo(rs.getString("tempo"));
                musica.setDataLancamento(rs.getString("data_lancamento"));
                musicas.add(musica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicas;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author igorb
 */
public class PlaylistMusica {
    private int id;
    private int playlistId;
    private String nomeMusica;
    private String artista;
    private String genero;
    private String tempo;
    private String dataLancamento;

    // Construtores
    public PlaylistMusica() {}

    public PlaylistMusica(int id, int playlistId, String nomeMusica, String artista, String genero, String tempo, String dataLancamento) {
        this.id = id;
        this.playlistId = playlistId;
        this.nomeMusica = nomeMusica;
        this.artista = artista;
        this.genero = genero;
        this.tempo = tempo;
        this.dataLancamento = dataLancamento;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}


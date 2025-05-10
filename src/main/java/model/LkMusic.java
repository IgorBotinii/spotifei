package model;

public class LkMusic {
    private String NomeMusica;
    private String Artista;
    private String Genero;
    private String dtlancamento;
    private String tempototmusica;

    public LkMusic(String NomeMusica, String Artista, String Genero, String dtlancamento, String tempototmusica) {
        this.NomeMusica = NomeMusica;
        this.Artista = Artista;
        this.Genero = Genero;
        this.dtlancamento = dtlancamento;
        this.tempototmusica = tempototmusica;
    }

    public String getNomeMusica() {
        return NomeMusica;
    }

    public String getNomeArtista() {
        return Artista;
    }

    public String getGenero() {
        return Genero;
    }
    public String getDtLancamento() {
        return dtlancamento;
    }
    public String getTempoTotMusica() {
        return tempototmusica;
    }
    
    public void setNomeMusica(String nomeMusica){
    this.NomeMusica = nomeMusica;
    }
    
    public void setArtista(String artista){
    this.Artista = artista;
    }
    
    
    
}

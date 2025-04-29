package model;

public class Usuario {
    private String nomeUsuario;
    private String senhaUsuario;
    private String nomeCompleto;

    public Usuario(String nomeUsuario, String senhaUsuario, String nomeCompleto) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
}

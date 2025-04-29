package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;

public class CadNovoUser {

    public void inserirUsuario(Usuario user) {
        String sql = "INSERT INTO cd_usuarios (nome_user, senha_user, nome_comp_user) VALUES (?, ?, ?)";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getNomeUsuario());
            stmt.setString(2, user.getSenhaUsuario());
            stmt.setString(3, user.getNomeCompleto());

            stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário:");
            e.printStackTrace();
        }
    }
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirHistorico {

    public static void registrarAcao(String acao) {
        String sql = "INSERT INTO historico (data_mudanca, acao) VALUES (CURRENT_DATE, ?)";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, acao);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao registrar histórico.");
        }
    }
}

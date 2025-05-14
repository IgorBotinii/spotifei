package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CarregarHist {

    public void carregarHistorico(JTable tabela) {
        String sql = "SELECT id, data_mudanca, acao FROM historico ORDER BY data_mudanca DESC";

        try (Connection conn = ConectarDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Data");
            modelo.addColumn("Ação");

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getDate("data_mudanca"),
                    rs.getString("acao")
                });
            }

            tabela.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar histórico.");
        }
    }
}

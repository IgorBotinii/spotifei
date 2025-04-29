package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // nome do seu banco aqui
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1qaz2wsx3EDC@@!"; // coloque a senha que você definiu

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

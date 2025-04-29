package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/db_spotifei"; 
    private static final String USUARIO = "postgres";
    private static final String SENHA = "1qaz2wsx3EDC@@!";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

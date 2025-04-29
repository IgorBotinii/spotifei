import DAO.ConectarDB;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = ConectarDB.conectar()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar:");
            e.printStackTrace();
        }
    }
}

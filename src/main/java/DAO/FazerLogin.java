package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;
import java.sql.ResultSet;

/**
 *
 * @author igorb
 */
public class FazerLogin {
    
    public boolean LoginUsuario(String usuario, String senha){
    String sql = "SELECT * FROM cd_usuarios where nome_user = ? and senha_user = ? ";
    
    try(Connection conn = ConectarDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
        
        stmt.setString(1, usuario);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        return rs.next(); //Retorna um true, caso encontre o login
    } catch(SQLException e){
    e.printStackTrace();
    return false;
    }
    }
    
}

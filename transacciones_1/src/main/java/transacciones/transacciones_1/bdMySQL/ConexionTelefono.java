package transacciones.transacciones_1.bdMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author karol
 */
public class ConexionTelefono {
    public boolean agregar(Connection conexion, String numero, int idForanea) throws SQLException{
        
        try{
        
        String sql = "INSERT INTO Telefono (Numero, Cliente_ID_Cliente) "
                + "VALUES (?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, numero);
        stmt.setInt(2, idForanea);
        stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

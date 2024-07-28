package transacciones.transacciones_1.bdMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author karol
 */
public class ConexionTelefono {
    public boolean agregar(Connection conexion, String numero, int idForanea) throws SQLException{
        
        String sql = "INSERT INTO Telefono (Numero, Cliente_ID_Cliente) "
                + "VALUES (?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, numero);
        stmt.setInt(2, idForanea);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}

package transacciones.transacciones_1bdMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author karol
 */
public class ConexionCliente {
    public boolean agregar(Connection conexion, String nombre, 
            String apellido, String direccion) 
            throws SQLException{
        String sql = "INSERT INTO Cliente "
                + "(Nombre, Apellido, Direccion) "
                + "VALUES (?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, direccion);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}

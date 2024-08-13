package transacciones.transacciones_1.bdMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author karol
 */
public class Conexion {
    private static Connection conexion;
    
    public Connection obtenerConexion(String aislamiento) {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/transacciones_1?serverTimezone=UTC", "root","Bromi.22AY04");
                System.out.println("Conexión establecida correctamente.");
                if (aislamiento == "Lecturas No Comprometidas") {
                    conexion.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                } else if (aislamiento == "Lecturas Comprometidas") {
                    conexion.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                } else if (aislamiento == "Lecturas Repetibles") {
                    conexion.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                } else if (aislamiento == "Serializable") {
                    conexion.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                }
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

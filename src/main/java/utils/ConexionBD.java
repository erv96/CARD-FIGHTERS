package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que nos permitirá conectarnos a nuestra BBDD, en ella definimos nuestro
 * número o nombre de host y referenciamos el nombre de la conexión, el usuario,
 * y la contraseña de acceso
 * 
 * @author toled
 *
 */

public abstract class ConexionBD {
	/**
	 * Ruta del host donde se encuentra nuestra BBDD creada con la información
	 */
	private final static String cadenaConexion = "jdbc:mysql://localhost/card_fighters";
	/**
	 * Usuario con acceso a la BBDD
	 */
	private final static String usuarioBD = "root";
	/**
	 * Conraseña de acceso a la BBDD
	 */
	private final static String passwordBD = "123Koalaenfermo";
	/**
	 * Variable Connection que nos permite heredear los métodos necesarios para
	 * operar la BBDD
	 */
	private static Connection conexion; // singleton

	/**
	 * Método conectar en el que se introducen los datos mencionados anteriormente
	 * para una correcta conexión a la BBDD.
	 * 
	 * @return devuelve un Statement con el que nos conectaremos a la BBDD.
	 */
	public static Statement conectar() {
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Método para cerrar la conexión de la BBDD cuando hayamos acabado de operar
	 * con ella.
	 */
	public static void desconectar() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

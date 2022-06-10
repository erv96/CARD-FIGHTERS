package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que nos permitir� conectarnos a nuestra BBDD, en ella definimos nuestro
 * n�mero o nombre de host y referenciamos el nombre de la conexi�n, el usuario,
 * y la contrase�a de acceso
 * 
 * @author toled
 *
 */

public abstract class ConexionBD {
	/**
	 * Ruta del host donde se encuentra nuestra BBDD creada con la informaci�n
	 */
	private final static String cadenaConexion = "jdbc:mysql://localhost/card_fighters";
	/**
	 * Usuario con acceso a la BBDD
	 */
	private final static String usuarioBD = "root";
	/**
	 * Conrase�a de acceso a la BBDD
	 */
	private final static String passwordBD = "123Koalaenfermo";
	/**
	 * Variable Connection que nos permite heredear los m�todos necesarios para
	 * operar la BBDD
	 */
	private static Connection conexion; // singleton

	/**
	 * M�todo conectar en el que se introducen los datos mencionados anteriormente
	 * para una correcta conexi�n a la BBDD.
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
	 * M�todo para cerrar la conexi�n de la BBDD cuando hayamos acabado de operar
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

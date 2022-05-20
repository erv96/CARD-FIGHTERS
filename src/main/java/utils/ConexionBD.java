package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConexionBD {
	private final static String cadenaConexion = "jdbc:mysql://localhost/card_fighters"; 
	private final static String usuarioBD = "root";
	private final static String passwordBD = "123Koalaenfermo";
	private static Connection conexion; // singleton

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

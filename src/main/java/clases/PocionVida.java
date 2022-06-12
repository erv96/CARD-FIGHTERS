package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

/**
 * Clase que definir� los atributos y caracter�sticas de la poci�n de vida.
 * 
 * @author toled
 *
 */
public class PocionVida extends Consumible {
	/**
	 * aumentoVida: n�mero que se le sumar� a la vida del jugador al recoger la
	 * poci�n.
	 */
	private byte aumentoVida;

	/**
	 * En este constructor mediante una consulta a nuestra BBDD recoger�mos la
	 * descripci�n del objeto y el n�mero que se le sumar� a la vida del jugador.
	 */
	public PocionVida() {

		Statement smt = ConexionBD.conectar();

		try {
			ResultSet cursor = smt.executeQuery("Select * from consumible WHERE nombre= 'PocionVida'");
			if (cursor.next()) {
				this.aumentoVida = cursor.getByte("aumentoVida");
				String descripcion = cursor.getString("descripcion");
				setDesripcion(descripcion);
			}
		} catch (SQLException e) {
			ConexionBD.desconectar();
			e.printStackTrace();
		}

		ConexionBD.desconectar();

	}

}

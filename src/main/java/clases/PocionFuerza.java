package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

/**
 * Clase que definir� los atributos y caracter�sticas de la poci�n de fuerza.
 * 
 * @author toled
 *
 */
public class PocionFuerza extends Consumible {
	/**
	 * aumentoFuerza este n�mero ser� sumado al ataque de la siguiente carta que use
	 * el jugador.
	 */
	private byte aumentoFuerza;

	/**
	 * En este constructor mediante una consulta a nuestra BBDD recoger�mos la
	 * descripci�n del objeto y el n�mero en el que aumenta la fuerza de la
	 * siguiente carta del jugador
	 */
	public PocionFuerza() {

		Statement smt = ConexionBD.conectar();

		try {
			ResultSet cursor = smt.executeQuery("Select * from consumible WHERE nombre= 'PocionAtaque'");
			if (cursor.next()) {
				this.aumentoFuerza = cursor.getByte("aumentoAtaque");
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

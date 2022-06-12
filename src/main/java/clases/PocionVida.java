package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

/**
 * Clase que definirá los atributos y características de la poción de vida.
 * 
 * @author toled
 *
 */
public class PocionVida extends Consumible {
	/**
	 * aumentoVida: número que se le sumará a la vida del jugador al recoger la
	 * poción.
	 */
	private byte aumentoVida;

	/**
	 * En este constructor mediante una consulta a nuestra BBDD recogerémos la
	 * descripción del objeto y el número que se le sumará a la vida del jugador.
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

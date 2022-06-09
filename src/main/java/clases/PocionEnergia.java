package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

/**
 * Clase que definirá los atributos y características de la poción de energía
 * 
 * @author toled
 *
 */
public class PocionEnergia extends Consumible {
	/**
	 * aumentoEnergia: número que aumenta la energía del jugador al recogerla
	 */
	private byte aumentoEnergia;

	/**
	 * En este constructor mediante una consulta a nuestra BBDD recogerémos la
	 * descripción del objeto y el número que se le sumará a la energía del jugador
	 */
	public PocionEnergia() {

		Statement smt = ConexionBD.conectar();

		try {
			ResultSet cursor = smt.executeQuery("Select * from consumible WHERE nombre= 'PocionEnergia'");
			if (cursor.next()) {
				this.aumentoEnergia = cursor.getByte("aumentoEnergia");
				String descripcion = cursor.getString("descripcion");
				setDesripcion(descripcion);
			}
		} catch (SQLException e) {
			ConexionBD.desconectar();
			e.printStackTrace();
		}

		ConexionBD.desconectar();

	}

	public byte getAumentoEnergia() {
		return aumentoEnergia;
	}

	public void setAumentoEnergia(byte aumentoEnergia) {
		this.aumentoEnergia = aumentoEnergia;
	}

	@Override
	public String toString() {
		return "PocionEnergia [aumentoEnergia=" + aumentoEnergia + ", getDescripcion()=" + getDescripcion() + "]";
	}
}

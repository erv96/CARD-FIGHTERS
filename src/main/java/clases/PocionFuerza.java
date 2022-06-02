package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class PocionFuerza extends Consumible {
	private byte aumentoFuerza;

	public PocionFuerza(String nombre, String descripcion, byte aumentoFuerza) {
		super(nombre, descripcion);
		this.aumentoFuerza = aumentoFuerza;
	}

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

	public byte getAumentoFuerza() {
		return aumentoFuerza;
	}

	public void setAumentoFuerza(byte aumentoFuerza) {
		this.aumentoFuerza = aumentoFuerza;
	}

	@Override
	public String toString() {
		return "PocionFuerza [aumentoFuerza=" + aumentoFuerza + ", getDescripcion()=" + getDescripcion() + "]";
	}

}

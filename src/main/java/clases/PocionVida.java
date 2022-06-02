package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class PocionVida extends Consumible {
	private byte aumentoVida;

	public PocionVida(String nombre, String descripcion, byte aumentoVida) {
		super(nombre, descripcion);
		this.aumentoVida = aumentoVida;
	}

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

	public byte getAumentoVida() {
		return aumentoVida;
	}

	public void setAumentoVida(byte aumentoVida) {
		this.aumentoVida = aumentoVida;
	}

	@Override
	public String toString() {
		return "PocionVida [aumentoVida=" + aumentoVida + ", getDescripcion()=" + getDescripcion() + "]";
	}
	
	
	
	

}

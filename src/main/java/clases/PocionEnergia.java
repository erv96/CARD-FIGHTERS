package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class PocionEnergia extends Consumible{
	private byte aumentoEnergia;

	public PocionEnergia(String nombre, String descripcion, byte aumentoEnergia) {
		super(nombre, descripcion);
		this.aumentoEnergia = aumentoEnergia;
	}

	public PocionEnergia() {
		
		Statement smt = ConexionBD.conectar();
		
		try {
			ResultSet cursor = smt.executeQuery("Select * from consumibles WHERE nombre= 'PocionEnergia'");
			if(cursor.next()) {
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
		return "PocionEnergia [aumentoEnergia=" + aumentoEnergia 
				+ ", getDescripcion()=" + getDescripcion() + "]";
	}
}

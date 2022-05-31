package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import exceptions.EscenarioNoExisteException;
import utils.ConexionBD;

public class CampoCombate extends ElementoNombreDescripcion {
	private byte[] tama�o;

	public CampoCombate(String nombre, String descripcion, byte[] tama�o) {
		super(nombre, descripcion);
		this.tama�o = new byte[8];
	}
	
	public CampoCombate(String nombre) {
		super(nombre);
			
			Statement smt = ConexionBD.conectar();
			
			try {
				ResultSet cursor = smt.executeQuery("Select * from escenarios WHERE nombre='"+nombre+"'");
				if(cursor.next()) {
					nombre = cursor.getString("nombre");
					String descripcion = cursor.getString("descripcion");
					setDesripcion(descripcion);
				}else {
					throw new EscenarioNoExisteException("El escenario no introducido no se encuentra en la base de datos");
				}
			} catch (SQLException | EscenarioNoExisteException e) {
				ConexionBD.desconectar();
				System.err.println(e.getMessage());
			}
			
			ConexionBD.desconectar();
			
			this.tama�o = new byte[8];
		
	}

	public byte[] getTama�o() {
		return tama�o;
	}

	public void setTama�o(byte[] tama�o) {
		this.tama�o = tama�o;
	}

	@Override
	public String toString() {
		return "Nombre =" + getNombre()
				+ ", getDescripcion()=" + getDescripcion() + "]";
	}


	
	
	
	
	
	
	
}

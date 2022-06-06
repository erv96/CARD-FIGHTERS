package clases;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import exceptions.EscenarioNoExisteException;
import utils.ConexionBD;

/**
 * Clase que define el nombre y la descripci�n de cada escenario en el que se
 * pelea.
 * 
 * @author toled
 *
 */
public class CampoCombate extends ElementoNombreDescripcion {
	private char[] tama�o;

	public CampoCombate(String nombre, String descripcion, byte[] tama�o) {
		super(nombre, descripcion);
		this.tama�o = new char[8];
	}

	public CampoCombate(String nombre) {
		super(nombre);

		this.tama�o = new char[8];

		Statement smt = ConexionBD.conectar();

		try {
			ResultSet cursor = smt.executeQuery("Select * from escenario WHERE nombre='" + nombre + "'");
			if (cursor.next()) {
				nombre = cursor.getString("nombre");
				String descripcion = cursor.getString("descripcion");
				setDesripcion(descripcion);
			} else {
				throw new EscenarioNoExisteException("El escenario introducido no se encuentra en la base de datos");
			}
		} catch (SQLException | EscenarioNoExisteException e) {
			ConexionBD.desconectar();
			System.err.println(e.getMessage());
		}

		ConexionBD.desconectar();

	}
	
	public static String[] generaMapa() {
		String[]tama�o = new String[8];
		tama�o[2] = "./icon/punch.png";
		tama�o[5] =	"./icon/punch_rival.png";
		
		
		return tama�o;
	}

	public char[] getTama�o() {
		return tama�o;
	}

	@Override
	public String toString() {
		return "Nombre =" + getNombre() + ", getDescripcion()=" + getDescripcion() + "]";
	}

}

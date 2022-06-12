package clases;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import exceptions.EscenarioNoExisteException;
import utils.ConexionBD;

/**
 * Clase que define el nombre y la descripción de cada escenario en el que se
 * pelea, la posición del jugador, del rival, y el tamaño del mapa que siempre
 * será el mismo. (ESTA CLASE SE USA EN "PantallaCombate" Y TIENE RELACIÓN CON
 * LA CLASE "Mapa" DE INTERFACES)
 * 
 * @author toled
 *
 */
public class CampoCombate extends ElementoNombreDescripcion {
	/**
	 * La variable mapa es un array de String ya que al que le pasamos la ruta de
	 * los iconos pertenecientes al jugador y al rival para que en otra clase de
	 * interfaces imprima los iconos en las posiciones correspondientes.
	 */
	private String[] mapa;
	/**
	 * posJugador es la variable que define la posición del jugador, en un principio
	 * será la posición 2 del array de String mapa.
	 */
	private byte posJugador;
	/**
	 * posRival es la variable que define la posición del rival, en un principio
	 * será la posición 5 del array de String mapa.
	 */
	private byte posRival;

	/**
	 * Este constructor de CampoCombate recibirá un nombre, dentro del constructor
	 * se hará una consulta en la BBDD para comprobar si el nombre de ese
	 * CampoCombate existe, si no existe saltará una excepción personalizada, además
	 * de todo esto, dentro de este constructor se definirán las posiciones del
	 * rival y el jugador, el tamaño del array del String y las rutas de los iconos
	 * del rival y el jugador. Además recibirá las posiciones del jugador y del
	 * rival, en este caso la única que se irá actualizando será la del jugador.
	 * 
	 * @param nombre    nombre del escenario
	 * @param posicionJ posicion del jugador
	 * @param posicionR posicion del rival
	 */

	public CampoCombate(String nombre, Byte posicionJ, Byte posicionR) {
		super(nombre);

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

		this.mapa = new String[8];
		mapa[posicionJ] = "./icon/punch.png";
		mapa[posicionR] = "./icon/punch_rival.png";

	}

	/**
	 * Método que devuelve el array de String
	 * 
	 * @return devuelve el array de String
	 */

	public String[] getMapa() {
		return mapa;
	}

}

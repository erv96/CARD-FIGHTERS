package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.PriorityQueue;

import exceptions.PersonajeNoExisteException;
import utils.ConexionBD;

/**
 * Clase en la que definiremos al objeto personaje en su totalidad, en esta
 * clase se realizan consultas de BBDD, y se le proporciona el mazo de cartas al
 * personaje
 * 
 * @author toled
 *
 */
public class Personaje extends ElementoNombreDescripcion {
	/**
	 * vida: puntos de vida del personaje(20)
	 */
	private byte vida;
	/**
	 * posicion: posicion del personaje en el mapa
	 */
	private byte posicion;
	/**
	 * baraja: ArrayList de Carta que se le proporcionar� al personaje mediante
	 * consultas a la BBDD.
	 */
	private ArrayList<Carta> baraja;
	/**
	 * energia: energia del personaje (5)
	 */
	private byte energia;

	/**
	 * Consctructor de personaje en el que se realizar�n varias consultas en la BBDD
	 * para definir la descripci�n del personaje y su baraja a�adiendo en ella qu�
	 * especiales y ultimates le pertenecen, el constructor cuenta con un par�metro
	 * nombre, que servir� para buscar en la BBDD todas las cartas pertenecientes a
	 * ese nombre, si defines un objeto Personaje con un nombre que no se encuentra
	 * en la BBDD ocurrir� una excepci�n de tipo PersonajeNoExisteException. Al
	 * final del constructor se definir� el nombre, la vida, la posici�n y la
	 * energ�a del personaje (Tanto la vida como la energ�a siempre empezar� en 20 y
	 * 5 respectivamente)
	 * 
	 * @param nombre nombre que recibe el personaje, con este par�metro se
	 *               realizar�n las consultas en la BBDD y se obtendr�n las cartas
	 *               del personaje concretado
	 */
	public Personaje(String nombre) {
		super(nombre);

		baraja = new ArrayList<Carta>();

		Statement smt = ConexionBD.conectar();

		try {

			ResultSet curPersonaje = smt.executeQuery("SELECT * FROM personaje WHERE nombre='" + nombre + "'");

			if (curPersonaje.next()) {
				Statement smt2 = ConexionBD.conectar();

				ResultSet cursor = smt2.executeQuery("select*from carta WHERE personaje = '" + nombre + "'");
				while (cursor.next()) {
					Carta barajita = new Carta(cursor.getString("nombre"), cursor.getString("descripcion"),
							cursor.getByte("puntosAtaque"), cursor.getByte("velocidad"), cursor.getByte("alcance"),
							cursor.getString("tipo"));
					baraja.add(barajita);

				}
				Statement smt3 = ConexionBD.conectar();
				ResultSet cursorDesc = smt3.executeQuery("select * from personaje WHERE nombre= '" + nombre + "'");
				if (cursorDesc.next()) {
					String descripcion = cursorDesc.getString("descripcion");
					setDesripcion(descripcion);
				}

				Statement smt4 = ConexionBD.conectar();

				ResultSet cursorUlt = smt4.executeQuery("select*from ultimate where personaje = '" + nombre + "'");
				while (cursorUlt.next()) {
					Carta ulti = new Ultimate(cursorUlt.getString("nombre"), cursorUlt.getString("descripcion"),
							cursorUlt.getByte("puntosAtaque"), cursorUlt.getByte("velocidad"),
							cursorUlt.getByte("alcance"), cursorUlt.getByte("costeEnergia"),
							cursorUlt.getByte("costeVida"), cursorUlt.getString("tipo"));
					baraja.add(ulti);
				}

				Statement smt5 = ConexionBD.conectar();

				ResultSet cursorSp = smt5.executeQuery("select*from especial where personaje = '" + nombre + "'");

				while (cursorSp.next()) {
					Carta spec = new Especial(cursorSp.getString("nombre"), cursorSp.getString("descripcion"),
							cursorSp.getByte("puntosAtaque"), cursorSp.getByte("velocidad"),
							cursorSp.getByte("alcance"), cursorSp.getByte("costeEnergia"), cursorSp.getString("tipo"));
					baraja.add(spec);
				}

			} else {
				throw new PersonajeNoExisteException("Ese personaje no se encuentra dentro del roster");
			}

		} catch (SQLException | PersonajeNoExisteException e) {
			ConexionBD.desconectar();
			System.err.println(e.getMessage());
		}

		ConexionBD.desconectar();

		this.setNombre(nombre);
		this.vida = 20;
		this.posicion = posicion;
		this.energia = 4;

	}

	/**
	 * M�todo que utilizamos para obtener la vida tanto del rival como del jugador
	 * 
	 * @return devuelve un byte con la vida del rival o del jugador
	 */
	public byte getVida() {
		return vida;
	}

	/**
	 * M�todo que utilizamos para obtener la posici�n del rival o del jugador en el
	 * mapa
	 * 
	 * @return devuelve un byte con la posici�n del rival o del jugador.
	 */
	public byte getPosicion() {
		return posicion;
	}

	/**
	 * M�todo que utilizamos para asignar una posici�n al rival o al jugador en el
	 * mapa
	 * 
	 * @param posicion la posici�n que queremos asignar al rival o al jugador.
	 */
	public void setPosicion(byte posicion) {
		this.posicion = posicion;
	}

	/**
	 * M�todo que utilizamos para obtener la baraja del jugador o del rival
	 * 
	 * @return devuelve un ArrayList de Carta con las cartas pertenecientes al
	 *         personaje
	 */
	public ArrayList<Carta> getBaraja() {
		return baraja;
	}

	/**
	 * M�todo que utilizamos para obtener los puntos de energ�a actuales del
	 * personaje
	 * 
	 * @return devuelve un byte con los puntos de energ�a.
	 */
	public byte getEnergia() {
		return energia;
	}
	/**
	 * toString de personaje que muestra el nombre del personaje, su baraja y su descripci�n.
	 */
	@Override
	public String toString() {
		return getNombre() + "\n" + "\tBaraja: " + baraja + "\n" + "\n\tDescripci�n: " + getDescripcion();
	}

	/**
	 * M�todo que nos servir� para guardar en un ArrayList todo el roster de
	 * personaje que se encuentra en nuestra BBDD, este m�todo es funadmental para
	 * el correcto funcionamiento de la clase "Selecci�nPersonaje" ya que en esa
	 * clase usamos este m�todo para mostrar todos los personajes en una lista de
	 * selecci�n para el jugador y para el rival
	 * 
	 * @return la funci�n devuelve un ArrayList con los nombres de los personajes.
	 */
	public static ArrayList<String> getTodos() {
		ArrayList<String> ret = new ArrayList<String>();
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor = smt.executeQuery("select * from personaje");
			while (cursor.next()) {
				String personaje = cursor.getString("nombre");

				ret.add(personaje);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}

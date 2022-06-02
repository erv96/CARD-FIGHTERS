package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.PriorityQueue;

import exceptions.PersonajeNoExisteException;
import utils.ConexionBD;

public class Personaje extends ElementoNombreDescripcion {
	private byte vida;
	private byte posicion;
	private ArrayList<Carta> baraja;
	private byte energia;

	public Personaje() {

	}

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
							cursor.getByte("puntosAtaque"), cursor.getByte("velocidad"), cursor.getByte("alcance"));
					baraja.add(barajita);

					// System.out.println(barajita);
				}
				Statement smt3 = ConexionBD.conectar();
				ResultSet cursorDesc = smt3.executeQuery("select * from personaje WHERE nombre= '" + nombre + "'");
				if (cursorDesc.next()) {
					String descripcion = cursorDesc.getString("descripcion");
					setDesripcion(descripcion);
				}
				
				Statement smt4 = ConexionBD.conectar();

				ResultSet cursorUlt = smt4.executeQuery("select*from ultimate where personaje = '"+nombre+"'");
				while (cursorUlt.next()) {
					Carta ulti = new Ultimate(cursorUlt.getString("nombre"), cursorUlt.getString("descripcion"),
							cursorUlt.getByte("puntosAtaque"), cursorUlt.getByte("velocidad"),
							cursorUlt.getByte("alcance"), cursorUlt.getByte("costeEnergia"),
							cursorUlt.getByte("costeVida"));
					baraja.add(ulti);
				}
				
				Statement smt5 = ConexionBD.conectar();

				ResultSet cursorSp = smt5.executeQuery("select*from especial where personaje = '"+nombre+"'");

				while (cursorSp.next()) {
					Carta gancho = new Especial(cursorSp.getString("nombre"), cursorSp.getString("descripcion"),
							cursorSp.getByte("puntosAtaque"), cursorSp.getByte("velocidad"),
							cursorSp.getByte("alcance"), cursorSp.getByte("costeEnergia"));
					baraja.add(gancho);
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
		this.energia = 5;

	}

	public byte getVida() {
		return vida;
	}

	public void setVida(byte vida) {
		this.vida = vida;
	}

	public byte getPosicion() {
		return posicion;
	}

	public void setPosicion(byte posicion) {
		this.posicion = posicion;
	}

	public ArrayList<Carta> getBaraja() {
		ArrayList<Carta> baraja = new ArrayList<Carta>();
		return baraja;
	}

	public void setBaraja(ArrayList<Carta> baraja) {

		this.baraja = baraja;
	}

	public byte getEnergia() {
		return energia;
	}

	public void setEnergia(byte energia) {
		this.energia = energia;
	}



	@Override
	public String toString() {
		return getNombre() + "\n"+"\tBaraja: "+baraja + "\n"
				+ "\n\tDescripción: " + getDescripcion();
	}

	/*
	 * public static ArrayList<Personaje> getTodos(){ ArrayList<Personaje> ret=new
	 * ArrayList<Personaje>(); Statement smt=ConexionBD.conectar(); try { ResultSet
	 * cursor=smt.executeQuery("select * from personajes"); while(cursor.next()) {
	 * Personaje actual=new Personaje();
	 * actual.setNombre(cursor.getString("nombre")); actual.setVida((byte)20);
	 * actual.setEnergia((byte)5); actual.setBaraja(getBaraja());
	 * actual.setEspecial(cursor.getString("especial"));
	 * actual.setUltimate(cursor.getString("ultimate"));
	 * actual.setDesripcion(cursor.getString("descripcion")); ret.add(actual); } }
	 * catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return ret; }
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

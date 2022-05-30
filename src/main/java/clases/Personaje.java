package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.PersonajeNoExisteException;
import utils.ConexionBD;

public class Personaje extends ElementoNombreDescripcion {
	private String texto;
	private byte vida;
	private byte posicion;
	private ArrayList<Carta> baraja;
	private byte energia;
	
	
	

	public Personaje(String nombre, String descripcion, byte posicion, ArrayList<Carta> baraja) {
		super(nombre, descripcion);

		Statement smt = ConexionBD.conectar();

		try {

			ResultSet curPersonaje = smt
					.executeQuery("SELECT nombre, descripcion FROM personajes WHERE nombre='" + nombre + "'");

			if (curPersonaje.next()) {
				

				for (byte i = 0; i < 5; i++) {
					ResultSet cursor = smt.executeQuery("select*from cartas");
					while (cursor.next()) {
						Carta barajita = new Carta(cursor.getString("nombre"), cursor.getString("descripcion"),
								cursor.getByte("puntosAtaque"), cursor.getByte("velocidad"), cursor.getByte("alcance"));
						baraja.add(barajita);

						// System.out.println(barajita);
					}
				}
				

				switch (nombre) {
				case "Steven":
					for (byte j = 0; j < 2; j++) {
						ResultSet cursorUlt = smt
								.executeQuery("select*from ultimates where nombre = 'Bomba imparable'");
						if (cursorUlt.next()) {
							Carta bomba = new Ultimate(cursorUlt.getString("nombre"),
									cursorUlt.getString("descripcion"), cursorUlt.getByte("puntosAtaque"),
									cursorUlt.getByte("velocidad"), cursorUlt.getByte("alcance"),
									cursorUlt.getByte("costeEnergia"), cursorUlt.getByte("costeVida"));
							baraja.add(bomba);
						}
					}
					
					for (byte i = 0; i < 3; i++) {
						ResultSet cursorSp = smt.executeQuery("select*from especiales where nombre='Gancho Rompedor'");
						
						if(cursorSp.next()) {
							Carta gancho = new Especial(cursorSp.getString("nombre"),
									cursorSp.getString("descripcion"), cursorSp.getByte("puntosAtaque"),
									cursorSp.getByte("velocidad"), cursorSp.getByte("alcance"),
									cursorSp.getByte("costeEnergia"));
							baraja.add(gancho);
						}
					}
					break;
				case "Mario":

					break;
				}

			} else {
				throw new PersonajeNoExisteException("Ese personaje no se encuentra dentro del roster");
			}

		} catch (SQLException | PersonajeNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionBD.desconectar();

		this.vida = 20;
		this.posicion = posicion;
		this.baraja = baraja;
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
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return getNombre() + ": \n" + "\tvida: " + vida + "\n" + "\tenergia: " + energia +"\n"
				+  "\tbaraja: " + baraja + "\n" + "\n" + "\tdescripción: "+ getDescripcion();
	}

}

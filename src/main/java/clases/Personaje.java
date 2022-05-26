package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class Personaje extends ElementoNombreDescripcion {
	private byte vida;
	private byte posicion;
	private ArrayList<Carta> baraja;
	private byte energia;

	public Personaje(String nombre, String descripcion, byte vida, byte posicion, ArrayList<Carta> baraja, byte energia)
			throws SQLException {
		super(nombre, descripcion);

		Statement smt = ConexionBD.conectar();
		for (byte i = 0; i < 5; i++) {
			ResultSet cursor = smt.executeQuery("select*from cartas");
			while (cursor.next()) {
				Carta barajita = new Carta(cursor.getString("nombre"), cursor.getString("descripcion"),
						cursor.getByte("puntosAtaque"), cursor.getByte("velocidad"), cursor.getByte("alcance"));
				baraja.add(barajita);

				System.out.println(barajita);
			}
		}

			switch (nombre) {
			case "Steven":
				for (byte j = 0; j < 2; j++) {
					ResultSet cursorUlt = smt.executeQuery("select*from ultimates where nombre = 'Bomba imparable'");
					if (cursorUlt.next()) {
						Carta bomba = new Ultimate(cursorUlt.getString("nombre"), cursorUlt.getString("descripcion"),
								cursorUlt.getByte("puntosAtaque"), cursorUlt.getByte("velocidad"),
								cursorUlt.getByte("alcance"), cursorUlt.getByte("costeEnergia"),
								cursorUlt.getByte("costeVida"));
						baraja.add(bomba);
					}

				}
				break;

			}
		

		ConexionBD.desconectar();

		this.vida = vida;
		this.posicion = posicion;
		this.baraja = baraja;
		this.energia = energia;
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

	public Personaje(String nombre, String descripcion, Carta ataques) {
		super(nombre, descripcion);

	}

	@Override
	public String toString() {

		return "Personaje [vida=" + vida + ", posicion=" + posicion + ", baraja=" + baraja + ", energia=" + energia
				+ "]";
	}

}

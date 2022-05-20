package clases;

import java.util.ArrayList;

public class Personaje extends ElementoNombreDescripcion {
	private byte vida;
	private byte posicion;
	private ArrayList<Carta> baraja;
	private byte energia;
	
	
	public Personaje(String nombre, String descripcion, byte vida, byte posicion, ArrayList<Carta> baraja,
			byte energia) {
		super(nombre, descripcion);
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
	
	
	
	
	
}

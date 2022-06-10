package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

/**
 * La clase carta nos permitir� definir las caracter�sticas de un objeto carta,
 * con esta clase lograremos crear las cartas comunes b�sicas que tendr� cada
 * jugador.
 * 
 * NOTA: he tenido que a�adir las variables 
 * 
 * @author toled
 *
 */
public class Carta extends ElementoNombreDescripcion {
	/**
	 * puntosAtaque: el da�o que har� la carta.
	 */
	private byte puntosAtaque;
	/**
	 * velocidad: velocidad que tendr� la carta, a mayor valor, mas posibilidades de
	 * que golpees primero.
	 */
	private byte velocidad;
	/**
	 * alcance: rango que tendr� la carta, definir� si la carta puede acertar desde
	 * una posici�n alejada de tu oponente en el mapa.
	 */
	private byte alcance;
	/**
	 * tipo: el tipo que puede ser la carta, b�sico, especial o ultimate
	 */
	private String tipo;
	
	/**
	 * Introduzco en esta clase un objeto de tipo ultimate para poder heredar sus m�todos y poder mostrar los costes de vida en la pantalla ListaCarta
	 */
	private Ultimate heredarMetodoVida;
	/**
	 * Introduzco en esta clase un objeto de tipo especial para poder heredar sus m�todos y poder mostrar los costes de energia en la pantalla ListaCarta
	 */
	private Especial heredarMetodoEnergia;

	/**
	 * Constructor con el que definir�mos la construcci�n de un objeto Carta, no se
	 * incluyen los valores de costeVida ni de costeEnerg�a porque las cartas
	 * b�sicas no poseen coste, pero he tenido que crear las variables internas para
	 * poder crear los m�todos de getVida y getEnergia para poder mostrar los costes
	 * de los ultimates y especiales en la clase ListarCarta la cual tiene como
	 * par�metro un objeto de tipo Carta.
	 * 
	 * @param nombre       nombre de la carta
	 * @param descripcion  funci�n que realiza la carta
	 * @param puntosAtaque da�o que realiza la carta
	 * @param velocidad    prioridad de la carta en golpear
	 * @param alcance      rango de impacto de la carta
	 * @param tipo         el tipo de la carta.
	 */

	public Carta(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance, String tipo) {
		super(nombre, descripcion);
		this.puntosAtaque = puntosAtaque;
		this.velocidad = velocidad;
		this.alcance = alcance;
		this.tipo = tipo;
	}
	
	/**
	 * Metodo para retornar el coste de vida con el m�todo del objeto ultimate getCosteVida
	 * @return
	 */
	public byte getCosteVida() {
		return heredarMetodoVida.getCosteVida();
	}
	
	
	/**
	 * Metodo para retornar el costeEnergia con el m�todo del objeto especial getCosteEnergia
	 * @return
	 */
	public byte getCosteEnergia() {
		return heredarMetodoEnergia.getCosteEnergia();
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte getPuntosAtaque() {
		return puntosAtaque;
	}

	public void setPuntosAtaque(byte puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}

	public byte getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(byte velocidad) {
		this.velocidad = velocidad;
	}

	public byte getAlcance() {
		return alcance;
	}

	public void setAlcance(byte alcance) {
		this.alcance = alcance;
	}

	@Override
	public String toString() {
		return "Carta: " + getNombre();

	}

}

package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

/**
 * La clase carta nos permitirá definir las características de un objeto carta,
 * con esta clase lograremos crear las cartas comunes básicas que tendrá cada
 * jugador.
 * 
 * NOTA: he tenido que añadir las variables 
 * 
 * @author toled
 *
 */
public class Carta extends ElementoNombreDescripcion {
	/**
	 * puntosAtaque: el daño que hará la carta.
	 */
	private byte puntosAtaque;
	/**
	 * velocidad: velocidad que tendrá la carta, a mayor valor, mas posibilidades de
	 * que golpees primero.
	 */
	private byte velocidad;
	/**
	 * alcance: rango que tendrá la carta, definirá si la carta puede acertar desde
	 * una posición alejada de tu oponente en el mapa.
	 */
	private byte alcance;
	/**
	 * tipo: el tipo que puede ser la carta, básico, especial o ultimate
	 */
	private String tipo;
	
	/**
	 * Introduzco en esta clase un objeto de tipo ultimate para poder heredar sus métodos y poder mostrar los costes de vida en la pantalla ListaCarta
	 */
	private Ultimate heredarMetodoVida;
	/**
	 * Introduzco en esta clase un objeto de tipo especial para poder heredar sus métodos y poder mostrar los costes de energia en la pantalla ListaCarta
	 */
	private Especial heredarMetodoEnergia;

	/**
	 * Constructor con el que definirémos la construcción de un objeto Carta, no se
	 * incluyen los valores de costeVida ni de costeEnergía porque las cartas
	 * básicas no poseen coste, pero he tenido que crear las variables internas para
	 * poder crear los métodos de getVida y getEnergia para poder mostrar los costes
	 * de los ultimates y especiales en la clase ListarCarta la cual tiene como
	 * parámetro un objeto de tipo Carta.
	 * 
	 * @param nombre       nombre de la carta
	 * @param descripcion  función que realiza la carta
	 * @param puntosAtaque daño que realiza la carta
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
	 * Metodo para retornar el coste de vida con el método del objeto ultimate getCosteVida
	 * @return
	 */
	public byte getCosteVida() {
		return heredarMetodoVida.getCosteVida();
	}
	
	
	/**
	 * Metodo para retornar el costeEnergia con el método del objeto especial getCosteEnergia
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

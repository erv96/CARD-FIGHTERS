package clases;

import java.sql.SQLException;

/**
 * Clase que define la carta de tipo Ultimate, esta carta puede tener coste de
 * energía o de vida.
 * 
 * @author toled
 *
 */
public class Ultimate extends Especial {
	/**
	 * costeVida: el coste de vida que tiene para el jugador usar esta carta.
	 */
	private byte costeVida;

	/**
	 * Constructor con el que definiremos los objetos Carta de tipo Ultimate
	 * 
	 * @param nombre       nombre de la carta
	 * @param descripcion  función que realiza la carta
	 * @param puntosAtaque daño que realiza la carta
	 * @param velocidad    prioridad de la carta en golpear
	 * @param alcance      rango de impacto de la carta
	 * @param tipo         el tipo de la carta.
	 * @param costeEnergia el coste de energía de la carta
	 * @param costeVida    el coste de vida que tiene la carta
	 * 
	 */
	public Ultimate(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance,
			byte costeEnergia, byte costeVida, String tipo) {
		super(nombre, descripcion, puntosAtaque, velocidad, alcance, costeEnergia, tipo);
		this.costeVida = costeVida;
	}

	@Override
	public String toString() {
		return getNombre();
	}

	public byte getCosteVida() {
		return costeVida;
	}

	public void setCosteVida(byte costeVida) {
		this.costeVida = costeVida;
	}

}

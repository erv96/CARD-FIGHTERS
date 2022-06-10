package clases;

import java.sql.SQLException;

/**
 * Clase que define la carta de tipo Especial, esta carta tiene coste de
 * energía.
 * 
 * @author toled
 *
 */
public class Especial extends Carta {
	/**
	 * costeEnergia: el coste de energía que tendrá para el jugador usar esta carta.
	 */
	private byte costeEnergia;

	/**
	 * Constructor con el que podrémos definir un objeto Carta de tipo Especial.
	 * 
	 * @param nombre       nombre de la carta
	 * @param descripcion  función que realiza la carta
	 * @param puntosAtaque daño que realiza la carta
	 * @param velocidad    prioridad de la carta en golpear
	 * @param alcance      rango de impacto de la carta
	 * @param tipo         el tipo de la carta.
	 * @param costeEnergia el coste de energía de la carta
	 */

	public Especial(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance,
			byte costeEnergia, String tipo) {
		super(nombre, descripcion, puntosAtaque, velocidad, alcance, tipo);
		this.costeEnergia = costeEnergia;
	}

	public byte getCosteEnergia() {
		return costeEnergia;
	}

	public void setCosteEnergia(byte costeEnergia) {
		this.costeEnergia = costeEnergia;
	}

	@Override
	public String toString() {
		return getNombre();
	}

}

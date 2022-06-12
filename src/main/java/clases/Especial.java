package clases;

import java.sql.SQLException;

/**
 * Clase que define la carta de tipo Especial, esta carta tiene coste de
 * energ�a.
 * 
 * @author toled
 *
 */
public class Especial extends Carta {
	/**
	 * costeEnergia: el coste de energ�a que tendr� para el jugador usar esta carta.
	 */
	private byte costeEnergia;

	/**
	 * Constructor con el que podr�mos definir un objeto Carta de tipo Especial.
	 * 
	 * @param nombre       nombre de la carta
	 * @param descripcion  funci�n que realiza la carta
	 * @param puntosAtaque da�o que realiza la carta
	 * @param velocidad    prioridad de la carta en golpear
	 * @param alcance      rango de impacto de la carta
	 * @param tipo         el tipo de la carta.
	 * @param costeEnergia el coste de energ�a de la carta
	 */

	public Especial(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance,
			byte costeEnergia, String tipo) {
		super(nombre, descripcion, puntosAtaque, velocidad, alcance, tipo);
		this.costeEnergia = costeEnergia;
	}

	/**
	 * M�todo que utilizamos para obtener el coste de energ�a de la carta
	 * 
	 * @return devuelve un byte con el coste de energ�a.
	 */
	public byte getCosteEnergia() {
		return costeEnergia;
	}
	
	/**
	 * toString que utilizamos para imprimir el nombre de la carta gracias al m�todo getNombre de la clase ElementoNombreDescripcion.
	 */
	@Override
	public String toString() {
		return getNombre();
	}

}

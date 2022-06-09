package clases;

import java.sql.SQLException;

/**
 * Clase que define la carta de tipo Ultimate, esta carta puede tener coste de energía o de vida.
 * @author toled
 *
 */
public class Ultimate extends Especial{
	/**
	 * costeVida: el coste de vida que tiene para el jugador usar esta carta.
	 */
	private byte costeVida;
	
	/**
	 * Constructor con el que definiremos los objetos Carta de tipo Ultimate.
	 * @param nombre
	 * @param descripcion
	 * @param puntosAtaque
	 * @param velocidad
	 * @param alcance
	 * @param costeEnergia
	 * @param costeVida
	 * @param tipo
	 * @throws SQLException
	 */
	public Ultimate(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance,
			byte costeEnergia, byte costeVida, String tipo) throws SQLException {
		super(nombre, descripcion, puntosAtaque, velocidad, alcance, costeEnergia,tipo);
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

package clases;

import java.sql.SQLException;
/**
 * Clase que define la carta de tipo Especial, esta carta tiene coste de energía.
 * @author toled
 *
 */
public class Especial extends Carta{
	/**
	 * costeEnergia: el coste de energía que tendrá para el jugador usar esta carta.
	 */
	private byte costeEnergia;
	
	/**
	 * Constructor con el que podrémos definir un objeto Carta de tipo Especial. 
	 * @param nombre
	 * @param descripcion
	 * @param puntosAtaque
	 * @param velocidad
	 * @param alcance
	 * @param costeEnergia
	 * @param tipo
	 * @throws SQLException
	 */

	public Especial(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance,
			byte costeEnergia,String tipo) throws SQLException {
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

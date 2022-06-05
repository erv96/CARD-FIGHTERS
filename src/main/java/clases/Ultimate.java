package clases;

import java.sql.SQLException;

public class Ultimate extends Especial{
	private byte costeVida;

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

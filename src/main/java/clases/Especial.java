package clases;

import java.sql.SQLException;

public class Especial extends Carta{
	private byte costeEnergia;

	public Especial(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance,
			byte costeEnergia) throws SQLException {
		super(nombre, descripcion, puntosAtaque, velocidad, alcance);
		this.costeEnergia = costeEnergia;
	}

	public byte getCosteEnergia() {
		return costeEnergia;
	}

	public void setCosteEnergia(byte costeEnergia) {
		this.costeEnergia = costeEnergia;
	}
	
	
	
	
}

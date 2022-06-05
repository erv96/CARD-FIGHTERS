package clases;

import java.sql.SQLException;

public class Especial extends Carta{
	private byte costeEnergia;

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

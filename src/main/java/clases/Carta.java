package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class Carta extends ElementoNombreDescripcion {
	private byte puntosAtaque;
	private byte velocidad;
	private byte alcance;
	private String tipo;
	private byte costeVida;
	private byte costeEnergia;
	
	public Carta(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance,String tipo) {
		super(nombre,descripcion);
		this.puntosAtaque = puntosAtaque;
		this.velocidad = velocidad;
		this.alcance = alcance;
		this.tipo = tipo;
		this.costeEnergia = 0;
		this.costeVida = 0;
	}

	public byte getCosteVida() {
		return costeVida;
	}

	public void setCosteVida(byte costeVida) {
		this.costeVida = costeVida;
	}

	public byte getCosteEnergia() {
		return costeEnergia;
	}

	public void setCosteEnergia(byte costeEnergia) {
		this.costeEnergia = costeEnergia;
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
		return "Carta: "+ getNombre();
				
	}

	

	
	
	

}

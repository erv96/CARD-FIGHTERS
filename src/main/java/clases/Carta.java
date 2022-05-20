package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class Carta extends ElementoNombreDescripcion {
	private byte puntosAtaque;
	private byte velocidad;
	private byte alcance;
	

	public Carta(String nombre, String descripcion, byte puntosAtaque, byte velocidad, byte alcance){
		super(nombre, descripcion);

		Statement smt = ConexionBD.conectar();

		try {
			if (smt.executeUpdate("INSERT INTO cartas VALUES('" + nombre + "','" + descripcion + "'," + puntosAtaque
					+ "," + velocidad + "," + alcance + ")") > 0) {

				this.puntosAtaque = puntosAtaque;
				this.velocidad = velocidad;
				this.alcance = alcance;
				
			}else {
				ConexionBD.desconectar();
				throw new SQLException("Los valores no han podido insertarse");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
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

}

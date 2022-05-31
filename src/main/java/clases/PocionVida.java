package clases;

public class PocionVida extends Consumible{
	private byte aumentoVida;

	public PocionVida(String nombre, String descripcion, byte aumentoVida) {
		super(nombre, descripcion);
		this.aumentoVida = aumentoVida;
	}
	
	
}

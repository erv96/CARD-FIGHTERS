package clases;

public class PocionFuerza extends Consumible{
	private byte aumentoFuerza;

	public PocionFuerza(String nombre, String descripcion, byte aumentoFuerza) {
		super(nombre, descripcion);
		this.aumentoFuerza = aumentoFuerza;
	}
	
}

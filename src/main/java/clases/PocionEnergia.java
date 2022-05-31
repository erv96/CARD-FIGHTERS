package clases;

public class PocionEnergia extends Consumible{
	private byte aumentoEnergia;

	public PocionEnergia(String nombre, String descripcion, byte aumentoEnergia) {
		super(nombre, descripcion);
		this.aumentoEnergia = aumentoEnergia;
	}	
	
}

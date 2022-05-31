package clases;

public class CampoCombate extends ElementoNombreDescripcion {
	private byte[] tamaño;

	public CampoCombate(String nombre, String descripcion, byte[] tamaño) {
		super(nombre, descripcion);
		this.tamaño = tamaño;
	}
	
	
}

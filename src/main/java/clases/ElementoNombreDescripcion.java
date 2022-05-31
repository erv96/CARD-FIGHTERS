package clases;

public class ElementoNombreDescripcion {
	private String nombre;
	private String descripcion;
	
	public ElementoNombreDescripcion(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	


	protected ElementoNombreDescripcion(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	public ElementoNombreDescripcion() {
		super();
	}




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDesripcion(String desripcion) {
		this.descripcion = desripcion;
	}

	
	
	
	
}

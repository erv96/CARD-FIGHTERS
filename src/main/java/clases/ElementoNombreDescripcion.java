package clases;

/**
 * Super clase que proporcionará los atributos de nombre y descripción a las
 * clases que hereden de ella y sus métodos. Esta clase será abstracta ya que
 * nunca se inicializará un objeto ElementoNombreDescripcion.
 * 
 * @author toled
 *
 */
public abstract class ElementoNombreDescripcion {
	/**
	 * Nombre: nombre del tipo de objeto que definamos.
	 */
	private String nombre;
	/**
	 * Descripcion: descripcion del tipo de objeto que definamos.
	 */
	private String descripcion;

	/**
	 * Constructor que nos proporcionará la posibilidad de añadir las variables
	 * internas de nombre y descripción a cada objeto que herede de esta clase
	 * 
	 * @param nombre
	 * @param descripcion
	 */
	public ElementoNombreDescripcion(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * Constructor para que sea posible añadirle únicamente el argumento de nombre a
	 * los constructores de los objetos que hereden de esta clase, sin necesidad de
	 * la descripción.
	 * 
	 * @param nombre
	 */
	protected ElementoNombreDescripcion(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * Constructor para poder definir un constructor vacío de las clases que hereden
	 * de esta.
	 */
	public ElementoNombreDescripcion() {
		super();
	}

	/**
	 * Método que utilizamos para obtener el nombre de los objetos que heredan de
	 * esta clase
	 * 
	 * @return devuelve un string con su nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que usamos para asignar un nombre a los objetos que heredan de esta
	 * clase.
	 * 
	 * @param nombre nombre que queremos asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que utilizamos para obtener la descripción de los objetos que heredan
	 * de esta clase
	 * 
	 * @return devuelve un String con la descripción del objeto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método que utilizamos para asignar una descripción a los objetos que heredan
	 * de esta clase
	 * 
	 * @param desripcion descripción que se le va a asignar al objeto
	 */
	public void setDesripcion(String desripcion) {
		this.descripcion = desripcion;
	}

}

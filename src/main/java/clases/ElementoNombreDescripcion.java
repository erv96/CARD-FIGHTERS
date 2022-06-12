package clases;

/**
 * Super clase que proporcionar� los atributos de nombre y descripci�n a las
 * clases que hereden de ella y sus m�todos. Esta clase ser� abstracta ya que
 * nunca se inicializar� un objeto ElementoNombreDescripcion.
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
	 * Constructor que nos proporcionar� la posibilidad de a�adir las variables
	 * internas de nombre y descripci�n a cada objeto que herede de esta clase
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
	 * Constructor para que sea posible a�adirle �nicamente el argumento de nombre a
	 * los constructores de los objetos que hereden de esta clase, sin necesidad de
	 * la descripci�n.
	 * 
	 * @param nombre
	 */
	protected ElementoNombreDescripcion(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * Constructor para poder definir un constructor vac�o de las clases que hereden
	 * de esta.
	 */
	public ElementoNombreDescripcion() {
		super();
	}

	/**
	 * M�todo que utilizamos para obtener el nombre de los objetos que heredan de
	 * esta clase
	 * 
	 * @return devuelve un string con su nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo que usamos para asignar un nombre a los objetos que heredan de esta
	 * clase.
	 * 
	 * @param nombre nombre que queremos asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo que utilizamos para obtener la descripci�n de los objetos que heredan
	 * de esta clase
	 * 
	 * @return devuelve un String con la descripci�n del objeto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * M�todo que utilizamos para asignar una descripci�n a los objetos que heredan
	 * de esta clase
	 * 
	 * @param desripcion descripci�n que se le va a asignar al objeto
	 */
	public void setDesripcion(String desripcion) {
		this.descripcion = desripcion;
	}

}

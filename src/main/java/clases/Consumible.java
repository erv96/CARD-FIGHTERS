package clases;
/**
 * Clase que nos sirve para que PocionEnergia, PocionFuerza y PocionVida hereden de la super clase ElementoConNombreDescripcion 
 * esta clase será abstracta ya que nunca se inicializará un objeto consumible como tal.
 * @author toled
 *
 */
public abstract class Consumible extends ElementoNombreDescripcion {

	
	/**
	 * Este constructor sirve para que PocionEnergia, PocionFuerza y PocionVida puedan inicializarse sin ningún argumento, ya que no nos será necesario.
	 */
	public Consumible() {

	}

}

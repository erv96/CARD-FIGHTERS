package clases;
/**
 * Clase que nos sirve para que PocionEnergia, PocionFuerza y PocionVida hereden de la super clase ElementoConNombreDescripcion 
 * esta clase ser� abstracta ya que nunca se inicializar� un objeto consumible como tal.
 * @author toled
 *
 */
public abstract class Consumible extends ElementoNombreDescripcion {

	
	/**
	 * Este constructor sirve para que PocionEnergia, PocionFuerza y PocionVida puedan inicializarse sin ning�n argumento, ya que no nos ser� necesario.
	 */
	public Consumible() {

	}

}

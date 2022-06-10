package exceptions;

/**
 * Excepci�n programada para que se ejecute cuando al instanciar un objeto de
 * tipo escenario se introduzca un nombre no disponible en la base de datos
 * 
 * @author toled
 *
 */
public class EscenarioNoExisteException extends Exception {
	/**
	 * Constructor de la excepcion que recibe el mensaje que se mostrar� cuando
	 * surja la excepci�n
	 * 
	 * @param message mensaje que se muestra cuando surje la excepci�n.
	 */
	public EscenarioNoExisteException(String message) {
		super(message);
	}

}

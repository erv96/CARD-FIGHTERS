package exceptions;

/**
 * Excepción programada para que se ejecute cuando al instanciar un objeto de
 * tipo escenario se introduzca un nombre no disponible en la base de datos
 * 
 * @author toled
 *
 */
public class EscenarioNoExisteException extends Exception {
	/**
	 * Constructor de la excepcion que recibe el mensaje que se mostrará cuando
	 * surja la excepción
	 * 
	 * @param message mensaje que se muestra cuando surje la excepción.
	 */
	public EscenarioNoExisteException(String message) {
		super(message);
	}

}

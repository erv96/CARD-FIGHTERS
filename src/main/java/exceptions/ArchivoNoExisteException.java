package exceptions;

/**
 * Excepción programada para que se ejecute cuando no se encuentre el archivo de
 * texto con los ganadores de combates pasados
 * 
 * @author toled
 *
 */

public class ArchivoNoExisteException extends Exception {

	/**
	 * Constructor de la excepcion que recibe el mensaje que se mostrará cuando
	 * surja la excepción
	 * 
	 * @param message mensaje que se muestra cuando surje la excepción.
	 */
	public ArchivoNoExisteException(String message) {
		super(message);
	}

}

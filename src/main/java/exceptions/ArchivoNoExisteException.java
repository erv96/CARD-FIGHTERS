package exceptions;

/**
 * Excepci�n programada para que se ejecute cuando no se encuentre el archivo de
 * texto con los ganadores de combates pasados
 * 
 * @author toled
 *
 */

public class ArchivoNoExisteException extends Exception {

	/**
	 * Constructor de la excepcion que recibe el mensaje que se mostrar� cuando
	 * surja la excepci�n
	 * 
	 * @param message mensaje que se muestra cuando surje la excepci�n.
	 */
	public ArchivoNoExisteException(String message) {
		super(message);
	}

}

package interfaces;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.player.Player;

/**
 * Clase que nos proporcionará las funcionalidades músicales de nuestro
 * programa,
 * 
 * @author toled
 *
 */
public class Sound {
	/**
	 * En la variable clip almacenaremos el sonido que hemos guardado en la variable
	 * de tipo AudioInputStream.
	 */
	Clip clip;

	/**
	 * Constructor para inicializar un objeto de tipo Sound, con el que usar los
	 * métodos siguientes.
	 */
	public Sound() {

	}

	/**
	 * Método con el que conseguiremos reproducir un archivo de sonido hasta que
	 * termine mediante el parámetro que contendrá la ruta del archivo de sonido.
	 * Almacenamos el archivo de sonido en una variable de tipo AudioInpuStream que
	 * procesa y reconoce el archivo a reproducir con su método getAudioInputStream,
	 * luego de eso usamos la variable de tipo clip a la que le pasamos como
	 * argumento la variable de tipo AudioInputStream, abrimos el archivo con .open
	 * y luego de eso lo reproducimos con .star
	 * 
	 * @param sonido parametro de tipo File en el que le pasaremos la ruta del
	 *               archivo de sonido que queremos reproducir.
	 */
	public void play(File sonido) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(sonido);
			clip = AudioSystem.getClip();
			clip.open(ais);

		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.start();

	}

	/**
	 * Este método funciona igual que el anterior con la diferencia de que en lugar
	 * del método .start usamos .loop para reproducir el archivo en bucle
	 * 
	 * @param sonido
	 */

	public void loop(File sonido) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(sonido);
			clip = AudioSystem.getClip();
			clip.open(ais);

		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * Método que permite pausar el clip de sonido.
	 */
	public void stop() {
		clip.stop();
	}

}

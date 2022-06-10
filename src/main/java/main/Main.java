package main;

import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;

import clases.CampoCombate;
import clases.Carta;
import clases.Consumible;
import clases.ElementoNombreDescripcion;
import clases.Personaje;
import clases.PocionEnergia;
import clases.PocionFuerza;
import clases.PocionVida;
import exceptions.PersonajeNoExisteException;
import interfaces.Sound;
import interfaces.Ventana;
import javazoom.jl.player.Player;
import utils.ConexionBD;

public class Main {
	/**
	 * ESTA VARIABLE INTERNA LA UTILIZO PARA PASAR LOS ARGUMENTOS DE PROGRAMA HACIA
	 * LA PANTALLA DE SELECCIÓN DE PERSONAJE
	 */
	private static String[] savedArgs;

	/**
	 * Clase main donde inciamos la variable Ventana cardFighters el cual nos
	 * muestra la pantalla principal de nuestro de juego con todas las
	 * características generales que hemos añadido en la clase Ventana
	 * 
	 * @param args argumentos de programa que guardamos en un array de String para
	 *             llevarlos a la pantalla de SeleccionPersonaje
	 */
	public static void main(String[] args) {

		Ventana cardFighters = new Ventana();

		// IGUALO EL ARRAY DE STRING SAVEDARGS A LOS ARGUMENTOS DE PROGRAMA
		savedArgs = args;


	}

	/**
	 * ESTE MÉTODO LO UTILIZO PARA OBTENER LOS ARGUMENTOS DE PROGRAMA EN LA CLASE DE
	 * SELEECIONPERSONAJE.
	 * 
	 * @return devuelve el array de argumentos.
	 */
	public static String[] getArgs() {
		return savedArgs;
	}

}

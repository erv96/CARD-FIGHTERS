package main;

import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	//ESTA VARIABLE INTERNA LA UTILIZO PARA PASAR LOS ARGUMENTOS DE PROGRAMA HACIA LA PANTALLA DE SELECCIÓN DE PERSONAJE
	private static String[] savedArgs;

	public static void main(String[] args) {

		Ventana cardFighters = new Ventana();
		
		//IGUALO EL ARRAY DE STRING SAVEDARGS A LOS ARGUMENTOS DE PROGRAMA
		savedArgs = args;
		
		

		// DOCUMENTAR TODAS LAS CLASES
		// ENCIMA DE CADA VARIABLE INTERNA SE PONE PARA QUE SIRVE.

	}
	
	
	/**
	 * ESTE MÉTODO LO UTILIZO PARA OBTENER LOS ARGUMENTOS DE PROGRAMA EN LA CLASE DE SELEECIONPERSONAJE.
	 * @return
	 */
	public static String[] getArgs() {
		return savedArgs;
	}

}

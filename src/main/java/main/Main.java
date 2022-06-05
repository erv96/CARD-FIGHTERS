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

	public static void main(String[] args) {

		Ventana cardFighters = new Ventana();
		
		//ARGUMENTO PARA IR DIRECTAMENTE A LA PANTALLA DE SELECCIÓN DE PERSONAJE.
		
		/*String pantallaElegida = "";

		for (byte i = 0; i < args.length; i++) {
			if (args[i].equals("-pantalla")) {
				pantallaElegida = args[i + 1];
			}
		}
		cardFighters.irAPantalla(pantallaElegida);*/

		// DOCUMENTAR TODAS LAS CLASES
		// ENCIMA DE CADA VARIABLE INTERNA SE PONE PARA QUE SIRVE.

	}

}

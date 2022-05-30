package main;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Carta;
import clases.ElementoNombreDescripcion;
import clases.Personaje;
import exceptions.PersonajeNoExisteException;
import interfaces.Ventana;
import utils.ConexionBD;

public class Main {

	public static void main(String[] args) {

		Ventana prueba = new Ventana();
		ArrayList<Carta> manoInicial = new ArrayList<Carta>();

		Personaje steven = new Personaje("Steven",
				"Luchador especializado en cuerpo a cuerpo no posee ataques a distancia pero hace mucho daño con sus habilidades",
				(byte) 5, manoInicial);

		System.out.println(steven);

	}

}

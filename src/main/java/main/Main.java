package main;

import java.sql.SQLException;
import java.util.ArrayList;

import clases.Carta;
import clases.Personaje;
import exceptions.PersonajeNoExisteException;
import interfaces.Ventana;

public class Main {

	public static void main(String[] args) {
		
		Ventana prueba = new Ventana();
		ArrayList<Carta> manoInicial = new ArrayList<Carta>();
		
			Personaje steven = new Personaje("Steven","probando",(byte)5,manoInicial);
			
			System.out.println(steven);
		

	}

}

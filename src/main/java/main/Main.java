package main;

import java.sql.SQLException;
import java.util.ArrayList;

import clases.Carta;
import clases.Personaje;

public class Main {

	public static void main(String[] args) {
		ArrayList<Carta> manoInicial = new ArrayList<Carta>();
		
		try {
			Personaje pepino = new Personaje("Steven", "Esta roto",(byte) 22, (byte)4, manoInicial,(byte) 5);
			System.out.println(pepino);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

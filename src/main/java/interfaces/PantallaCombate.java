package interfaces;

import clases.CampoCombate;
import clases.Carta;
import clases.Consumible;
import clases.PocionEnergia;
import clases.PocionFuerza;
import clases.PocionVida;

public class PantallaCombate {
	private Carta CartaElegidaJugador;
	private Carta CartaElegidRival;

	// CONSUMIBLES

	Consumible pEnergia = new PocionEnergia();
	Consumible pFuerza = new PocionFuerza();
	Consumible pVida = new PocionVida();

	// ESCENARIOS
	CampoCombate playa = new CampoCombate("Playa enigmática");
	CampoCombate dojo = new CampoCombate("Dojo");

}

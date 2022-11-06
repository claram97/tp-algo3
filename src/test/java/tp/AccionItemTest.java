package tp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Mejoras.MejoraDinamita;
import tp.Mejoras.Usable;

public class AccionItemTest {

	@Test
	public void seAplicaLaMejora() {
		Jugador jugador = new Jugador(10, 10,10,10);
		ConfigSuelo configSuelo = new Suelo1(Main.ALTURA,Main.ANCHO);
		Suelo suelo = new Suelo(configSuelo);
		Usable mejora = new MejoraDinamita(suelo);
		jugador.agregarUsable(mejora);
		AccionItem accionItem = new AccionItem(jugador,mejora);
		assertEquals(true,accionItem.aplicar());
	}
	
	public void noSeAplicaLaMejora() {
		Jugador jugador = new Jugador(10,10,10,10);
		ConfigSuelo configSuelo = new Suelo1(Main.ALTURA,Main.ANCHO);
		Suelo suelo = new Suelo(configSuelo);
		Usable mejora = new MejoraDinamita(suelo);
		AccionItem accionItem = new AccionItem(jugador,mejora);
		assertEquals(false,accionItem.aplicar());
	}

}

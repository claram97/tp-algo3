package tiendas;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.Jugador;
import mejoras.MejoraHullRepairNanobots;

public class TiendaDeConsumiblesTest {

	@Test
	public void compraExitosa() {
		var tienda = new TiendaDeConsumibles(10);
		Jugador pj = new Jugador(5, 0, 10, 10);
		pj.setDinero(10000);
		tienda.vender(pj, 'R');
		
		boolean cantidadAdecuada = pj.getMejoras().size() == 1;
		boolean itemCorrecto = pj.getMejoras().get(0) instanceof MejoraHullRepairNanobots;
		
		assertTrue(cantidadAdecuada && itemCorrecto);
	}
	
	@Test
	public void admiteComprasMultiples() {
		var tienda = new TiendaDeConsumibles(10);
		Jugador pj = new Jugador(5, 0, 10, 10);
		pj.setDinero(100000);
		tienda.vender(pj, 'R');
		tienda.vender(pj, 'R');
		tienda.vender(pj, 'R');
		tienda.vender(pj, 'R');
		tienda.vender(pj, 'R');
		tienda.vender(pj, 'R');
		
		assertEquals(pj.getMejoras().size(), 6);
	}
	
	@Test
	public void descuentaDineroCorrectamente() {
		var tienda = new TiendaDeConsumibles(10);
		Jugador pj = new Jugador(5, 0, 10, 10);
		pj.setDinero(100000);
		tienda.vender(pj, 'R');
		tienda.vender(pj, 'R');
		
		assertEquals(pj.getDinero(), 100000 - (2 * MejoraHullRepairNanobots.VALOR));
	}
	
	@Test
	public void itemNoExistente() {
		var tienda = new TiendaDeConsumibles(10);
		Jugador pj = new Jugador(5, 0, 10, 10);
		pj.setDinero(100000);
		tienda.vender(pj, 'B');
		
		assertTrue(pj.getMejoras().size() == 0 && pj.getDinero() == 100000);
	}

}

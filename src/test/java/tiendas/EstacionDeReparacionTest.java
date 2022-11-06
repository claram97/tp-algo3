package tiendas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jugador.Jugador;

public class EstacionDeReparacionTest {
	private static final int PRECIO_REPARACION = 15;
	@Test
	public void venderFull() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.setHP(1);
		jugador.setDinero(1000);
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.vender(jugador, 1000);
		
		assertEquals(jugador.getHP(), jugador.getMaxHP());
	}
	
	@Test
	public void vender100Gasto() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.setHP(0);
		jugador.setMaxHP(100);
		jugador.setDinero(1000);
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.vender(jugador, 100);
		
		assertEquals(jugador.getHP(), 100/PRECIO_REPARACION);
	}
	
	@Test
	public void venderSinDinero() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.setHP(0);
		jugador.setDinero(0);
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.vender(jugador, 100);
		
		assertEquals(jugador.getHP(), 0);
	}
	
	@Test
	public void gastoCorrecto() {
		Jugador jugador = new Jugador(5,0,10,10);
		jugador.setHP(1);
		jugador.setMaxHP(100);
		jugador.setDinero(55);
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.vender(jugador, 50);
		
		assertEquals(5, jugador.getDinero());
	}

}
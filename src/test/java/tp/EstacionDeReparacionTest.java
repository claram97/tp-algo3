package tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EstacionDeReparacionTest {
	private static final int PRECIO_REPARACION = 15;
	@Test
	public void repararFull() {
		Jugador jugador = new Jugador(5, 0);
		jugador.hp = 1;
		jugador.dinero = 1000;
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.reparar(jugador, 1000);
		
		assertEquals(jugador.hp, jugador.maxHP);
	}
	
	@Test
	public void reparar100Gasto() {
		Jugador jugador = new Jugador(5, 0);
		jugador.hp = 0;
		jugador.maxHP = 100;
		jugador.dinero = 1000;
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.reparar(jugador, 100);
		
		assertEquals(jugador.hp, 100/PRECIO_REPARACION);
	}
	
	@Test
	public void repararSinDinero() {
		Jugador jugador = new Jugador(5, 0);
		jugador.hp = 0;
		jugador.dinero = 0;
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.reparar(jugador, 100);
		
		assertEquals(jugador.hp, 0);
	}
	
	@Test
	public void gastoCorrecto() {
		Jugador jugador = new Jugador(5, 0);
		jugador.hp = 1;
		jugador.maxHP = 100;
		jugador.dinero = 55;
		
		var mecanico = new EstacionDeReparacion(10);
		mecanico.reparar(jugador, 50);
		
		assertEquals(5, jugador.dinero);
	}
	
	

}
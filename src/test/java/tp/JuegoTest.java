package tp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class JuegoTest {

	@Test
	public void MoverDerecha() {
		Jugador pj = new Jugador(2,0);
		Suelo suelo = new Suelo(4, 4);
		Juego juego = new Juego(suelo, null, pj);
		var acciones = new ArrayList<Accion>();
		
		var mover = new AccionMovimiento(pj, suelo, null, 1, 0);
		acciones.add(mover);
		juego.realizarAccion(acciones);
		
		assertEquals(pj.getPosicion().getX(), 3);
	}
	
	@Test
	public void MoverIzquierda() {
		Jugador pj = new Jugador(2,0);
		Suelo suelo = new Suelo(4, 4);
		Juego juego = new Juego(suelo, null, pj);
		var acciones = new ArrayList<Accion>();
		
		var mover = new AccionMovimiento(pj, suelo, null, -1, 0);
		acciones.add(mover);
		juego.realizarAccion(acciones);
		
		assertEquals(pj.getPosicion().getX(), 1);
	}
	
	@Test
	public void recibirInput() {
		var acciones = new ArrayList<Accion>();
		Juego juego = new Juego(null, null, null);
		juego.convertirInput('W', acciones);
		assertEquals(acciones.size(), 1);
	}
	
	public void recibirMultiplesInputs() {
		var acciones = new ArrayList<Accion>();
		Juego juego = new Juego(null, null, null);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		juego.convertirInput('W', acciones);
		assertEquals(acciones.size(), 5);
	}
	
	@Test
	public void inputCorrecto() {
		var acciones = new ArrayList<Accion>();
		Jugador pj = new Jugador(3, 1);
		Suelo suelo = new Suelo(4, 4);
		Juego juego = new Juego(suelo, null, pj);
		juego.convertirInput('W', acciones);
		juego.realizarAccion(acciones);
		assertEquals(pj.getPosicion().getY(), 0);
	}
	
	@Test
	public void funcionaComoCola() {
		var acciones = new ArrayList<Accion>();
		Jugador pj = new Jugador(3, 1);
		Suelo suelo = new Suelo(4, 4);
		Juego juego = new Juego(suelo, null, pj);
		juego.convertirInput('W', acciones);
		juego.convertirInput('S', acciones);
		juego.convertirInput('S', acciones);
		juego.convertirInput('S', acciones);
		juego.convertirInput('S', acciones);
		juego.realizarAccion(acciones);
		
		boolean posCorrecta = pj.getPosicion().getY() == 0;
		boolean cantidadCorrecta = acciones.size() == 4;
		assertTrue(posCorrecta && cantidadCorrecta);
	}
	

}
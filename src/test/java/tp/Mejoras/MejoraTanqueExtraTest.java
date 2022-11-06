package tp.Mejoras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Jugador;

public class MejoraTanqueExtraTest {

	@Test
	public void elJugadorNoGastaDinero() {
		Jugador pj = new Jugador(5,0,10,10);
		Usable mejora = new MejoraTanqueExtra();
		int antes = pj.getDinero();
		mejora.utilizar(pj);
		int despues = pj.getDinero();
		assertEquals(antes,despues);
	}
	
	//Podríamos agregar tests en caso de que decidamos que se guarde lo que sobre (si no se carga todo el tanque extra), quizás podríamos ver de que la mejora se elimine cuando cantidad == 0 o algo de eso :P

}

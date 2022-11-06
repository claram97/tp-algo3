package mejoras;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import jugador.Jugador;
import jugador.Posicion;


public class MejoraTeleportTest {

    @Test
    public void seTeletransportaAlPisoDelTerreno() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.setY(10);
    	Usable mejoraTeleport = new MejoraTeleport();
    	mejoraTeleport.utilizar(jugador);
    	assertEquals(jugador.getY(),0);
    }
    
    //Este test falla y ni idea por qué jeje
    @Test
    public void seTeletransporta() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.setX(9);
    	jugador.setY(10);
    	Posicion posicionAnterior = jugador.getPosicion();
    	Usable mejoraTeleport = new MejoraTeleport();
    	mejoraTeleport.utilizar(jugador);
    	Posicion nuevaPosicion = jugador.getPosicion();
    	assertFalse(posicionAnterior.esPosicionIgual(nuevaPosicion));
    }

}

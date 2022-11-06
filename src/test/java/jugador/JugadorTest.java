package jugador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mejoras.MejoraTeleport;
import mejoras.Usable;
import minerales.Cobre;
import minerales.FabricaDeMinerales;
import minerales.Mineral;

public class JugadorTest {

	@Test
    public void losMineralesSeAñadenCorrectamente() {
        Jugador jugador = new Jugador(5, 0,10,10);
        jugador.agregarInventario(FabricaDeMinerales.crear("Cobre"));
        assertEquals(jugador.getCantidadDeMinerales(),1);
    }


    @Test
    public void losMineralesSeVendenCorrectamente() {
        Jugador jugador = new Jugador(5, 0,10,10);
        for(int i = 0; i < 5; i++) {
        	jugador.agregarInventario(new Cobre());
        }
        jugador.venderMinerales();
        assertEquals(jugador.getCantidadDeMinerales(),0);
    }

    @Test
    public void elLmiteDeInventarioNoSePuedeSobrepasar() {
        Jugador jugador = new Jugador(5, 0,10,10);
        Mineral cobre = FabricaDeMinerales.crear("Cobre");
        for(int i = 0; i < 7; i++) {
            jugador.agregarInventario(cobre);
        }
        int antes = jugador.getCantidadDeMinerales();
        jugador.agregarInventario(cobre);
        int despues = jugador.getCantidadDeMinerales();
        assertEquals(antes,despues);
    }
   
    @Test
    public void noSePuedeCrearJugadorFueraDelSuelo() {
        
    }
    
    @Test
    public void sePuedeHacerCompra() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.setDinero(120);
    	assertTrue(jugador.hacerCompra(110));
    }
    
    @Test
    public void noSePuedeHacerCompra() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.setDinero(100);
    	assertFalse(jugador.hacerCompra(110));
    }
    
    @Test
    public void elJugadorNoSePuedePosicionarFueraDeLosLimites(){
    	Jugador jugador = new Jugador(5,0,10,10);
    	Posicion posicionInicial = jugador.getPosicion();
    	jugador.setX(11);
    	jugador.setY(11);
    	Posicion posicionFinal = jugador.getPosicion();
    	assertEquals(posicionInicial,posicionFinal);
    }
   
    
    @Test
    public void jugadorSinCombustible() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.gastarCombustible(jugador.nivelDeCombustible());
    	assertTrue(jugador.seQuedoSinCombustible());
    }
    
    @Test
    public void jugadorTieneCombustible() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	assertFalse(jugador.seQuedoSinCombustible());
    }
        
    @Test
    public void noSePuedeActualizarLimiteDeInventarioAUnoMasPequenio() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	
    }
    
    @Test
    public void noSePuedeActualizarMaxHPAUnoMasPequenio() {
    	
    }
    
    @Test
    public void noSePuedeActualizarCapacidadDelTanquePorUnaMenorALaActual() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	double antes = jugador.getCapacidadTanque();
    	jugador.agregarCapacidadAlTanque(10);
    	double despues = jugador.getCapacidadTanque();
    	assertEquals(antes,despues);
    }
    
    @Test
    public void sePuedeActualizarCapacidadDelTanquePorUnaMayorALaActual() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	double antes = jugador.getCapacidadTanque();
    	jugador.agregarCapacidadAlTanque(20);
    	double despues = jugador.getCapacidadTanque();
    	assertNotEquals(antes,despues);
    }
    
    @Test
    public void jugadorNoTieneUsable() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	Usable usable = new MejoraTeleport();
    	assertFalse(jugador.tieneUsable(usable));
    }
    
    @Test
    public void losUsablesSeAgreganCorrectamente() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	Usable usable = new MejoraTeleport();
    	jugador.agregarUsable(usable);
    	assertTrue(jugador.tieneUsable(usable));
    }
    
    @Test
    public void losUsablesSeEliminanCorrectamente() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	Usable usable = new MejoraTeleport();
    	jugador.agregarUsable(usable);
    	int antes = jugador.getMejoras().size();
    	jugador.eliminarMejora(usable);
    	int despues = jugador.getMejoras().size();
    	assertNotEquals(antes,despues);
    }
    
    @Test
    public void noSePuedeGastarCombustibleNegativo() {
    	
    }
    
    @Test
    public void seGastaCombustibleSuficienteParaQueElJugadorSeQuedeSinCombustible() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.gastarCombustible(100);
    	assertTrue(jugador.seQuedoSinCombustible());
    }
      
    @Test
    public void elCombustibleSeGastaCorrectamente() {
       	Jugador jugador = new Jugador(5,0,10,10);
    	double antes = jugador.nivelDeCombustible();
    	jugador.gastarCombustible(5);
    	double despues = jugador.nivelDeCombustible();
    	assertNotEquals(antes,despues);
    }
    
    @Test
    public void seRecibeDanioSuficienteParaQueElJugadorSeEstrelle() {
    	Jugador jugador = new Jugador(5,0,10,10);
    	jugador.recibirDanio(100);
    	assertTrue(jugador.seEstrello());
    }

    /*
    @Test
    public void 
    
    @Test
    public void
    */
}

package tp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JugadorTest {

	@Test
    public void losMineralesSeAñadenCorrectamente() {
        Jugador jugador = new Jugador(5, 0);
        jugador.agregarInventario(FabricaDeMinerales.crear("Cobre"));
        assertEquals(jugador.getCantidadDeMinerales(),1);
    }


    @Test
    public void losMineralesSeVendenCorrectamente() {
        Jugador jugador = new Jugador(5, 0);
        for(int i = 0; i < 5; i++) {
        	jugador.agregarInventario(new Cobre());
        }
        int antes = jugador.getCantidadDeMinerales();
        jugador.venderMinerales();
        int despues = jugador.getCantidadDeMinerales();
        assertEquals((antes-5),despues);
    }

    @Test
    public void elLmiteDeInventarioNoSePuedeSobrepasar() {
        Jugador jugador = new Jugador(5, 0);
        Mineral cobre = FabricaDeMinerales.crear("Cobre");
        for(int i = 0; i < 7; i++) {
            jugador.agregarInventario(cobre);
        }
        int antes = jugador.getCantidadDeMinerales();
        jugador.agregarInventario(cobre);
        int despues = jugador.getCantidadDeMinerales();
        assertEquals(antes,despues);
    }
    
    

}
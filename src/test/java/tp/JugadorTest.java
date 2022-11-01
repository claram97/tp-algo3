package tp;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTest {

	@Test
    public void losMineralesSeAñadenCorrectamente() {
        Jugador jugador = new Jugador(5, 0);
        jugador.agregarInventario(FabricaDeMinerales.crear(TipoDeBloque.COBRE));
        assertEquals(jugador.getCantidadDeMinerales(),1);
    }


    @Test
    public void losMineralesSeVendenCorrectamente() {
        Jugador jugador = new Jugador(5, 0);
        Bloque cobre = FabricaDeMinerales.crear(TipoDeBloque.COBRE);
        jugador.agregarInventario(cobre);
        int antes = jugador.getCantidadDeMinerales();
        jugador.venderMinerales(cobre);
        int despues = jugador.getCantidadDeMinerales();
        assertEquals(despues,(antes-1));
    }

    @Test
    public void elLmiteDeInventarioNoSePuedeSobrepasar() {
        Jugador jugador = new Jugador(5, 0);
        Bloque cobre = FabricaDeMinerales.crear(TipoDeBloque.COBRE);
        for(int i = 0; i < 7; i++) {
            jugador.agregarInventario(cobre);
        }
        int antes = jugador.getCantidadDeMinerales();
        jugador.agregarInventario(cobre);
        int despues = jugador.getCantidadDeMinerales();
        assertEquals(antes,despues);
    }

}

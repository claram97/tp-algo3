package mejoras;

import jugador.Jugador;
import jugador.Posicion;
import terreno.Suelo;

public class MejoraExplosivos extends MejoraDeTerreno {
	public static int VALOR = 5000;
	public static char LETRA = 'C';
	
	private Suelo suelo;
	
	public MejoraExplosivos(Suelo suelo, Jugador pj) {
		super(LETRA, suelo);
		this.suelo = suelo;
	}
	
	@Override
	public char getLetra() {
		return LETRA;
	}

	@Override
	public TipoUsable getTipo() {
		return TipoUsable.EXPLOSIVOS;
	}

	@Override
	public void utilizar(Jugador jugador) {
		Posicion actual = jugador.getPosicion();
		Posicion aRomper = new Posicion(0, 0);
		for(int i = -2; i < 3; i++) {
			for(int j = -2; j < 3; j++) {
				aRomper.set(actual.getX() + i, actual.getY() + j);
				suelo.destruirBloque(aRomper);
			}
		}
	}

	@Override
	public int getCosto() {
		return VALOR;
	}
}

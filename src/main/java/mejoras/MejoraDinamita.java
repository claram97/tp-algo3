package mejoras;

import jugador.Jugador;
import jugador.Posicion;
import terreno.Suelo;

public class MejoraDinamita extends MejoraDeTerreno {
	public static int VALOR = 20;
	public static char LETRA = 'X';
	
	private Suelo suelo;
	
	public MejoraDinamita(Suelo suelo) {
		super(MejoraDinamita.LETRA, suelo);
		this.suelo = suelo;
	}

	@Override
	public void utilizar(Jugador pj) {
		Posicion actual = pj.getPosicion();
		Posicion aRomper = new Posicion(0, 0);
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				aRomper.set(actual.getX() + i, actual.getY() + j);
				suelo.destruirBloque(aRomper);
			}
		}
	}

	@Override
	public char getLetra() {
		return LETRA;
	}

	@Override
	public TipoUsable getTipo() {
		return TipoUsable.DINAMITA;
	}

	@Override
	public int getCosto() {
		return VALOR;
	}
}

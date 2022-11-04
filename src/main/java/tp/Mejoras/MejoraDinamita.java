package tp.Mejoras;

import tp.Jugador;
import tp.Posicion;
import tp.Suelo;
import tp.Terreno;

public class MejoraDinamita extends MejoraDeTerreno {
	public static int VALOR = 2000;
	public static char LETRA = 'X';
	
	private Suelo suelo;
	
	public MejoraDinamita(char letra, Suelo suelo) {
		super(letra, suelo);
		this.suelo = suelo;
	}

	@Override
	public void utilizar(Jugador pj) {
		Posicion actual = pj.getPosicion();
		Posicion aRomper = new Posicion(0, 0);
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				aRomper.set(actual.getPosicionX() + i, actual.getPosicionY() + j);
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

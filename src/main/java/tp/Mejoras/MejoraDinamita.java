package tp.Mejoras;

import tp.Jugador;
import tp.Posicion;
import tp.Suelo;
import tp.Terreno;

public class MejoraDinamita extends MejoraDeTerreno {
	public static int VALOR = 2000;
	public static char LETRA = 'X';
	
	private Suelo suelo;
	private Jugador pj;
	
	public MejoraDinamita(char letra, Suelo suelo, Jugador pj) {
		super(letra, suelo, pj);
		this.pj = pj;
		this.suelo = suelo;
	}
		
	@Override
	public void utilizar() {
		Posicion actual = pj.getPosicion();
		Posicion aRomper = new Posicion(0, 0);
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				aRomper.set(actual.getPosicionX() + i, actual.getPosicionY() + j);
				suelo.destruirBloque(aRomper);
			}
		}
	}
}

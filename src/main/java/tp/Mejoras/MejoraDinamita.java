package tp.Mejoras;

import tp.Jugador;
import tp.Posicion;
import tp.Terreno;

public class MejoraDinamita extends MejoraDeTerreno {
	public static int VALOR = 2000;
	public static char LETRA = 'X';
	
	private Terreno terreno;
	private Jugador pj;
	
	public MejoraDinamita(char letra, Terreno terreno, Jugador pj) {
		super(letra, terreno, pj);
		this.pj = pj;
		this.terreno = terreno;
	}
		
	@Override
	public void utilizar() {
		Posicion actual = pj.getPosicion();
		Posicion aRomper = new Posicion(0, 0);
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				aRomper.set(actual.getPosicionX() + i, actual.getPosicionY() + j);
				terreno.romperBloque(aRomper);
			}
		}
	}
}

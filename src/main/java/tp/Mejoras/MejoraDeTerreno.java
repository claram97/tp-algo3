package tp.Mejoras;

import tp.Jugador;
import tp.Terreno;

public abstract class MejoraDeTerreno {
	public char letra;
	private Terreno terreno;
	private Jugador pj;
	
	public MejoraDeTerreno(char letra, Terreno terreno, Jugador pj) {
		super();
		this.letra = letra;
		this.terreno = terreno;
		this.pj = pj;
	}

	public abstract void utilizar();
	
}


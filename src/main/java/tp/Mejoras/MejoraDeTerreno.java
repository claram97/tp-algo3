package tp.Mejoras;

import tp.Jugador;
import tp.Suelo;
import tp.Terreno;

public abstract class MejoraDeTerreno {
	public char letra;
	private Jugador pj;
	private Suelo suelo;
	
	public MejoraDeTerreno(char letra, Suelo suelo, Jugador pj) {
		super();
		this.letra = letra;
		this.suelo = suelo;
		this.pj = pj;
	}

	public abstract void utilizar();
	
}


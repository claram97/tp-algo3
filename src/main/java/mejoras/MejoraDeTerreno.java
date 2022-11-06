package mejoras;

import jugador.Jugador;
import terreno.Suelo;
import terreno.Terreno;

public abstract class MejoraDeTerreno implements Usable{
	public char letra;
	private Suelo suelo;
	
	public MejoraDeTerreno(char letra, Suelo suelo) {
		super();
		this.letra = letra;
		this.suelo = suelo;
	}

	
}


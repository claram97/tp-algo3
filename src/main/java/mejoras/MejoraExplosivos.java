package mejoras;

import jugador.Jugador;
import terreno.Suelo;
import terreno.Terreno;

public class MejoraExplosivos extends MejoraDeTerreno {

	public MejoraExplosivos(char letra, Suelo suelo, Jugador pj) {
		super(letra, suelo);
		// TODO Auto-generated constructor stub
	}

	public static int VALOR = 5000;
	public static char LETRA = 'C';
	

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCosto() {
		return VALOR;
	}
}

package jugador;

import mejoras.MejoraDeTerreno;

public class AccionItemTerreno implements Accion{
	MejoraDeTerreno mejora;
	Jugador jugador;
	
	public AccionItemTerreno(Jugador pj,MejoraDeTerreno mejora) {
		super();
		this.jugador = pj;
		this.mejora = mejora;
	}

	@Override
	public boolean aplicar() {
		if(jugador.tieneUsable(mejora)) {
			mejora.utilizar(jugador);
			jugador.eliminarMejora(mejora);
			return true;
		}
		return false;
	}

}

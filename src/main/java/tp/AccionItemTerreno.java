package tp;

import tp.Mejoras.MejoraDeTerreno;

public class AccionItemTerreno implements Accion{
	MejoraDeTerreno mejora;
	Jugador jugador;
	
	public AccionItemTerreno(Jugador pj,MejoraDeTerreno mejora) {
		super();
		this.jugador = pj;
		this.mejora = mejora;
	}

	@Override
	public void aplicar() {
		if(jugador.tieneUsable(mejora)) {
			mejora.utilizar(jugador);
		}
	}

}

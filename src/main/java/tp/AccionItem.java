package tp;

import tp.Mejoras.MejoraDeJugador;
import tp.Mejoras.MejoraDeTerreno;

public class AccionItem implements Accion{
	private Jugador pj;
	private MejoraDeJugador mejora;
	
	public AccionItem(Jugador pj, MejoraDeJugador mejora) {
		this.pj = pj;
		this.mejora = mejora;
	}

	public void utilizarMejoraJugador(char letra) {
		int i = 0;
		boolean utilizado = false;
		while(i < this.pj.getMejoras().size() && !utilizado) {
			if(this.pj.getMejoras().get(i).letra == letra) {
				this.pj.getMejoras().get(i).utilizar(this.pj);
			}
		}
		this.pj.eliminarMejora(this.pj.getMejoras().get(i));
	}
			
	@Override
	public void aplicar() {
		mejora.utilizar(pj);
	}
}

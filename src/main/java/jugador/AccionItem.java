package jugador;

import mejoras.Usable;

public class AccionItem implements Accion{
	private Jugador pj;
	private Usable mejora;
	
	public AccionItem(Jugador pj, Usable mejora) {
		this.pj = pj;
		this.mejora = mejora;
	}

	@Override
	public boolean aplicar() {
		if(pj.tieneUsable(mejora)) {
			mejora.utilizar(pj);
			pj.eliminarMejora(mejora);
			return true;
		}
		return false;
	}
}

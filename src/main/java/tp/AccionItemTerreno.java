package tp;

import tp.Mejoras.MejoraDeTerreno;

public class AccionItemTerreno implements Accion{
	MejoraDeTerreno mejora;
	
	public AccionItemTerreno(MejoraDeTerreno mejora) {
		super();
		this.mejora = mejora;
	}



	@Override
	public void aplicar() {
		mejora.utilizar();
	}

}

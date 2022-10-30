package tp.Mejoras;

import tp.Jugador;

public class MejoraCapacidadDelTanque extends MejoraInstantanea {
	
	public MejoraCapacidadDelTanque(int cantidad, int valor) {
		if(cantidad > 0 && valor > 0) {
			super.cantidadAMejorar = cantidad;
			super.valor = valor;
		}
		else {
			//throw an exception
		}
	}
	public void utilizar(Jugador jugador) {
		jugador.setCapacidadDelTanque(super.cantidadAMejorar);
	}
}

package mejoras;

import jugador.Jugador;

public class MejoraCapacidadDelTanque extends MejoraInstantanea {
	private double cantidad;
	
	public MejoraCapacidadDelTanque(double cantidad, int valor) {
		if(cantidad > 0 && valor > 0) {
			super.cantidadAMejorar = (int) cantidad;
			super.valor = valor;
			this.cantidad = cantidad;
		}
		else {
			super.cantidadAMejorar = 0;
			super.valor = 0;
			this.cantidad = 0;
		}
	}
	
	public void utilizar(Jugador jugador) {
		jugador.ampliarTanque(this.cantidad);
	}
	
	@Override
	public int getValor() {
		return this.valor;
	}
}

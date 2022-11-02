package tp;


public class AccionMovimiento implements Accion{
	//No se si sera mucho que reciba a ambos, pero no se me ocurre otra forma por ahora.
	private Jugador pj;
	Suelo suelo;
	PisoSuperior tiendas;
	int dx;
	int dy;
	
	public AccionMovimiento(Jugador pj, Suelo suelo, PisoSuperior tiendas, int dx, int dy) {
		this.pj = pj;
		this.suelo = suelo;
		this.tiendas = tiendas;
		this.dx = dx;
		this.dy = dy;
	}

	private boolean chocaArriba() {
		if(pj.getY() == 0) {
			return false;
		}
			//No se si son punteros o que pero si ponia Posicion actual = pj.getPosicion()
			//Funcionaba como si actual fuera un puntero a pj.
		Posicion arriba = new Posicion(pj.getX(), pj.getY() - 1);
		if(suelo.casilleroVacio(arriba)) {
				return false;
		}

		return true;
	}

	private void caer() {
		if(pj.getY() < Main.ALTURA) {
			Posicion debajo = new Posicion(pj.getX(), pj.getY() + 1);
			while(suelo.casilleroVacio(debajo) && pj.getY() < Main.ALTURA - 2) {
				pj.setY(pj.getY() + 1);
				debajo.setPosicionY(debajo.getPosicionY() + 1);
			}
		}
	}
	
	private void taladrar(Posicion pos) {
		if(suelo.casilleroVacio(pos) || suelo.getBloque(pos).getTipo() == TipoDeBloque.TIERRA) {
			return;
		}
		if(this.tiendas != null) {
			if(pj.getY() == 0 && tiendas.colisionEntidad(pos).getTipoEntidad() == TipoEntidad.TIENDA) {
				return;
			}
		}
		pj.agregarInventario(suelo.getBloque(pos));
	}
	
	public void aplicar() {		
		Posicion nueva = new Posicion(pj.getX(), pj.getY());
		if(this.dy != 0) {
			if(this.dy > 0 || !chocaArriba()) {
				nueva.setPosicionY(this.pj.getY() + dy); //Si se le pasa un valor negativo deberia funcionar igual.
				//Falta excepcion para que no se escape por los bordes
			}
		}
		if(this.dx != 0) {
			nueva.setPosicionX(this.pj.getX() + dx);
		}
		
		taladrar(nueva);
		pj.setX(nueva.getPosicionX());
		pj.setY(nueva.getPosicionY());
		
		if(pj.getY() == 0 && this.tiendas != null) {
			if(tiendas.colisionEntidad(pj.getPosicion()).getTipoEntidad() == TipoEntidad.TIENDA) {
				tiendas.colisionEntidad(pj.getPosicion()).interactuar(pj);
			}
		}
		
		suelo.destruirBloque(pj.getPosicion());
		
		if(this.dy >= 0) {
			caer();
		}
	}
}

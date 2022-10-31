package tp;


public class AccionJugador {
	//No se si sera mucho que reciba a ambos, pero no se me ocurre otra forma por ahora.
	private Jugador pj;
	private Terreno terreno;
	int dx;
	int dy;
	
	public AccionJugador(Jugador pj, Terreno terreno, int dx, int dy) {
		this.pj = pj;
		this.terreno = terreno;
		this.dy = dy;
		this.dx = dx;
	}
	
	private boolean chocaArriba() {
		if(pj.getY() == 0) {
			return false;
		}
			//No se si son punteros o que pero si ponia Posicion actual = pj.getPosicion()
			//Funcionaba como si actual fuera un puntero a pj.
		Posicion arriba = new Posicion(pj.getX(), pj.getY() - 1);
		if(terreno.casilleroVacio(arriba)) {
				return false;
		}

		return true;
	}

	private void caer() {
		if(pj.getY() < Main.ALTURA) {
			Posicion debajo = new Posicion(pj.getX(), pj.getY() + 1);
			while(terreno.casilleroVacio(debajo) && pj.getY() < Main.ALTURA - 2) {
				pj.setY(pj.getY() + 1);
				debajo.setPosicionY(debajo.getPosicionY() + 1);
			}
		}
	}
	
	private void taladrar(Posicion pos) {
		if(terreno.casilleroVacio(pos) || terreno.devolverBloque(pos).getTipo() == TipoDeBloque.TIERRA) {
			return;
		}
		
		if(pj.getY() == 0 && terreno.getSuelo()[pj.getX()].getTipoEntidad() == TipoEntidad.TIENDA) {
			return;
		}
		
		pj.agregarInventario(terreno.devolverBloque(pos));
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
		
		if(pj.getY() == 0) {
			if(terreno.getSuelo()[pj.getX()].getTipoEntidad() == TipoEntidad.TIENDA) {
				terreno.getSuelo()[pj.getX()].interactuar(pj);
			}
		}
		
		if(this.dy >= 0) {
			caer();
		}
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
	
	//Estas hay que ver donde las guardamos o qué :P
	public void utilizarMejoraTerreno(char letra) {
		
	}
}

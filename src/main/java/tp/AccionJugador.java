package tp;

public class AccionJugador {
	//No se si sera mucho que reciba a ambos, pero no se me ocurre otra forma por ahora.
	private Jugador pj;
	private Terreno terreno;
	
	public AccionJugador(Jugador pj, Terreno terreno) {
		this.pj = pj;
		this.terreno = terreno;
	}
	
	private boolean chocaArriba() {
		if(pj.getY() > 0) {
			//No se si son punteros o que pero si ponia Posicion actual = pj.getPosicion()
			//Funcionaba como si actual fuera un puntero a pj.
			Posicion arriba = new Posicion(pj.getX(), pj.getY() - 1);
			if(terreno.casilleroVacio(arriba)) {
				return false;
			}
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
		if(terreno.casilleroVacio(pos) || terreno.devolverBloque(pos).getTipo() == tipoDeBloque.TIERRA) {
			return;
		}
		
		pj.agregarInventario(terreno.devolverBloque(pos));
	}
	
	public void moverPJ(char movimiento) {
		Posicion nueva = new Posicion(pj.getX(), pj.getY());
		
		if(movimiento == 'W' && pj.getY() > 0 && !chocaArriba()) {
			nueva.setPosicionY(pj.getY() - 1);
		}
		else if(movimiento == 'A' && pj.getX() > 0) {
			nueva.setPosicionX(pj.getX() - 1);
		}
		else if(movimiento == 'S' && pj.getY() < Main.ALTURA) {
			nueva.setPosicionY(pj.getY() + 1);
		}
		else if(movimiento == 'D' && pj.getX() < Main.ANCHO) {
			nueva.setPosicionX(pj.getX() + 1);
		} else {
			//Excepcion.
		}
		
		taladrar(nueva);
		
		pj.setX(nueva.getPosicionX());
		pj.setY(nueva.getPosicionY());
		
		if(movimiento != 'W') {
			caer();
		}
	}
		
	
}

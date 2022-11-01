package tp;

public class Posicion {
	private int posicionX;
	private int posicionY;
	
	public Posicion(int posicionX, int posicionY) {
		if(posicionX < 0 || posicionY < 0) {
			//throw an exception
		}
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public Posicion get() {
		return this;
	}
	
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	
	public void set(int posicionX, int posicionY) {
		this.setPosicionX(posicionX);
		this.setPosicionY(posicionY);
	}
	
	public boolean esPosicionIgual(Posicion pos2) {
		if(this.posicionX == pos2.posicionX && this.posicionY == pos2.posicionY) {
			return true;
		}
		return false;
	}
	
	
}

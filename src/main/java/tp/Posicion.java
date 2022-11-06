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
	
	public int getX() {
		return posicionX;
	}

	public int getY() {
		return posicionY;
	}

	public Posicion get() {
		return this;
	}
	
	public void setX(int posicionX) {
		if(posicionX < 0) {
			//throw an exception
		}
		this.posicionX = posicionX;
	}
	
	public void setY(int posicionY) {
		if(posicionY < 0) {
			//throw an exception
		}
		this.posicionY = posicionY;
	}
	
	
	public void set(int posicionX, int posicionY) {
		if(posicionX < 0 || posicionY < 0) {
			//throw an exception
		}
		else {
			this.setX(posicionX);
			this.setY(posicionY);
		}
	}
	
	public boolean esPosicionIgual(Posicion pos2) {
		if(this.posicionX == pos2.posicionX && this.posicionY == pos2.posicionY) {
			return true;
		}
		return false;
	}
	
	
}

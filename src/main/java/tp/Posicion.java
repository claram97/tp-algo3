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

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	
	
}

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
	
	//No sé si es lo mejor que pude hacer :P
	public int getCoordenada(String posicion) {
		if(posicion == "X") {
			return this.posicionX;
		}
		else if(posicion == "Y") {
			return this.posicionY;
		}
		return -1; //este -1 está porque aun no le puse una excepción :P
		//throw an exception
	}

	//No sé si es lo mejor que pude hacer :P
	public void setCoordenada(String posicion,int valor) {
		if((posicion != "X" && posicion != "Y") || valor < 0) {
			//throw an exception
		}
		if(posicion == "X") {
			this.posicionX = valor;
		}
		else if(posicion == "Y") {
			this.posicionY = valor;
		}
	}
}

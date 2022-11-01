package tp;

import java.util.Random;

public class Suelo {
	Bloque[][] bloques;
	private int alto;
	private int ancho;
	
	private Bloque ponerBloque() {
		Random rand = new Random();
		int valor = rand.nextInt(100);
		
		if(valor > 0 && valor < 60) {
			return new Tierra();
		} else if(valor >= 60 && valor < 80) {
			return FabricaDeMinerales.crear(TipoDeBloque.COBRE);
		} else if(valor >= 80 && valor < 92) {
			return FabricaDeMinerales.crear(TipoDeBloque.PLATA);
		} else if(valor >= 92 && valor < 98) {
			return FabricaDeMinerales.crear(TipoDeBloque.ORO);
		} else {
			return FabricaDeMinerales.crear(TipoDeBloque.DIAMANTE);
		}
	}
	
	
	public Suelo(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		
		var bloques = new Bloque[alto][ancho];
		
		for(int k = 0; k < this.ancho; k++) {
			bloques[0][k] = new Aire();
		}
		
		for(int i = 1; i < alto; i++) {
			for(int j = 0; j < ancho; j++) {
				bloques[i][j] = ponerBloque();
			}
		}
		
		this.bloques = bloques;
	}
	
	public Bloque getBloque(Posicion pos) {
		return(bloques[pos.getPosicionY()][pos.getPosicionX()]);
	}
	
	public void destruirBloque(Posicion pos) {
		bloques[pos.getPosicionY()][pos.getPosicionX()] = new Aire();
	}
	
	public boolean casilleroVacio(Posicion posicion) {
		if(posicion.getPosicionY() == this.alto - 1) {
			return false;
		}
		
		return(bloques[posicion.getPosicionY()][posicion.getPosicionX()].getTipo() == TipoDeBloque.AIRE);
	}
	
	
}

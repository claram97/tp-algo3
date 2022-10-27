package tp;

import java.util.Random;

public class Terreno {
	private Bloque[][] terreno;
	private int ancho;
	private int alto;
	
	private Bloque ponerBloque() {
		Random rand = new Random();
		int valor = rand.nextInt(100);

		if(valor > 0 && valor < 35) {
			return new Tierra();
		} else if(valor >= 35 && valor < 60) {
			return FabricaDeMinerales.crear(tipoDeBloque.COBRE);
		} else if(valor >= 60 && valor < 80) {
			return FabricaDeMinerales.crear(tipoDeBloque.PLATA);
		} else if(valor >= 80 && valor < 90) {
			return FabricaDeMinerales.crear(tipoDeBloque.ORO);
		} else {
			return FabricaDeMinerales.crear(tipoDeBloque.DIAMANTE);
		}
	}
	
	public boolean casilleroVacio(Posicion posicion) {
		if(posicion.getPosicionY() == this.alto - 1) {
			return false;
		}
		
		return(terreno[posicion.getPosicionY()][posicion.getPosicionX ()].getTipo() == tipoDeBloque.AIRE);
	}
	
	public Bloque devolverBloque(Posicion pos) {
		return(terreno[pos.getPosicionY()][pos.getPosicionX()]);
	}
	
	public Terreno(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		
		terreno = new Bloque[alto][ancho];
		for(int k = 0; k < ancho; k++) {
			terreno[0][k] = new Aire();
		}
		for(int i = 1; i < alto; i++) {
			for(int j = 0; j < ancho; j++) {
				terreno[i][j] = ponerBloque();
			}
		}
	}
	
	//No se si es lo mejor manejar asi al pj pero con la implementacion actual
	//habria que hacer otro loop para borrar al caracter del turno anterior.
	public void imprimirTerreno(Jugador pj) {
		int x = pj.getX();
		int y = pj.getY();
		
		for(int i = 0; i < this.alto; i++) {
			for(int j = 0; j < this.ancho; j++) {
				if(j == x && i == y) {
					System.out.print(' ');
					System.out.print(pj.getLetra());
					System.out.print(' ');
				} else {
				System.out.print(' ');
				System.out.print(terreno[i][j].getLetra());
				System.out.print(' ');
				}
			}
			System.out.print("\n");
		}
		System.out.print('\n');
	}
	
	//No se porque esto queda bien asi invertido aaaaaaa.
	public void romperBloque(Posicion posicion) {
		terreno[posicion.getPosicionY()][posicion.getPosicionX()] = new Aire();
	}
	
	
	
}

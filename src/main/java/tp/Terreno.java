package tp;

import java.util.Random;

public class Terreno {
	private Bloque[][] terreno;
	
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
		return(terreno[posicion.getPosicionX()][posicion.getPosicionY()] instanceof Aire);
	}
	
	public Terreno() {
		terreno = new Bloque[10][10];
		for(int i = 0; i < 10; i++) {
			terreno[0][i] = new Aire();
		}
		for(int i = 1; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				terreno[i][j] = ponerBloque();
			}
		}
	}
	
	//No se si es lo mejor manejar asi al pj pero con la implementacion actual
	//habria que hacer otro loop para borrar al caracter del turno anterior.
	public void imprimirTerreno(Jugador pj) {
		int x = pj.getX();
		int y = pj.getY();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
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
	
	public void romperBloque(int x, int y) {
		terreno[x][y] = new Aire();
	}
	
	
	
}

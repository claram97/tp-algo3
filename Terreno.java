package tp;

import tp.Bloque.tipoDeMineral;

public class Terreno {
	private Bloque[][] terreno;
	
	public Terreno() {
		terreno = new Bloque[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				terreno[i][j] = new Mineral(tipoDeMineral.BRONCE);
			}
		}
		for(int i = 5; i < 8; i++) {
			for(int j = 5; j < 8; j++) {
				terreno[i][j] = new Mineral(tipoDeMineral.COBRE);
			}
		}
		for(int i = 8; i < 10; i++) {
			for(int j = 8; j < 10; j++) {
				terreno[i][j] = new Mineral(tipoDeMineral.PLATA);
			}
		}
	}
	
	public void imprimirTerreno() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(terreno[i][j].getLetra());
			}
			System.out.print("\n");
		}
	}
}

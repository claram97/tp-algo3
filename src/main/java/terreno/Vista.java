package terreno;

import jugador.Jugador;
import jugador.Posicion;
import mejoras.Usable;
import minerales.Mineral;

public class Vista {
	private PisoSuperior tiendas;
	private Suelo suelo;
	private Jugador pj;
	private int ancho;
	private int alto;

	public Vista(PisoSuperior tiendas, Suelo suelo, Jugador pj, int ancho, int alto) {
		if(tiendas == null || suelo == null || pj == null) {
			//throw an exception
		}
		
		this.tiendas = tiendas;
		this.suelo = suelo;
		this.pj = pj;
		this.ancho = ancho;
		this.alto = alto;
	}


	public void imprimirTerreno(Jugador pj) {
		int x = pj.getX();
		int y = pj.getY();
		
		for(int i = 0; i < this.ancho; i++) {
			System.out.print(' ');
			if(pj.getPosicion().getX() == i && pj.getPosicion().getY() == 0) {
				System.out.print(this.pj.getLetra());
			} else{
				System.out.print(tiendas.devolverTiendas().get(i).getLetra());
			}
			System.out.print(' ');
		}
		System.out.print('\n');
		
		for(int i = 1; i < this.alto; i++) {
			for(int j = 0; j < this.ancho; j++) {
				if(x > 0 && (j == x && i == y)) {
					System.out.print(' ');
					System.out.print(pj.getLetra());
					System.out.print(' ');
				} else {
					System.out.print(' ');
					System.out.print(suelo.getBloque(new Posicion(j, i)).getLetra());
					System.out.print(' ');
				}
			}
			System.out.print("\n");
		}
		System.out.print('\n');
		
		System.out.print("Nivel de nafta: " + String.format("%.02f", pj.nivelDeCombustible()));
		System.out.println("\t\t Nivel de vida: " + pj.getHp());
		System.out.println("Dinero: $" + pj.getDinero());
		System.out.print("Minerales recolectados: ");
		for(Mineral actual: pj.getMinerales()) {
			System.out.print('|');
			System.out.print(actual.getLetra());
			System.out.print('|');
		}
		System.out.print('\n');
		
		System.out.print("Consumibles en el inventario: ");
		for(Usable actual: pj.getMejoras()) {
			System.out.print('|');
			System.out.print(actual.getLetra());
			System.out.print('|');
		}
		System.out.print('\n');
	}
		
}

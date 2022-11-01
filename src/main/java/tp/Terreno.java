package tp;

public class Terreno {
	private PisoSuperior tiendas;
	private Suelo suelo;
	private Jugador pj;
	private int ancho;
	private int alto;

	public Terreno(PisoSuperior tiendas, Suelo suelo, Jugador pj, int ancho, int alto) {
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
			if(pj.getPosicion().getPosicionX() == i && pj.getPosicion().getPosicionY() == 0) {
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
	}
	
}

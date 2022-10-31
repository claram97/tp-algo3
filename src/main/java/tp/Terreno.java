package tp;

import java.util.Random;

public class Terreno {
	private Entidad[] suelo;
	private Bloque[][] terreno;
	private int ancho;
	private int alto;
	
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
	
	public boolean casilleroVacio(Posicion posicion) {
		if(posicion.getPosicionY() == this.alto - 1) {
			return false;
		}
		
		return(terreno[posicion.getPosicionY()][posicion.getPosicionX ()].getTipo() == TipoDeBloque.AIRE);
	}
	
	public Bloque devolverBloque(Posicion pos) {
		return(terreno[pos.getPosicionY()][pos.getPosicionX()]);
	}
	
	public Terreno(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		
		terreno = new Bloque[alto][ancho];
		suelo = new Entidad[ancho];
		for(int k = 0; k < ancho; k++) {
			suelo[k] = new Aire();
			terreno[0][k] = new Aire();
		}
		
		var ypf = new EstacionDeServicio(this.ancho);
		this.suelo[ypf.getPosicion().getPosicionX()] = ypf;
		var mecanico = new EstacionDeReparacion(this.ancho);
		this.suelo[mecanico.getPosicion().getPosicionX()] = mecanico;
		var tiendita = new TiendaDeMejoras(ancho);
		this.suelo[tiendita.getPosicion().getPosicionX()] = tiendita;
		
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
		
		for(int k = 0; k < this.ancho; k++) {
			if(y == 0 && k == x) {
				System.out.print(' ');
				System.out.print(pj.getLetra());
				System.out.print(' ');
			} else {
				System.out.print(' ');
				System.out.print(suelo[k].getLetra());
				System.out.print(' ');
			}
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
	
	public Entidad[] getSuelo(){
		return this.suelo;
	}
	
	
}

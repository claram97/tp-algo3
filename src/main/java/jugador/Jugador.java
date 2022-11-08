package jugador;

import minerales.Mineral;
import terreno.Bloque;

public class Jugador implements Bloque {
	private static final int DINERO_INICIAL = 20;
	private static final char LETRA = '&';
	
	private Inventario inventario;
	private Nave nave;
	private Posicion posicion;
	private int dinero;
	private int altoTerreno;
	private int anchoTerreno;
	
	//Cuidado con los limites a las pos, las pruebas usan y != 0
	public Jugador(int posX, int posY,int altoTerreno, int anchoTerreno) {
		if(posX < 0 || altoTerreno < 10 || anchoTerreno < 10) {
			return;
		}
		if(posY > altoTerreno || posX > altoTerreno) {
			return;
		}
		
		this.posicion = new Posicion(posX, posY);
		this.inventario = new Inventario();
		this.nave = new Nave();
		this.dinero = DINERO_INICIAL;
		
		this.altoTerreno = altoTerreno;
		this.anchoTerreno = anchoTerreno;
	}	
	
	//------------------------------------------------
	//          		DINERO
	//------------------------------------------------
	public boolean hacerCompra(double gasto) {
		if(gasto > this.dinero) {
			return false;
		}
		
		this.dinero -= gasto;
		return true;
	}
	
	public void setDinero(int dinero) {
		if(dinero < 0) {
			//throw an exception
		}
		this.dinero = dinero;
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void venderMinerales() {
		this.dinero = inventario.venderMinerales();
	}
	
	//------------------------------------------------
	//          		POSICION
	//------------------------------------------------
	public char getLetra() {
		return Jugador.LETRA;
	}
	
	public int getX() {
		return this.posicion.getX();
	}
	
	public int getY() {
		return this.posicion.getY();
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public void setY(int i) {
		if(i <= this.altoTerreno) {
			this.posicion.setY(i);
		}
	}

	public void setX(int i) {
		if(i <= this.anchoTerreno) {
			this.posicion.setX(i);
		}
	}
	
	//------------------------------------------------
	//          		DEMAS
	//------------------------------------------------

	public void observarBloque(Bloque bloque) {
		if(bloque instanceof Mineral) {
			inventario.agregarInventario((Mineral)bloque);
		}
	}
	
	public Inventario getInventario() {
		return this.inventario;
	}
	
	public Nave getNave() {
		return this.nave;
	}

	public void ampliarInventario(int nuevoMax) {
		inventario.setMaxInventario(nuevoMax);
		
	}

	public void ampliarTanque(double cantidad) {
		nave.setCapacidadDelTanque(cantidad);
	}

	public void ampliarMaxHP(int cantidad) {
		if(cantidad > nave.getMaxHP()) {
			nave.setMaxHP(cantidad);			
		}
	}

	public boolean noPuedeContinuar() {
		return (nave.seEstrello() || nave.seQuedoSinCombustible());
	}


}


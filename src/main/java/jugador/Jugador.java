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
	//Entonces cambiá las pruebas xD
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
	//Devuelve true si se pudo efectuar la compra y false en caso contrario.
	public boolean hacerCompra(double gasto) {
		if(gasto > this.dinero) {
			return false;
		}
		
		this.dinero -= gasto;
		return true;
	}
	
	//Setea la cantidad de dinero actual.
	public void setDinero(int dinero) {
		if(dinero < 0) {
			//throw an exception
		}
		this.dinero = dinero;
	}
	
	//Devuelve el dinero actual.
	public int getDinero() {
		return this.dinero;
	}
	
	//Vende los minerales.
	public void venderMinerales() {
		this.dinero = inventario.venderMinerales();
	}
	
	//------------------------------------------------
	//          		POSICION
	//------------------------------------------------
	
	//Devuelve la letra que representa a la clase.
	public char getLetra() {
		return Jugador.LETRA;
	}
	
	//Devuelve la coordenada X del Jugador.
	public int getX() {
		return this.posicion.getX();
	}
	
	//Devuelve la coordenada Y del Jugador.
	public int getY() {
		return this.posicion.getY();
	}
	
	//Devuelve la posicion actual del Jugador.
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	//Setea la componente Y del personaje si está entre 0 y el alto del terreno
	public void setY(int i) {
		if(i >= 0 && i <= this.altoTerreno) {
			this.posicion.setY(i);
		}
	}

	//Setea la componente Y del personaje si está entre 0 y el ancho del terreno
	public void setX(int i) {
		if(i <= this.anchoTerreno) {
			this.posicion.setX(i);
		}
	}
	
	public int getLimiteAlto() {
		return this.altoTerreno;
	}
	
	public int getLimiteAncho() {
		return this.anchoTerreno;
	}
	
	//------------------------------------------------
	//          		DEMAS
	//------------------------------------------------

	//Permite agregar al inventario los bloques si son minerales.
	public void observarBloque(Bloque bloque) {
		if(bloque instanceof Mineral) {
			inventario.agregarInventario((Mineral)bloque);
		}
	}
	
	//Devuelve el inventario.
	public Inventario getInventario() {
		return this.inventario;
	}
	
	//Devuelve la nave.
	public Nave getNave() {
		return this.nave;
	}

	//Permite ampliar el inventario.
	public void ampliarInventario(int nuevoMax) {
		inventario.setMaxInventario(nuevoMax);
	}

	//Permite ampliar el tanque.
	public void ampliarTanque(double cantidad) {
		nave.setCapacidadDelTanque(cantidad);
	}

	//Permite ampliar el HP max.
	public void ampliarMaxHP(int cantidad) {
		if(cantidad > nave.getMaxHP()) {
			nave.setMaxHP(cantidad);			
		}
	}

	//Devuelve true si no puede continuar, false en caso contrario.
	public boolean noPuedeContinuar() {
		return (nave.seEstrello() || nave.seQuedoSinCombustible());
	}

}


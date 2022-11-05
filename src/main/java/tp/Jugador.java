package tp;

import java.util.ArrayList;
import java.util.List;

import tp.Mejoras.Usable;

public class Jugador implements Bloque {
	private static int COMBUSTIBLE_INICIAL = 6;
	private static int MAX_COMBUSTIBLE_INICIAL = 10;
	private static int HP_INICIAL = 10;
	private static int MAX_HP_INICIAL = 10;
	private static int DINERO_INICIAL = 20;
	private static int RESISTENCIA_INICIAL = 10; //no se que valor le vamos a poner a esto, después lo charlamos bien :P
	private static int MAX_INVENTARIO_INICIAL = 7;
	
	int hp;
	int nivelCombustible;
	int dinero;
	List<Mineral> mineralesRecolectados;
	Posicion posicion;
	int capacidadTanque;
	int resistencia; //a mayor resistencia, menos vida pierde, después lo implementamos bien :P
	int maxInventario;
	int maxHP;
	List<Usable> mejoras;
	
	public Jugador(int posX, int posY) {
		//Faltaria la excepcion para tamaño terreno
		this.nivelCombustible = Jugador.COMBUSTIBLE_INICIAL;
		this.capacidadTanque = Jugador.MAX_COMBUSTIBLE_INICIAL;
		this.hp = Jugador.HP_INICIAL;
		this.maxHP = Jugador.MAX_HP_INICIAL;
		this.dinero = Jugador.DINERO_INICIAL;
		this.resistencia = Jugador.RESISTENCIA_INICIAL; 
		this.maxInventario = Jugador.MAX_INVENTARIO_INICIAL;
		this.mejoras = new ArrayList<>();
		this.mineralesRecolectados = new ArrayList<>();
		this.posicion = new Posicion(posX, posY);
	}
	
	
	//------------------------------------------------
	//          MINERALES / INVENTARIO
	//------------------------------------------------
	
	//Puse que reciba minerales porque sino le podrías pasar cualquier bloque, como jugador o tierra
	//Si bien eso lo chequeabas en otro lado, siento que no es lo correcto, así que lo cambié
	public void venderMinerales() {
		for(Mineral mineral: mineralesRecolectados) {
			this.dinero += mineral.getPrecio();
		}
		this.mineralesRecolectados.clear();
	}
	
	public void agregarInventario(Mineral mineral) {
		if(mineralesRecolectados.size() < this.maxInventario) {
			mineralesRecolectados.add(mineral);
		}
	}
	
	public void mostrarInventario() {
		for(Bloque b: mineralesRecolectados) {
			System.out.print(" | " + b.getLetra());
		}
		System.out.print('\n');
	}
	
	public int getCantidadDeMinerales() {
		return this.mineralesRecolectados.size();
	}

	//------------------------------------------------
	//          INTERFAZ BLOQUE
	//------------------------------------------------
	
	public int getPrecio() {
		return -1;
	}

	public char getLetra() {
		return '&';
	}

	//------------------------------------------------
	//          	POSICION
	//------------------------------------------------
	
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
		this.posicion.setPosicionY(i);
	}

	public void setX(int i) {
		this.posicion.setPosicionX(i);
	}

	
	//------------------------------------------------
	//          	COMBUSTIBLE
	//------------------------------------------------
	
	public boolean seQuedoSinCombustible() {
		return this.nivelCombustible <= 0;
	}
	
	public int nivelDeCombustible() {
		return this.nivelCombustible;
	}

	public int getCapacidadTanque() {
		return this.capacidadTanque;
	}
	
	public int getNivelCombustible() {
		return this.nivelCombustible;
	}
	
	public void cargarCombustible(int cantidadCombustible, int cantidadDePlata) {
		int faltante = this.capacidadTanque - this.nivelCombustible;
		//Ternario de abajo:
		//Si faltante es menor a cantidadCombustible --> cantidadCargar = faltante.
		//Si cantidad de combustible es menor --> cantidadCargar = cantidadCombustible.
		int cantidadCargar = faltante < cantidadCombustible ? faltante: cantidadCombustible;
		if(hacerCompra(this.calcularGasto(cantidadCargar, cantidadCombustible, cantidadDePlata))) {
			this.nivelCombustible += cantidadCargar;
		}
	}
	
	//Estas funciones actualizan el máximo y el nivel actual también, viola el SRP?
	public void setCapacidadDelTanque(int capacidad) {
		if(capacidad > this.capacidadTanque) {
			this.capacidadTanque = capacidad;
			this.nivelCombustible = capacidad;
		}
		else {
			//throw exception
		}
	}
	
	
	
	//------------------------------------------------
	//          		DINERO
	//------------------------------------------------
	
	private int calcularGasto(int cantidadCargada, int cantidadCombustible, int cantidadDePlata) {
		if(cantidadCargada <= 0) {
			return 0;
		}
		return (cantidadCargada * cantidadDePlata) / cantidadCombustible;
	}
	
	
	public boolean hacerCompra(int gasto) {
		if(gasto > this.dinero) {
			return false;
		}
		
		this.dinero -= gasto;
		return true;
	}
	
	//------------------------------------------------
	//          		HP
	//------------------------------------------------
	
	public boolean seEstrello() {
		return this.hp == 0;
	}


	public int getHp() {
		return hp;
	}

	public int getMaxHP() {
		return maxHP;
	}
	
	public void repararDmg(int vidaSumar) {
		this.hp += vidaSumar;
	}
	
	public void setMaxVida(int maxVida) {
		if(maxVida > this.maxHP) {
			this.maxHP = maxVida;
			this.hp = maxVida;
		}
		else {
			//throw exception
		}
	}
	
	public void agregarHP(int healthPoints) {
		if((this.hp + healthPoints) > this.maxHP) {
			this.hp = this.maxHP;
		}
		else{
			this.hp += healthPoints;
		}
	}
	
	//------------------------------------------------
	//          		MEJORAS
	//------------------------------------------------

	
	public List<Usable> getMejoras() {
		return this.mejoras;
	}
	
	public boolean tieneUsable(Usable item) {
		for(Usable u :this.mejoras) {
			if(u.getTipo() == item.getTipo()) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarUsable(Usable item) {
		this.mejoras.add(item);
	}
	

	public void setMaxInventario(int maxInventario) {
		if(maxInventario > this.maxInventario) {
			this.maxInventario = maxInventario;
		}
		else {
			//throw exception
		}
	}
	
	public void eliminarMejora(Usable mejora) {
		if(this.mejoras.contains(mejora)) {
			mejoras.remove(mejora);
		}
	}
	
	public void setResistencia(int resistencia) {
		if(resistencia > this.resistencia) {
			this.resistencia = resistencia;
		}
		else {
			//throw exception
		}
	}
	
	public void gastarCombustible(int cantidad) {
		if(cantidad <= 0) {
			//throw exception
		}
		if(cantidad <= this.nivelCombustible){
			this.nivelCombustible -= cantidad;
		}
	}
	
	public void recibirDanio(int danio) {
		if(danio < 0) {
			//throw an exception
		}
		else if(danio > this.hp) {
			this.hp = 0;	
		}
		else{
			this.hp -= danio;
		}
	}

}


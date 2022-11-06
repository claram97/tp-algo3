package jugador;

import java.util.ArrayList;
import java.util.List;

import mejoras.Usable;
import minerales.Mineral;
import terreno.Bloque;

public class Jugador implements Bloque {
	private static final int COMBUSTIBLE_INICIAL = 6;
	private static final int MAX_COMBUSTIBLE_INICIAL = 10;
	private static final int HP_INICIAL = 10;
	private static final int MAX_HP_INICIAL = 10;
	private static final int DINERO_INICIAL = 20;
	private static final int MAX_INVENTARIO_INICIAL = 7;
	private static final char LETRA = '&';
	
	private int hp;
	private float nivelCombustible;
	private int dinero;
	private List<Mineral> mineralesRecolectados;
	private Posicion posicion;
	private int capacidadTanque;
	private int maxInventario;
	private int maxHP;
	private List<Usable> mejoras;
	private int altoTerreno;
	private int anchoTerreno;
	
	public Jugador(int posX, int posY,int altoTerreno, int anchoTerreno) {
		if(posX < 0 || posY != 0 || altoTerreno < 10 || anchoTerreno < 10) {
			//throw an exception
		}
		if(posY > altoTerreno || posX > altoTerreno) {
			//throw an exception
		}
		
		this.nivelCombustible = Jugador.COMBUSTIBLE_INICIAL;
		this.capacidadTanque = Jugador.MAX_COMBUSTIBLE_INICIAL;
		this.hp = Jugador.HP_INICIAL;
		this.maxHP = Jugador.MAX_HP_INICIAL;
		this.dinero = Jugador.DINERO_INICIAL;
		this.maxInventario = Jugador.MAX_INVENTARIO_INICIAL;
		this.mejoras = new ArrayList<>();
		this.mineralesRecolectados = new ArrayList<>();
		this.posicion = new Posicion(posX, posY);
		this.altoTerreno = altoTerreno;
		this.anchoTerreno = anchoTerreno;
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
		if(this.mineralesRecolectados.size() > 0) {
			for(Mineral mineral: mineralesRecolectados) {
				System.out.print(" | " + mineral.getLetra());
			}
			System.out.print('\n');
		}
		if(this.mineralesRecolectados.size() == 0) {
			System.out.println("Inventario vacío");
		}
	}
	
	public int getCantidadDeMinerales() {
		return this.mineralesRecolectados.size();
	}

	//------------------------------------------------
	//          INTERFAZ BLOQUE
	//------------------------------------------------
	

	public char getLetra() {
		return Jugador.LETRA;
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
	//          	COMBUSTIBLE
	//------------------------------------------------
	
	public boolean seQuedoSinCombustible() {
		return this.nivelDeCombustible() <= 0;
	}
	
	public float nivelDeCombustible() {
		return this.nivelCombustible;
	}

	public float getCapacidadTanque() {
		return this.capacidadTanque;
	}
	
	public void cargarCombustible(float cantidadCombustible, float cantidadDePlata) {
		float faltante = this.capacidadTanque - this.nivelCombustible;
		//Ternario de abajo:
		//Si faltante es menor a cantidadCombustible --> cantidadCargar = faltante.
		//Si cantidad de combustible es menor --> cantidadCargar = cantidadCombustible.
		float cantidadCargar = faltante < cantidadCombustible ? faltante: cantidadCombustible;
		if(hacerCompra(this.calcularGasto(cantidadCargar, cantidadCombustible, cantidadDePlata))) {
			this.nivelCombustible += cantidadCargar;
		}
	}
	
	//Estas funciones actualizan el máximo y el nivel actual también, viola el SRP?
	public void agregarCapacidadAlTanque(int capacidad) {
		if(capacidad < 0) {
			//throw an exception
		}
		
		this.setCapacidadDelTanque(capacidad);
		this.setNivelDeCombustible(capacidad);
		
	}
	
	public void setCapacidadDelTanque(int capacidad) {
		if(capacidad < 0) {
			//throw an exception
		}
		if(capacidad < this.capacidadTanque) {
			//throw an exception (no deberíamos achicar el tanque)
		}
		this.capacidadTanque = capacidad;
	}
	
	
	//------------------------------------------------
	//          		DINERO
	//------------------------------------------------
	
	private float calcularGasto(float cantidadCargada, float cantidadCombustible, float cantidadDePlata) {
		if(cantidadCargada <= 0) {
			return 0;
		}
		return (cantidadCargada * cantidadDePlata) / cantidadCombustible;
	}
	
	
	public boolean hacerCompra(float gasto) {
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
	
	public void repararDmg(float vidaSumar) {
		this.hp += vidaSumar;
	}
	
	public void setHP(int hp) {
		if(hp < 0) {
			//throw exception
		}
		this.hp = hp;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setMaxHP(int hp) {
		if(hp < 0) {
			//throw exception
		}
		if(hp <= this.maxHP) {
			//throw an exception
		}
		this.maxHP = hp;
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
		return this.mejoras.contains(item);
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
	
	public void gastarCombustible(float cantidad) {
		if(cantidad <= 0) {
			//throw exception
		}
		if(cantidad <= this.nivelCombustible){
			this.nivelCombustible -= cantidad;
		}
		if(cantidad > this.nivelCombustible) {
			this.nivelCombustible = 0;
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
	
	public void setNivelDeCombustible(int nivelDeCombustible) {
		if(nivelDeCombustible < 0) {
			//throw an exception
		}
		if(nivelDeCombustible > this.capacidadTanque) {
			//throw an exception
		}
		this.nivelCombustible = nivelDeCombustible;
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

}


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
	private double nivelCombustible;
	private int dinero;
	private List<Mineral> mineralesRecolectados;
	private Posicion posicion;
	private double capacidadTanque;
	private int maxInventario;
	private int maxHP;
	private List<Usable> mejoras;
	private int altoTerreno;
	private int anchoTerreno;
	
	public Jugador(int posX, int posY,int altoTerreno, int anchoTerreno) {
		if(posX < 0 || posY != 0 || altoTerreno < 10 || anchoTerreno < 10) {
			//No sé bien cómo es la sintaxis pero acá iría un throw JugadorOutOfLimitsException();
			//Cuestión que si está esta excepción se tiene que pedir que se setee bien esto A
			//O no sé la verdad me perdí ya
			//Además lo de altoTerreno y anchoTerreno puse que no se pueda poner < 10 porque no tiene sentido sino pero esa sería otra excepción supongo
		}
		if(posY > altoTerreno || posX > altoTerreno) {
			//No sé bien cómo es la sintaxis pero acá iría un throw JugadorOutOfLimitsException();
			//Cuestión que si está esta excepción se tiene que pedir que se setee bien esto A
			//O no sé la verdad me perdí ya
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
	
	public List<Mineral> getMinerales() {
		return this.mineralesRecolectados;
	}
	
	public int getCantidadDeMinerales() {
		return this.mineralesRecolectados.size();
	}
	
	public int getMaxInventario() {
		return this.maxInventario;
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
	
	public double nivelDeCombustible() {
		return this.nivelCombustible;
	}

	public double getCapacidadTanque() {
		return this.capacidadTanque;
	}
	
	
	public void setNivelDeCombustible(double nivelDeCombustible) {
		if(nivelDeCombustible < 0) {
			//throw an exception
		}
		if(nivelDeCombustible > this.capacidadTanque) {
			//throw an exception
		}
		this.nivelCombustible = nivelDeCombustible;
	}
	
	public void cargarCombustible(double cantidadCombustible, double cantidadDePlata) {
		double faltante = this.capacidadTanque - this.nivelCombustible;
		//Ternario de abajo:
		//Si faltante es menor a cantidadCombustible --> cantidadCargar = faltante.
		//Si cantidad de combustible es menor --> cantidadCargar = cantidadCombustible.
		double cantidadCargar = faltante < cantidadCombustible ? faltante: cantidadCombustible;
		if(hacerCompra(this.calcularGasto(cantidadCargar, cantidadCombustible, cantidadDePlata))) {
			this.nivelCombustible += cantidadCargar;
		}
	}
	
	//Estas funciones actualizan el máximo y el nivel actual también, viola el SRP?
	public void agregarCapacidadAlTanque(double cantidad) {
		if(cantidad < 0) {
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
		
		this.setCapacidadDelTanque(cantidad);
		this.setNivelDeCombustible(cantidad);
		
	}
	
	public void setCapacidadDelTanque(double capacidad) {
		if(capacidad < 0) {
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
			return;
		}
		if(capacidad < this.capacidadTanque) {
			//throw an exception (no deberíamos achicar el tanque) -> esta excepción consistiría en tirar un mensaje por pantalla quizás?
			return;
		}
		this.capacidadTanque = capacidad;
	}
	
	public void gastarCombustible(double cantidad) {
		if(cantidad <= 0) {
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
		if(cantidad <= this.nivelCombustible){
			this.nivelCombustible -= cantidad;
		}
		if(cantidad > this.nivelCombustible) {
			this.nivelCombustible = 0;
		}
	}
	
	
	
	//------------------------------------------------
	//          		DINERO
	//------------------------------------------------
	
	private double calcularGasto(double cantidadCargar, double cantidadCombustible, double cantidadDePlata) {
		if(cantidadCargar <= 0) {
			return 0;
		}
		return (cantidadCargar * cantidadDePlata) / cantidadCombustible;
	}
	
	
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
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
		if(hp <= this.maxHP) {
			//lo mismo que con el tanque, no deberíamos disminuir esto
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
	
	public void recibirDanio(int danio) {
		if(danio < 0) {
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
		else if(danio > this.hp) {
			this.hp = 0;	
		}
		else{
			this.hp -= danio;
		}
	}
	
	//------------------------------------------------
	//          		MEJORAS
	//------------------------------------------------

	
	public List<Usable> getMejoras() {
		return this.mejoras;
	}
	
	public boolean tieneUsable(Usable item) {
		for(Usable usable: this.mejoras) {
			if(item.getTipo() == usable.getTipo()) {
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
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
	}
	
	public void eliminarMejora(Usable buscado) {
		for(int i = 0; i < this.mejoras.size(); i++) {
			if(mejoras.get(i).getTipo() == buscado.getTipo()) {
				mejoras.remove(i);
				return;
			}
		}
	}
	



	

}


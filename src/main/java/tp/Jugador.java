package tp;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Bloque{
	int hp;
	int nivelCombustible;
	int dinero;
	List<Bloque> mineralesRecolectados;
	Posicion posicion;
	int capacidadTanque;
	int resistencia; //a mayor resistencia, menos vida pierde, después lo implementamos bien :P
	int maxInventario;
	int maxHP;
	//las mejoras, para mí hay que hacer algo con esto porque sino cada vez que metes una mejora hay que hacer una banda de cambios
	boolean tanqueExtra;
	int cantidadDinamita;
	int cantidadExplosivos;
	boolean teleport;
	int cantidadHRN; //los hull repair nanobots :P
	
	
	public Jugador(int tamanioTerreno) {
		//Faltaria la excepcion para tamaño terreno
		this.nivelCombustible = 10;
		this.mineralesRecolectados = new ArrayList<>();
		this.posicion = new Posicion((int)(tamanioTerreno*0.5), 0);
		this.dinero = 20;
		this.capacidadTanque = 10;
		this.hp = 10;
		this.resistencia = 10; //no se que valores le vamos a poner a esto, después lo charlamos bien :P
		this.maxInventario = 7;
		this.maxHP = 10;
		this.tanqueExtra = false;
		this.teleport = false;
		this.cantidadDinamita = 0;
		this.cantidadExplosivos = 0;
		this.cantidadHRN = 0;
	}
	
	//Hay que mover y aparte hay que ir restando el combustible, y si está usando el taladro debería perder hp :P
	//Evidentemente el 10 esta hardcodeado, faltarian unas constantes.
	
	
	//Supongo que la idea sería armar algún tipo de loop para vender los minerales, cuestión que vaya recibiendo
	//de a uno hasta que ese loop se termine y los vaya buscando de a uno y eliminándolos :P
	//Habria que revisar esto. el juego original creo que te permite vender de a uno pero nunca use eso :p.
	public void venderMinerales(Bloque mineral) {
		if(mineralesRecolectados.contains(mineral)) {
			this.mineralesRecolectados.remove(mineral);
		}
		this.dinero += mineral.getPrecio();
	}
	
	public void agregarInventario(Bloque mineral) {
		if(mineralesRecolectados.size() < this.maxInventario) {
			mineralesRecolectados.add(mineral);
		}
	}
	
	//Mas que nada para chequear el funcionamiento, quizas inventario sea una clase aparte. No lo se.
	public void mostrarInventario() {
		for(Bloque b: mineralesRecolectados) {
			System.out.print(" | " + b.getLetra());
		}
		System.out.print('\n');
	}

	public int getPrecio() {
		return -1;
	}

	public TipoDeBloque getTipo() {
		return TipoDeBloque.AIRE;
	}

	public char getLetra() {
		return '&';
	}

	
	//Se puede cambiar getX y getY por getPosicion.getX()
	public int getX() {
		return this.posicion.getPosicionX();
	}
	
	public int getY() {
		return this.posicion.getPosicionY();
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	
	public boolean seQuedoSinCombustible() {
		return this.nivelCombustible <= 0;
	}
	
	public int nivelDeCombustible() {
		return this.nivelCombustible;
	}
	
	//-------------- Creo que implemente esto mismo pero en EstacionDeServicio. No lo habia visto --------------------------------------
	//Esta función está acá por si se cargó menos combustible del que se pidió (por ej cuando te faltan 3L para llenar el tanque pero le das click a la opción de 5L, solo te carga 3L y te cobra los 3L)
	//aunque quizás esto debería estar en EstacionDeServicio tmb no sé shoro
	//la onda es que esto hace tipo una regla de 3 simple :P
	private int calcularGasto(int cantidadCargada, int cantidadCombustible, int cantidadDePlata) {
		if(cantidadCargada <= 0) {
			return 0;
		}
		return cantidadCargada * cantidadDePlata / cantidadCombustible;
	}
	
	//
	private boolean tieneSuficienteDinero(int dinero){
		return (this.dinero >= dinero);
	}	
	
	//
	public void cargarCombustible(int cantidadCombustible,int cantidadDePlata) {
		if(tieneSuficienteDinero(cantidadDePlata)){
			if(cantidadCombustible + this.nivelCombustible >= this.capacidadTanque){
				int cantidadCargada = this.capacidadTanque - this.nivelCombustible;
				this.nivelCombustible = this.capacidadTanque;
				//Acá necesitamos hacer la cuenta de lo que efectivamente
				this.pagar(this.calcularGasto(cantidadCargada,cantidadCombustible,cantidadDePlata));
			}
			int cantidadCargada = cantidadCombustible;
			this.nivelCombustible += cantidadCombustible;
			this.pagar(this.calcularGasto(cantidadCargada,cantidadCombustible,cantidadDePlata));
		}
	}
	
	//corte esto debería recibir la cantidad y devolver una cantidad de carga :P se supone que se elige con un click pero no sé a
	public CantidadDeCarga cargarCombustible() {
		//Acá se supone que el jugador elige la cantidad de carga y la devuelve, por ahora puede hacerse por pantalla supongo :P
		return CantidadDeCarga.FULL; //no mas para q ande :P
	}
	
	public void pagar(int cantidadDePlata) {
		if((this.dinero-=cantidadDePlata) >= 0) {
			this.dinero -= cantidadDePlata;
		}
		else {
			//throw exception
		}
	}
	
	public boolean seEstrello() {
		return this.hp == 0;
	}

	public void setY(int i) {
		this.posicion.setPosicionY(i);
	}

	public void setX(int i) {
		this.posicion.setPosicionX(i);
	}

	public int getCapacidadTanque() {
		return this.capacidadTanque;
	}
	
	public int getNivelCombustible() {
		return this.nivelCombustible;
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

	public int getCantidadDeMinerales() {
		return this.mineralesRecolectados.size();
	}
}


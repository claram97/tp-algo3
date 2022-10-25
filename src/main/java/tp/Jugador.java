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
	
	public Jugador(int tamanioTerreno) {
		//Faltaria la excepcion para tamaño terreno
		this.nivelCombustible = 10;
		this.mineralesRecolectados = new ArrayList<Bloque>();
		this.posicion = new Posicion(tamanioTerreno/2, 0);
		this.dinero = 20;
		this.capacidadTanque = 10;
		this.hp = 10;
		this.resistencia = 10; //no se que valores le vamos a poner a esto, después lo charlamos bien :P
		this.maxInventario = 10;
		this.maxHP = 10;
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

	public tipoDeBloque getTipo() {
		return tipoDeBloque.AIRE;
	}

	public char getLetra() {
		return '&';
	}

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
	
	//Revisar esta función
	private int calcularGasto(int cantidadCargada) {	
		int gastoTotal = cantidadCargada * 5;
		//puse 5 pero hay que ver cuánto va a salir el combustible :P además vamos a necesitar alguna función así para la pérdida de HP tmb :P
		return gastoTotal;
	}
	
	private boolean tieneSuficienteDinero(int dinero){
		return (this.dinero >= dinero);
	}

	public void cargarCombustible(int cantidadCombustible,int cantidadDePlata) {
		if(tieneSuficienteDinero(cantidadDePlata)){
			if(cantidadCombustible + this.nivelCombustible >= this.capacidadTanque){
				int cantidadCargada = this.capacidadTanque - this.nivelCombustible;
				this.nivelCombustible = this.capacidadTanque;
				//Acá necesitamos hacer la cuenta de lo que efectivamente
				this.pagar(this.calcularGasto(cantidadCargada));
			}
			int cantidadCargada = cantidadCombustible;
			this.nivelCombustible += cantidadCombustible;
			this.pagar(this.calcularGasto(cantidadCombustible));
		}
	}
	
	//tengo que armar bien esto :P
	public void pagar(int cantidadDePlata) {
		this.dinero -= cantidadDePlata;
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

	
}

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
	int maxHP;
	
	public Jugador(int tamanioTerreno) {
		if(hp < 0 || nivelCombustible < 0 || tamanioTerreno < 0) {
			//throw an exception
		}
		this.nivelCombustible = 10;
		this.mineralesRecolectados = new ArrayList<Bloque>();
		this.posicion = new Posicion(tamanioTerreno/2, 0);
		this.dinero = 20;
		this.capacidadTanque = 10;
		this.hp = 10;
		this.resistencia = 10; //no se que valores le vamos a poner a esto, después lo charlamos bien :P
		this.maxHP = 10;
	}
	
	public void caer() {
		this.posicion.setPosicionY(this.posicion.getPosicionY() + 1);
	}
	
	
	//Hay que mover y aparte hay que ir restando el combustible, y si está usando el taladro debería perder hp :P
	//Evidentemente el 10 esta hardcodeado, faltarian unas constantes.
	public void mover(char movimiento) {
		if(movimiento == 'W' && this.posicion.getPosicionY() > 0) {
			this.posicion.setPosicionY(this.posicion.getPosicionY()-1);
		}
		else if(movimiento == 'A' && this.posicion.getPosicionX() > 0) {
			this.posicion.setPosicionX(this.posicion.getPosicionX()-1);
		}
		else if(movimiento == 'S' && this.posicion.getPosicionY() < 10) {
			this.posicion.setPosicionY(this.posicion.getPosicionY() + 1);
		}
		else if(movimiento == 'D' && this.posicion.getPosicionX() < 10) {
			this.posicion.setPosicionX(this.posicion.getPosicionX()+1);
		} else {
			//Excepcion.
		}
	}
	
	//Supongo que la idea sería armar algún tipo de loop para vender los minerales, cuestión que vaya recibiendo
	//de a uno hasta que ese loop se termine y los vaya buscando de a uno y eliminándolos :P
	public void venderMinerales(Bloque mineral) {
		if(mineralesRecolectados.contains(mineral)) {
			this.mineralesRecolectados.remove(mineral);
		}
		this.dinero += mineral.getPrecio();
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
		return this.nivelCombustible == 0;
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

	
}

package tp;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Bloque{
	int hp;
	int nivelCombustible;
	List<Bloque> mineralesRecolectados;
	Posicion posicion;
	int dinero;
	
	public Jugador(int hp, int nivelCombustible, int tamanioTerreno) {
		if(hp < 0 || nivelCombustible < 0 || tamanioTerreno < 0) {
			//throw an exception
		}
		this.hp = hp;
		this.nivelCombustible = nivelCombustible;
		this.mineralesRecolectados = new ArrayList<Bloque>();
		this.posicion = new Posicion(tamanioTerreno/2, 0); // deberia ser (x ; y) pero la matriz imprime (y ; x)
		//0 (j ; i) mejor dicho.
		//la onda es posicionar al bicho en el medio del terreno :P
		this.dinero = 20;
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
	
}

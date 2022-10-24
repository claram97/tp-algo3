package tp;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
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
		this.posicion = new Posicion(tamanioTerreno/2,0);
		//la onda es posicionar al bicho en el medio del terreno :P
		this.dinero = 20;
	}
	
	//Hay que mover y aparte hay que ir restando el combustible, y si está usando el taladro debería perder hp :P
	public void mover(char movimiento) {
		if(movimiento == 'W') {
			
		}
		else if(movimiento == 'A') {
			
		}
		else if(movimiento == 'S') {
			
		}
		else if(movimiento == 'D') {
			
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
	
}

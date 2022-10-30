package tp;

import java.util.List;

import tp.Mejoras.MejoraCapacidadDelTanque;
import tp.Mejoras.MejoraInstantanea;
import tp.Mejoras.MejoraMaxInventario;
import tp.Mejoras.MejoraMaxVida;

import java.util.ArrayList;

public class TiendaDeMejoras {
	Posicion posicion;
	List<MejoraInstantanea> mejoras;
	
	//Para mí hay que refactorizar esto, no estaría mal crear una factory o algo :P
	//Fijate que en todos los casos siempre hay 6 opciones, las 6 opciones valen siempre lo mismo, no más cambia
	//la capacidad total del tanque, el máximo del inventario o el máximo de la vida.
	private void inicializarMejoras() {
		this.mejoras.add(new MejoraMaxInventario(15,750));
		this.mejoras.add(new MejoraMaxInventario(25,2000));
		this.mejoras.add(new MejoraMaxInventario(40,5000));
		this.mejoras.add(new MejoraMaxInventario(60,20000));
		this.mejoras.add(new MejoraMaxInventario(70,100000));
		this.mejoras.add(new MejoraMaxInventario(120,150000));
				
		this.mejoras.add(new MejoraMaxVida(17,750));
		this.mejoras.add(new MejoraMaxVida(30,2000));
		this.mejoras.add(new MejoraMaxVida(50,5000));
		this.mejoras.add(new MejoraMaxVida(80,20000));
		this.mejoras.add(new MejoraMaxVida(120,100000));
		this.mejoras.add(new MejoraMaxVida(180,150000));
		
		this.mejoras.add(new MejoraCapacidadDelTanque(15,750));
		this.mejoras.add(new MejoraCapacidadDelTanque(25,2000));
		this.mejoras.add(new MejoraCapacidadDelTanque(40,5000));
		this.mejoras.add(new MejoraCapacidadDelTanque(60,20000));
		this.mejoras.add(new MejoraCapacidadDelTanque(100,100000));
		this.mejoras.add(new MejoraCapacidadDelTanque(150,150000));
		
		
/*		Hay que ver si esto queda :P lo de la resistencia digo, hay que elegir valores, yo pensaba que la resistencia
 *		aumente en porcentaje :P no es parte del juego original, lo inventé yo.
 * ***************************************************** *
 		this.mejoras.add(new MejoraDeResistencia(15));
		this.mejoras.add(new MejoraDeResistencia(25));
		this.mejoras.add(new MejoraDeResistencia(40));
		this.mejoras.add(new MejoraDeResistencia(60));
		this.mejoras.add(new MejoraDeResistencia(100));
		this.mejoras.add(new MejoraDeResistencia(150));
*/
	}
	
	//Acá hay que chequear qué mejora/s eliminar, porque por ejemplo si comprás el tanque de 25 ya no vas a comprar el de 15
	//PIENSO QUE quizás no hay que borrarlas, sino que simplemente según la mejora que se quiere comprar, se chequea el nivel que tiene el jugador
	//y no se deja comprar lo que no se deba comprar
	//pero no estoy segura :P
	private void eliminarMejora(MejoraInstantanea mejora) {
	
	}
	
	public TiendaDeMejoras(int tamanioTerreno) {
		this.posicion.set((int)(tamanioTerreno * 0.6),0);
		this.mejoras = new ArrayList<>();
		this.inicializarMejoras();
	}
	
	//Tenemos que ver bien cómo el Jugador elige la mejora
	public void vender(Jugador jugador, MejoraInstantanea mejora) {
		mejora.utilizar(jugador);
		jugador.pagar(mejora.valor);
		eliminarMejora(mejora);
	}
}

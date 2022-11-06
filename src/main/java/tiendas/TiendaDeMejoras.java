package tiendas;

import java.util.Map;
import java.util.Scanner;

import jugador.Jugador;
import jugador.Posicion;
import mejoras.MejoraCapacidadDelTanque;
import mejoras.MejoraInstantanea;
import mejoras.MejoraMaxInventario;
import mejoras.MejoraMaxVida;
import mejoras.Usable;
import terreno.Entidad;
import terreno.TipoEntidad;

import java.util.HashMap;

public class TiendaDeMejoras implements Entidad{
	private static final char LETRA = '+';
	Scanner input;
	Posicion posicion;
	Map<String, MejoraInstantanea> mejoras;
	Map<String, Usable> usables;
	
	
	public TiendaDeMejoras(int posX, int posY) {
		this.input = null;
		this.posicion.setX(posX);
		this.posicion.setY(posY);
	}
	
	private void inicializarMejoras() {
		this.mejoras.put("I1",new MejoraMaxInventario(15,750));
		this.mejoras.put("I2",new MejoraMaxInventario(25,2000));
		this.mejoras.put("I3",new MejoraMaxInventario(40,5000));
		this.mejoras.put("I4",new MejoraMaxInventario(60,20000));
		this.mejoras.put("I5",new MejoraMaxInventario(70,100000));
		this.mejoras.put("I6",new MejoraMaxInventario(120,150000));
				
		this.mejoras.put("V1",new MejoraMaxVida(17,750));
		this.mejoras.put("V2",new MejoraMaxVida(30,2000));
		this.mejoras.put("V3",new MejoraMaxVida(50,5000));
		this.mejoras.put("V4",new MejoraMaxVida(80,20000));
		this.mejoras.put("V5",new MejoraMaxVida(120,100000));
		this.mejoras.put("V6",new MejoraMaxVida(180,150000));
		
		this.mejoras.put("T1", new MejoraCapacidadDelTanque(15,750));
		this.mejoras.put("T2", new MejoraCapacidadDelTanque(25,2000));
		this.mejoras.put("T3", new MejoraCapacidadDelTanque(40,5000));
		this.mejoras.put("T4", new MejoraCapacidadDelTanque(60,20000));
		this.mejoras.put("T5", new MejoraCapacidadDelTanque(100,100000));
		this.mejoras.put("T6", new MejoraCapacidadDelTanque(150,150000));
		
	}
	
	//Acá hay que chequear qué mejora/s eliminar, porque por ejemplo si comprás el tanque de 25 ya no vas a comprar el de 15
	//PIENSO QUE quizás no hay que borrarlas, sino que simplemente según la mejora que se quiere comprar, se chequea el nivel que tiene el jugador
	//y no se deja comprar lo que no se deba comprar
	//pero no estoy segura :P
	private void eliminarMejora(MejoraInstantanea mejora) {
		
	}
	
	public TiendaDeMejoras(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.9), 0);
		this.mejoras = new HashMap<>();
		this.inicializarMejoras();
	}
	
	private String codigoMejora(char opcion, int tier) {
		String busqueda = "";
		busqueda += opcion;
		busqueda += tier;
		return busqueda;
	}
	
	private void promptMejoras() {
		System.out.println("----------------------------------------");
		System.out.println("Mejora a comprar:");
		System.out.println("I para mejoras del inventario\nV para mejoras de vida\nT para mejoras de tanque");
		System.out.print("Opcion: ");
	}
	
	private void promptOpciones(char opcion) {
		if(opcion == 'I') {
			System.out.println("Seleccione el tier de mejora: ");
			System.out.println("(1)+15 por $750\n(2)+25 por $2000\n(3)+40 por $5000\n(4)+60 por $20000\n(5)+70 por $100000\n(6)+120 por $150000");
			System.out.print("Opcion: ");
		} else if(opcion == 'V') {
			System.out.println("Seleccione el tier de mejora: ");
			System.out.println("(1)+17 por $750\n(2)+30por $2000\n(3)+50 por $5000\n(4)+80 por $20000\n(5)+120 por $100000\n(6)+180 por $150000");
			System.out.print("Opcion: ");
		} else if(opcion == 'T') {
			System.out.println("Seleccione el tier de mejora: ");
			System.out.println("(1)+15 por $750\n(2)+25 por $2000\n(3)+40 por $5000\n(4)+60 por $20000\n(5)+70 por $100000\n(6)+120 por $150000");
			System.out.print("Opcion: ");
		} else {
			System.out.println("Todavia no tenemos ese item a la venta :P");
		}
	}
	
	
	//Tenemos que ver bien cómo el Jugador elige la mejora
	public void vender(Jugador jugador, String codigo) {
		MejoraInstantanea mejora = this.mejoras.get(codigo);
		
		if(mejora == null) {
			System.out.println("No tenemos esa mejora o ya la vendimos :(");
			return;
		}
		
		mejora.utilizar(jugador);
		jugador.hacerCompra(mejora.getValor());
		eliminarMejora(mejora);
		
	}

	@Override
	public void interactuar(Jugador jugador) {
		this.input = new Scanner(System.in);
		promptMejoras();
		char opcion = input.next().charAt(0);
	
		promptOpciones(opcion);
		int tier = input.nextInt();
		String codigo = codigoMejora(opcion, tier);
		vender(jugador, codigo);
	}

	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public TipoEntidad getTipoEntidad() {
		return TipoEntidad.TIENDA;
	}

	@Override
	public char getLetra() {
		return TiendaDeMejoras.LETRA;
	}
}
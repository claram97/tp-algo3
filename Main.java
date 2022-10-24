package tp;

public class Main {

	public static void main(String[] args) {
		Terreno terreno = new Terreno();
		Jugador pj = new Jugador(100, 100, 10);

		terreno.imprimirTerreno(pj);
		
		pj.mover('S');
		terreno.imprimirTerreno(pj);
		
		pj.mover('D');
		terreno.imprimirTerreno(pj);
		
		pj.mover('W');
		terreno.imprimirTerreno(pj);
		
		pj.mover('A');
		terreno.imprimirTerreno(pj);
	
	}

}

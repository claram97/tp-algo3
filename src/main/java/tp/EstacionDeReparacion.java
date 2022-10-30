package tp;

import java.util.Scanner;

public class EstacionDeReparacion implements EstacionDeMantenimiento, Entidad {
	public Posicion posicion;
	private static final int PRECIO_REPARACION = 10;
	
	public EstacionDeReparacion(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.8), 0);
	}
	
	public void cobrar(Jugador jugador, int hpReparados) {
		jugador.pagar(hpReparados * PRECIO_REPARACION);
	}
	
	
	public void reparar(Jugador jugador, int porcentajeReparar) {
		int hpFaltante = (jugador.getMaxHP() - jugador.getHp());
		int hpReparar = (int)((hpFaltante/porcentajeReparar) * 100); //Revisar este calculo
		jugador.repararDmg(hpReparar);
		cobrar(jugador, hpReparar);
	}
	
	
	
	public void prompt_reparacion(int vidaActual) {
		System.out.println("-----------------------------------");
		System.out.println("Su vida actual es " + vidaActual);
		System.out.println("Indique que % del daño desea reparar");
		System.out.println("10, 25, 50, 75 o 100(Reparacion completa)");
		System.out.print("Opcion: ");
	}
	
	
	public void vender(Jugador jugador) {
		prompt_reparacion(jugador.getHp());
		Scanner sc = new Scanner(System.in);
		int porcentajeReparar = sc.nextInt();
		reparar(jugador, porcentajeReparar);
	}

	@Override
	public void interactuar(Jugador jugador) {
		vender(jugador);
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
		return '!';
	}
}

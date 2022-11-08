package jugador;

public class Nave {
	private static final int COMBUSTIBLE_INICIAL = 6;
	private static final int MAX_COMBUSTIBLE_INICIAL = 10;
	private static final int HP_INICIAL = 10;
	private static final int MAX_HP_INICIAL = 10;
	
	private int hp;
	private double nivelCombustible;
	private double capacidadTanque;
	private int maxHP;
	
	public Nave() {
		this.nivelCombustible = COMBUSTIBLE_INICIAL;
		this.capacidadTanque = MAX_COMBUSTIBLE_INICIAL;
		this.hp = HP_INICIAL;
		this.maxHP = MAX_HP_INICIAL;
	}
	
	public boolean seQuedoSinCombustible() {
		return this.getNivelDeCombustible() <= 0;
	}
	
	public double getNivelDeCombustible() {
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
		this.nivelCombustible += cantidadCombustible;
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
		this.nivelCombustible -= cantidad;
	}
	
	//------------------------------------------------
	//          		HP
	//------------------------------------------------
	
	
	public boolean seEstrello() {
		return this.hp == 0;
	}

	public int getMaxHP() {
		return maxHP;
	}
	
	public void setMaxHP(int maxVida) {
		if(maxVida < this.maxHP) {
			return;
		}
		this.maxHP = maxVida;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int hp) {
		if(hp < 0) {
			//throw exception
		}
		this.hp = hp;
	}
	
	public void repararDmg(int vidaSumar) {
		this.hp += vidaSumar;
		if(this.hp > this.maxHP) {
			this.hp = this.maxHP;
		}
	}
	
	public void recibirDanio(int danio) {
		if(danio < 0) {
			return;
		}
		
		this.hp -= danio;
		if(this.hp < 0) {
			this.hp = 0;
		}
	}
}

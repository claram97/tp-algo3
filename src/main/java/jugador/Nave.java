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
	
	//Devuelve true si el nivel de combustible es menor o igual que 0.
	public boolean seQuedoSinCombustible() {
		return this.getNivelDeCombustible() <= 0;
	}
	
	//Devuelve el nivel de combustible actual.
	public double getNivelDeCombustible() {
		return this.nivelCombustible;
	}

	//Devuelve la capacidad máxima del tanque actual.
	public double getCapacidadTanque() {
		return this.capacidadTanque;
	}
	
	//Permite aumentar la cantidad de combustible.
	public void setNivelDeCombustible(double nivelDeCombustible) {
		if(nivelDeCombustible < 0) {
			//throw an exception
		}
		if(nivelDeCombustible > this.capacidadTanque) {
			//throw an exception
			//o no, creo que acá llenaría el tanque y ya.
		}
		
		this.nivelCombustible = nivelDeCombustible;
	}
	
	//Permite cargar una cantidad de combustible deseada por la cantidad de plata especificada.
	public void cargarCombustible(double cantidadCombustible, double cantidadDePlata) {
		this.nivelCombustible += cantidadCombustible;
	}
	
	//Estas funciones actualizan el máximo y el nivel actual también, viola el SRP? (Agregar esta duda en el Notion y sacar este comentario)
	//Aumenta la capacidad máxima del tanque, seteando el nivel actual al máximo.
	public void agregarCapacidadAlTanque(double cantidad) {
		if(cantidad < 0) {
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
		this.setCapacidadDelTanque(cantidad);
		this.setNivelDeCombustible(cantidad);
	}
	
	//Aumenta la capacidad del tanque si la capacidad recibida es mayor a la actual.
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
	
	//Permite gastar combustible en una cantidad dada.
	public void gastarCombustible(double cantidad) {
		if(cantidad <= 0) {
		//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
		this.nivelCombustible -= cantidad;
	}
	
	//------------------------------------------------
	//          		HP
	//------------------------------------------------
	
	//Devuelve true si el hp es menor o igual que 0.
	public boolean seEstrello() {
		return this.hp <= 0;
	}

	//Devuelve el maxHP.
	public int getMaxHP() {
		return maxHP;
	}
	
	//Recibe la cantidad de vida máxima y la extiende si el valor recibido es mayor que el actual.
	public void setMaxHP(int maxVida) {
		if(maxVida < this.maxHP) {
			return;
		}
		this.maxHP = maxVida;
	}
	
	//Devuelve el hp actual.
	public int getHP() {
		return this.hp;
	}
	
	//Setea el hp en un hp dado.
	public void setHP(int hp) {
		if(hp < 0) {
			//throw exception
		}
		if(hp > this.maxHP){
			this.hp = maxHP;
		}
		else{
			this.hp = hp;
		}
		
	}
	
	//Permite reparar la nave según la cantidad de vida especificada.
	public void repararDmg(int vidaSumar) {
		this.hp += vidaSumar;
		if(this.hp > this.maxHP) {
			this.hp = this.maxHP;
		}
	}
	
	//Recibe daño mientras este sea un valor positivo.
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

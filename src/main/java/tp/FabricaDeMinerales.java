package tp;

public class FabricaDeMinerales {
	
	public static Mineral crear(String tipoMineral) {
		if(tipoMineral == null) {
			//throw an exception bc tipoMineral shouldn't be null
		}
		else if(tipoMineral == "Cobre") {
			return new Cobre();
		}
		else if(tipoMineral == "Bronce") {
			return new Bronce();
		}
		else if(tipoMineral == "Hierro") {
			return new Hierro();
		}
		else if(tipoMineral == "Plata") {
			return new Plata();
		}
		else if(tipoMineral == "Oro") {
			return new Oro();
		}
		else if(tipoMineral == "Diamante") {
			return new Diamante();
		}

		return null;
	}
}
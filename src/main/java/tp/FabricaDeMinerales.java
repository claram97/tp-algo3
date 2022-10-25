package tp;

public class FabricaDeMinerales {
	
	public static Mineral crear(tipoDeBloque tipoMineral) {
		if(tipoMineral == null) {
			//throw an exception bc tipoMineral shouldn't be null
		}
		else if(tipoMineral == tipoDeBloque.COBRE) {
			return new Mineral(tipoDeBloque.COBRE,30,'C');
		}
		else if(tipoMineral == tipoDeBloque.BRONCE) {
			return new Mineral(tipoDeBloque.BRONCE,60,'B');
		}
		else if(tipoMineral == tipoDeBloque.HIERRO) {
			return new Mineral(tipoDeBloque.HIERRO,50,'H');
		}
		else if(tipoMineral == tipoDeBloque.PLATA) {
			return new Mineral(tipoDeBloque.PLATA,150,'P');
		}
		else if(tipoMineral == tipoDeBloque.ORO) {
			return new Mineral(tipoDeBloque.ORO,300,'O');
		}
		else if(tipoMineral == tipoDeBloque.DIAMANTE) {
			return new Mineral(tipoDeBloque.DIAMANTE,675,'D');
		}

		return null;
	}
}
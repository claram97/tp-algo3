package tp;

public class FabricaDeMinerales {
	
	public static Mineral crear(TipoDeBloque tipoMineral) {
		if(tipoMineral == null) {
			//throw an exception bc tipoMineral shouldn't be null
		}
		else if(tipoMineral == TipoDeBloque.COBRE) {
			return new Mineral(TipoDeBloque.COBRE,30,'C');
		}
		else if(tipoMineral == TipoDeBloque.BRONCE) {
			return new Mineral(TipoDeBloque.BRONCE,60,'B');
		}
		else if(tipoMineral == TipoDeBloque.HIERRO) {
			return new Mineral(TipoDeBloque.HIERRO,50,'H');
		}
		else if(tipoMineral == TipoDeBloque.PLATA) {
			return new Mineral(TipoDeBloque.PLATA,150,'P');
		}
		else if(tipoMineral == TipoDeBloque.ORO) {
			return new Mineral(TipoDeBloque.ORO,300,'O');
		}
		else if(tipoMineral == TipoDeBloque.DIAMANTE) {
			return new Mineral(TipoDeBloque.DIAMANTE,675,'D');
		}

		return null;
	}
}
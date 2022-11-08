package jugador;

import java.util.ArrayList;
import java.util.List;

import mejoras.Usable;
import minerales.Mineral;

public class Inventario{
	private static final int MAX_INVENTARIO_INICIAL = 7;
	private List<Mineral> mineralesRecolectados;
	private List<Usable> usables;
	private int maxInventario;
	
	public Inventario() {
		this.mineralesRecolectados = new ArrayList<Mineral>();
		this.usables = new ArrayList<Usable>();
		this.maxInventario = MAX_INVENTARIO_INICIAL;
	}
	
	//------------------------------------------------
	//          		MINERALES
	//------------------------------------------------

	public int venderMinerales() {
		int total = 0;
		for(Mineral mineral: mineralesRecolectados) {
			total += mineral.getPrecio();
		}
		this.mineralesRecolectados.clear();
		return total;
	}
	
	public void agregarInventario(Mineral mineral) {
		if(mineralesRecolectados.size() < this.maxInventario) {
			mineralesRecolectados.add(mineral);
		}
	}
	
	public List<Mineral> getMinerales() {
		return this.mineralesRecolectados;
	}
	
	public int getCantidadDeMinerales() {
		return this.mineralesRecolectados.size();
	}
	
	public int getMaxInventario() {
		return this.maxInventario;
	}
	
	//------------------------------------------------
	//          		MEJORAS
	//------------------------------------------------

	
	public List<Usable> getUsables() {
		return this.usables;
	}
	
	public boolean tieneUsable(Usable item) {
		for(Usable usable: this.usables) {
			if(item.getTipo() == usable.getTipo()) {
				return true;
			}
		}
		return false;
	}
	
	public void agregarUsable(Usable item) {
		this.usables.add(item);
	}
	

	public void setMaxInventario(int maxInventario) {
		if(maxInventario > this.maxInventario) {
			this.maxInventario = maxInventario;
		}
		else {
			//throw an exception -> o no, quizás simplemente dejaríamos que no haga nada si el valor no es válido? AAA no sé jkldjklfj
		}
	}
	
	public void eliminarUsable(Usable buscado) {
		for(int i = 0; i < this.usables.size(); i++) {
			if(usables.get(i).getTipo() == buscado.getTipo()) {
				usables.remove(i);
				return;
			}
		}
	}

}

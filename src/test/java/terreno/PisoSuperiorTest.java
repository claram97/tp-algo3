package terreno;

import org.junit.jupiter.api.Test;

public class PisoSuperiorTest {

	   @Test
	    public void hayColisionConEntidad() {
		   var config = new ConfigPisoSuperior();
		   PisoSuperior piso = new PisoSuperior(config);
		   //seguila vos jiji
	    }
	   
	   @Test
	    public void noHayColisionConEntidad() {
		   var config = new ConfigPisoSuperior();
		   PisoSuperior piso = new PisoSuperior(config);
		   //seguila vos jiji
	    }

}
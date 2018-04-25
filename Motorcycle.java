package projeto_poo;

/** Classe derivada da
 * classe master veículo
 * @author gferreira
 */

public class Motorcycle extends Vehicles {

	/**
	 * Construtor da moto
	 * @param x
	 * @param y
	 * @param factory
	 */
	
	public Motorcycle(int x, int y, boolean factory) {
		super(x, y, 3, factory, "blue");
		
	}

}

package projeto_poo;

/** Classe derivada
 * da classe master veículo
 * @author gferreira
 *
 */

public class Truck extends Vehicles {
	
	/** Construtor caminhão
	 * 
	 * @param x
	 * @param y
	 * @param factory
	 */

	public Truck(int x, int y, boolean factory) {
		super(x, y, 1, factory, "yellow");
		
	}
	
}
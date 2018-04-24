package projeto_poo;

/** Classe derivada da 
 * classe master veículo
 * @author gferreira
 *
 */

public class Car extends Vehicles {
	
	/** Construtor veículo
	 * 
	 * @param x
	 * @param y
	 * @param factory
	 */

	public Car(int x, int y, boolean factory) {
		super(x, y, 2, factory, "red");
		
	}
	
}

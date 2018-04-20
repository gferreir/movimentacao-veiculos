package projeto_poo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList <Truck> t = new ArrayList<>();
		ArrayList <Car> c = new ArrayList<>();
		ArrayList <Motorcycle> m = new ArrayList<>();
		
		t.add(new Truck(1, 1, false));
		c.add(new Car(1, 2, false));
		m.add(new Motorcycle(4, 4, false));
		
		m.get(0).move();
		
		World w = new World();
		w.print(m, c, t);
		
	}

}

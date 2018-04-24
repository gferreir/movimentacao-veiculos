package projeto_poo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		int reciveValuesMovim;
		
		ArrayList <Truck> t = new ArrayList<>();
		ArrayList <Car> c = new ArrayList<>();
		ArrayList <Motorcycle> m = new ArrayList<>();
		
//		t.add(new Truck(1, 1, false));
//		c.add(new Car(1, 2, false));
//		m.add(new Motorcycle(4, 4, false));
		
		for(int i=0; i<10; i++){
			createMotorcycle(m);
			createCar(c);
			createTruck(t);
		}
		
		while((c.size() == 0) && (m.size() == 0)){
			
		}
		
		reciveValuesMovim = t.get(1).move(t.subList(0, 1));
		
		System.out.println(t.get(0).move());
				
		World w = new World();
		w.print(m, c, t);
		
	}

	private static void createMotorcycle(ArrayList<Motorcycle>m) {
		m.add(new Motorcycle(createRandomX(), createRandomY(), false));
	}
	private static void createCar(ArrayList<Car>c ){
		c.add(new Car(createRandomX(), createRandomY(), false));
	}
	private static void createTruck(ArrayList<Truck>t) {
		t.add(new Truck(createRandomX(), createRandomY(), false));
	}
	
	private static int createRandomX() {
		int x;
		x = (int)(Math.random()*30);
		return x;
	}
	private static int createRandomY() {
		int y;
		y = (int)(Math.random()*60);
		return y;
	}
	
	private static void destoyTruck(ArrayList<Truck>t, int i) {
		t.remove(i);
	}
	private static void destoyCar(ArrayList<Car>c, int i) {
		c.remove(i);
	}
	private static void destoyMotorcycle(ArrayList<Motorcycle>m, int i) {
		m.remove(i);
	}
	
	
	private static void whatCollision(int i, int atual, char v, ArrayList<Truck>t, ArrayList<Car>c, ArrayList<Motorcycle>m) {
		switch(i) {
			case -2 :
				createTruck(t);
				break;
			
			case -3 :
				createCar(c);
				break;
				
			case -4 :
				createMotorcycle(m);
				break;
			
			case -5 :
				if(v == 't')
					destoyTruck(t, atual);
				else if(v == 'c')
					destoyCar(c, atual);
				else
					destoyMotorcycle(m, atual);
				break;
				
			default : 
				if(v == 't') {
					destoyTruck(t, atual);
					destoyTruck(t, i);
				}
				else if(v == 'c'){
					destoyCar(c, atual);
					destoyCar(c, i);
				}
				else {
					destoyMotorcycle(m, atual);
				 	destoyMotorcycle(m, i);
				}
				break;
		}
		
	}
	
}

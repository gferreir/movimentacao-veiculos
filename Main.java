package projeto_poo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		int reciveValuesMovim; /** Recebe valor de retorno da movimentação */
		
		ArrayList <Truck> t = new ArrayList<>();
		ArrayList <Car> c = new ArrayList<>();
		ArrayList <Motorcycle> m = new ArrayList<>();
		
		World w = new World(); /** Instancia o mundo cíclico */
		
		for(int i=0; i<10; i++){ /** Inicialização dos 10 veículos de cada tipo */
			createMotorcycle(m);
			createCar(c);
			createTruck(t);
		}
		
		while((c.size() > 0) && (m.size() > 0)){ /** Looping do projeto */
			w.print(m, c, t);
			
			for(int i=0; i<t.size(); i++){
				reciveValuesMovim = t.get(i).move(t.subList(0, i));
				whatCollision(reciveValuesMovim, i, 't', t, c, m);
			}
			for(int i=0; i<c.size(); i++){
				reciveValuesMovim = c.get(i).move(c.subList(0, i), t.subList(0, t.size()));
				whatCollision(reciveValuesMovim, i, 'c', t, c, m);
			}
			for(int i=0; i<m.size(); i++){
				reciveValuesMovim = m.get(i).move(m.subList(0, i), c.subList(0, c.size()), t.subList(0, t.size()));
				whatCollision(reciveValuesMovim, i, 'm', t, c, m);
			}
			
			System.out.println("Motocycles - " + m.size() + "; Cars - " + c.size() + "; Truks - " + t.size());
			System.out.println("----------------------------------");
			System.out.println();
			
			try { /** Contador de tempo para compilação */
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	private static void createMotorcycle(ArrayList<Motorcycle>m) { /** Método que cria o veículo Moto */
		m.add(new Motorcycle(createRandomX(), createRandomY(), false));
	}
	private static void createCar(ArrayList<Car>c ){ /** Método que cria o veículo Carro */
		c.add(new Car(createRandomX(), createRandomY(), false));
	}
	private static void createTruck(ArrayList<Truck>t) { /** Método que cria o veículo Caminhão */
		t.add(new Truck(createRandomX(), createRandomY(), false));
	}
	
	private static int createRandomX() { /** Método que cria um 'x' aleátorio para criação de veículos */
		int x;
		x = (int)(Math.random()*30);
		return x;
	}
	private static int createRandomY() { /** Método que cria um 'y' aleátorio para criação de veículos */
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
			case -1 :
				break;
				
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

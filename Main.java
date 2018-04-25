/** Código fonte com o objetivo de implementação dos conceitos de Java SE orientado a objeto.
 * 
 * Existe um mundo cíclico (uma matriz 60x30) onde possuem 6 fábricas já previamente definidas, 
 * onde são inicializados 30 veículo. Sendo 10 caminhões, 10 carros e 10 motos que são derivados
 * de uma classe master e que se movimentam aleatóriamente pelo mundo. Quando algum objeto passa
 * pela posição de alguma fábrica é criado um novo objeto daquele mesmo tipo, em alguma coordenada
 * aleatória no mapa. 
 * Se um objeto caminhão colidir com qualquer outro objeto caminhão, os dois
 * objetos serão excluídos, porém se colidir com com algum objeto carro ou moto ele se manterá no
 * mapa e os objetos carro e moto serão excluídos do mundo. Se um objeto carro colidir com qualquer 
 * outro objeto carro, os dois objetos serão excluídos, porém se colidir com um objeto moto ele 
 * se manterá no mapa e o objeto moto será excluído do mapa. Se um objeto moto colidir com qualquer
 * outro objeto moto, os dois objetos serão excluídos, porém se colidir com qualquer outro objeto
 * ele será excluído.
 * A execução irá parar quando o ArrayList de Moto e ArrayList de Carro forem 0 (zero).
 * 
 * @author gferreira (Guilherme Ferreira)
 * @version 1.0
 */


package projeto_poo;

import java.util.ArrayList;

public class Main { /** Classe principal onde chama as outras classes */

	public static void main(String[] args) {
		
		int reciveValuesMovim; /** Recebe valor de retorno da movimentação */
		
		ArrayList <Truck> t = new ArrayList<>(); /** Instanciando um ArrayList de caminhão */
		ArrayList <Car> c = new ArrayList<>(); /** Instanciando um ArrayList de carro */
		ArrayList <Motorcycle> m = new ArrayList<>(); /** Instanciando um ArrayList de moto */
		
		World w = new World(); /** Instanciando o mundo cíclico */
		
		for(int i=0; i<10; i++){ /** Inicialização dos 10 veículos de cada tipo */
			createMotorcycle(m);
			createCar(c);
			createTruck(t);
		}
		
		while((c.size() > 0) || (m.size() > 0)){ /** Looping do projeto */
			w.print(m, c, t); /** Impressão do mundo com os três tipos de veículos */
			
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
			
			System.out.println("Motocycles - " + m.size() + "; Cars - " + c.size() + "; Truks - " + t.size()); /** Imprimindo a quantidade de cada veículo */
			System.out.println();
			System.out.println();
			System.out.println();
			
			try { /** Controla a velocidade de compilação */
				Thread.sleep(200);
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
	
	private static void destoyTruck(ArrayList<Truck>t, int i) { /** Método que destroi um veículo caminhão
	 															 *	do ArrayList caminhão, que recebe
	 															 *  como parâmetro o ArrayList de caminhão
	 															 *  e a posição*/
		t.remove(i);
	}
	private static void destoyCar(ArrayList<Car>c, int i) { /** Método que destroi um veículo carro
	 														 *	do ArrayList carro, que recebe
	 														 *  como parâmetro o ArrayList de carro
	 														 *  e a posição */
		c.remove(i);
	}
	private static void destoyMotorcycle(ArrayList<Motorcycle>m, int i) {  /** Método que destroi um veículo moto
																			*	do ArrayList moto, que recebe
																			*	como parâmetro o ArrayList de moto
																			* 	e a posição */
		m.remove(i);
	}
	
	
	private static void whatCollision(int i, int atual, char v, ArrayList<Truck>t, ArrayList<Car>c, ArrayList<Motorcycle>m) {
		/**
		 *  Método responsável por identificar
		 *  se o objeto colidiu com alguma fábrica
		 *  ou se colidiu com algum outro objeto
		 */
		
		switch(i) {
			case -1 :
				break;
				
			case -2 :
				if(v == 't')
					createTruck(t);
				else if(v == 'c')
					createCar(c);
				else
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

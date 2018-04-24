package projeto_poo;

/** Classe onde o mundo (matriz) é instanciado
 * e setado estaticamente com 60 colunas e
 * 30 linhas
 */

import java.util.ArrayList;

/** Criando a matriz estaticamente */

public class World {
	
	int map[][] = new int[30][60];
	
	public World() {
		printReset();
	}
	
	/** Método responsável por imprimir
	 * o mapa e as fabricas
	 */
	
	private void printReset() {
		
		for(int i=0; i<30; i++) {
			for(int j=0; j<60; j++) {
				if(i==4 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				else if(i==5 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				else if(i==6 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				
				else if(i==14 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				else if(i==15 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				else if(i==16 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				
				else if(i==23 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				else if(i==24 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				else if(i==25 && ((j>5 && j<11) || (j>48 && j<54)))
					map[i][j]=2;
				
				else
					map[i][j]=0;
			}
		}
		
	}
	
	/** Método responsável pela 
	 * impressão dos objetos caminhão,
	 * carro e moto.
	 * Recebendo como parâmetros os 
	 * ArrayLists de cada objeto
	 * @param m
	 * @param c
	 * @param t
	 */
	
	public void print(ArrayList <Motorcycle> m, ArrayList <Car> c, ArrayList <Truck> t) {
		
		printReset();
		checkCar(c);
		checkMotorcycle(m);
		checkTruck(t);
		
		/** Looping FOR que tem como objetivo
		 * a impressão dos objetos de cada tipo 
		 * com a diferenciação por cor
		 */
		
		for(int i=0; i<30; i++) {
			for(int j=0; j<60; j++) {
				if(map[i][j]==7)
					System.out.print("\u001b[44m \033[0m"); /** Imprime no console a cor azul, referente ao objeto moto */
				else if(map[i][j]==8)
					System.out.print("\u001b[41m \033[0m"); /** Imprime no console a cor vermelha, referente ao objeto carro */
				else if(map[i][j]==9)
					System.out.print("\u001b[43m \033[0m"); /** Imprime no console a cor amarelo, referente ao objeto caminhão */
				else if(map[i][j]==2)
					System.out.print("\u001b[42m \033[0m"); /** Imprime no console a cor verde, referente as fábricas */
				else
					System.out.print("\u001b[40m \033[0m"); /** Imprime no console a cor preta, referente ao restante do mapa */
			}
			System.out.println();
		}
	}	
	
	/** Método responsável pela verificação
	 * da posição do carro e preenche com o
	 * número 8, onde mais tarde será substiuido
	 * pela cor específica no console
	 * @param c
	 */
	
	private void checkCar(ArrayList <Car> c) {
		for (Car car : c) {
			map[car.getX()][car.getY()]=8;
		}
	}
	
	/** Método responsável pela verificação da
	 * posição do caminhão e preenche com o número 
	 * 9, onde mais tarde será substituído pela
	 * cor específica no console 
	 * @param t
	 */
	
	private void checkTruck(ArrayList <Truck> t) {
		for (Truck truck : t) {
			map[truck.getX()][truck.getY()]=9;
		}
		
	}
	
	/** Método responsável pela verificação da
	 * posição da moto e preenche com o número 7,
	 * onde mais tarde será substituido pela com
	 * específica no console
	 * @param m
	 */
	
	private void checkMotorcycle(ArrayList <Motorcycle> m) {
		for (Motorcycle motorcycle : m) {
			map[motorcycle.getX()][motorcycle.getY()]=7;			
		}
		
	}
		
}

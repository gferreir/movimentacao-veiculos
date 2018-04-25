package projeto_poo;

import java.util.List;

/** Classe master onde deriva caminhão, carro e moto 
 * @author gferreira
 */

public class Vehicles { 
	
	private int x; /** Variável que representa a posição x na matriz */
	private int y; /** Variável que representa a posição y na matriz */
	private int velocity; /** Variável estática que varia dependendo do veículo
							* resposável pelo tamanho do deslocamento */
	private boolean factory; /** Variável responsável por armazenar se o 
							   * objeto está em alguma fábrica*/
	private String color;
	
	/** Get e Set da variável x 
	 *@return x 
	 **/
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	/** Get e Set da variável y */
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/** Get e Set da variável velocity */
	
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	/** Get e Set da variável boolean factory */
	
	public boolean isFactory() {
		return factory;
	}
	public void setFactory(boolean factory) {
		this.factory = factory;
	}
	
	/** Get e Set 
	 * da variável color*/
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	/** Método responsável pela movimentação
	 *  aletória dos objetos
	 * @return
	 */
	
	public int move() {
		double n;
		n = (int)(Math.random()*4);
		if(n==3)
			moveLeft();
		else if(n==2)
			moveRight();
		else if(n==1)
			moveUp();
		else
			moveDown();
		
		return checkFactory();
	}
	
	/** Método responsável pela
	 * movimentação e por checar as colisões
	 * do veículo caminhão
	 * @param t
	 * @return
	 */
	
	public int move(List<Truck>t) {
		int tmp;
		boolean crash;
		tmp = move();
		
		for(int i=0; i<t.size(); i++) { /** Check de colisão entre os mesmos tipos */
			crash = checkCollision(t.get(i));
			if(crash)
				return i; /** O return destroi caminhão */
		}
		
		return tmp;
	}
	
	/** Método responsável pela
	 * movimentação e por checar as colisões
	 * do veículo carro
	 * @param c
	 * @param t
	 * @return
	 */
	
	public int move(List<Car>c, List<Truck>t) {
		int tmp;
		boolean crash;
		tmp = move();
		
		for(int i=0; i<c.size(); i++) { /** Check de colisão entre os mesmos tipos de objetos */
			crash = checkCollision(c.get(i));
			if(crash)
				return i; /** O return destroi carro */
		}
		for(int i=0; i<t.size(); i++) { /** Check de colisão entre carro e caminhão */
			crash = checkCollision(t.get(i));
			if(crash)
				return -5; /** O return destroi carro */
		}
		
		return tmp;
	}
	
	/** Método responsável pela
	 * movimentação e por checar as colisões
	 * do veículo moto
	 * @param m
	 * @param c
	 * @param t
	 * @return
	 */
	
	public int move(List<Motorcycle>m, List<Car>c, List<Truck>t) {
		int tmp;
		boolean crash;
		tmp = move();
		
		for(int i=0; i<m.size(); i++) { /** Check de colisão entre os mesmos tipos */
			crash = checkCollision(m.get(i));
			if(crash)
				return i; /** O return destroi moto */
		}
		for(int i=0; i<c.size(); i++) { /** Check de colisão entre moto e carro */
			crash = checkCollision(c.get(i));
			if(crash)
				return -5; /** O return destroi moto */
		}
		for(int i=0; i<t.size(); i++) { /** Check de colisão entre moto e caminhão */
			crash = checkCollision(t.get(i));
			if(crash)
				return -5; /** O return destroi moto */
		}
		
		return tmp;
	}
	
	/** Método responsável por verificar
	 * se houve uma colisão entre dois
	 * objetos, fazendo a verificação se ocupam
	 * uma mesma posição
	 * @param v
	 * @return
	 */
	
	private boolean checkCollision(Vehicles v) {
		if((this.x == v.getX()) && (this.y == v.getY()))
			return true;
		
		return false;
	}
	
	/** Método responsável por verificar
	 * se houve colisão entre um objeto veículo
	 * com alguma fábrica
	 * @return
	 */
	
	private int checkFactory() { 

		if(((y>5 && y<11) || (y>48 && y<54)) && ((x>3 && x<7) || (x>13 && x<17) || (x>22 && x<26))){
			if(!factory) {
				factory = true;
				return -2;
			}
		}
		
		else
			factory = false;
		return -1;
	}
	
	/** Método responsável em
	 * realizar a movimentação
	 * da variável y para esquerda
	 * e tornar ela cíclica
	 */
	
	private void moveLeft() {
		y=(y-velocity)%60;
		if(y<0) {
			y=60-Math.abs(y);
		}
	}
	
	/** Método responsável em
	 * realizar a movimentação
	 * da variável y para direita
	 * e tornar ela cíclica
	 */
	
	private void moveRight() {
		y=(y+velocity)%60;
	}
	
	/** Método responsável em
	 * realizar a movimentação
	 * da variável x para esquerda
	 * e tornar ela cíclica
	 */
	
	private void moveUp() {
		x=(x-velocity)%30;
		if(x<0)
			x=30-Math.abs(x);
	}
	
	/** Método responsável em
	 * realizar a movimentação
	 * da variável x para direita
	 * e tornar ela cíclica
	 */
	
	private void moveDown() {
		x=(x+velocity)%30;
	}
	
	/** Construtor */
	
	public Vehicles(int x, int y, int velocity, boolean factory, String color) {
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.factory = factory;
		this.color = color;
	}
	
}

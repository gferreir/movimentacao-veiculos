package projeto_poo;

import java.util.List;
//import java.util.ArrayList;

public class Vehicles {
	
	private int x;
	private int y;
	private int velocity;
	private boolean factory;
	private String color;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	
	public boolean isFactory() {
		return factory;
	}
	public void setFactory(boolean factory) {
		this.factory = factory;
	}
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
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
	
	//Movimenta e checa as colisões
	
	public int move(List<Truck>t) {
		int tmp;
		boolean crash;
		tmp = move();
		
		for(int i=0; i<t.size(); i++) { //check de colisão entre os mesmos tipos
			crash = checkCollision(t.get(i));
			if(crash)
				return i; //return destroi caminhão
		}
		
		return tmp;
	}
	
	public int move(List<Car>c, List<Truck>t) {
		int tmp;
		boolean crash;
		tmp = move();
		
		for(int i=0; i<c.size(); i++) { //check de colisão entre os mesmos tipos
			crash = checkCollision(c.get(i));
			if(crash)
				return i; //return destroi carro
		}
		for(int i=0; i<t.size(); i++) { //check de colisão entre carro e caminhão
			crash = checkCollision(t.get(i));
			if(crash)
				return -5; //return destroi carro
		}
		
		return tmp;
	}
	
	public int move(List<Motorcycle>m, List<Car>c, List<Truck>t) {
		int tmp;
		boolean crash;
		tmp = move();
		
		for(int i=0; i<m.size(); i++) { //check de colisão entre os mesmos tipos
			crash = checkCollision(m.get(i));
			if(crash)
				return i; //return destroi moto
		}
		for(int i=0; i<c.size(); i++) { //check de colisão entre moto e carro
			crash = checkCollision(c.get(i));
			if(crash)
				return -5; //return destroi moto
		}
		for(int i=0; i<t.size(); i++) { //check de colisão entre moto e caminhão
			crash = checkCollision(t.get(i));
			if(crash)
				return -5; //return destroi moto
		}
		
		return tmp;
	}
	
	
	
	private boolean checkCollision(Vehicles v) {
		if((this.x == v.getX()) && (this.y == v.getY()))
			return true;
		
		return false;
	}
	
	private int checkFactory() { //return -2 colisão com fabrica de caminhão
		if(x==4 && ((y>5 && y<11) || (y>48 && y<54))) {
			if(!factory) {
				//metodo que cria
				factory = true;
				return -2;
			}
		}
				
		else if(x==5 && ((y>5 && y<11) || (y>48 && y<54))) {
			if(!factory) {
				//metodo que cria
				factory = true;
				return -2;
			}
		}
		else if(x==6 && ((y>5 && y<11) || (y>48 && y<54))) {
			if(!factory) {
				//metodo que cria
				factory = true;
				return -2;
			}
		}
		
		
		else if(x==14 && ((y>5 && y<11) || (y>48 && y<54))) { //return -3 colisão com fabrica de carro
			if(!factory) {
				//metodo que cria
				factory = true;
				return -3;
			}
		}
		else if(x==15 && ((y>5 && y<11) || (y>48 && y<54))) {
			if(!factory) {
				//metodo que cria
				factory = true;
				return -3;
			}
		}
		else if(x==16 && ((y>5 && y<11) || (y>48 && y<54))) {
			if(!factory) {
				//metodo que cria
				factory = true;
				return -3;
			}
		}
		
		
		else if(x==23 && ((y>5 && y<11) || (y>48 && y<54))) { //return -4 colisão com fabrica de moto
			if(!factory) {
				//metodo que cria
				factory = true;
				return -4;
			}
		}
		else if(x==24 && ((y>5 && y<11) || (y>48 && y<54))) {
			if(!factory) {
				//metodo que cria
				factory = true;
				return -4;
			}
		}
		else if(x==25 && ((y>5 && y<11) || (y>48 && y<54))) {
			if(!factory) {
				//metodo que cria
				factory = true;
				return -4;
			}
		}
		
		
		else
			factory = false;
		
		
		return -1;
	}
	
	
	private void moveLeft() {
		y=(y-velocity)%60;
		if(y<0) {
			y=60-Math.abs(y);
		}
	}
	private void moveRight() {
		y=(y+velocity)%60;
	}
	private void moveUp() {
		x=(x-velocity)%30;
		if(x<0)
			x=30-Math.abs(x);
	}
	private void moveDown() {
		x=(x+velocity)%30;
	}
	
	public Vehicles(int x, int y, int velocity, boolean factory, String color) {
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.factory = factory;
		this.color = color;
	}
	
}

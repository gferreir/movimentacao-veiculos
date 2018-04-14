package projeto_poo;

public class Vehicles {
	
	int x;
	int y;
	int velocity;
	boolean factory;
	String color;
	
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
	
	
	public void moveLeft() {
		
	}
	public void moveRight() {
		
	}
	public void moveFront() {
		
	}
	public void moveBack() {
		
	}
	
	public Vehicles(int x, int y, int velocity, boolean factory, String color) {
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.factory = factory;
		this.color = color;
	}
	
}










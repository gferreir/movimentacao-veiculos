package projeto_poo;

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
	
	public void move() {
		double n;
		n = Math.random()*4;
		if(n>3)
			moveLeft();
		else if(n>2)
			moveRight();
		else if(n>1)
			moveForward();
		else
			moveBack();
	}
	
	private void moveLeft() {
		x=(x+velocity)%30;
	}
	private void moveRight() {
		x=(x+velocity)%30;
	}
	private void moveForward() {
		y=(y+velocity)%60;
	}
	private void moveBack() {
		y=(y+velocity)%60;
	}
	
	public Vehicles(int x, int y, int velocity, boolean factory, String color) {
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.factory = factory;
		this.color = color;
	}
	
}










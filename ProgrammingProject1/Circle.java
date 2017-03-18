import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Oval {

	public Circle(int X, int Y, int Width, int Height) {
		super(X, Y, Width, Height);
		
	}
	
	public double getArea() {		
		return Math.PI * getWidth() * getHeight();
	}
	
	public void render(Graphics g) {
		if(super.getHit()){
			g.drawOval(getX(), getY(), getWidth(), getWidth());
			g.setColor(super.getColor());
			g.fillOval(getX(), getY(), getWidth(), getWidth());
			g.setColor(super.getColor());
		}else{
			g.drawOval(getX(), getY(), getWidth(), getWidth());
			g.setColor(Color.WHITE);
			g.fillOval(getX() + 1, getY() + 1, getWidth()-2, getWidth()-2);
			g.setColor(super.getColor());
		}
	}

}

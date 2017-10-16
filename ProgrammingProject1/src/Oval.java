import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval implements Shape {
	
private int X;
private int Y;
private int Width;
private int Height;
private boolean tested;
private Color color;

	public Oval(int X, int Y, int Width, int Height){
		this.Height = Height;
		this.Width = Width;
		this.X = X;
		this.Y = Y;

	}
	@Override
	public void render(Graphics g) {
		if (tested){
			g.drawOval(X, Y, Width, Height);
			g.setColor(color);
			g.fillOval(X, Y, Width, Height);
			g.setColor(color);			
		}else {
			g.drawOval(X, Y, Width, Height);
			g.setColor(Color.WHITE);
			g.fillOval(X + 1, Y + 1, Width - 2, Height - 2);
			g.setColor(color);
		}
	}

	@Override
	public boolean hitTest(Point pt, HitTestChangeListener listener) {
		if (((pt.getX() >= X && (pt.getX() <= X + Width)) && (pt.getY() >= Y && (pt.getY() <= Y + Height)))){
			listener.OnHitTestChange();
			this.tested = true;
			return true;
		}else{
			this.tested = false;
			return false;
		}
		
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		
	}

	@Override
	public double getArea() {		
		return Math.PI * this.Width * this.Height;
	}

	@Override
	public Point getPosition() {
		Point ret = new Point(this.X, this.Y);
		return ret;
	}

	@Override
	public void setPosition(Point point) {
		this.X = (int) point.getX();
		this.Y = (int) point.getY();
		
	}
	
	
	public int getWidth(){return this.Width;}
	public int getHeight(){return this.Height;}
	public int getX(){return this.X;}
	public int getY(){return this.Y;}
	public boolean getHit(){return this.tested;}
	public Color getColor(){return this.color;}
}

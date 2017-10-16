import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle implements Shape {
	
	private int X;
	private int Y;
	private int Height;
	private int Width;
	private Color color;
	private boolean tested;
	
	public Rectangle(int X, int Y, int height, int width){
		this.Height = height;
		this.Width = width;
		this.X = X;
		this.Y = Y;
	}
	
	
	@Override
	public void render(Graphics g) {
		if (tested){
			g.drawRect(X, Y, Width, Height);
			g.setColor(color);
			g.fillRect(X, Y, Width, Height);
			g.setColor(color);
			
		}else{
			g.setColor(color);
			g.drawRect(X, Y, Width, Height);
			g.setColor(Color.WHITE);
			g.fillRect(X + 1, Y + 1, Width-1, Height-1);
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
		return (Height+1) * (Width+1);
	}

	@Override
	public Point getPosition() {
		Point position = new Point(X, Y);		
		return position;
	}
	
	public boolean getHit(){return this.tested;}
	
	public Color getColor(){
		return this.color;
	}

	@Override
	public void setPosition(Point point) {
		this.X = (int) point.getX();
		this.Y = (int) point.getY();
		}	
	
	public int getX(){return this.X;} 
	public int getY(){return this.Y;}
	public int getWidth(){return this.Width;}
	public int getHeight(){return this.Height;}
	public void setX(int x){this.X = x;}
	public void setY(int y){this.Y = y;}
} 

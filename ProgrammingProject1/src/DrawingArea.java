import java.awt.*;
import java.awt.Point;
import java.util.*;

public class DrawingArea extends DrawingAreaBase implements HitTestChangeListener {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	@Override
	public double getTotalShapeArea() {
		int area = 0;
		for(int x = 0; x < shapes.size(); x++){
			area += shapes.get(x).getArea();
		}
		return area; 
	}

	@Override
	public void renderShapes(Graphics g) {
		for(int x = 0; x < shapes.size(); x++){
			shapes.get(x).render(g);
			//System.out.println(shapes.get(x).getPosition());
		}
		
	}

	@Override
	public Shape findFirstShapeHit (Point point) {
		for (int x = 0; x < shapes.size(); x++){
			if(shapes.get(x).hitTest(point, this)){
				handleShapeClicked(shapes.get(x));
				return shapes.get(x);
			}
		}
		return null;
	}

	@Override
	public void handleShapeClicked(Shape shape) {
			addShape(shape);
		
	}

	@Override
	public void hitTestAllShapes(Point point) {
		for (int x = 0; x < shapes.size(); x++){
			shapes.get(x).hitTest(point, this);
		}
		
	}

	@Override
	public void addShape(Shape s) {
		shapes.add(s);
		//System.out.println(shapes.size());
		
	}

	@Override
	public void removeAllShapes() {
		shapes.clear();
		
	}

}

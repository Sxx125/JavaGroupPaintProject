package paint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

/**
 * Draws the Shapes on the Paint Panel
 * 
 * @author Procrastinators
 *
 */
public class DrawShapeFactory 
{
	private ArrayList<Shape> shapes; //List of all shapes in canvas
	private Shape current; //Shape that user is drawing
	public DrawShapeFactory(ArrayList<Shape> shapes, Shape current)
	{
		this.shapes = shapes;
		this.current = current;
	}

	/**
	 * Paint the shape objects onto the paint panel;
	 * View aspect of this.
	 * 
	 * @param g - graphic component
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
        
        
        for (Shape s: this.shapes) 
        {
        	String type = s.getType();
        	g2d.setColor(s.getColor());
        	int x = s.getStart().getX();
			int y = s.getStart().getY();
    		int width = s.getWidth();
    		int height = s.getHeight();
    		boolean fill = s.getFill();
    		int lineThickness = s.getThickness();
			
        	if (type == "Circle")
        	{
        		int radius;
        		width = Math.abs(width);
        		height = Math.abs(height);
        		if (width >= height)
        		{
        			radius = width;
        		}
        		else
        		{
        			radius = height;
        		}
        		if (fill == false){
        			for (int i = 0; i < lineThickness; i++)
            		{
            			g2d.drawOval(x-radius+i, y-radius+i, 2*radius-2*i,2*radius-2*i);
            		}
        		} else {
        			g2d.fillOval(x-radius, y-radius, 2*radius,2*radius);
        		}
        	}
        	else if (type == "Square")
        	{
        		int side;
        		if (Math.abs(width) >= Math.abs(height))
        		{
        			side = width;
        		}
        		else
        		{
        			side = height;
        		}
        		side = Math.abs(side);
        		if (width < 0)
        		{
        			x = x - side;
        		}
        		if (height < 0)
        		{
        			y = y - side;
        		}
        		if (fill == false){
        			for (int i = 0; i < lineThickness; i++)
            		{
            			g2d.drawRect(x+i, y+i, side-2*i, side-2*i);
            		}
        		} else {
        			g2d.fillRect(x, y, side, side);
        		}
        	}
        	else if (type == "Rectangle")
        	{
        		if (width < 0)
        		{
        			x = x + width;
        		}
        		if (height < 0)
        		{
        			y = y + height;
        		}
        		width = Math.abs(width);
        		height = Math.abs(height);
        		if (fill == false){
        			for (int i = 0; i < lineThickness; i++)
            		{
            			g2d.drawRect(x+i, y+i, width-2*i, height-2*i);
            		}
        		} else {
        			g2d.fillRect(x, y, width, height);
        		}
        	}
        	else if (type == "Polyline")
        	{
        		Polyline polyline = ((Polyline)s);
        		int numPoints = polyline.getNumPoints();
        		ArrayList<Point> points = polyline.getPoints();
        		int[] xValues = new int[numPoints];
    			int[] yValues = new int[numPoints];
    			for(int j = 0; j < lineThickness; j++){
    				for(int i = 0; i < numPoints; i++){
    					xValues[i] = points.get(i).getX()+j;
    					yValues[i] = points.get(i).getY();
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    				for(int i = 0; i < numPoints; i++){
    					xValues[i] = points.get(i).getX();
    					yValues[i] = points.get(i).getY()+j;
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    			}
        	}
        	else if (type == "Squiggle")
        	{
        		Squiggle squiggle = ((Squiggle)s);
        		int numPoints = squiggle.getNumPoints();
        		ArrayList<Point> points = squiggle.getPoints();
        		//Width value used for numPoints in this instance
        		int[] xValues = new int[numPoints];
    			int[] yValues = new int[numPoints];
    			for(int j = 0; j < lineThickness; j++){
    				for(int i = 0; i < numPoints; i++){
    					xValues[i] = points.get(i).getX()+j;
    					yValues[i] = points.get(i).getY();
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    				for(int i = 0; i < numPoints; i++){
    					xValues[i] = points.get(i).getX();
    					yValues[i] = points.get(i).getY()+j;
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    			}
        	}
        }
        
        //Draw current shape above existing
        if (this.current!=null)
        {
        	g2d.setColor(this.current.getColor());
        	int x = this.current.getStart().getX();
			int y = this.current.getStart().getY();
    		int width = this.current.getWidth();
    		int height = this.current.getHeight();
    		int lineThickness = this.current.getThickness();
    		boolean fill = this.current.getFill();
        	if (this.current.getType() == "Polyline")
        	{
        		Polyline polyline = (Polyline)this.current;
        		int numPoints = polyline.getNumPoints();
    			int[] xValues = new int[numPoints];
    			int[] yValues = new int[numPoints];
    			ArrayList<Point> points = polyline.getPoints();
    			for(int j = 0; j < lineThickness; j++){
    				for(int i = 0; i < numPoints; i++){
    					xValues[i] = points.get(i).getX()+j;
    					yValues[i] = points.get(i).getY();
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    				for(int i = 0; i < numPoints; i++){
    					xValues[i] = points.get(i).getX();
    					yValues[i] = points.get(i).getY()+j;
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    			}
        	}
        	else if (this.current.getType() == "Squiggle")
        	{
        		Squiggle squiggle = (Squiggle)this.current;
        		int numPoints = squiggle.getNumPoints();
    			int[] xValues = new int[numPoints];
    			int[] yValues = new int[numPoints];
    			ArrayList<Point> points = squiggle.getPoints();
    			for(int j = 0; j < lineThickness; j++){
    				for(int i = 0; i < numPoints; i++){
    					xValues[i] = points.get(i).getX()+j;
    					yValues[i] = points.get(i).getY();
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    				for(int i = 0; i < width; i++){
    					xValues[i] = points.get(i).getX();
    					yValues[i] = points.get(i).getY()+j;
    				}
    				g2d.drawPolyline(xValues, yValues, numPoints);
    			}
        	}
        	else if (this.current.getType() == "Circle")
        	{
        		int radius;
        		width = Math.abs(width);
        		height = Math.abs(height);
        		if (width >= height)
        		{
        			radius = width;
        		}
        		else
        		{
        			radius = height;
        		}
        		for (int i = 0; i < lineThickness; i++)
            	{
            		g2d.drawOval(x-radius+i, y-radius+i, 2*radius-2*i,2*radius-2*i);
            	}	
        	}
        	else if (this.current.getType() == "Square")
        	{
        		int side;
        		if (Math.abs(width) >= Math.abs(height))
        		{
        			side = width;
        		}
        		else
        		{
        			side = height;
        		}
        		side = Math.abs(side);
        		if (width < 0)
        		{
        			x = x - side;
        		}
        		if (height < 0)
        		{
        			y = y - side;
        		}
        		if (fill == false){
        			for (int i = 0; i < lineThickness; i++)
            		{
            			g2d.drawRect(x+i, y+i, side-2*i, side-2*i);
            		}
        		}
        	}
        	else if (this.current.getType() == "Rectangle")
        	{
        		if (width < 0)
        		{
        			x = x + width;
        		}
        		if (height < 0)
        		{
        			y = y + height;
        		}
        		width = Math.abs(width);
        		height = Math.abs(height);
        		if (fill == false){
        			for (int i = 0; i < lineThickness; i++)
            		{
            			g2d.drawRect(x+i, y+i, width-2*i, height-2*i);
            		}
        		}
        	}
        }
        g2d.dispose();
        
	}

}

/**
 * 
 */
package td_geometrics;

/**
 * @author fedou
 *
 */
public class Rectangle implements Polygon {

	// Propertys
	
	double length;
	double width;
	
	// Constructor
	
	public Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}
	
	// Getters Satters
	
	public double getLength()
	{
		return this.length;
	}
	
	public double getWidth()
	{
		return this.width;
	}
	
	public void setLength()
	{
		
	}
	
	public void setWidth()
	{
		
	}
	
	// Methods
	
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

}

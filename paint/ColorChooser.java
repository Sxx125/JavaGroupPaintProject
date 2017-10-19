package paint;

import java.awt.*;

import javax.swing.*;

/**
 * This class provides the user with the ability to select the
 * line color of their paint drawings
 * 
 * @author Procrastinators
 * 
 */
public class ColorChooser 
{
	private static Color c;
	
	/**
	 * Displays a color palate to the user so that they can select
	 * the new drawing color of their choice.
	 * 
	 * @return c: new line color
	 */
	public static Color pickColor()
	{
		new JColorChooser();
		c = JColorChooser.showDialog(null, "Pick Color", Color.WHITE);
		if (c == null)
		{
			c = Color.white;
		}
		return c;
	}
	
	/**
	 * This method checks to see if an object is to be filled
	 * and returns a boolean value depending on the outcome.
	 * 
	 * @param currentFill boolean
	 * @return boolean value depending on if Fill is enabled or not.
	 */
	public static boolean pickFill(boolean currentFill)
	{
		if (currentFill == false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}

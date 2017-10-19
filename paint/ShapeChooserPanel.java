package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * This class is responsible for generating the mode panel with which
 * users interact to select or switch between drawable shape objects.
 * 
 * @author Procrastinators
 *
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private JButton[] buttons = new JButton[5]; //Set of buttons involved in the panel
	private ImageIcon[] icons = icons(); //Icons associated with the buttons
	
	/**
	 * Creates the Shape Chooser Panel
	 * 
	 * Initializes and adds new buttons for each variation of shape object to a JPanel
	 * and connects them to the view and controller.
	 * 
	 * @param view
	 */
	public ShapeChooserPanel(View view) {	
		this.view=view;
		int i = 0;
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		for (String label : buttonLabels) {
			JButton button = new JButton(label,icons[i]);
			if (i == 0){button.setForeground(Color.ORANGE);}
			this.add(button);
			this.buttons[i] = button;
			
			button.addActionListener(this);
			i +=1;
		}
	}
	
	/**
	 * Arranges the image icons of the different shapes
	 * in an array for easier future referencing and use.
	 * 
	 * @return icons: and ImageIcon array
	 */
	public ImageIcon[] icons()
	{
		ImageIcon[] icons = new ImageIcon[5];
		icons[0] = new ImageIcon("Resources/circle.png");
		icons[1] = new ImageIcon("Resources/rectangle.png");
		icons[2] = new ImageIcon("Resources/square.png");
		icons[3] = new ImageIcon("Resources/squiggle.png");
		icons[4] = new ImageIcon("Resources/polyline.png");
		return icons;
		
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		this.view.getPaintPanel().setMode(command);
		System.out.println(command);
		for (JButton b: this.buttons)
		{
			if (e.getSource() == b)
			{
				b.setForeground(Color.ORANGE);
			}
			else
			{
				b.setForeground(Color.BLACK);
			}
		}
	}

	
}

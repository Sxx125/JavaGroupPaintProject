package paint;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	private final String[] lineThickness = {"1pt", "2pt", "3pt", "4pt", "5pt"};
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	
	/**
	 * Frame GUI - View
	 * 
	 * @param model
	 */
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		Container c=this.getContentPane();
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		c.add(this.shapeChooserPanel,BorderLayout.WEST);
	
		this.model=model;
		
		this.paintPanel = new PaintPanel(model, this);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		this.pack();
		this.setSize(this.getHeight(),this.getHeight());
		
		this.setVisible(true);
	}
	
	/**
	 * Fetch the Paint Panel
	 * @return paintPanel
	 */
	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	/**
	 * Fetch the Mode Panel
	 * @return shapeChooserPanel
	 */
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	/**
	 * Menu Bar GUI
	 * 
	 * Create menu options, buttons, and drop down menus.
	 * @return JMenuBar component
	 */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);
		
		//Menu Bar Option (Drop Down) - Line Thickness
		menu = new JMenu("Line Thickness");
		
		menuItem = new JMenuItem("1pt");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("2pt");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("3pt");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("4pt");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("5pt");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		//Menu Buttons - Undo, Redo, Color, Fill
		JButton menuButtonUndo = new JButton("Undo");
		menuButtonUndo.addActionListener(this);
		menuBar.add(menuButtonUndo);
		
		JLabel space = new JLabel("   ");
		menuBar.add(space);
		
		JButton menuButtonRedo = new JButton("Redo");
		menuButtonRedo.addActionListener(this);
		menuBar.add(menuButtonRedo);
		
		JLabel space2 = new JLabel("   ");
		menuBar.add(space2);
		
		JButton menuButtonColor = new JButton("Color");
		menuButtonColor.addActionListener(this);
		menuBar.add(menuButtonColor);
		
		JLabel space3 = new JLabel("   ");
		menuBar.add(space3);
		
		JButton menuButtonFill = new JButton("Fill");
		menuButtonFill.addActionListener(this);
		menuBar.add(menuButtonFill);
		
		return menuBar;
	}

	/**
	 * Controller aspect
	 */	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		
		//Pick a color
		if (command == "Color") {
			this.paintPanel.setColor(ColorChooser.pickColor());
		}
		
		//Change Fill
		if (command == "Fill") {
			this.paintPanel.setFill(ColorChooser.pickFill(this.paintPanel.getFill()));
		}
			
		//New Game
		if (command == "New") {
			this.model.newDrawing();
			this.paintPanel.setMoves(0);
		}
		
		//Exit Game
		if (command == "Exit") {
			System.exit(0);
		}
		
		//Undo Action
		if (command == "Undo") {
			this.model.undo();
		}
		
		//Re-do Action
		if (command == "Redo") {
			this.model.redo();
		}
		
		//Set line thickness
		for (String s: this.lineThickness){
			if (command.equals(s)){
				this.paintPanel.setThickness(command);
			}
		}
	}
	
}

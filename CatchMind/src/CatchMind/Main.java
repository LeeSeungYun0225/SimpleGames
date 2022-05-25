package CatchMind;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JPanel
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CatchMind panel = new CatchMind();
		
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
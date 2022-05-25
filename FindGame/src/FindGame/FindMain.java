package FindGame;


import java.awt.*;
import javax.swing.*;

public class FindMain extends JPanel
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800,640));
		TotalFindGame tfg = new TotalFindGame();
		
		frame.getContentPane().add(tfg);
		
		frame.pack();
		frame.setVisible(true);
	}
}
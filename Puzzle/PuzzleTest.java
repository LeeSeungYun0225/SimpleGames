import java.awt.*;
import javax.swing.*;

public class PuzzleTest extends JPanel
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TotalPuzzle pz = new TotalPuzzle();
		
		frame.getContentPane().add(pz);
		frame.pack();
		frame.setVisible(true);
	}		
}




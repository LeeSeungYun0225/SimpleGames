package FindGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;//배열 사용을 위해 


public class FindGame2 extends JPanel
{
	private ImageIcon topImage,botImage;
	private JLabel toplbl,botlbl;
	private ImageIcon[] CircleImage;
	private JLabel[] topCircle,botCircle;
	private JLabel[] Clicklbl;
	private int[] check;

	public FindGame2()
	{
		
		setLayout(null);
		setPreferredSize(new Dimension(742,546));
		
		topImage = new ImageIcon("2top.jpg");
		botImage = new ImageIcon("2bot.jpg");
		toplbl = new JLabel("",topImage,SwingConstants.CENTER);
		botlbl = new JLabel("",botImage,SwingConstants.CENTER);
		
		toplbl.setBounds(0,0,742,278);
		botlbl.setBounds(0,272,742,274);
		
		topCircle = new JLabel[5];
		botCircle = new JLabel[5];
		CircleImage = new ImageIcon[10];
		
		InitCircleImage();
		setCircleImage();
		add(botlbl);
		add(toplbl);
		
		Clicklbl = new JLabel[10];
		
		setClicklbl();
		check = new int[5];
		setcheck();
		
		setVisible(false);
}
	
	
	public void InitCircleImage()
	{
		for(int i=0;i<10;i++)
		{
			CircleImage[i] = new ImageIcon("2Circle"+i+".jpg");
		}
		for(int i=0;i<5;i++)
		{
			topCircle[i] = new JLabel("",CircleImage[i],SwingConstants.CENTER);
		}
		for(int i=5;i<10;i++)
		{
			botCircle[i-5] = new JLabel("",CircleImage[i],SwingConstants.CENTER);
		}
	}
	
	public void setCircleImage()
	{
		topCircle[0].setBounds(2,4,28,25);
		topCircle[1].setBounds(91,162,28,31);
		topCircle[2].setBounds(332,170,27,28);
		topCircle[3].setBounds(543,178,25,28);
		topCircle[4].setBounds(667,82,26,28);
		botCircle[0].setBounds(2,278,26,29);
		botCircle[1].setBounds(92,437,27,29);
		botCircle[2].setBounds(334,446,28,28);
		botCircle[3].setBounds(540,443,28,27);
		botCircle[4].setBounds(662,353,27,26);
	
		for(int i=0;i<5;i++)//둘다 이미지패널에 add한뒤 안보이게 바꾼다 
		{
			add(topCircle[i]);
			add(botCircle[i]);
			topCircle[i].setVisible(false);
			botCircle[i].setVisible(false);
		}
	}
	
	public JLabel[] gettopCircle()
	{
		return topCircle;
	}
	public JLabel[] getbotCircle()
	{
		return botCircle;
	}
	public JLabel[] getClicklbl()
	{
		return Clicklbl;
	}
	
	public void setClicklbl()
	{
		for(int i=0;i<10;i++)
		{
			Clicklbl[i] = new JLabel();
			add(Clicklbl[i]);
		}
		Clicklbl[0].setBounds(2,4,28,25);
		Clicklbl[1].setBounds(91,162,28,31);
		Clicklbl[2].setBounds(332,170,27,28);
		Clicklbl[3].setBounds(543,178,25,28);
		Clicklbl[4].setBounds(667,82,26,28);
		Clicklbl[5].setBounds(2,278,26,29);
		Clicklbl[6].setBounds(92,437,27,29);
		Clicklbl[7].setBounds(334,446,28,28);
		Clicklbl[8].setBounds(540,443,28,27);
		Clicklbl[9].setBounds(662,353,27,26);
	
	}
	
	public int[] getcheck()
	{
		return check;
	}
	public int getRemain()
	{
		int remain = 0;
		for(int i=0;i<5;i++)
		{
			if(check[i] == 0)
			{
				remain++;
			}
		}
		return remain;
	}
	public int getAll()
	{
		return 5;
	}
	public void setcheck()
	{
		for(int i=0;i<5;i++)
		{
			check[i] = 0;
		}
	}
	public void setcheck(int index,int x)
	{
		check[index] = x;
	}
	
	public boolean checkGame()
	{
	 	boolean tf = true;
	 	for(int i=0;i<5;i++)
	 	{
	 		if(check[i] == 0)
	 		{
	 			tf = false;	
	 		}
	 	}
	 	
	 	if(!tf)
	 	{
	 		return true;
	 	}
	 	else 
	 	{
	 		return false;
	 	}
	}
	 
	 public void fillcheck()
	 {
	 	for(int i=0;i<5;i++)
	 	{
	 		check[i] = 1;
	 	}
	 }
	 
	 
	public JLabel[] gettopCirclelbl()
	{
		return topCircle;
	}
	
	public JLabel[] getbotCirclelbl()
	{
		return botCircle;
	}
	 


}

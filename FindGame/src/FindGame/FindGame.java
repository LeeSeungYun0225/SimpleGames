package FindGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;//배열 사용을 위해 


public class FindGame extends JPanel//첫번째 그림 패널 
{
	private ImageIcon leftImage,rightImage;//좌 우 이미지 
	private JLabel leftlbl,rightlbl;//좌 우 라벨 
	private ImageIcon[] CircleImage;//원 이미지 배열
	private JLabel[] leftCircle,rightCircle;// 원 이미지를 담을 배열 
	private JLabel[] Clicklbl;//클릭할 라벨 배열 
	private int[] check;//맞은 문제 체크 배열 

	public FindGame()
	{
		setLayout(null);
		setPreferredSize(new Dimension(740,300));
		setBackground(Color.red);
		leftImage = new ImageIcon("Left.jpg");
		rightImage = new ImageIcon("Right.jpg");
		leftlbl = new JLabel("",leftImage,SwingConstants.CENTER);
		rightlbl = new JLabel("",rightImage,SwingConstants.CENTER);

		leftlbl.setBounds(0,0,370,300);
		rightlbl.setBounds(370,0,370,300);
		
		
		leftCircle = new JLabel[7];
		rightCircle = new JLabel[7];
		CircleImage = new ImageIcon[14];
		
		InitCircleImage();
		setCircleImage();

		
		add(leftlbl);
		add(rightlbl);
		
		Clicklbl = new JLabel[14];
		
		setClicklbl();

		check = new int[7];
		setcheck();

		setVisible(false);
	}
	
	
	public void InitCircleImage()//동그라미 이미지들 가져오기 
	{
		for(int i=0;i<14;i++)
		{
			CircleImage[i] = new ImageIcon("Circle"+i+".jpg");
		}
		for(int i=0;i<7;i++)
		{
			leftCircle[i] = new JLabel("",CircleImage[i],SwingConstants.CENTER);
		}
		for(int i=7;i<14;i++)
		{
			rightCircle[i-7] = new JLabel("",CircleImage[i],SwingConstants.CENTER);
		}
	}
	
	public void setCircleImage()//동그라미 이미지들 위치설정 
	{
		leftCircle[0].setBounds(1,162,26,27);
		leftCircle[1].setBounds(50,128,26,27);
		leftCircle[2].setBounds(90,76,25,29);
		leftCircle[3].setBounds(130,99,24,27);
		leftCircle[4].setBounds(223,173,27,27);
		leftCircle[5].setBounds(259,107,28,26);
		leftCircle[6].setBounds(276,26,67,34);
		rightCircle[0].setBounds(374,166,24,27);
		rightCircle[1].setBounds(418,130,30,27);
		rightCircle[2].setBounds(462,79,24,27);
		rightCircle[3].setBounds(497,102,24,27);
		rightCircle[4].setBounds(594,176,27,28);
		rightCircle[5].setBounds(630,102,24,26);
		rightCircle[6].setBounds(649,26,65,37);
		for(int i=0;i<7;i++)//둘다 이미지패널에 add한뒤 안보이게 바꾼다 
		{
			add(leftCircle[i]);
			add(rightCircle[i]);
			leftCircle[i].setVisible(false);
			rightCircle[i].setVisible(false);
		}
	}
	
	//각종 set get 함수 
	public JLabel[] getleftCircle()
	{
		return leftCircle;
	}
	public JLabel[] getrightCircle()
	{
		return rightCircle;
	}
	public JLabel[] getClicklbl()
	{
		return Clicklbl;
	}
	
	public void setClicklbl()
	{
		for(int i=0;i<14;i++)
		{
			Clicklbl[i] = new JLabel();
			add(Clicklbl[i]);
		}
		Clicklbl[0].setBounds(1,162,26,27);
		Clicklbl[1].setBounds(50,128,26,27);
		Clicklbl[2].setBounds(90,76,25,29);
		Clicklbl[3].setBounds(130,99,24,27);
		Clicklbl[4].setBounds(223,173,27,27);
		Clicklbl[5].setBounds(259,107,28,26);
		Clicklbl[6].setBounds(276,26,67,34);
		Clicklbl[7].setBounds(374,166,24,27);
		Clicklbl[8].setBounds(418,130,30,27);
		Clicklbl[9].setBounds(462,79,24,27);
		Clicklbl[10].setBounds(497,102,24,27);
		Clicklbl[11].setBounds(594,176,27,28);
		Clicklbl[12].setBounds(630,102,24,26);
		Clicklbl[13].setBounds(649,26,65,37);
	}
	
	
	public void setcheck()
	{
		for(int i=0;i<7;i++)
		{
			check[i] = 0;
		}
	}
	
	public int getRemain()
	{
		int remain = 0;
		for(int i=0;i<7;i++)
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
		return 7;
	}
	public void setcheck(int index,int x)
	{
		check[index] = x;
	}
	public int[] getcheck()
	{
		return check;
	}
	
	public boolean checkGame()//남은 문제 있나 체크 있으면 true 없으면 false반환 
	{
	 	boolean tf = true;
	 	for(int i=0;i<7;i++)
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
	 
	 public void fillcheck()//answer버튼 누를때 필요한 함수 
	 {
	 	for(int i=0;i<7;i++)
	 	{
	 		check[i] = 1;
	 	}
	 }
	
	public JLabel[] getleftCirclelbl()
	{
		return leftCircle;
	}
	
	public JLabel[] getrightCirclelbl()
	{
		return rightCircle;
	}
	

	
}

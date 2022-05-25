package FindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class TotalFindGame extends JPanel
{
	//Object//
	private FindGame fg;
	private FindGame1 fg1;
	private FindGame2 fg2;
	//////////
	
	//Btn//
	private JButton Startbtn;//����
	private JButton Exitbtn;//������ 
	private JButton Answerbtn;//�� 
	private JButton Nextbtn;//�������ΰ��� 
	private JButton Backbtn;//�������ΰ��� 
	///////////////

	
	//Listener//
	private bListener bl;
	private MListener ml;
	/////////////////

	
	//Start//
	private JLabel Startlbl;
	private JLabel Startlbl1;
	private ImageIcon StartImage;
	///////////////
	
	//Score//
	private int score;
	public JLabel scorelbl;
	private int scoreactive;//������ ���ص� �� ��Ȳ���� ���� �ʿ� ���� ��Ȳ���� ���� 
	///////////////

//ETC//
	private JButton Resetbtn;//���¹�ư 
	private int checkend;//���������� ������ �÷��� �ߴ��� ���� 
	private int track;//������ ������ ���° �������� ���� 
	//////////////////
	
	//Remain
	private int countRemain;
	private int All;//�ش� ������ ��ü ���� ���� ���� 
	private JLabel remainlbl;//���� �� ���� ������ 
	/////////////////////
	
	//Background//
	private ImageIcon backgroundimage;
	private JLabel backgroundlbl;
	//////////////
	public TotalFindGame()
	{
		bl = new bListener();
		StartImage = new ImageIcon("FindGameMain.jpg");
		remainlbl = new JLabel();
		Startlbl = new JLabel("",StartImage,SwingConstants.CENTER);
		Startlbl1 = new JLabel("������ 10��, Ʋ���� -5��!");
		Startbtn = new JButton("S T A R T");
		Answerbtn = new JButton("Answer");
		Nextbtn = new JButton("Next");
		Backbtn = new JButton("Back");	
		Resetbtn = new JButton("Reset");	
		Exitbtn = new JButton("Exit");	
		ml = new MListener();	
		backgroundimage = new ImageIcon("bg3.jpg");;
		backgroundlbl = new JLabel("",backgroundimage,SwingConstants.CENTER);	
		Init();
	}//Default Constructor
	
	public void Init()
	{
		
		setPreferredSize(new Dimension(800,640));
		setLayout(null);
		setBackground(Color.white);
		checkend = 0;
		track = 0;
		countRemain = 0;
		All = 0;
		remainlbl.setVisible(false);
		Startlbl.setBounds(100,100,600,150);
		Startlbl1.setBounds(310,350,300,30);
		add(Startlbl);
		add(Startlbl1);
		Startbtn.setBackground(Color.black);
		Startbtn.setForeground(Color.white);
		Startbtn.setBounds(330,400,100,30);
		add(Startbtn);
		Startbtn.addActionListener(bl);
		Answerbtn.setBackground(Color.black);
		Answerbtn.setForeground(Color.white);
		Answerbtn.setBounds(330,570,100,30);
		add(Answerbtn);
		Answerbtn.addActionListener(bl);
		Answerbtn.setVisible(false);
		Nextbtn.setBackground(Color.black);
		Nextbtn.setForeground(Color.white);
		Nextbtn.setBounds(450,570,100,30);
		add(Nextbtn);
		Nextbtn.addActionListener(bl);
		Nextbtn.setVisible(false);
		Backbtn.setBackground(Color.black);
		Backbtn.setForeground(Color.white);
		Backbtn.setBounds(210,570,100,30);
		add(Backbtn);
		Backbtn.addActionListener(bl);
		Backbtn.setVisible(false);
		Backbtn.setEnabled(false);
		Resetbtn.setBackground(Color.black);
		Resetbtn.setForeground(Color.white);
		Resetbtn.setBounds(670,570,100,30);
		add(Resetbtn);
		Resetbtn.addActionListener(bl);
		Resetbtn.setVisible(false);
		Exitbtn.setBackground(Color.green);
		Exitbtn.setForeground(Color.white);
		Exitbtn.setBounds(10,570,100,30);
		add(Exitbtn);
		Exitbtn.addActionListener(bl);
		remainlbl.setFont(new Font("Verdana",Font.BOLD,30));
		remainlbl.setBounds(130,570,100,30);
		add(remainlbl);
		remainlbl.setVisible(false);
		fg = new FindGame();
		fg1 = new FindGame1();
		fg2 = new FindGame2();
		fg.setBounds(20,30,740,300);
		fg1.setBounds(20,10,746,548);
		fg2.setBounds(20,10,742,546);
		add(fg);
		add(fg1);
		add(fg2);
		fg.addMouseListener(ml);
		fg1.addMouseListener(ml);
		fg2.addMouseListener(ml);
		setClicklbl();
		setscore();
		backgroundlbl.setBounds(0,0,800,640);
		backgroundlbl.setVisible(true);
		add(backgroundlbl);
	}
	
	public void Reset()//���� ���° ������������ ã�� ���� ���������� �Լ� 
	{
		if(track == 1)
		{	
			fg.setcheck();
			for(int i=0;i<7;i++)
			{
				fg.getleftCirclelbl()[i].setVisible(false);
				fg.getrightCirclelbl()[i].setVisible(false);
			}
			if(checkend == 0)
			{
				score = score - 70;
			}
			countRemain = 7;
			All = 7;
			remainlbl.setText(""+countRemain+"/"+All);
			fg.setVisible(true);
		}
		else if(track == 2)
		{
			fg1.setcheck();
			for(int i=0;i<5;i++)
			{
				fg1.gettopCirclelbl()[i].setVisible(false);
				fg1.getbotCirclelbl()[i].setVisible(false);
			}
			fg1.setVisible(true);
			if(checkend == 0)
			{
				score = score - 50;
			}
			countRemain = 5;
			All = 5;
			remainlbl.setText(""+countRemain+"/"+All);
		}
		else if(track == 3)
		{
			fg2.setcheck();
			for(int i=0;i<5;i++)
			{
				fg2.gettopCirclelbl()[i].setVisible(false);
				fg2.getbotCirclelbl()[i].setVisible(false);
			}
			fg2.setVisible(true);
			if(checkend == 0)
			{
				score = score - 50;
			}
			countRemain = 5;
			All = 5;
			remainlbl.setText(""+countRemain+"/"+All);
		}
	}
	
	
	public void showAnswer()//�亸���ִ� �Լ� 
	{
		if(track == 1)
		{
			fg.fillcheck();
			for(int i=0;i<7;i++)
			{
				fg.getleftCirclelbl()[i].setVisible(true);
				fg.getrightCirclelbl()[i].setVisible(true);
			}
		}
		else if(track == 2)
		{
			fg1.fillcheck();
			for(int i=0;i<5;i++)
			{
				fg1.gettopCirclelbl()[i].setVisible(true);
				fg1.getbotCirclelbl()[i].setVisible(true);
			}
		}
		else if(track == 3)
		{
			fg2.fillcheck();
			for(int i=0;i<5;i++)
			{
				fg2.gettopCirclelbl()[i].setVisible(true);
				fg2.getbotCirclelbl()[i].setVisible(true);
			}
		}
	}
	
	private void setscore()//���� �ʱ�ȭ �Լ� 
	{
		score = 0;
		scorelbl = new JLabel("Score : "+score);
		scorelbl.setFont(new Font("Verdana",Font.BOLD,15));
		scorelbl.setVisible(false);
		scorelbl.setBounds(560,570,120,30);
		add(scorelbl);
		scoreactive = 0;
	}
	
	private void setscore(int tooverride)//���� �����Լ� 
	{
		score = score + 10;
		scorelbl.setText("Score : "+score);
	}
	
		
	public void setClicklbl()//Ŭ���ϸ� ���� �׷����� �󺧿� ���콺������ �ֵ� 
	{
		for(int i=0;i<14;i++)
		{
			fg.getClicklbl()[i].addMouseListener(ml);
		}
		for(int i=0;i<10;i++)
		{
			fg1.getClicklbl()[i].addMouseListener(ml);
			fg2.getClicklbl()[i].addMouseListener(ml);
		}
	}
	
	private class bListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object obj = event.getSource();
			
			if(obj == Startbtn)//���۹�ư ������ 
			{
				track = 1;
				scorelbl.setVisible(true);
				fg.setVisible(true);
				Startbtn.setVisible(false);
				Answerbtn.setVisible(true);
				Nextbtn.setVisible(true);
				Backbtn.setVisible(true);
				Resetbtn.setVisible(true);
				scoreactive = 1;//������ ��ȭ�ϴ� ���·� ���� 
				Startlbl.setVisible(false);
				Startlbl1.setVisible(false);
				Nextbtn.setEnabled(false);
				countRemain = 7;//���� ���� ���� 
				All = 7;//��ü ���� ���� 
				remainlbl.setVisible(true);
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if(obj == Answerbtn)//���� ����ϴ� ��ư 
			{	
				scoreactive = 0;//���� ��ȭ ������ ���� 
				if(track != 3)
				{
					showAnswer();//���� �����ִ� �Լ� 
					Answerbtn.setEnabled(false);
					Nextbtn.setEnabled(true);
					countRemain = 0;//���� �������� 0���� ���� 
					remainlbl.setText(""+countRemain+"/"+All);
				}
				else//����° �׸������� �������� �� ���� ���� ������ next�� false�� 
				{
					showAnswer();
					Answerbtn.setEnabled(false);
					Nextbtn.setEnabled(false);
					countRemain = 0;
					remainlbl.setText(""+countRemain+"/"+All);
				}
			}
			else if(obj == Nextbtn)//���� �׸����� �Ѿ�� ��ư 
			{
				if(track == 1)//ù��° �׸��� �� 
				{
					fg.setVisible(false);
					fg1.setVisible(true);//�ι�° �׸��� �����ְ� 
					Answerbtn.setEnabled(true);//answer��ư Ȱ��ȭ 
					Backbtn.setEnabled(true);//back��ư�� Ȱ��ȭ 
					if(checkend == 0)//������ ������ ������ ���� ���ٸ� 
					{
						Nextbtn.setEnabled(false);//Next��ư�� �������� 
					}
					else//�̹� ������ �� �����ؽ�ٸ� 
					{
						Nextbtn.setEnabled(true);//Next��ư�� ������� ������ 
					}
					scoreactive = 1;//���� �ø� �� �ֵ��� 
					track++;//track�� �������� �̹����� �Ѿ���� �˷��� 
					countRemain = fg1.getRemain();//���� ���� ������ 
					All = fg1.getAll();
					remainlbl.setText(""+countRemain+"/"+All);	
				}
				else if(track == 2)//�ι�° �׸��� �� 
				{
					fg1.setVisible(false);
					fg2.setVisible(true);
					Answerbtn.setEnabled(true);
					Nextbtn.setEnabled(false);
					scoreactive = 1;
					checkend = 1;
					track++;
					countRemain = fg2.getRemain();
					All = fg2.getAll();
					remainlbl.setText(""+countRemain+"/"+All);	
				}
			}
			else if(obj == Backbtn)//�ǵ��ư��� 
			{
				if(track == 2)//�ι�° �׸��� �� 
				{
					fg1.setVisible(false);
					fg.setVisible(true);
					Answerbtn.setEnabled(true);
					Backbtn.setEnabled(false);
					Nextbtn.setEnabled(true);
					scoreactive = 0;
					track--;
					countRemain = fg.getRemain();
					All = fg.getAll();
					remainlbl.setText(""+countRemain+"/"+All);	
				}
				else if(track == 3)//����° �׸��� �� 
				{
					fg2.setVisible(false);
					fg1.setVisible(true);
					Answerbtn.setEnabled(true);
					Nextbtn.setEnabled(true);
					scoreactive = 0;
					track--;
					countRemain = fg1.getRemain();
					All = fg1.getAll();
					remainlbl.setText(""+countRemain+"/"+All);	
				}
			}
			else if(obj == Resetbtn)//���� ��ư 
			{
				int checking;
				checking = JOptionPane.showConfirmDialog(null,"���� �����Ͻðڽ��ϱ�?");
				
				if(checking == JOptionPane.YES_OPTION)
				{
					scoreactive = 1;//�ٽ� ���� �ø����ְ� 
					Reset();//���� �� ���� 
					scorelbl.setText("Score : "+score);
				}
			}
			else if(obj == Exitbtn)//������ ��ư :: Reset�� ��� Track�� ���� �ؾ��� 
			{
				scoreactive = 0;//������ �ø� �� ���� 
				Reset();//�� ���� 
			}
		}
	}

	
	private class MListener implements MouseListener
	{
		public void mouseClicked(MouseEvent event)
		{}
		public void mousePressed(MouseEvent event)
		{
			Object obj = event.getSource();
			//�Ʒ��� ���� ���� Ŭ���ؼ� ���� ������ ��//
			if((obj == fg.getClicklbl()[0] || obj == fg.getClicklbl()[7]) && fg.getcheck()[0] == 0)//1����//
			{
				fg.getleftCircle()[0].setVisible(true);
				fg.getrightCircle()[0].setVisible(true);
				fg.setcheck(0,1);
				setscore(1);
				if(!fg.checkGame())
				{
					JOptionPane.showMessageDialog(null,"1���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg.getRemain();
				All = fg.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg.getClicklbl()[1] || obj == fg.getClicklbl()[8]) && fg.getcheck()[1] == 0)
			{
				fg.getleftCircle()[1].setVisible(true);
				fg.getrightCircle()[1].setVisible(true);
				fg.setcheck(1,1);
				setscore(1);
				if(!fg.checkGame())
				{
					JOptionPane.showMessageDialog(null,"1���� ����");	
					Nextbtn.setEnabled(true);
					scoreactive = 0;		
				}
				countRemain = fg.getRemain();
				All = fg.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg.getClicklbl()[2] || obj == fg.getClicklbl()[9]) && fg.getcheck()[2] == 0)
			{
				fg.getleftCircle()[2].setVisible(true);
				fg.getrightCircle()[2].setVisible(true);
				fg.setcheck(2,1);
				setscore(1);
				if(!fg.checkGame())
				{
					JOptionPane.showMessageDialog(null,"1���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg.getRemain();
				All = fg.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg.getClicklbl()[3] || obj == fg.getClicklbl()[10]) && fg.getcheck()[3] == 0)
			{	
				fg.getleftCircle()[3].setVisible(true);
				fg.getrightCircle()[3].setVisible(true);
				fg.setcheck(3,1);
				setscore(1);
				if(!fg.checkGame())
				{
					JOptionPane.showMessageDialog(null,"1���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg.getRemain();
				All = fg.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg.getClicklbl()[4] || obj == fg.getClicklbl()[11]) && fg.getcheck()[4] == 0)
			{
				fg.getleftCircle()[4].setVisible(true);
				fg.getrightCircle()[4].setVisible(true);
				fg.setcheck(4,1);
				setscore(1);
				if(!fg.checkGame())
				{
					JOptionPane.showMessageDialog(null,"1���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg.getRemain();
				All = fg.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg.getClicklbl()[5] || obj == fg.getClicklbl()[12]) && fg.getcheck()[5] == 0)
			{
				fg.getleftCircle()[5].setVisible(true);
				fg.getrightCircle()[5].setVisible(true);
				fg.setcheck(5,1);
				setscore(1);
				if(!fg.checkGame())
				{
					JOptionPane.showMessageDialog(null,"1���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg.getRemain();
				All = fg.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
				
			}
			else if((obj == fg.getClicklbl()[6] || obj == fg.getClicklbl()[13]) && fg.getcheck()[6] == 0)
			{
				fg.getleftCircle()[6].setVisible(true);
				fg.getrightCircle()[6].setVisible(true);
				fg.setcheck(6,1);
				setscore(1);
				if(!fg.checkGame())
				{
					JOptionPane.showMessageDialog(null,"1���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg.getRemain();
				All = fg.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg1.getClicklbl()[0] || obj == fg1.getClicklbl()[5]) && fg1.getcheck()[0] == 0)//2���� 
			{
				fg1.gettopCircle()[0].setVisible(true);
				fg1.getbotCircle()[0].setVisible(true);
				fg1.setcheck(0,1);
				setscore(1);
				if(!fg1.checkGame())
				{
					JOptionPane.showMessageDialog(null,"2���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg1.getRemain();
				All = fg1.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg1.getClicklbl()[1] || obj == fg1.getClicklbl()[6]) && fg1.getcheck()[1] == 0)
			{
				fg1.gettopCircle()[1].setVisible(true);
				fg1.getbotCircle()[1].setVisible(true);
				fg1.setcheck(1,1);
				setscore(1);
				if(!fg1.checkGame())
				{
					JOptionPane.showMessageDialog(null,"2���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg1.getRemain();
				All = fg1.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg1.getClicklbl()[2] || obj == fg1.getClicklbl()[7]) && fg1.getcheck()[2] == 0)
			{	
				fg1.gettopCircle()[2].setVisible(true);
				fg1.getbotCircle()[2].setVisible(true);
				fg1.setcheck(2,1);
				setscore(1);
				if(!fg1.checkGame())
				{
					JOptionPane.showMessageDialog(null,"2���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg1.getRemain();
				All = fg1.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg1.getClicklbl()[3] || obj == fg1.getClicklbl()[8]) && fg1.getcheck()[3] == 0)
			{
				fg1.gettopCircle()[3].setVisible(true);
				fg1.getbotCircle()[3].setVisible(true);
				fg1.setcheck(3,1);
				setscore(1);
				if(!fg1.checkGame())
				{
					JOptionPane.showMessageDialog(null,"2���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg1.getRemain();
				All = fg1.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg1.getClicklbl()[4] || obj == fg1.getClicklbl()[9]) && fg1.getcheck()[4] == 0)
			{
				fg1.gettopCircle()[4].setVisible(true);
				fg1.getbotCircle()[4].setVisible(true);
				fg1.setcheck(4,1);
				setscore(1);
				if(!fg1.checkGame())
				{
					JOptionPane.showMessageDialog(null,"2���� ����");
					Nextbtn.setEnabled(true);
					scoreactive = 0;
				}
				countRemain = fg1.getRemain();
				All = fg1.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg2.getClicklbl()[0] || obj == fg2.getClicklbl()[5]) && fg2.getcheck()[0] == 0)//3���� 
			{
				fg2.gettopCircle()[0].setVisible(true);
				fg2.getbotCircle()[0].setVisible(true);
				fg2.setcheck(0,1);
				setscore(1);
				if(!fg2.checkGame())
				{
					checkend = 1;
					scoreactive = 0;
				}
				if(!fg.checkGame() && !fg1.checkGame() && !fg2.checkGame())
				{
					JOptionPane.showMessageDialog(null,"���� ��.     ����  :  "+ score);
				}
				countRemain = fg2.getRemain();
				All = fg2.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg2.getClicklbl()[1] || obj == fg2.getClicklbl()[6]) && fg2.getcheck()[1] == 0)
			{
				fg2.gettopCircle()[1].setVisible(true);
				fg2.getbotCircle()[1].setVisible(true);
				fg2.setcheck(1,1);
				setscore(1);
				if(!fg2.checkGame())
				{
					checkend = 1;
					scoreactive = 0;
				}
				if(!fg.checkGame() && !fg1.checkGame() && !fg2.checkGame())
				{
					JOptionPane.showMessageDialog(null,"���� ��.     ����  :  "+ score);
				}
				countRemain = fg2.getRemain();
				All = fg2.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg2.getClicklbl()[2] || obj == fg2.getClicklbl()[7]) && fg2.getcheck()[2] == 0)
			{
				fg2.gettopCircle()[2].setVisible(true);
				fg2.getbotCircle()[2].setVisible(true);
				fg2.setcheck(2,1);
				setscore(1);
				if(!fg2.checkGame())
				{
					checkend = 1;
					scoreactive = 0;
				}
				if(!fg.checkGame() && !fg1.checkGame() && !fg2.checkGame())
				{
					JOptionPane.showMessageDialog(null,"���� ��.     ����  :  "+ score);
				}
				countRemain = fg2.getRemain();
				All = fg2.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg2.getClicklbl()[3] || obj == fg2.getClicklbl()[8]) && fg2.getcheck()[3] == 0)
			{
				fg2.gettopCircle()[3].setVisible(true);
				fg2.getbotCircle()[3].setVisible(true);
				fg2.setcheck(3,1);
				setscore(1);
				if(!fg2.checkGame())
				{
					checkend = 1;
					scoreactive = 0;
				}
				if(!fg.checkGame() && !fg1.checkGame() && !fg2.checkGame())
				{
					JOptionPane.showMessageDialog(null,"���� ��.     ����  :  "+ score);
				}
				countRemain = fg2.getRemain();
				All = fg2.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
			else if((obj == fg2.getClicklbl()[4] || obj == fg2.getClicklbl()[9]) && fg2.getcheck()[4] == 0)
			{
				fg2.gettopCircle()[4].setVisible(true);
				fg2.getbotCircle()[4].setVisible(true);
				fg2.setcheck(4,1);
				setscore(1);
				if(!fg2.checkGame())
				{
					checkend = 1;
					scoreactive = 0;
				}
				if(!fg.checkGame() && !fg1.checkGame() && !fg2.checkGame())
				{
					JOptionPane.showMessageDialog(null,"���� ��.     ����  :  "+ score);
				}
				countRemain = fg2.getRemain();
				All = fg2.getAll();
				remainlbl.setText(""+countRemain+"/"+All);
			}
		
			else
			{
				if(scoreactive ==1)//���� �ƴѰ��� ������ -5�� 
				{
					score = score -5;
					scorelbl.setText("Score : " + score);
				}
			}

		}
		public void mouseReleased(MouseEvent event)	{}
		public void mouseEntered(MouseEvent event)	{}
		public void mouseExited(MouseEvent event)	{}
	}
}			
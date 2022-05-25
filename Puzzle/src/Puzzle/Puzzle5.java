package Puzzle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;

public class Puzzle5 extends JPanel
{
	//��� ����//
	private final int IMAGE = 49;//������ �� 
	private final int XSIZE = 86;//�� ������ X�� ũ�� 
	private final int YSIZE = 64;//�� ������ Y�� ũ�� 
	/////////////
	
	//Image//
	private JLabel[] imagelbl;//���� �������� ���� �� 
	private ImageIcon[] image;//���� �������� �޾ƿ� �̹��������� 
	//////////////////
	
	//Point//
	private Point[] startPt;//������ ������ �� ������ �������� �ּ�(����)��ǥ�� ���� ����Ʈ 
	private Point savePt;//�� ����Ʈ�� �߿��� ��ҷμ� �̹� ��� �� �������� ĭ�� �ٽ� ������ ���� �� 
	//���� ��ǥ������ ���� ������ ���� �����̴�.//
	private Point[] framePt;//���� ������ �������� ��ǥ���� ���� 
	///////////////////

	//Frame//
	private ImageIcon frameimage;//������ �̹����� ���� ���� 
	private JLabel framelbl;//������ �̹����� ������ �� 
	///////////////////
	
	private int[] ximageRange;//�� ������ x�� �� ��ǥ�� ���� ���� 
	private int[] yimageRange;//�� ������ y�� �� ��ǥ�� ���� ���� 

	private int[] answer;//���� �����ӿ� ���� ������ ����������, ������ ����������, ����ִ��� ���� 
	private int[] saveId;//�ʱ� �̹��� ��ġ�� ���� �߻��� ���� �ϱ� ������, �̷� �迭 ������ �̿��Ͽ� 
	//�̹����� ���� �� �������� ã����� �� �ʿ䰡 ���� 
	
	//Remain//
	private int remain;//����� �� ���� ������ �˷��� 
	private JLabel remainlbl;//�̸� ������ lbl
	///////////////////
	
	// ETC //
	private int pressedimage;//���� �����̰� �ִ� �̹����� �˷��� ���� 
	private int getbackanswer;//���� �����ӿ� �������ִ� ������ �ٸ� ������ �гο� ���� �� 
	//�ڱ� �ڽ��� �ִ� �ڸ��� ����ִٰ� ǥ�õǱ� ������ �ʿ��� 
	private int nanswer;
	///////////////////
	
	
	public Puzzle5()
	{			
		Init();
	}//default Constructor

	public void Init()//�ʱ�ȭ �Լ� 
	{
		//Default Initiation//
		setPreferredSize(new Dimension(800,640));
		setLayout(null);
		setBackground(Color.white);
		//////////////////////

		//Variables Initiation//
		nanswer = 0;
		getbackanswer = -1;
		remain = IMAGE;
		remainlbl = new JLabel(""+remain+"/"+IMAGE);
		remainlbl.setBounds(700,20,100,30);
		remainlbl.setFont(new Font("Verdana",Font.ITALIC,30));
		add(remainlbl);
		saveId = new int[IMAGE];
		savePt = new Point();
		Initanswer();
		InitframePt();
		pressedimage = -1;
		image = new ImageIcon[IMAGE];
		imagelbl = new JLabel[IMAGE];
		startPt = new Point[IMAGE];
		ximageRange = new int[IMAGE];
		yimageRange = new int[IMAGE];
		
		for(int i=0;i<IMAGE;i++)//�̹������� ������ ���� ������ �ʱ�ȭ 
		{
			startPt[i] = new Point();
			startPt[i].x = 0;
			startPt[i].y = 0;
		}
		
		//���� ���� ���� ���� �ʱ�ȭ//
		int[] checking;
		checking = new int[IMAGE];
		for(int k=0;k<IMAGE;k++)
		{
			checking[k] = 0;
		}
		///////////////////////////////
		
		//3���� �������� ���� �ʱ�ȭ 
		int count = 0;
		int j=0;
		int check=0;
		
		while(check<1)//���۽� �׸� ���� ��ġ�ϵ��� 
		{
			check = 1;
			int i;
			
			i = (int)(Math.random()*IMAGE);//�����߻��� ���� ������ġ 
			
			if(checking[i] == 0)//���� i�� ���� �̹� ó���Ͽ����� 
			{
				image[i] = new ImageIcon("3img_"+(i+1)+".jpg");//�̹��� �ҷ����� 
				imagelbl[j] = new JLabel("",image[i],SwingConstants.CENTER);//�̹����� �󺧿� 
				saveId[j] = i;//������ j������ ���� �̹����� ���� �� ��ġ�� �˾Ƶ� 
				imagelbl[j].setBounds(630,70 + YSIZE * (count/7),XSIZE,YSIZE);//�̹��� ��ġ ���� 
				startPt[j].x = 630;//���� ��ġ ���� X 
				startPt[j].y = 70 + YSIZE * (count/7);//���� ��ġ ���� Y
				ximageRange[j] = 630 + XSIZE;//�� ��ġ ���� X 
				yimageRange[j] = 70 + YSIZE * (count/7) + YSIZE;//�� ��ġ ���� Y
				add(imagelbl[j]);

				count ++;//��� lbl�� ó���Ͽ����� 
				checking[i] = 1;//�� i�� ó���Ͽ��� ǥ�� 
				j++;
			}
			for(int k=0;k<IMAGE;k++)//���� ó������ ���� i�� �ִ��� üũ 
			{
				if(checking[k] == 0)
				{
					check = 0;
				}
			}
		}
		
		
		//���� ������(Ʋ) �̹��� ���̺�//
		frameimage = new ImageIcon("frame5.jpg");
		framelbl = new JLabel("",frameimage,SwingConstants.CENTER);
		add(framelbl);
		framelbl.setBackground(Color.white);
		framelbl.setBounds(10,70,600,448);
	}
	
	public void InitframePt()//framePt������ ����,�ʱ�ȭ�ϰ� �������� 
	{
		framePt = new Point[IMAGE];
		for(int i=0;i<IMAGE;i++)
		{	
			framePt[i] = new Point();
			framePt[i].x = 10 + XSIZE * (i%7);
			framePt[i].y = 70 + YSIZE * (int)(i/7);
			if((i%7) == 0)
			{
				framePt[i].x = 10 + XSIZE * (i%7) + 2;
			}
			if(i%7 == 5 || i%7 == 6)
			{
				framePt[i].x = 10 + XSIZE * (i%7) - 3;
			}
				
		}
	}

	public void Initanswer()//answer���� ���� �ʱ�ȭ 
	{
		answer = new int[IMAGE];
		for(int i=0;i<IMAGE;i++)
		{
			answer[i] = 0;
		}		
	}
	public void setanswer(int i,int x)//answer���� �Ķ���͸� ���� �ٲٱ� 
	{
		answer[i] = x;
	}
	public int getanswer(int i)//answer���� �޾ƿ��� 
	{
		return answer[i];
	}
	public Point[] getstartPt()
	{
		return startPt;
	}
	public void setstartPt(int x, int y,int pressed)
	{
		startPt[pressed].x = x;
		startPt[pressed].y = y;
	}
	public int getgetbackanswer()
	{
		return getbackanswer;
	}
	public void setgetbackanswer(int x)
	{
		getbackanswer = x;
	}
	public Point getsavePt()
	{
		return savePt;
	}
	public void setsavePt(int x,int y)
	{
		savePt.x = x;
		savePt.y = y;
	}
	public Point[] getframePt()
	{
		return framePt;
	}
	public int getpressedimage()
	{
		return pressedimage;
	}
	public void setpressedimage(int x)
	{
		pressedimage = x;
	}
	public int[] getximageRange()
	{
		return ximageRange;
	}
	public void setximageRange(int x,int index)
	{
		ximageRange[index] = x;
	}
	public int[] getyimageRange()
	{
		return yimageRange;
	}
	public void setyimageRange(int x,int index)
	{
		yimageRange[index] = x;
	}
	public JLabel[] getimagelbl()
	{
		return imagelbl;
	}
	public int getremain()
	{
		return remain;
	}
	public void setremain()
	{
		remain --;
	}
	public int[] getsaveId()
	{
		return saveId;
	}
	public final int getIMAGE()
	{
		return IMAGE;
	}
	public final int getXSIZE()
	{
		return XSIZE;
	}
	public final int getYSIZE()
	{
		return YSIZE;
	}
	public JLabel getremainlbl()
	{
		return remainlbl;
	}
	public void setnanswer()
	{
		nanswer ++;
	}
	public int getnanswer()
	{
		return nanswer;
	}
	private class mListener implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event)
		{
			Point pt = event.getPoint();
			int check;

			for(int i=0;i<getIMAGE();i++)
			{
				if(getstartPt()[i].x < pt.x && pt.x < getximageRange()[i] && getstartPt()[i].y < pt.y && pt.y < getyimageRange()[i])//�󺧵鿡 ���� ���� 
				{//��� �̹����� ���� �������� ��, 
					if(getanswer(getsaveId()[i]) != 2)//�� i�� ������ ������ 
					{
						setpressedimage(i);//i�� �����̰� ���� ǥ�� 
						setgetbackanswer(i); 
						setsavePt(getstartPt()[i].x+getXSIZE()/2,getstartPt()[i].y+getYSIZE()/2);//���� �����̱� ������ ��ġ�� �����ص� 
						break;
					}
				}
			}
			for(int i=0;i<getIMAGE();i++)
			{
				if( getframePt()[i].x < pt.x && pt.x < getframePt()[i].x+getXSIZE() &&
					 getframePt()[i].y < pt.y && pt.y < getframePt()[i].y+getYSIZE() && getanswer(i) == 1)//�����ӿ� ������ �̹����� �ǵ帱 �� 
				{
					setgetbackanswer(i);//���� �ִ� �ڸ����� �ٸ� ������ �����ӿ� �ű� �� 
					//�����ִ� �ڸ��� �������� ��Ÿ���ֱ����� 
					setanswer(i,0);//�� �����ӿ� ���������� �������� �ٲ� 
				}
			}
		}
		public void mouseReleased(MouseEvent event)
		{
			Point pt = event.getPoint();
			Point ptOriginal = event.getPoint();
			pt.x = pt.x-getXSIZE()/2;
			pt.y = pt.y-getYSIZE()/2;
			if(getpressedimage() != -1)
			{
				setstartPt(pt.x,pt.y,getpressedimage());//���� ��ǥ ���� 
				setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//�� ��ǥ ���� 
				setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
				
				for(int i=0;i<getIMAGE();i++)
				{
					if( getframePt()[i].x <= ptOriginal.x && ptOriginal.x <= getframePt()[i].x+getXSIZE() &&
					 getframePt()[i].y <= ptOriginal.y && ptOriginal.y <= getframePt()[i].y+getYSIZE() )//frame�� ���� ����
					{			
							if(getsaveId()[getpressedimage()] == i)//���������ӿ� ������ ���� ��
							{
								if(getanswer(i) == 0)
								{	
									setnanswer();
									getimagelbl()[getpressedimage()].setBounds(getframePt()[i].x,getframePt()[i].y,getXSIZE(),getYSIZE());
									setstartPt(getframePt()[i].x,getframePt()[i].y,getpressedimage());
									setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//�� ��ǥ ���� 
									setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
									setremain();//remain�� ���ҽ�Ŵ 
									getremainlbl().setText(""+getremain()+"/"+getIMAGE());
									setanswer(i,2);//�� �����ӿ� ������ ���á���� �ǹ�
									if(getnanswer() == IMAGE)//��Ǯ�� 
									{
										
									}
								}
								else if(getanswer(i) == 1)//�г��� �ִ� ���� ���� ��,
								{	
									setanswer(getgetbackanswer(),1);
									getimagelbl()[getpressedimage()].setBounds(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE()/2,getXSIZE(),getYSIZE());
									setstartPt(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE(),getpressedimage());
									setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//�� ��ǥ ���� 
									setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
								}
								//score����
							}
			
							else if(getanswer(i)==0)//�� �гο� ������ ���� �� 
							{
								getimagelbl()[getpressedimage()].setBounds(getframePt()[i].x,getframePt()[i].y,getXSIZE(),getYSIZE());
								setstartPt(getframePt()[i].x,getframePt()[i].y,getpressedimage());
								setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//�� ��ǥ ���� 
								setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
								setanswer(i,1);
							}
							else if(getanswer(i) == 1 || getanswer(i) == 2)//������ �гο� ������ ���� �� 
							{
								setanswer(getgetbackanswer(),1);
								getimagelbl()[getpressedimage()].setBounds(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE()/2,getXSIZE(),getYSIZE());
								setstartPt(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE()/2,getpressedimage());
								setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//�� ��ǥ ���� 
								setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
							}
							
						}
				
					}
				}
			
			setpressedimage(-1);
		}
		public void mouseEntered(MouseEvent event)
		{
		}
		public void mouseExited(MouseEvent event)
		{
		}
		public void mouseMoved(MouseEvent event)
		{
		}
		public void mouseDragged(MouseEvent event)
		{
			Point pt = event.getPoint();
			
			if(getpressedimage() != -1)//�����̰� �ִ� ����� ������ ��
			{
				getimagelbl()[getpressedimage()].setBounds(pt.x-getXSIZE()/2,pt.y-getYSIZE()/2,getXSIZE(),getYSIZE());//��ġ�� ��� �ٲ��� 
				repaint();
			}
		}
	}
}


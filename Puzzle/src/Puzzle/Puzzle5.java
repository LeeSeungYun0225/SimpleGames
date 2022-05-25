package Puzzle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;

public class Puzzle5 extends JPanel
{
	//상수 선언//
	private final int IMAGE = 49;//조각의 수 
	private final int XSIZE = 86;//각 조각의 X축 크기 
	private final int YSIZE = 64;//각 조각의 Y축 크기 
	/////////////
	
	//Image//
	private JLabel[] imagelbl;//퍼즐 조각들을 받을 라벨 
	private ImageIcon[] image;//퍼즐 조각들을 받아올 이미지아이콘 
	//////////////////
	
	//Point//
	private Point[] startPt;//게임을 시작할 때 각각의 조각들의 최소(시작)좌표를 넣을 포인트 
	private Point savePt;//이 포인트는 중요한 요소로서 이미 들어 찬 프레임의 칸에 다시 조각을 넣을 시 
	//이전 좌표값으로 돌려 보내기 위한 변수이다.//
	private Point[] framePt;//각각 프레임 조각들의 좌표값을 가짐 
	///////////////////

	//Frame//
	private ImageIcon frameimage;//프레임 이미지를 담을 변수 
	private JLabel framelbl;//프레임 이미지를 보여줄 라벨 
	///////////////////
	
	private int[] ximageRange;//각 조각의 x축 끝 좌표값 가질 변수 
	private int[] yimageRange;//각 조각의 y축 끝 좌표값 가질 변수 

	private int[] answer;//현재 프레임에 정답 조각이 끼워졌는지, 오답이 끼워졌는지, 비어있는지 저장 
	private int[] saveId;//초기 이미지 배치를 난수 발생을 통해 하기 때문에, 이런 배열 변수를 이용하여 
	//이미지가 들어가야 할 프레임을 찾아줘야 할 필요가 있음 
	
	//Remain//
	private int remain;//맞춰야 할 조각 개수를 알려줌 
	private JLabel remainlbl;//이를 보여줄 lbl
	///////////////////
	
	// ETC //
	private int pressedimage;//현재 움직이고 있는 이미지를 알려줄 변수 
	private int getbackanswer;//현재 프레임에 끼워져있는 조각을 다른 끼워진 패널에 넣을 때 
	//자기 자신이 있던 자리가 비어있다고 표시되기 때문에 필요함 
	private int nanswer;
	///////////////////
	
	
	public Puzzle5()
	{			
		Init();
	}//default Constructor

	public void Init()//초기화 함수 
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
		
		for(int i=0;i<IMAGE;i++)//이미지들의 시작점 저장 포인터 초기화 
		{
			startPt[i] = new Point();
			startPt[i].x = 0;
			startPt[i].y = 0;
		}
		
		//지역 변수 선언 생성 초기화//
		int[] checking;
		checking = new int[IMAGE];
		for(int k=0;k<IMAGE;k++)
		{
			checking[k] = 0;
		}
		///////////////////////////////
		
		//3개의 지역변수 선언 초기화 
		int count = 0;
		int j=0;
		int check=0;
		
		while(check<1)//시작시 그림 랜덤 배치하도록 
		{
			check = 1;
			int i;
			
			i = (int)(Math.random()*IMAGE);//난수발생을 통해 랜덤배치 
			
			if(checking[i] == 0)//현재 i에 대해 이미 처리하였는지 
			{
				image[i] = new ImageIcon("3img_"+(i+1)+".jpg");//이미지 불러오기 
				imagelbl[j] = new JLabel("",image[i],SwingConstants.CENTER);//이미지를 라벨에 
				saveId[j] = i;//난수와 j변수를 통해 이미지가 들어가야 할 위치를 알아둠 
				imagelbl[j].setBounds(630,70 + YSIZE * (count/7),XSIZE,YSIZE);//이미지 위치 설정 
				startPt[j].x = 630;//시작 위치 설정 X 
				startPt[j].y = 70 + YSIZE * (count/7);//시작 위치 설정 Y
				ximageRange[j] = 630 + XSIZE;//끝 위치 설정 X 
				yimageRange[j] = 70 + YSIZE * (count/7) + YSIZE;//끝 위치 설정 Y
				add(imagelbl[j]);

				count ++;//몇개의 lbl을 처리하였는지 
				checking[i] = 1;//이 i는 처리하였다 표시 
				j++;
			}
			for(int k=0;k<IMAGE;k++)//아직 처리하지 않은 i가 있는지 체크 
			{
				if(checking[k] == 0)
				{
					check = 0;
				}
			}
		}
		
		
		//퍼즐 프레임(틀) 이미지 레이블//
		frameimage = new ImageIcon("frame5.jpg");
		framelbl = new JLabel("",frameimage,SwingConstants.CENTER);
		add(framelbl);
		framelbl.setBackground(Color.white);
		framelbl.setBounds(10,70,600,448);
	}
	
	public void InitframePt()//framePt변수를 생성,초기화하고 설정해줌 
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

	public void Initanswer()//answer변수 생성 초기화 
	{
		answer = new int[IMAGE];
		for(int i=0;i<IMAGE;i++)
		{
			answer[i] = 0;
		}		
	}
	public void setanswer(int i,int x)//answer값을 파라미터를 통해 바꾸기 
	{
		answer[i] = x;
	}
	public int getanswer(int i)//answer값을 받아오기 
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
				if(getstartPt()[i].x < pt.x && pt.x < getximageRange()[i] && getstartPt()[i].y < pt.y && pt.y < getyimageRange()[i])//라벨들에 대해 따짐 
				{//어떠한 이미지에 대해 움직였을 때, 
					if(getanswer(getsaveId()[i]) != 2)//라벨 i의 정답을 맞춘경우 
					{
						setpressedimage(i);//i를 움직이고 있음 표시 
						setgetbackanswer(i); 
						setsavePt(getstartPt()[i].x+getXSIZE()/2,getstartPt()[i].y+getYSIZE()/2);//현재 움직이기 시작한 위치를 저장해둠 
						break;
					}
				}
			}
			for(int i=0;i<getIMAGE();i++)
			{
				if( getframePt()[i].x < pt.x && pt.x < getframePt()[i].x+getXSIZE() &&
					 getframePt()[i].y < pt.y && pt.y < getframePt()[i].y+getYSIZE() && getanswer(i) == 1)//프레임에 끼워진 이미지를 건드릴 때 
				{
					setgetbackanswer(i);//원래 있던 자리에서 다른 끼워진 프레임에 옮길 때 
					//원래있던 자리에 끼워진걸 나타내주기위함 
					setanswer(i,0);//이 프레임에 끼워진것이 없음으로 바꿈 
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
				setstartPt(pt.x,pt.y,getpressedimage());//시작 좌표 변경 
				setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//끝 좌표 변경 
				setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
				
				for(int i=0;i<getIMAGE();i++)
				{
					if( getframePt()[i].x <= ptOriginal.x && ptOriginal.x <= getframePt()[i].x+getXSIZE() &&
					 getframePt()[i].y <= ptOriginal.y && ptOriginal.y <= getframePt()[i].y+getYSIZE() )//frame에 대해 따짐
					{			
							if(getsaveId()[getpressedimage()] == i)//정답프레임에 조각을 떨굴 때
							{
								if(getanswer(i) == 0)
								{	
									setnanswer();
									getimagelbl()[getpressedimage()].setBounds(getframePt()[i].x,getframePt()[i].y,getXSIZE(),getYSIZE());
									setstartPt(getframePt()[i].x,getframePt()[i].y,getpressedimage());
									setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//끝 좌표 변경 
									setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
									setremain();//remain을 감소시킴 
									getremainlbl().setText(""+getremain()+"/"+getIMAGE());
									setanswer(i,2);//이 프레임엔 정답이 들어찼음을 의미
									if(getnanswer() == IMAGE)//다풀면 
									{
										
									}
								}
								else if(getanswer(i) == 1)//패널이 있는 데에 떨굴 때,
								{	
									setanswer(getgetbackanswer(),1);
									getimagelbl()[getpressedimage()].setBounds(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE()/2,getXSIZE(),getYSIZE());
									setstartPt(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE(),getpressedimage());
									setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//끝 좌표 변경 
									setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
								}
								//score증가
							}
			
							else if(getanswer(i)==0)//빈 패널에 조각을 떨굴 때 
							{
								getimagelbl()[getpressedimage()].setBounds(getframePt()[i].x,getframePt()[i].y,getXSIZE(),getYSIZE());
								setstartPt(getframePt()[i].x,getframePt()[i].y,getpressedimage());
								setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//끝 좌표 변경 
								setyimageRange(getstartPt()[getpressedimage()].y+getYSIZE(),getpressedimage());
								setanswer(i,1);
							}
							else if(getanswer(i) == 1 || getanswer(i) == 2)//차여진 패널에 조각을 떨굴 때 
							{
								setanswer(getgetbackanswer(),1);
								getimagelbl()[getpressedimage()].setBounds(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE()/2,getXSIZE(),getYSIZE());
								setstartPt(getsavePt().x-getXSIZE()/2,getsavePt().y-getYSIZE()/2,getpressedimage());
								setximageRange(getstartPt()[getpressedimage()].x+getXSIZE(),getpressedimage());//끝 좌표 변경 
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
			
			if(getpressedimage() != -1)//움직이고 있는 대상이 존재할 때
			{
				getimagelbl()[getpressedimage()].setBounds(pt.x-getXSIZE()/2,pt.y-getYSIZE()/2,getXSIZE(),getYSIZE());//위치를 계속 바꿔줌 
				repaint();
			}
		}
	}
}


package Puzzle;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TotalPuzzle extends JPanel
{
	
	//Object//
	private Puzzle pz1;
	private Puzzle2 pz2;
	private Puzzle3 pz3;
	private Puzzle4 pz4;
	private Puzzle5 pz5;
	/////////////////
	
	//Btn//
	private JButton GameStart;//게임시작버튼 
	private JButton Nextbtn;//다음 게임 버튼 
	private JButton Exitbtn;//게임 나가기 버튼 
	private JButton Restartbtn;
	/////////////////
	
	//Combo//
	private int combocheck;
	private int maxcombo;
	private int countcombo;
	private JLabel combolbl;
	private ImageIcon[] comboimage;
	private JLabel[] comboimagelbl;
	////////////////
	
	//Stop//
	private JButton Stopgamebtn;//게임 중지 버튼 
	private int checkbtn;
	////////////////////
	
	//CLEAR//
	private JLabel clearlbl;
	private ImageIcon clearimage;
	
	//Score//
	private int score;
	private JLabel scorelbl;
	///////////////
	
	//Background//
	private JLabel Backgroundlbl;
	private ImageIcon Backgroundimage;
	private JLabel Titlelbl;
	////////////////
	
	
	//Listener//
	private mListener ml;
	private bListener bl;
	/////////////////
	
	
	//ETC//
	private int checkstage;
	private JLabel Exitlbl;
	private ImageIcon Byebye;
	private JLabel Lastlbl;
	private ImageIcon Lastimage;
	//////////////// 
	
	public TotalPuzzle()
	{
		ml = new mListener();
		bl = new bListener();
		
		Lastimage = new ImageIcon("Last.jpg");
		Lastlbl = new JLabel("",Lastimage,SwingConstants.CENTER);
		
			
		Stopgamebtn = new JButton("게임 중지");
		Exitbtn = new JButton("나가기");
		
		
		Byebye = new ImageIcon("Exit.jpg");
		Exitlbl = new JLabel("",Byebye,SwingConstants.CENTER);
		GameStart = new JButton("Start");
		
		Backgroundimage = new ImageIcon("Background1.jpg");
		Backgroundlbl = new JLabel("",Backgroundimage,SwingConstants.CENTER);
		Titlelbl = new JLabel("PUZZLE");
		
		combolbl = new JLabel("");
		comboimage = new ImageIcon[3];
		comboimage[0] = new ImageIcon("combo1.jpg");
		comboimage[1] = new ImageIcon("combo2.jpg");
		comboimage[2] = new ImageIcon("combo3.jpg");
		comboimagelbl = new JLabel[3];
 		comboimagelbl[0] = new JLabel("",comboimage[0],SwingConstants.CENTER);
 		comboimagelbl[1] = new JLabel("",comboimage[1],SwingConstants.CENTER);
 		comboimagelbl[2] = new JLabel("",comboimage[2],SwingConstants.CENTER);
 		
 		clearimage = new ImageIcon("Clear.jpg");
		clearlbl = new JLabel("",clearimage,SwingConstants.CENTER);
		
		scorelbl = new JLabel("Score : "+score);
 		Nextbtn = new JButton("NEXT");
 		
 		Restartbtn = new JButton("재시작");
		Init();
	}//Default Constructor
	
	public void Init()
	{
		//Default Init
		setPreferredSize(new Dimension(800,640));
		setBackground(Color.white);
		setLayout(null);
		/////////////////
		
		
		//Stop & EXIT btn //
		Stopgamebtn.setBackground(Color.black);
		Stopgamebtn.setForeground(Color.white);
		Stopgamebtn.setVisible(false);
		Stopgamebtn.setBounds(120,600,100,30);
		
		Exitbtn.setBackground(Color.green);
		Exitbtn.setForeground(Color.white);
		Exitbtn.setVisible(true);
		Exitbtn.setBounds(10,600,100,30);
		add(Exitbtn);
		add(Stopgamebtn);
		Restartbtn.setBounds(120,600,100,30);
		Restartbtn.setVisible(false);
		Restartbtn.setForeground(Color.white);
		Restartbtn.setBackground(Color.black);
		add(Restartbtn);
		
		//EXIT 2//
		
		Exitlbl.setBounds(10,540,100,100);
		Exitlbl.setVisible(false);
		add(Exitlbl);
		////////////////////
		
		
		
		//Background//
		
		GameStart.setBackground(Color.white);
		GameStart.setForeground(Color.black);
		GameStart.setBounds(350,500,100,30);
		add(GameStart);
		GameStart.setVisible(true);
		
		Titlelbl.setFont(new Font("Verdana",Font.BOLD,100));
		Backgroundlbl.setBounds(0,0,800,640);
		Backgroundlbl.setVisible(true);
		Titlelbl.setVisible(true);
		Titlelbl.setBounds(200,100,500,100);
		Titlelbl.setForeground(Color.white);
		add(Titlelbl);
		add(Backgroundlbl);
		
		//////////////
		
		
		
		//Combo//
		combocheck = 0;
		maxcombo = 0;
		countcombo = 0;
	 	
 		comboimagelbl[0].setBounds(480,490,100,150);
 		comboimagelbl[0].setVisible(false);
 		add(comboimagelbl[0]);
 		comboimagelbl[1].setBounds(480,490,100,150);
 		comboimagelbl[1].setVisible(false);
 		add(comboimagelbl[1]);
 		comboimagelbl[2].setBounds(480,490,100,150);
 		comboimagelbl[2].setVisible(false);
 		add(comboimagelbl[2]);
 		combolbl.setBounds(460,460,200,30);
 		combolbl.setFont(new Font("Verdana",Font.PLAIN,30));
 		add(combolbl);
 		combolbl.setVisible(false);
 		//////////////////
		
		//CLEAR//

		clearlbl.setBounds(200,10,200,115);
		clearlbl.setVisible(false);
		add(clearlbl);
		/////////////////
		
		//Score//
		score = 0;
		scorelbl.setBounds(230,600,300,30);
		scorelbl.setFont(new Font("Verdana",Font.BOLD,30));
		add(scorelbl);
		scorelbl.setVisible(false);
		
			//E T C//
		checkstage = 0;
		
		Nextbtn.setBackground(Color.black);
		Nextbtn.setForeground(Color.white);
		Nextbtn.setVisible(false);
		add(Nextbtn);
		Nextbtn.setBounds(670,600,100,30);
		checkbtn = 0;
		//////////////////////
		
		//Last//

		Lastlbl.setBounds(0,0,800,640);
		Lastlbl.setVisible(false);
		add(Lastlbl);
		////////////////////////
		
		//Object//
		pz1 = new Puzzle();
		pz2 = new Puzzle2();
		pz3 = new Puzzle3();
		pz4 = new Puzzle4();
		pz5 = new Puzzle5();
		pz1.setBounds(0,0,800,640);
		pz2.setBounds(0,0,800,640);
		pz3.setBounds(0,0,800,640);
		pz4.setBounds(0,0,800,640);
		pz5.setBounds(0,0,800,640);
		add(pz1);
		add(pz2);
		add(pz3);
		add(pz4);
		add(pz5);
		pz1.setVisible(false);
		pz2.setVisible(false);
		pz3.setVisible(false);
		pz4.setVisible(false);
		pz5.setVisible(false);
		//////////////
		
		
		
		
		//Listener//
		
		Exitbtn.addMouseListener(ml);
		Stopgamebtn.addActionListener(bl);
		Restartbtn.addActionListener(bl);
		Exitlbl.addMouseListener(ml);
		GameStart.addActionListener(bl);
		Nextbtn.addActionListener(bl);
		pz1.addMouseListener(ml);
		pz2.addMouseListener(ml);
		pz3.addMouseListener(ml);
		pz4.addMouseListener(ml);
		pz5.addMouseListener(ml);
		pz1.addMouseMotionListener(ml);
		pz2.addMouseMotionListener(ml);
		pz3.addMouseMotionListener(ml);
		pz4.addMouseMotionListener(ml);
		pz5.addMouseMotionListener(ml);
		/////////////////
		
		scorelbl.setText("Score : " + score);
		combolbl.setText(""+countcombo+"Combo!");
	}
	
	public void combodisable()//콤보가 끊겼을 때 호출하는 함수 
	{
		comboimagelbl[0].setVisible(false);
		comboimagelbl[1].setVisible(false);
		comboimagelbl[2].setVisible(false);
		countcombo = 0;
		combocheck = 0;
		combolbl.setVisible(false);
		score = score - 10;
		scorelbl.setText("Score : " + score);
	}
	public void comboable()// 콤보가 다시 시작될 때 호출하는 함수 
	{
		combocheck = 1;
		countcombo++;
		combolbl.setText(""+countcombo+"Combo!");
		combolbl.setVisible(true);
		score = score + 20 * (countcombo)*(countcombo);
		scorelbl.setText("Score : " + score);
		if(maxcombo < countcombo)
		{
			maxcombo = countcombo;
		}
		if(countcombo>9)
		{
			comboimagelbl[2].setVisible(true);
			comboimagelbl[1].setVisible(false);
		}
		else if(countcombo>4)
		{
			comboimagelbl[1].setVisible(true);
			comboimagelbl[0].setVisible(false);
		}
		else
		{
			comboimagelbl[0].setVisible(true);
		}

	}
	
	private class mListener implements MouseListener, MouseMotionListener
	{
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event)
		{
			Object obj = event.getSource();
			
			Point pt = event.getPoint();
			int check;
			if(obj == pz1)
			{
				for(int i=0;i<pz1.getIMAGE();i++)
				{
					if(pz1.getstartPt()[i].x < pt.x && pt.x < pz1.getximageRange()[i] && pz1.getstartPt()[i].y < pt.y && pt.y < pz1.getyimageRange()[i])//라벨들에 대해 따짐 
					{//어떠한 이미지에 대해 움직였을 때, 
						if(pz1.getanswer(pz1.getsaveId()[i]) != 2)//라벨 i의 정답을 맞춘경우 
						{
							pz1.setpressedimage(i);//i를 움직이고 있음 표시 
							pz1.setgetbackanswer(i); 
							pz1.setsavePt(pz1.getstartPt()[i].x+pz1.getXSIZE()/2,pz1.getstartPt()[i].y+pz1.getYSIZE()/2);//현재 움직이기 시작한 위치를 저장해둠 
							break;
						}
					}
				}
			
				for(int i=0;i<pz1.getIMAGE();i++)
				{
					if( pz1.getframePt()[i].x < pt.x && pt.x < pz1.getframePt()[i].x+pz1.getXSIZE() &&
						 pz1.getframePt()[i].y < pt.y && pt.y < pz1.getframePt()[i].y+pz1.getYSIZE() && pz1.getanswer(i) == 1)//프레임에 끼워진 이미지를 건드릴 때 
					{
						pz1.setgetbackanswer(i);//원래 있던 자리에서 다른 끼워진 프레임에 옮길 때 
						//원래있던 자리에 끼워진걸 나타내주기위함 
						pz1.setanswer(i,0);//이 프레임에 끼워진것이 없음으로 바꿈 
					}
				}
			}
			else if(obj == pz2)
			{
				for(int i=0;i<pz2.getIMAGE();i++)
				{
					if(pz2.getstartPt()[i].x < pt.x && pt.x < pz2.getximageRange()[i] && pz2.getstartPt()[i].y < pt.y && pt.y < pz2.getyimageRange()[i])//라벨들에 대해 따짐 
					{//어떠한 이미지에 대해 움직였을 때, 
						if(pz2.getanswer(pz2.getsaveId()[i]) != 2)//라벨 i의 정답을 맞춘경우 
						{
							pz2.setpressedimage(i);//i를 움직이고 있음 표시 
							pz2.setgetbackanswer(i); 
							pz2.setsavePt(pz2.getstartPt()[i].x+pz2.getXSIZE()/2,pz2.getstartPt()[i].y+pz2.getYSIZE()/2);//현재 움직이기 시작한 위치를 저장해둠 
							break;
						}
					}
				}
				for(int i=0;i<pz2.getIMAGE();i++)
				{
					if( pz2.getframePt()[i].x < pt.x && pt.x < pz2.getframePt()[i].x+pz2.getXSIZE() &&
						 pz2.getframePt()[i].y < pt.y && pt.y < pz2.getframePt()[i].y+pz2.getYSIZE() && pz2.getanswer(i) == 1)//프레임에 끼워진 이미지를 건드릴 때 
					{
						pz2.setgetbackanswer(i);//원래 있던 자리에서 다른 끼워진 프레임에 옮길 때 
						//원래있던 자리에 끼워진걸 나타내주기위함 
						pz2.setanswer(i,0);//이 프레임에 끼워진것이 없음으로 바꿈 
					}
				}
			}
			else if(obj == pz3)
			{
				for(int i=0;i<pz3.getIMAGE();i++)
				{
					if(pz3.getstartPt()[i].x < pt.x && pt.x < pz3.getximageRange()[i] && pz3.getstartPt()[i].y < pt.y && pt.y < pz3.getyimageRange()[i])//라벨들에 대해 따짐 
					{//어떠한 이미지에 대해 움직였을 때, 
						if(pz3.getanswer(pz3.getsaveId()[i]) != 2)//라벨 i의 정답을 맞춘경우 
						{
							pz3.setpressedimage(i);//i를 움직이고 있음 표시 
							pz3.setgetbackanswer(i); 
							pz3.setsavePt(pz3.getstartPt()[i].x+pz3.getXSIZE()/2,pz3.getstartPt()[i].y+pz3.getYSIZE()/2);//현재 움직이기 시작한 위치를 저장해둠 
							break;
						}
					}
				}
				for(int i=0;i<pz3.getIMAGE();i++)
				{
					if( pz3.getframePt()[i].x < pt.x && pt.x < pz3.getframePt()[i].x+pz3.getXSIZE() &&
						 pz3.getframePt()[i].y < pt.y && pt.y < pz3.getframePt()[i].y+pz3.getYSIZE() && pz3.getanswer(i) == 1)//프레임에 끼워진 이미지를 건드릴 때 
					{
						pz3.setgetbackanswer(i);//원래 있던 자리에서 다른 끼워진 프레임에 옮길 때 
						//원래있던 자리에 끼워진걸 나타내주기위함 
						pz3.setanswer(i,0);//이 프레임에 끼워진것이 없음으로 바꿈 
					}
				}
			}
			else if(obj == pz4)
			{
				for(int i=0;i<pz4.getIMAGE();i++)
				{
					if(pz4.getstartPt()[i].x < pt.x && pt.x < pz4.getximageRange()[i] && pz4.getstartPt()[i].y < pt.y && pt.y < pz4.getyimageRange()[i])//라벨들에 대해 따짐 
					{//어떠한 이미지에 대해 움직였을 때, 
						if(pz4.getanswer(pz4.getsaveId()[i]) != 2)//라벨 i의 정답을 맞춘경우 
						{
							pz4.setpressedimage(i);//i를 움직이고 있음 표시 
							pz4.setgetbackanswer(i); 
							pz4.setsavePt(pz4.getstartPt()[i].x+pz4.getXSIZE()/2,pz4.getstartPt()[i].y+pz4.getYSIZE()/2);//현재 움직이기 시작한 위치를 저장해둠 
							break;
						}
					}
				}
				for(int i=0;i<pz4.getIMAGE();i++)
				{
					if( pz4.getframePt()[i].x < pt.x && pt.x < pz4.getframePt()[i].x+pz4.getXSIZE() &&
						 pz4.getframePt()[i].y < pt.y && pt.y < pz4.getframePt()[i].y+pz4.getYSIZE() && pz4.getanswer(i) == 1)//프레임에 끼워진 이미지를 건드릴 때 
					{
						pz4.setgetbackanswer(i);//원래 있던 자리에서 다른 끼워진 프레임에 옮길 때 
						//원래있던 자리에 끼워진걸 나타내주기위함 
						pz4.setanswer(i,0);//이 프레임에 끼워진것이 없음으로 바꿈 
					}
				}
			}
			else if(obj == pz5)
			{
				for(int i=0;i<pz5.getIMAGE();i++)
				{
					if(pz5.getstartPt()[i].x < pt.x && pt.x < pz5.getximageRange()[i] && pz5.getstartPt()[i].y < pt.y && pt.y < pz5.getyimageRange()[i])//라벨들에 대해 따짐 
					{//어떠한 이미지에 대해 움직였을 때, 
						if(pz5.getanswer(pz5.getsaveId()[i]) != 2)//라벨 i의 정답을 맞춘경우 
						{
							pz5.setpressedimage(i);//i를 움직이고 있음 표시 
							pz5.setgetbackanswer(i); 
							pz5.setsavePt(pz5.getstartPt()[i].x+pz5.getXSIZE()/2,pz5.getstartPt()[i].y+pz5.getYSIZE()/2);//현재 움직이기 시작한 위치를 저장해둠 
							break;
						}
					}
				}
				for(int i=0;i<pz5.getIMAGE();i++)
				{
					if( pz5.getframePt()[i].x < pt.x && pt.x < pz5.getframePt()[i].x+pz5.getXSIZE() &&
						 pz5.getframePt()[i].y < pt.y && pt.y < pz5.getframePt()[i].y+pz5.getYSIZE() && pz5.getanswer(i) == 1)//프레임에 끼워진 이미지를 건드릴 때 
					{
						pz5.setgetbackanswer(i);//원래 있던 자리에서 다른 끼워진 프레임에 옮길 때 
						//원래있던 자리에 끼워진걸 나타내주기위함 
						pz5.setanswer(i,0);//이 프레임에 끼워진것이 없음으로 바꿈 
					}
				}
			}
			
			else if(obj == Exitlbl)//Exit수행 
			{
			}
		}
		public void mouseReleased(MouseEvent event)
		{
			Point pt = event.getPoint();
			Point ptOriginal = event.getPoint();
			Object obj = event.getSource();
			if(obj == pz1)
			{
				pt.x = pt.x-pz1.getXSIZE()/2;
				pt.y = pt.y-pz1.getYSIZE()/2;
				if(pz1.getpressedimage() != -1)
				{
					pz1.setstartPt(pt.x,pt.y,pz1.getpressedimage());//시작 좌표 변경 
					pz1.setximageRange(pz1.getstartPt()[pz1.getpressedimage()].x+pz1.getXSIZE(),pz1.getpressedimage());//끝 좌표 변경 
					pz1.setyimageRange(pz1.getstartPt()[pz1.getpressedimage()].y+pz1.getYSIZE(),pz1.getpressedimage());
				
					for(int i=0;i<pz1.getIMAGE();i++)
					{
						if( pz1.getframePt()[i].x <= ptOriginal.x && ptOriginal.x <= pz1.getframePt()[i].x+pz1.getXSIZE() &&
					 	pz1.getframePt()[i].y <= ptOriginal.y && ptOriginal.y <= pz1.getframePt()[i].y+pz1.getYSIZE() )//frame에 퍼즐조각을 끼웠을 떄 
						{			
							if(pz1.getsaveId()[pz1.getpressedimage()] == i)//정답프레임에 조각을 떨굴 때
							{
								if(pz1.getanswer(i) == 0)//정답 프레임이 비어있을 때 
								{	
									comboable();//콤보 able
									pz1.setnanswer();
									pz1.getimagelbl()[pz1.getpressedimage()].setBounds(pz1.getframePt()[i].x,pz1.getframePt()[i].y,pz1.getXSIZE(),pz1.getYSIZE());
									pz1.setstartPt(pz1.getframePt()[i].x,pz1.getframePt()[i].y,pz1.getpressedimage());
									pz1.setximageRange(pz1.getstartPt()[pz1.getpressedimage()].x+pz1.getXSIZE(),pz1.getpressedimage());//끝 좌표 변경 
									pz1.setyimageRange(pz1.getstartPt()[pz1.getpressedimage()].y+pz1.getYSIZE(),pz1.getpressedimage());
									pz1.setremain();//remain을 감소시킴 
									pz1.getremainlbl().setText(""+pz1.getremain()+"/"+pz1.getIMAGE());
									pz1.setanswer(i,2);//이 프레임엔 정답이 들어찼음을 의미
									if(pz1.getnanswer() == pz1.getIMAGE())//다풀면 
									{
										Nextbtn.setVisible(true);
										clearlbl.setVisible(true);
									}
								}
								else if(pz1.getanswer(i) == 1)//잘못 끼웠을 때 
								{	
										combodisable();//콤보초기화 
										pz1.setanswer(pz1.getgetbackanswer(),1);
										pz1.getimagelbl()[pz1.getpressedimage()].setBounds(pz1.getsavePt().x-pz1.getXSIZE()/2,pz1.getsavePt().y-pz1.getYSIZE()/2,pz1.getXSIZE(),pz1.getYSIZE());
										pz1.setstartPt(pz1.getsavePt().x-pz1.getXSIZE()/2,pz1.getsavePt().y-pz1.getYSIZE(),pz1.getpressedimage());
										pz1.setximageRange(pz1.getstartPt()[pz1.getpressedimage()].x+pz1.getXSIZE(),pz1.getpressedimage());//끝 좌표 변경 
										pz1.setyimageRange(pz1.getstartPt()[pz1.getpressedimage()].y+pz1.getYSIZE(),pz1.getpressedimage());
								}
								//score증가
							}
			
							else if(pz1.getanswer(i)==0)//빈 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz1.getimagelbl()[pz1.getpressedimage()].setBounds(pz1.getframePt()[i].x,pz1.getframePt()[i].y,pz1.getXSIZE(),pz1.getYSIZE());
								pz1.setstartPt(pz1.getframePt()[i].x,pz1.getframePt()[i].y,pz1.getpressedimage());
								pz1.setximageRange(pz1.getstartPt()[pz1.getpressedimage()].x+pz1.getXSIZE(),pz1.getpressedimage());//끝 좌표 변경 
								pz1.setyimageRange(pz1.getstartPt()[pz1.getpressedimage()].y+pz1.getYSIZE(),pz1.getpressedimage());
								pz1.setanswer(i,1);
							}
							else if(pz1.getanswer(i) == 1 || pz1.getanswer(i) == 2)//차여진 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz1.setanswer(pz1.getgetbackanswer(),1);
								pz1.getimagelbl()[pz1.getpressedimage()].setBounds(pz1.getsavePt().x-pz1.getXSIZE()/2,pz1.getsavePt().y-pz1.getYSIZE()/2,pz1.getXSIZE(),pz1.getYSIZE());
								pz1.setstartPt(pz1.getsavePt().x-pz1.getXSIZE()/2,pz1.getsavePt().y-pz1.getYSIZE()/2,pz1.getpressedimage());
								pz1.setximageRange(pz1.getstartPt()[pz1.getpressedimage()].x+pz1.getXSIZE(),pz1.getpressedimage());//끝 좌표 변경 
								pz1.setyimageRange(pz1.getstartPt()[pz1.getpressedimage()].y+pz1.getYSIZE(),pz1.getpressedimage());
							}
						}
					}
				}
				pz1.setpressedimage(-1);
			}
			else if(obj == pz2)
			{
				pt.x = pt.x-pz2.getXSIZE()/2;
				pt.y = pt.y-pz2.getYSIZE()/2;
				if(pz2.getpressedimage() != -1)
				{
					pz2.setstartPt(pt.x,pt.y,pz2.getpressedimage());//시작 좌표 변경 
					pz2.setximageRange(pz2.getstartPt()[pz2.getpressedimage()].x+pz2.getXSIZE(),pz2.getpressedimage());//끝 좌표 변경 
					pz2.setyimageRange(pz2.getstartPt()[pz2.getpressedimage()].y+pz2.getYSIZE(),pz2.getpressedimage());
				
					for(int i=0;i<pz2.getIMAGE();i++)
					{
						if( pz2.getframePt()[i].x <= ptOriginal.x && ptOriginal.x <= pz2.getframePt()[i].x+pz2.getXSIZE() &&
					 	pz2.getframePt()[i].y <= ptOriginal.y && ptOriginal.y <= pz2.getframePt()[i].y+pz2.getYSIZE() )//frame에 대해 따짐
						{			
							if(pz2.getsaveId()[pz2.getpressedimage()] == i)//정답프레임에 조각을 떨굴 때
							{
								if(pz2.getanswer(i) == 0)
								{	
									comboable();
									pz2.setnanswer();
									pz2.getimagelbl()[pz2.getpressedimage()].setBounds(pz2.getframePt()[i].x,pz2.getframePt()[i].y,pz2.getXSIZE(),pz2.getYSIZE());
									pz2.setstartPt(pz2.getframePt()[i].x,pz2.getframePt()[i].y,pz2.getpressedimage());
									pz2.setximageRange(pz2.getstartPt()[pz2.getpressedimage()].x+pz2.getXSIZE(),pz2.getpressedimage());//끝 좌표 변경 
									pz2.setyimageRange(pz2.getstartPt()[pz2.getpressedimage()].y+pz2.getYSIZE(),pz2.getpressedimage());
									pz2.setremain();//remain을 감소시킴 
									pz2.getremainlbl().setText(""+pz2.getremain()+"/"+pz2.getIMAGE());
									pz2.setanswer(i,2);//이 프레임엔 정답이 들어찼음을 의미
									if(pz2.getnanswer() == pz2.getIMAGE())//다풀면 
									{
										Nextbtn.setVisible(true);
										clearlbl.setVisible(true);
									}
								}
								else if(pz2.getanswer(i) == 1)//패널이 있는 데에 떨굴 때,
								{	
										combodisable();
										pz2.setanswer(pz2.getgetbackanswer(),1);
										pz2.getimagelbl()[pz2.getpressedimage()].setBounds(pz2.getsavePt().x-pz2.getXSIZE()/2,pz2.getsavePt().y-pz2.getYSIZE()/2,pz2.getXSIZE(),pz2.getYSIZE());
										pz2.setstartPt(pz2.getsavePt().x-pz2.getXSIZE()/2,pz2.getsavePt().y-pz2.getYSIZE(),pz2.getpressedimage());
										pz2.setximageRange(pz2.getstartPt()[pz2.getpressedimage()].x+pz2.getXSIZE(),pz2.getpressedimage());//끝 좌표 변경 
										pz2.setyimageRange(pz2.getstartPt()[pz2.getpressedimage()].y+pz2.getYSIZE(),pz2.getpressedimage());
								}
								//score증가
							}
			
							else if(pz2.getanswer(i)==0)//빈 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz2.getimagelbl()[pz2.getpressedimage()].setBounds(pz2.getframePt()[i].x,pz2.getframePt()[i].y,pz2.getXSIZE(),pz2.getYSIZE());
								pz2.setstartPt(pz2.getframePt()[i].x,pz2.getframePt()[i].y,pz2.getpressedimage());
								pz2.setximageRange(pz2.getstartPt()[pz2.getpressedimage()].x+pz2.getXSIZE(),pz2.getpressedimage());//끝 좌표 변경 
								pz2.setyimageRange(pz2.getstartPt()[pz2.getpressedimage()].y+pz2.getYSIZE(),pz2.getpressedimage());
								pz2.setanswer(i,1);
							}
							else if(pz2.getanswer(i) == 1 || pz2.getanswer(i) == 2)//차여진 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz2.setanswer(pz2.getgetbackanswer(),1);
								pz2.getimagelbl()[pz2.getpressedimage()].setBounds(pz2.getsavePt().x-pz2.getXSIZE()/2,pz2.getsavePt().y-pz2.getYSIZE()/2,pz2.getXSIZE(),pz2.getYSIZE());
								pz2.setstartPt(pz2.getsavePt().x-pz2.getXSIZE()/2,pz2.getsavePt().y-pz2.getYSIZE()/2,pz2.getpressedimage());
								pz2.setximageRange(pz2.getstartPt()[pz2.getpressedimage()].x+pz2.getXSIZE(),pz2.getpressedimage());//끝 좌표 변경 
								pz2.setyimageRange(pz2.getstartPt()[pz2.getpressedimage()].y+pz2.getYSIZE(),pz2.getpressedimage());
							}
						}
					}
				}
				pz2.setpressedimage(-1);
			}
			else if(obj == pz3)
			{
				pt.x = pt.x-pz3.getXSIZE()/2;
				pt.y = pt.y-pz3.getYSIZE()/2;
				if(pz3.getpressedimage() != -1)
				{
					pz3.setstartPt(pt.x,pt.y,pz3.getpressedimage());//시작 좌표 변경 
					pz3.setximageRange(pz3.getstartPt()[pz3.getpressedimage()].x+pz3.getXSIZE(),pz3.getpressedimage());//끝 좌표 변경 
					pz3.setyimageRange(pz3.getstartPt()[pz3.getpressedimage()].y+pz3.getYSIZE(),pz3.getpressedimage());
				
					for(int i=0;i<pz3.getIMAGE();i++)
					{
						if( pz3.getframePt()[i].x <= ptOriginal.x && ptOriginal.x <= pz3.getframePt()[i].x+pz3.getXSIZE() &&
					 	pz3.getframePt()[i].y <= ptOriginal.y && ptOriginal.y <= pz3.getframePt()[i].y+pz3.getYSIZE() )//frame에 대해 따짐
						{			
							if(pz3.getsaveId()[pz3.getpressedimage()] == i)//정답프레임에 조각을 떨굴 때
							{
								if(pz3.getanswer(i) == 0)
								{	
									comboable();
									pz3.setnanswer();
									pz3.getimagelbl()[pz3.getpressedimage()].setBounds(pz3.getframePt()[i].x,pz3.getframePt()[i].y,pz3.getXSIZE(),pz3.getYSIZE());
									pz3.setstartPt(pz3.getframePt()[i].x,pz3.getframePt()[i].y,pz3.getpressedimage());
									pz3.setximageRange(pz3.getstartPt()[pz3.getpressedimage()].x+pz3.getXSIZE(),pz3.getpressedimage());//끝 좌표 변경 
									pz3.setyimageRange(pz3.getstartPt()[pz3.getpressedimage()].y+pz3.getYSIZE(),pz3.getpressedimage());
									pz3.setremain();//remain을 감소시킴 
									pz3.getremainlbl().setText(""+pz3.getremain()+"/"+pz3.getIMAGE());
									pz3.setanswer(i,2);//이 프레임엔 정답이 들어찼음을 의미
									if(pz3.getnanswer() == pz3.getIMAGE())//다풀면 
									{
										Nextbtn.setVisible(true);
										clearlbl.setVisible(true);
									}
								}
								else if(pz3.getanswer(i) == 1)//패널이 있는 데에 떨굴 때,
								{	
										combodisable();
										pz3.setanswer(pz3.getgetbackanswer(),1);
										pz3.getimagelbl()[pz3.getpressedimage()].setBounds(pz3.getsavePt().x-pz3.getXSIZE()/2,pz3.getsavePt().y-pz3.getYSIZE()/2,pz3.getXSIZE(),pz3.getYSIZE());
										pz3.setstartPt(pz3.getsavePt().x-pz3.getXSIZE()/2,pz3.getsavePt().y-pz3.getYSIZE(),pz3.getpressedimage());
										pz3.setximageRange(pz3.getstartPt()[pz3.getpressedimage()].x+pz3.getXSIZE(),pz3.getpressedimage());//끝 좌표 변경 
										pz3.setyimageRange(pz3.getstartPt()[pz3.getpressedimage()].y+pz3.getYSIZE(),pz3.getpressedimage());
								}
								//score증가
							}
			
							else if(pz3.getanswer(i)==0)//빈 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz3.getimagelbl()[pz3.getpressedimage()].setBounds(pz3.getframePt()[i].x,pz3.getframePt()[i].y,pz3.getXSIZE(),pz3.getYSIZE());
								pz3.setstartPt(pz3.getframePt()[i].x,pz3.getframePt()[i].y,pz3.getpressedimage());
								pz3.setximageRange(pz3.getstartPt()[pz3.getpressedimage()].x+pz3.getXSIZE(),pz3.getpressedimage());//끝 좌표 변경 
								pz3.setyimageRange(pz3.getstartPt()[pz3.getpressedimage()].y+pz3.getYSIZE(),pz3.getpressedimage());
								pz3.setanswer(i,1);
							}
							else if(pz3.getanswer(i) == 1 || pz3.getanswer(i) == 2)//차여진 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz3.setanswer(pz3.getgetbackanswer(),1);
								pz3.getimagelbl()[pz3.getpressedimage()].setBounds(pz3.getsavePt().x-pz3.getXSIZE()/2,pz3.getsavePt().y-pz3.getYSIZE()/2,pz3.getXSIZE(),pz3.getYSIZE());
								pz3.setstartPt(pz3.getsavePt().x-pz3.getXSIZE()/2,pz3.getsavePt().y-pz3.getYSIZE()/2,pz3.getpressedimage());
								pz3.setximageRange(pz3.getstartPt()[pz3.getpressedimage()].x+pz3.getXSIZE(),pz3.getpressedimage());//끝 좌표 변경 
								pz3.setyimageRange(pz3.getstartPt()[pz3.getpressedimage()].y+pz3.getYSIZE(),pz3.getpressedimage());
							}
						}
					}
				}
				pz3.setpressedimage(-1);
			}
			else if(obj == pz4)
			{
				pt.x = pt.x-pz4.getXSIZE()/2;
				pt.y = pt.y-pz4.getYSIZE()/2;
				if(pz4.getpressedimage() != -1)
				{
					pz4.setstartPt(pt.x,pt.y,pz4.getpressedimage());//시작 좌표 변경 
					pz4.setximageRange(pz4.getstartPt()[pz4.getpressedimage()].x+pz4.getXSIZE(),pz4.getpressedimage());//끝 좌표 변경 
					pz4.setyimageRange(pz4.getstartPt()[pz4.getpressedimage()].y+pz4.getYSIZE(),pz4.getpressedimage());
				
					for(int i=0;i<pz4.getIMAGE();i++)
					{
						if( pz4.getframePt()[i].x <= ptOriginal.x && ptOriginal.x <= pz4.getframePt()[i].x+pz4.getXSIZE() &&
					 	pz4.getframePt()[i].y <= ptOriginal.y && ptOriginal.y <= pz4.getframePt()[i].y+pz4.getYSIZE() )//frame에 대해 따짐
						{			
							if(pz4.getsaveId()[pz4.getpressedimage()] == i)//정답프레임에 조각을 떨굴 때
							{
								if(pz4.getanswer(i) == 0)
								{	
									comboable();
									pz4.setnanswer();
									pz4.getimagelbl()[pz4.getpressedimage()].setBounds(pz4.getframePt()[i].x,pz4.getframePt()[i].y,pz4.getXSIZE(),pz4.getYSIZE());
									pz4.setstartPt(pz4.getframePt()[i].x,pz4.getframePt()[i].y,pz4.getpressedimage());
									pz4.setximageRange(pz4.getstartPt()[pz4.getpressedimage()].x+pz4.getXSIZE(),pz4.getpressedimage());//끝 좌표 변경 
									pz4.setyimageRange(pz4.getstartPt()[pz4.getpressedimage()].y+pz4.getYSIZE(),pz4.getpressedimage());
									pz4.setremain();//remain을 감소시킴 
									pz4.getremainlbl().setText(""+pz4.getremain()+"/"+pz4.getIMAGE());
									pz4.setanswer(i,2);//이 프레임엔 정답이 들어찼음을 의미
									if(pz4.getnanswer() == pz4.getIMAGE())//다풀면 
									{
										Nextbtn.setVisible(true);
										clearlbl.setVisible(true);
									}
								}
								else if(pz4.getanswer(i) == 1)//패널이 있는 데에 떨굴 때,
								{	
										combodisable();
										pz4.setanswer(pz4.getgetbackanswer(),1);
										pz4.getimagelbl()[pz4.getpressedimage()].setBounds(pz4.getsavePt().x-pz4.getXSIZE()/2,pz4.getsavePt().y-pz4.getYSIZE()/2,pz4.getXSIZE(),pz4.getYSIZE());
										pz4.setstartPt(pz4.getsavePt().x-pz4.getXSIZE()/2,pz4.getsavePt().y-pz4.getYSIZE(),pz4.getpressedimage());
										pz4.setximageRange(pz4.getstartPt()[pz4.getpressedimage()].x+pz4.getXSIZE(),pz4.getpressedimage());//끝 좌표 변경 
										pz4.setyimageRange(pz4.getstartPt()[pz4.getpressedimage()].y+pz4.getYSIZE(),pz4.getpressedimage());
								}
								//score증가
							}
			
							else if(pz4.getanswer(i)==0)//빈 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz4.getimagelbl()[pz4.getpressedimage()].setBounds(pz4.getframePt()[i].x,pz4.getframePt()[i].y,pz4.getXSIZE(),pz4.getYSIZE());
								pz4.setstartPt(pz4.getframePt()[i].x,pz4.getframePt()[i].y,pz4.getpressedimage());
								pz4.setximageRange(pz4.getstartPt()[pz4.getpressedimage()].x+pz4.getXSIZE(),pz4.getpressedimage());//끝 좌표 변경 
								pz4.setyimageRange(pz4.getstartPt()[pz4.getpressedimage()].y+pz4.getYSIZE(),pz4.getpressedimage());
								pz4.setanswer(i,1);
							}
							else if(pz4.getanswer(i) == 1 || pz4.getanswer(i) == 2)//차여진 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz4.setanswer(pz4.getgetbackanswer(),1);
								pz4.getimagelbl()[pz4.getpressedimage()].setBounds(pz4.getsavePt().x-pz4.getXSIZE()/2,pz4.getsavePt().y-pz4.getYSIZE()/2,pz4.getXSIZE(),pz4.getYSIZE());
								pz4.setstartPt(pz4.getsavePt().x-pz4.getXSIZE()/2,pz4.getsavePt().y-pz4.getYSIZE()/2,pz4.getpressedimage());
								pz4.setximageRange(pz4.getstartPt()[pz4.getpressedimage()].x+pz4.getXSIZE(),pz4.getpressedimage());//끝 좌표 변경 
								pz4.setyimageRange(pz4.getstartPt()[pz4.getpressedimage()].y+pz4.getYSIZE(),pz4.getpressedimage());
							}
						}
					}
				}
				pz4.setpressedimage(-1);
			}
			else if(obj == pz5)
			{
				pt.x = pt.x-pz5.getXSIZE()/2;
				pt.y = pt.y-pz5.getYSIZE()/2;
				if(pz5.getpressedimage() != -1)
				{
					pz5.setstartPt(pt.x,pt.y,pz5.getpressedimage());//시작 좌표 변경 
					pz5.setximageRange(pz5.getstartPt()[pz5.getpressedimage()].x+pz5.getXSIZE(),pz5.getpressedimage());//끝 좌표 변경 
					pz5.setyimageRange(pz5.getstartPt()[pz5.getpressedimage()].y+pz5.getYSIZE(),pz5.getpressedimage());
				
					for(int i=0;i<pz5.getIMAGE();i++)
					{
						if( pz5.getframePt()[i].x <= ptOriginal.x && ptOriginal.x <= pz5.getframePt()[i].x+pz5.getXSIZE() &&
					 	pz5.getframePt()[i].y <= ptOriginal.y && ptOriginal.y <= pz5.getframePt()[i].y+pz5.getYSIZE() )//frame에 대해 따짐
						{			
							if(pz5.getsaveId()[pz5.getpressedimage()] == i)//정답프레임에 조각을 떨굴 때
							{
								comboable();
								if(pz5.getanswer(i) == 0)
								{	
									pz5.setnanswer();
									pz5.getimagelbl()[pz5.getpressedimage()].setBounds(pz5.getframePt()[i].x,pz5.getframePt()[i].y,pz5.getXSIZE(),pz5.getYSIZE());
									pz5.setstartPt(pz5.getframePt()[i].x,pz5.getframePt()[i].y,pz5.getpressedimage());
									pz5.setximageRange(pz5.getstartPt()[pz5.getpressedimage()].x+pz5.getXSIZE(),pz5.getpressedimage());//끝 좌표 변경 
									pz5.setyimageRange(pz5.getstartPt()[pz5.getpressedimage()].y+pz5.getYSIZE(),pz5.getpressedimage());
									pz5.setremain();//remain을 감소시킴 
									pz5.getremainlbl().setText(""+pz5.getremain()+"/"+pz5.getIMAGE());
									pz5.setanswer(i,2);//이 프레임엔 정답이 들어찼음을 의미
									if(pz5.getnanswer() == pz5.getIMAGE())//다풀면 
									{
										Nextbtn.setVisible(true);
										clearlbl.setVisible(true);
									}
								}
								else if(pz5.getanswer(i) == 1)//패널이 있는 데에 떨굴 때,
								{	
										combodisable();
										pz5.setanswer(pz5.getgetbackanswer(),1);
										pz5.getimagelbl()[pz5.getpressedimage()].setBounds(pz5.getsavePt().x-pz5.getXSIZE()/2,pz5.getsavePt().y-pz5.getYSIZE()/2,pz5.getXSIZE(),pz5.getYSIZE());
										pz5.setstartPt(pz5.getsavePt().x-pz5.getXSIZE()/2,pz5.getsavePt().y-pz5.getYSIZE(),pz5.getpressedimage());
										pz5.setximageRange(pz5.getstartPt()[pz5.getpressedimage()].x+pz5.getXSIZE(),pz5.getpressedimage());//끝 좌표 변경 
										pz5.setyimageRange(pz5.getstartPt()[pz5.getpressedimage()].y+pz5.getYSIZE(),pz5.getpressedimage());
								}
								//score증가
							}
			
							else if(pz5.getanswer(i)==0)//빈 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz5.getimagelbl()[pz5.getpressedimage()].setBounds(pz5.getframePt()[i].x,pz5.getframePt()[i].y,pz5.getXSIZE(),pz5.getYSIZE());
								pz5.setstartPt(pz5.getframePt()[i].x,pz5.getframePt()[i].y,pz5.getpressedimage());
								pz5.setximageRange(pz5.getstartPt()[pz5.getpressedimage()].x+pz5.getXSIZE(),pz5.getpressedimage());//끝 좌표 변경 
								pz5.setyimageRange(pz5.getstartPt()[pz5.getpressedimage()].y+pz5.getYSIZE(),pz5.getpressedimage());
								pz5.setanswer(i,1);
							}
							else if(pz5.getanswer(i) == 1 || pz5.getanswer(i) == 2)//차여진 패널에 조각을 떨굴 때 
							{
								combodisable();
								pz5.setanswer(pz5.getgetbackanswer(),1);
								pz5.getimagelbl()[pz5.getpressedimage()].setBounds(pz5.getsavePt().x-pz5.getXSIZE()/2,pz5.getsavePt().y-pz5.getYSIZE()/2,pz5.getXSIZE(),pz5.getYSIZE());
								pz5.setstartPt(pz5.getsavePt().x-pz5.getXSIZE()/2,pz5.getsavePt().y-pz5.getYSIZE()/2,pz5.getpressedimage());
								pz5.setximageRange(pz5.getstartPt()[pz5.getpressedimage()].x+pz5.getXSIZE(),pz5.getpressedimage());//끝 좌표 변경 
								pz5.setyimageRange(pz5.getstartPt()[pz5.getpressedimage()].y+pz5.getYSIZE(),pz5.getpressedimage());
							}
						}
					}
				}
				pz5.setpressedimage(-1);
			}
		}
		public void mouseEntered(MouseEvent event)
		{
			Object obj = event.getSource();
			if(obj == Exitbtn)
			{
				Exitbtn.setVisible(false);
				Exitlbl.setVisible(true);
			}
		}
		public void mouseExited(MouseEvent event)
		{
			Object obj = event.getSource();
			if(obj == Exitlbl)
			{
				Exitlbl.setVisible(false);
				Exitbtn.setVisible(true);
			}
		}
		public void mouseMoved(MouseEvent event)
		{
		}
		public void mouseDragged(MouseEvent event)
		{
			Point pt = event.getPoint();
			Object obj = event.getSource();
			if(obj == pz1)
			{
				if(pz1.getpressedimage() != -1)//움직이고 있는 대상이 존재할 때
				{
					pz1.getimagelbl()[pz1.getpressedimage()].setBounds(pt.x-pz1.getXSIZE()/2,pt.y-pz1.getYSIZE()/2,pz1.getXSIZE(),pz1.getYSIZE());//위치를 계속 바꿔줌 
					repaint();
				}
			}
			else if(obj == pz2)
			{
				if(pz2.getpressedimage() != -1)//움직이고 있는 대상이 존재할 때
				{
					pz2.getimagelbl()[pz2.getpressedimage()].setBounds(pt.x-pz2.getXSIZE()/2,pt.y-pz2.getYSIZE()/2,pz2.getXSIZE(),pz2.getYSIZE());//위치를 계속 바꿔줌 
					repaint();
				}
			}
			if(obj == pz3)
			{
				if(pz3.getpressedimage() != -1)//움직이고 있는 대상이 존재할 때
				{
					pz3.getimagelbl()[pz3.getpressedimage()].setBounds(pt.x-pz3.getXSIZE()/2,pt.y-pz3.getYSIZE()/2,pz3.getXSIZE(),pz3.getYSIZE());//위치를 계속 바꿔줌 
					repaint();
				}
			}
			if(obj == pz4)
			{
				if(pz4.getpressedimage() != -1)//움직이고 있는 대상이 존재할 때
				{
					pz4.getimagelbl()[pz4.getpressedimage()].setBounds(pt.x-pz4.getXSIZE()/2,pt.y-pz4.getYSIZE()/2,pz4.getXSIZE(),pz4.getYSIZE());//위치를 계속 바꿔줌 
					repaint();
				}
			}
			if(obj == pz5)
			{
				if(pz5.getpressedimage() != -1)//움직이고 있는 대상이 존재할 때
				{
					pz5.getimagelbl()[pz5.getpressedimage()].setBounds(pt.x-pz5.getXSIZE()/2,pt.y-pz5.getYSIZE()/2,pz5.getXSIZE(),pz5.getYSIZE());//위치를 계속 바꿔줌 
					repaint();
				}
			}
		}
	}
	
	private class bListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object obj = event.getSource();
			if(obj == GameStart)
			{
				GameStart.setVisible(false);
				Titlelbl.setVisible(false);
				Backgroundlbl.setVisible(false);
				pz1.setVisible(true);
				checkstage++;
				scorelbl.setVisible(true);
				Stopgamebtn.setVisible(true);
			}
			else if (obj == Nextbtn)
			{
				Nextbtn.setVisible(false);
				switch(checkstage)
				{
					case 1:
					{
						pz1.setVisible(false);
						pz2.setVisible(true);
						clearlbl.setVisible(false);
						checkstage++;
						break;
					}
					case 2:
					{
						pz2.setVisible(false);
						pz3.setVisible(true);
						clearlbl.setVisible(false);
						checkstage++;
						break;
					}
					case 3:
					{
						pz3.setVisible(false);
						pz4.setVisible(true);
						clearlbl.setVisible(false);
						checkstage++;
						break;
					}
					case 4:
					{
						pz4.setVisible(false);
						pz5.setVisible(true);
						clearlbl.setVisible(false);
						checkstage++;
						break;
					}
					case 5:
					{
						pz1.setVisible(false);
						pz2.setVisible(false);
						pz3.setVisible(false);
						pz4.setVisible(false);
						pz5.setVisible(false);
						Lastlbl.setVisible(true);
						scorelbl.setText("Score : " + score);
						combolbl.setText("Max Combo : " + maxcombo);
						scorelbl.setFont(new Font("Verdana",Font.BOLD,50));
						combolbl.setFont(new Font("Verdana",Font.BOLD,50));
						scorelbl.setBounds(100,100,500,50);
						combolbl.setBounds(100,200,500,50);
						scorelbl.setVisible(true);
						combolbl.setVisible(true);
						GameStart.setVisible(false);
						Backgroundlbl.setVisible(false);
						Titlelbl.setVisible(false);	
						Restartbtn.setVisible(true);
						Stopgamebtn.setVisible(false);
						clearlbl.setVisible(false);
						checkbtn = 1;
						comboimagelbl[0].setVisible(false);
						comboimagelbl[1].setVisible(false);
						comboimagelbl[2].setVisible(false);
						break;
					}
				}
					
			}
			else if(obj == Stopgamebtn)
			{
				pz1.setVisible(false);
				pz2.setVisible(false);
				pz3.setVisible(false);
				pz4.setVisible(false);
				pz5.setVisible(false);
				comboimagelbl[0].setVisible(false);
				comboimagelbl[1].setVisible(false);
				comboimagelbl[2].setVisible(false);
				Lastlbl.setVisible(true);
				scorelbl.setText("Score : " + score);
				combolbl.setText("Max Combo : " + maxcombo);
				scorelbl.setFont(new Font("Verdana",Font.BOLD,50));
				combolbl.setFont(new Font("Verdana",Font.BOLD,50));
				scorelbl.setBounds(100,100,500,50);
				combolbl.setBounds(100,200,500,50);
				scorelbl.setVisible(true);
				combolbl.setVisible(true);
				GameStart.setVisible(false);
				Backgroundlbl.setVisible(false);
				Titlelbl.setVisible(false);	
				Restartbtn.setVisible(true);
				Stopgamebtn.setVisible(false);
				clearlbl.setVisible(false);
				checkbtn = 1;
				
			}
			else if(obj == Restartbtn )
			{
				Init();
					
			}
				
		}
	}
}
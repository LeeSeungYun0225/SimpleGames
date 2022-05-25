package CatchMind;

import java.awt.*;
import javax.swing.*;//to Use Graphics...
import java.awt.event.*;//to Use Event Handler 
import java.util.*;
import java.lang.*;

public class CatchMind extends JPanel//캐치마인드 패널 
{
	
	////////////////////DATA FIELDS///////////////////////
	
	//Start//
	private JButton Startbtn;
	private JLabel Startlbl;
	//////////////////	
	
	
	//Point Size// 
	private JTextField sizeTxt;//사이즈 설정 텍스트 
	private JButton setSizebtn;//사이즈 설정 버튼 
	private JLabel sizelbl;//사이즈 문자 보유 레이블 
	//////////////////
	
	//Answer//
	private String[] answer;//문자열(답) 배열 
	private JTextField answerTxt; //답 입력 텍스트 
	private JButton answerInbtn;// 답 입력 버튼 
	private int randNum;//랜덤 숫자를 이용하여 문제를 매번 랜덤으로 받아오기 
	//////////////////
	
	//Color//
	private JButton setColorbtn;//컬러 설정 버튼 
	private JPanel Colorpane;//현재 설정된 컬러를 갖고있는 패널 
	private Color selectColor;//컬러를 설정 받을 Color타입 변수 
	///////////////////
	
	//Layout Panel//
	private JPanel boxPanel;//박스 레이아웃으로 설정하고 버튼을 넣을 패널, 우측에 배치 
	private JPanel GridPanel;//그리드 레이아웃으로 설정하고 버튼을 넣을 패널, 하단에 배치 
	///////////////////

	//score//
	private int score;//점수 저장 변수 
	private JLabel scorelbl;//점수/10 저장 레이블 
	private int count=0;//현재 푼 문제 수 카운트 
	///////////////////
	
	//Eraser//
	private JButton Erase;//누르면 자유롭게 지울 수 있도록 하는 지우개 버튼  
	private int getBack;//지우개를 사용하였다가 다시 그림그리기 모드로 돌아가면 
	//하얀색으로 설정 되어 있는 문제가 있다. 이전 색상으로 돌려주기 위해 변수 설정
	private JButton resetDraw;//화면 전체의 내용을 완전 삭제하는 버튼 
	private JButton lastbtn;//가장 마지막에 그린 내용에 대한 어레이 리스트 내용을 완전 삭제하여 지우는 버튼 
	///////////////////
	
	
	//Listener Object//
	private bListener bl;//모든 버튼, 텍스트에 add한뒤 사용할 액션 리스너 
	///////////////////
	
	//User Defined Class Object//
	private DrawingConstant dc;//DrawingConstants는 상수 저장 클래스로 선언할 필요가 없지만, DID배열을 사용하기 위함(아래 소스 참조)
	private Drawing drawPanel;//그림을 그릴 패널 drawPanel을 선언한다 
	///////////////////
	
	
	//ETC....//
	private JButton[] setModebtn;//모드 변경 버튼 배열 
	private JButton Passbtn;//문제 넘기기(패스) 버튼 
	private String str;//출력할 문자열 저장 
	private JButton About;//About버튼 
	private JButton EXIT;//나가기 버튼 
	private JButton Fillbtn;//하나의 색으로 전부 채우기 버튼 
	private ImageIcon BackImage;
	private JLabel Backlbl;//Background Image
	///////////////////
	
	

	//Default Constructor//
	public CatchMind()
	{
		
		BackImage = new ImageIcon("bg.jpg");
		Backlbl = new JLabel("",BackImage,SwingConstants.CENTER);
		Startbtn = new JButton("Start");
		Startlbl = new JLabel("Catch Mind!");
		sizeTxt = new JTextField(10);
		sizelbl = new JLabel("S I Z E : ");
		setSizebtn = new JButton("설정");
		answerTxt = new JTextField(50);//답 받을 텍스트필드 
		answer = new String[10];//답을 입력할 문자열 길이맞춰 생성
		answerInbtn = new JButton("입력"); 
		setColorbtn = new JButton("색 설정");
		Colorpane = new JPanel();
		Erase = new JButton("지우개");	
		lastbtn = new JButton("Undo");//마지막에 수행한 작업 돌리기 버튼 
		resetDraw = new JButton("비우기");	
		Passbtn = new JButton("패스");
		setModebtn = new JButton[5];//드로우 모드를 변경할 버튼 생성 
		GridPanel = new JPanel();
		boxPanel = new JPanel();
		Fillbtn = new JButton("배경색");
		scorelbl = new JLabel(""+score+ "/" + count);//내용 설정 
		About = new JButton("About");
		EXIT = new JButton("나가기");
		
		
		Init();
		
	}//Default Constructor
	
	public void Init()
	{
		//Initiate//
		setLayout(null);//레이아웃 설정 
		setPreferredSize(new Dimension(800,640));//크기를 800,640으로 
		setBackground(Color.white);//색상 설정 
		setVisible(true);//일단 보이도록 설정 
		//CatchMind 패널에 대한 초기화// 	
		
		//User Defined Class Object & Listener Class Object//
		dc = new DrawingConstant();//dc에 있는 DID배열을 사용할것이기 때문에 생성함 
		drawPanel = new Drawing();
		drawPanel.setDrawMode(dc.NONE);//드로우모드를 NONE으로 설정해둠 
		drawPanel.setBounds(10,30,600,430);//위치 & 크기
		bl = new bListener();
		//////////////////////////////
		
		//Start//

		Startbtn.setBounds(380,400,100,30);
		Startbtn.setBackground(Color.black);
		Startbtn.setForeground(Color.white);
		Startlbl.setFont(new Font("Verdana",Font.BOLD,50));
		Startlbl.setBounds(250,100,500,50);
		add(Startlbl);
		add(Startbtn);
		Startbtn.addActionListener(bl);
		////////////////////////////
		
		//Point Size// 
		
		sizeTxt.setBounds(695,430,20,30);//위치 & 크기
		sizeTxt.setText(""+drawPanel.getsize());//텍스트 필드 안에 기본 설정된 포인트사이즈 넣기 
		sizelbl.setText("S I Z E : ");
		sizelbl.setBounds(630,430,60,30);//위치 & 크기
		sizelbl.setFont(new Font("Verdana",Font.BOLD,13));
		sizelbl.setBackground(Color.white);//배경색
		sizelbl.setForeground(Color.black);//폰트색 

		setSizebtn.setBackground(Color.black);//배경색 
		setSizebtn.setForeground(Color.white);//폰트색 
		setSizebtn.setBounds(725,430,60,30);//위치 & 크기
		sizeTxt.setVisible(false);
		sizelbl.setVisible(false);
		setSizebtn.setVisible(false);//Point 혹은 Free 혹은 지우개 모드에서만 보여주기 위해 안보이게
		/////////////////////////////
		
		//Answer//

		randNum = (int)(Math.random()*10);//랜덤한 답 가져오기 
		answerTxt.setText("");
		answerTxt.setBounds(10,470,500,30);//위치 & 크기
		answerInbtn.setBackground(Color.black);//배경색 
		answerInbtn.setForeground(Color.white);//폰트색 
		answerInbtn.setBounds(520,470,90,30);//위치 & 크기
		saveAnswer();//answer스트링에 답을 저장해두는 함수 
		setNewAnswer();//새로운 답 설정함수 :: randNum이용
		/////////////////////////////
		
		//Color//
		setColorbtn.setBackground(Color.black);//배경색 
		setColorbtn.setForeground(Color.white);//폰트색 
		selectColor = Color.black;//색상을 검정색으로 초기화한다 
		Colorpane.setBackground(selectColor);//배경색 :: 기본 색상(검정색)으로 초기화한다 
		Colorpane.setBounds(740,100,50,30);//위치 & 크기 
		////////////////////////////
		
		//Eraser//
		getBack = 0;

		Erase.setBackground(Color.black);//배경색 
		Erase.setForeground(Color.white);//폰트색
		lastbtn.setBackground(Color.black);//배경색
		lastbtn.setForeground(Color.white);//폰트색 
		resetDraw.setBackground(Color.black);//배경색 
		resetDraw.setForeground(Color.white);//폰트색 
		//////////////////////////
		
		//Layout Panel//
		Passbtn.setBackground(Color.black);//배경색 
		Passbtn.setForeground(Color.white);//폰트색 
		InitBtn();//함수를 이용하여 이를 초기화 함 
		Fillbtn.setBackground(Color.black);//배경색 
		Fillbtn.setForeground(Color.white);//폰트색 
		setGridPanel();//패널 설정 함수 
		setBoxPanel();//패널 설정 함수 
		////////////////////////////
		
		
		//Score//
		score = 0;
		scorelbl.setText(""+score+ "/" + count);//내용 설정 
		scorelbl.setBackground(Color.yellow);//배경색 
		scorelbl.setFont(new Font("Verdana",Font.BOLD,20));//폰트지정
		scorelbl.setBounds(380,610,100,30);//위치 & 크기 
		//////////////////////////////
		
		//ETC....//
		About.setBackground(Color.black);//배경색 
		About.setForeground(Color.white);//폰트색 
		About.setBounds(720,600,70,30);//위치 & 크기 
		EXIT.setBackground(Color.green);//배경색
		EXIT.setForeground(Color.white);//폰트색 
		EXIT.setBounds(10,610,100,30);//위치 & 크기 
		str = "Version : 2.0 Answer : " + answer[randNum];

		//////////////////////////////
		
		
		
		
		//ADD//
		add(scorelbl);
		add(GridPanel);
		add(EXIT);
		add(About);
		add(Colorpane);
		add(answerInbtn);
		add(answerTxt);
		add(boxPanel);
		add(drawPanel);
		add(sizeTxt);
		add(sizelbl);
		add(setSizebtn);
		/////////////////
		
		//Background//
		add(Backlbl);
		Backlbl.setBounds(0,0,800,640);
		Backlbl.setVisible(true);
		////////////////////
		
		//ADD Action Listener//
		answerTxt.addActionListener(bl);
		answerInbtn.addActionListener(bl);
		Passbtn.addActionListener(bl);
		setModebtn[0].addActionListener(bl);
		setModebtn[1].addActionListener(bl);
		setModebtn[2].addActionListener(bl);
		setModebtn[3].addActionListener(bl);
		setModebtn[4].addActionListener(bl);
		sizeTxt.addActionListener(bl);
		setSizebtn.addActionListener(bl);
		setColorbtn.addActionListener(bl);
		About.addActionListener(bl);
		EXIT.addActionListener(bl);
		resetDraw.addActionListener(bl);
		Erase.addActionListener(bl);
		Fillbtn.addActionListener(bl);
		lastbtn.addActionListener(bl);
		////////////////////////
		Start();
	}
	
	public void StartShow()//스타트 버튼 클릭시 보여주기 
	{
		Startlbl.setVisible(false);
		Startbtn.setVisible(false);
		drawPanel.setVisible(true);
		boxPanel.setVisible(true);
		Colorpane.setVisible(true);
		answerInbtn.setVisible(true);
		answerTxt.setVisible(true);
		GridPanel.setVisible(true);
		About.setVisible(true);
		scorelbl.setVisible(true);
		for(int i = 0;i < 5;i++)//모든 버튼 활성화 및 색 초기화 
		{
			setModebtn[i].setEnabled(true);
			setModebtn[i].setBackground(Color.black);
			setModebtn[i].setForeground(Color.white);
		}
		Erase.setEnabled(true);
		Erase.setBackground(Color.black);
		Erase.setForeground(Color.white);
		Fillbtn.setEnabled(true);
		Fillbtn.setBackground(Color.black);
		Fillbtn.setForeground(Color.white);
	}
	
	public void Start()//시작시 시작화면만 보이도록 
	{
		drawPanel.setVisible(false);
		boxPanel.setVisible(false);
		Colorpane.setVisible(false);
		answerInbtn.setVisible(false);
		answerTxt.setVisible(false);
		GridPanel.setVisible(false);
		About.setVisible(false);
		scorelbl.setVisible(false);
	}
	
	public void setbtnEnable(JButton btn)//파라미터 버튼만 누르지 못하도록 . 나머지는 누를 수 있도록:: 현재 모드 표시역할 
	{
		for(int i = 0;i < 5;i++)
		{
			setModebtn[i].setEnabled(true);
			setModebtn[i].setBackground(Color.black);
			setModebtn[i].setForeground(Color.white);
		}
		Erase.setEnabled(true);
		Erase.setBackground(Color.black);
		Erase.setForeground(Color.white);
		setFillbtnEnable();//Fillbtn에 대해 같은 수행 
		btn.setEnabled(false);
		btn.setBackground(Color.white);
		btn.setForeground(Color.black);
	}
	public void setFillbtnEnable()
	{
		Fillbtn.setEnabled(true);
		Fillbtn.setBackground(Color.black);
		Fillbtn.setForeground(Color.white);
	}
	public void setNewAnswer()//새 답을 설정하는 함수 
	{
		boolean check = true;//check는 true or false를 갖는 boolean타입 지역변수 
		if(count == 10)//10문제 다했다면 
		{
			count = 0;//count를 초기화하고 
			check = false;//check에 false를 
		}
		else
		{
			check = true;//남은문제가 있다면 check에 true를 
		}
		if(check)//남은 문제가 있을 때, if문이 돌아가고 
		{
			randNum = (int)(Math.random()*10);//새 답을 한번 찾아 주고 
			while(dc.DID[randNum] == 1)//아직 안푼 문제를 찾을 때 까지 돌고
			{
				randNum = (int)(Math.random()*10);//0~0.9999... * 10 + 1 , int :: 1~10까지 
				//랜덤으로 숫자 받아와서 
			}
			dc.DID[randNum] = 1;//그 인덱스는 푼 문제로 바꿈 
		}
		else//모든 문제를 다 풀었다면 
		{
			InitDID();//DID배열을 Init해준다 
			randNum = (int)(Math.random()*10);
			dc.DID[randNum] = 1;
		}
		count++;//문제 푼 숫자도 하나 증가시켜준다 
	}
	
	
	public void InitDID()//DID배열을 초기화한다 
	{
		for(int i=0; i<10;i++)
		{
			dc.DID[i] = 0;
		}
	}
	
	public void InitEveryThings()//모두 초기화 
	{
		count = 0;//count 초기화 
		score = 0;
		drawPanel.InitDrawing();//그림그린거 지우고 
		InitDID();//DID배열도 초기화하고 
		setNewAnswer();//답도 수정하고 
		str = "Version : 2.0 Answer : " + answer[randNum];//그에따른 답도 변경해주고 
		scorelbl.setText(""+score+ "/" + count);//스코어 재설정 
	}
	
	public void saveAnswer()//답 저장 
	{
		answer[0] = "곰";
		answer[1] = "비";
		answer[2] = "꽃";
		answer[3] = "우주";
		answer[4] = "집";
		answer[5] = "아이스크림";
		answer[6] = "손";
		answer[7] = "기차";
		answer[8] = "학교";
		answer[9] = "구름";
	}
	
	public void InitBtn()//배열 버튼 초기화
	{
		
		setModebtn[0] = new JButton("점");
		setModebtn[1] = new JButton("선");	
		setModebtn[2] = new JButton("사각형");
		setModebtn[3] = new JButton("원");
		setModebtn[4] = new JButton("프리드로우");
		for(int i = 0;i < 5;i++)
		{
			setModebtn[i].setBackground(Color.black);//배경색 
			setModebtn[i].setForeground(Color.white);//폰트색 
		}
	}
	
	public void setBoxPanel()//박스 레이아웃 패널 설정 
	{
		boxPanel.setLayout(new GridLayout(7,1));
		boxPanel.setBackground(Color.white);//배경색 
		boxPanel.setBounds(630,30,100,400);//위치 & 크기 
		boxPanel.add(Passbtn);//버튼 add 
		boxPanel.add(setColorbtn);
		boxPanel.add(setModebtn[0]);
		boxPanel.add(setModebtn[1]);
		boxPanel.add(setModebtn[2]);
		boxPanel.add(setModebtn[3]);
		boxPanel.add(setModebtn[4]);// 동일 작업 수행 
	}		
	
	public void setGridPanel()//그리드 레이아웃 패널 설정 
	{
		GridPanel.setLayout(new GridLayout(1,4));//1행 4열로 된 그리드 레이아웃 
		GridPanel.setBackground(Color.white);//배경색 
		GridPanel.setBounds(10,520,400,30);//위치 & 크기 
		GridPanel.add(resetDraw);
		GridPanel.add(Erase);
		GridPanel.add(Fillbtn);
		GridPanel.add(lastbtn);
		//add 버튼 
	}
	
	
	public class bListener implements ActionListener//액션 리스너 클래스 
	{
		public void actionPerformed(ActionEvent event)
		{
			Object obj = event.getSource();//객체를 선언해서 소스 받아오기 
			
			
			if(obj == Startbtn)//스타트 버튼을 눌렀을 때, 
			{
				StartShow();
			}
			else if(obj == Passbtn)//패스버튼을 눌렀을 때, 
			{
				int pass;
				int look = 0;
				int fullCount;
				
				pass = JOptionPane.showConfirmDialog(null,"정말로 패스하시겠습니까?");
				if(pass == JOptionPane.YES_OPTION)//패스할 시 
				{
					answerTxt.setText("");//답 넣는 텍스트를 비우고 
					drawPanel.InitDrawing();//그림을 다 지우고 
					look = 1;//look을 1로 
				}
				else
				{
					look = 0;//look을 0으로 
				}

				if(count == 10 & look == 1)//10번째 문제이면서, 방금 10번째 문제를 통과했을 때, 
				{
					fullCount = JOptionPane.showConfirmDialog(null,""+score+"개 맞췄습니다."+"모든 문제를 다 풀었습니다. 다시 하시겠습니까?");
					if(fullCount == JOptionPane.YES_OPTION)//다 풀고 계속 할 시 
					{
						score = 0;//점수 초기화 
						answerTxt.setText("");//답 텍스트 초기화 
						drawPanel.InitDrawing();//그림 지우기 
						look = 1;//look을 1로 
					}
					else//계속 안할 시
					{
						look = 0;//look을 0으로 
					}
				}
				if(look == 1)//패스했거나 10문제 이후 계속할 시 ,
				{
					setNewAnswer();//새 답을 가져오고 
					str = "Version : 2.0 Answer : " + answer[randNum];//str을 변경 
				}
				if(count<=10)//count가 10보다 작거나 같을 때 
				{
					scorelbl.setText(""+score+ "/" + count);//스코어 새로고침 
				}
			}
			else if(obj == answerTxt || obj == answerInbtn)//답을 넣었을 때 
			{
				String check;//문자열 체크 스트링타입 변수 
				check = answerTxt.getText();//answer.Txt의 값을 받아와서 
				if(check.equals(answer[randNum]))//답과 비교해서 맞으면 , 
				{
					int continueGame,fullCount;
					int look = 0;
					score++;//스코어 증가
					scorelbl.setText(""+score+ "/" + count);
					
					
					continueGame = JOptionPane.showConfirmDialog(null,"정답입니다. 계속 하시겠습니까?");
					if(continueGame == JOptionPane.YES_OPTION)//계속 할 시 
					{	
						look = 1;//look 1로 
						answerTxt.setText("");//답 칸 비우기 
						drawPanel.InitDrawing();//그림 지우기 
					}
					else
					{
						look = 0;
					}
					
					if(count == 10)
					{
						fullCount = JOptionPane.showConfirmDialog(null,""+score+"개 맞췄습니다."+"모든 문제를 다 풀었습니다. 다시 하시겠습니까?");
						if(fullCount == JOptionPane.YES_OPTION)//맞추고 계속할 시, 
						{
							score = 0;//점수 초기화 
							answerTxt.setText("");//답칸 비우기 
							drawPanel.InitDrawing();//그림 지우기 
							look = 1;
						}
						else
						{
							look = 0;
						}
					}
					if(look == 1)
					{
						setNewAnswer();//새 답 가져오기 
						str = "Version : 2.0 Answer : " + answer[randNum];
					}
					if(count<=10)
					{
						scorelbl.setText(""+score+ "/" + count);//스코어 새로고침 
					}

				}
				else // 틀렸을 때, 
				{
					String str1;
					str1 = "틀렸습니다";
					JOptionPane.showMessageDialog(null,str1);//알려주고 
					answerTxt.setText("");//답칸 비우기 
				}
			}
			else if(obj == setModebtn[0])//POINT 그리기 
			{
				setbtnEnable(setModebtn[0]);
				if(getBack == 1)//방금 지우개를 썼다면, 
				{
					getBack = 0;//getBack을 0으로 바꿔주고 
					drawPanel.setdrawColor(selectColor);//예전 색상으로 되돌리기 
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setDrawMode(dc.POINT);//드로우 모드도 바꿔주기 
				sizeTxt.setVisible(true);
				sizelbl.setVisible(true);
				setSizebtn.setVisible(true);//점찍을거니까 크기설정 다 보여주기 
			}
			else if(obj == setModebtn[1])//LINE 그리기 
			{
				setbtnEnable(setModebtn[1]);
				if(getBack == 1)//위와 같음 
				{
					getBack = 0;
					drawPanel.setdrawColor(selectColor);
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setDrawMode(dc.LINE);
				sizeTxt.setVisible(false);
				sizelbl.setVisible(false);
				setSizebtn.setVisible(false);//안보이게 
			}
			else if(obj == setModebtn[2])//RECT
			{
				setbtnEnable(setModebtn[2]);
				if(getBack == 1)
				{
					getBack = 0;
					drawPanel.setdrawColor(selectColor);
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setDrawMode(dc.RECT);
				sizeTxt.setVisible(false);
				sizelbl.setVisible(false);
				setSizebtn.setVisible(false);
			}
			else if(obj == setModebtn[3])//OVAL
			{
				setbtnEnable(setModebtn[3]);
				if(getBack == 1)
				{
					getBack = 0;
					drawPanel.setdrawColor(selectColor);
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setDrawMode(dc.OVAL);
				sizeTxt.setVisible(false);
				sizelbl.setVisible(false);
				setSizebtn.setVisible(false);
			}
			else if(obj == setModebtn[4])//FREE
			{
				setbtnEnable(setModebtn[4]);
				if(getBack == 1)
				{
					getBack = 0;
					drawPanel.setdrawColor(selectColor);
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setDrawMode(dc.FREE);
				sizeTxt.setVisible(true);
				sizelbl.setVisible(true);
				setSizebtn.setVisible(true);
			}
			else if(obj == sizeTxt || obj == setSizebtn)//사이즈 설정할 때 
			{
				drawPanel.setsize(Integer.parseInt(sizeTxt.getText()));//drawPanel의 setsize함수를 이용하여 사이즈 변경 
			}
			else if(obj == setColorbtn)//색상 설정 버튼을 눌렀을 때 
			{
				setFillbtnEnable();
				selectColor = JColorChooser.showDialog(drawPanel,"Select Color",selectColor);//컬러 정하고
				drawPanel.setdrawColor(selectColor);//그릴 색상 변경 
				Colorpane.setBackground(selectColor);
			}
			else if(obj == About)//About버튼 
			{
				JOptionPane.showMessageDialog(null,str);//내용 출력 
			}
			else if(obj == EXIT)//나가기 버튼 
			{
				int confirm;
				confirm = JOptionPane.showConfirmDialog(null,"정말 나가시겠습니까?");
				if(confirm == JOptionPane.YES_OPTION)//나간다면 
				{
					InitEveryThings();//전체를 초기화 하고나서
					//나가기 수행 
				}
				else//나가지 않는다면 그냥 두기 
				{}
			}
			else if(obj == resetDraw)//화면 클리어 
			{
				setFillbtnEnable();
				drawPanel.InitDrawing();//화면 전체를 지우기 
			}
			else if(obj == Erase)//지우개 사용 
			{
				setbtnEnable(Erase);
				getBack = 1;//getBack변수를 1로 
				drawPanel.setdrawColor(Color.white);//그리기 색상을 흰색으로 
				Colorpane.setBackground(Color.white);//Color패널의 배경도 흰색으로 
				drawPanel.setDrawMode(dc.FREE);//그리기모드를 프리드로우모드로 
				sizeTxt.setVisible(true);
				sizelbl.setVisible(true);
				setSizebtn.setVisible(true);//포인트 크기 지정 가능하도록 
			}
			else if(obj == Fillbtn)//화면 채우기 버튼 
			{
				setbtnEnable(Fillbtn);
				if(getBack == 1)//방금 지우개 썼으면 
				{
					getBack = 0;
					drawPanel.setdrawColor(selectColor);
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setdBackground();//drawPanel의 setdBackground함수 이용 .
			}	
			else if(obj == lastbtn)//마지막에 실행한것 지우기 
			{
				setFillbtnEnable();
				drawPanel.Undo();//drawPanel의 Undo함수 이용 
			}
		}
	}
}

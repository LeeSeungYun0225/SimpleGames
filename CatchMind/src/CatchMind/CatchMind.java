package CatchMind;

import java.awt.*;
import javax.swing.*;//to Use Graphics...
import java.awt.event.*;//to Use Event Handler 
import java.util.*;
import java.lang.*;

public class CatchMind extends JPanel//ĳġ���ε� �г� 
{
	
	////////////////////DATA FIELDS///////////////////////
	
	//Start//
	private JButton Startbtn;
	private JLabel Startlbl;
	//////////////////	
	
	
	//Point Size// 
	private JTextField sizeTxt;//������ ���� �ؽ�Ʈ 
	private JButton setSizebtn;//������ ���� ��ư 
	private JLabel sizelbl;//������ ���� ���� ���̺� 
	//////////////////
	
	//Answer//
	private String[] answer;//���ڿ�(��) �迭 
	private JTextField answerTxt; //�� �Է� �ؽ�Ʈ 
	private JButton answerInbtn;// �� �Է� ��ư 
	private int randNum;//���� ���ڸ� �̿��Ͽ� ������ �Ź� �������� �޾ƿ��� 
	//////////////////
	
	//Color//
	private JButton setColorbtn;//�÷� ���� ��ư 
	private JPanel Colorpane;//���� ������ �÷��� �����ִ� �г� 
	private Color selectColor;//�÷��� ���� ���� ColorŸ�� ���� 
	///////////////////
	
	//Layout Panel//
	private JPanel boxPanel;//�ڽ� ���̾ƿ����� �����ϰ� ��ư�� ���� �г�, ������ ��ġ 
	private JPanel GridPanel;//�׸��� ���̾ƿ����� �����ϰ� ��ư�� ���� �г�, �ϴܿ� ��ġ 
	///////////////////

	//score//
	private int score;//���� ���� ���� 
	private JLabel scorelbl;//����/10 ���� ���̺� 
	private int count=0;//���� Ǭ ���� �� ī��Ʈ 
	///////////////////
	
	//Eraser//
	private JButton Erase;//������ �����Ӱ� ���� �� �ֵ��� �ϴ� ���찳 ��ư  
	private int getBack;//���찳�� ����Ͽ��ٰ� �ٽ� �׸��׸��� ���� ���ư��� 
	//�Ͼ������ ���� �Ǿ� �ִ� ������ �ִ�. ���� �������� �����ֱ� ���� ���� ����
	private JButton resetDraw;//ȭ�� ��ü�� ������ ���� �����ϴ� ��ư 
	private JButton lastbtn;//���� �������� �׸� ���뿡 ���� ��� ����Ʈ ������ ���� �����Ͽ� ����� ��ư 
	///////////////////
	
	
	//Listener Object//
	private bListener bl;//��� ��ư, �ؽ�Ʈ�� add�ѵ� ����� �׼� ������ 
	///////////////////
	
	//User Defined Class Object//
	private DrawingConstant dc;//DrawingConstants�� ��� ���� Ŭ������ ������ �ʿ䰡 ������, DID�迭�� ����ϱ� ����(�Ʒ� �ҽ� ����)
	private Drawing drawPanel;//�׸��� �׸� �г� drawPanel�� �����Ѵ� 
	///////////////////
	
	
	//ETC....//
	private JButton[] setModebtn;//��� ���� ��ư �迭 
	private JButton Passbtn;//���� �ѱ��(�н�) ��ư 
	private String str;//����� ���ڿ� ���� 
	private JButton About;//About��ư 
	private JButton EXIT;//������ ��ư 
	private JButton Fillbtn;//�ϳ��� ������ ���� ä��� ��ư 
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
		setSizebtn = new JButton("����");
		answerTxt = new JTextField(50);//�� ���� �ؽ�Ʈ�ʵ� 
		answer = new String[10];//���� �Է��� ���ڿ� ���̸��� ����
		answerInbtn = new JButton("�Է�"); 
		setColorbtn = new JButton("�� ����");
		Colorpane = new JPanel();
		Erase = new JButton("���찳");	
		lastbtn = new JButton("Undo");//�������� ������ �۾� ������ ��ư 
		resetDraw = new JButton("����");	
		Passbtn = new JButton("�н�");
		setModebtn = new JButton[5];//��ο� ��带 ������ ��ư ���� 
		GridPanel = new JPanel();
		boxPanel = new JPanel();
		Fillbtn = new JButton("����");
		scorelbl = new JLabel(""+score+ "/" + count);//���� ���� 
		About = new JButton("About");
		EXIT = new JButton("������");
		
		
		Init();
		
	}//Default Constructor
	
	public void Init()
	{
		//Initiate//
		setLayout(null);//���̾ƿ� ���� 
		setPreferredSize(new Dimension(800,640));//ũ�⸦ 800,640���� 
		setBackground(Color.white);//���� ���� 
		setVisible(true);//�ϴ� ���̵��� ���� 
		//CatchMind �гο� ���� �ʱ�ȭ// 	
		
		//User Defined Class Object & Listener Class Object//
		dc = new DrawingConstant();//dc�� �ִ� DID�迭�� ����Ұ��̱� ������ ������ 
		drawPanel = new Drawing();
		drawPanel.setDrawMode(dc.NONE);//��ο��带 NONE���� �����ص� 
		drawPanel.setBounds(10,30,600,430);//��ġ & ũ��
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
		
		sizeTxt.setBounds(695,430,20,30);//��ġ & ũ��
		sizeTxt.setText(""+drawPanel.getsize());//�ؽ�Ʈ �ʵ� �ȿ� �⺻ ������ ����Ʈ������ �ֱ� 
		sizelbl.setText("S I Z E : ");
		sizelbl.setBounds(630,430,60,30);//��ġ & ũ��
		sizelbl.setFont(new Font("Verdana",Font.BOLD,13));
		sizelbl.setBackground(Color.white);//����
		sizelbl.setForeground(Color.black);//��Ʈ�� 

		setSizebtn.setBackground(Color.black);//���� 
		setSizebtn.setForeground(Color.white);//��Ʈ�� 
		setSizebtn.setBounds(725,430,60,30);//��ġ & ũ��
		sizeTxt.setVisible(false);
		sizelbl.setVisible(false);
		setSizebtn.setVisible(false);//Point Ȥ�� Free Ȥ�� ���찳 ��忡���� �����ֱ� ���� �Ⱥ��̰�
		/////////////////////////////
		
		//Answer//

		randNum = (int)(Math.random()*10);//������ �� �������� 
		answerTxt.setText("");
		answerTxt.setBounds(10,470,500,30);//��ġ & ũ��
		answerInbtn.setBackground(Color.black);//���� 
		answerInbtn.setForeground(Color.white);//��Ʈ�� 
		answerInbtn.setBounds(520,470,90,30);//��ġ & ũ��
		saveAnswer();//answer��Ʈ���� ���� �����صδ� �Լ� 
		setNewAnswer();//���ο� �� �����Լ� :: randNum�̿�
		/////////////////////////////
		
		//Color//
		setColorbtn.setBackground(Color.black);//���� 
		setColorbtn.setForeground(Color.white);//��Ʈ�� 
		selectColor = Color.black;//������ ���������� �ʱ�ȭ�Ѵ� 
		Colorpane.setBackground(selectColor);//���� :: �⺻ ����(������)���� �ʱ�ȭ�Ѵ� 
		Colorpane.setBounds(740,100,50,30);//��ġ & ũ�� 
		////////////////////////////
		
		//Eraser//
		getBack = 0;

		Erase.setBackground(Color.black);//���� 
		Erase.setForeground(Color.white);//��Ʈ��
		lastbtn.setBackground(Color.black);//����
		lastbtn.setForeground(Color.white);//��Ʈ�� 
		resetDraw.setBackground(Color.black);//���� 
		resetDraw.setForeground(Color.white);//��Ʈ�� 
		//////////////////////////
		
		//Layout Panel//
		Passbtn.setBackground(Color.black);//���� 
		Passbtn.setForeground(Color.white);//��Ʈ�� 
		InitBtn();//�Լ��� �̿��Ͽ� �̸� �ʱ�ȭ �� 
		Fillbtn.setBackground(Color.black);//���� 
		Fillbtn.setForeground(Color.white);//��Ʈ�� 
		setGridPanel();//�г� ���� �Լ� 
		setBoxPanel();//�г� ���� �Լ� 
		////////////////////////////
		
		
		//Score//
		score = 0;
		scorelbl.setText(""+score+ "/" + count);//���� ���� 
		scorelbl.setBackground(Color.yellow);//���� 
		scorelbl.setFont(new Font("Verdana",Font.BOLD,20));//��Ʈ����
		scorelbl.setBounds(380,610,100,30);//��ġ & ũ�� 
		//////////////////////////////
		
		//ETC....//
		About.setBackground(Color.black);//���� 
		About.setForeground(Color.white);//��Ʈ�� 
		About.setBounds(720,600,70,30);//��ġ & ũ�� 
		EXIT.setBackground(Color.green);//����
		EXIT.setForeground(Color.white);//��Ʈ�� 
		EXIT.setBounds(10,610,100,30);//��ġ & ũ�� 
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
	
	public void StartShow()//��ŸƮ ��ư Ŭ���� �����ֱ� 
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
		for(int i = 0;i < 5;i++)//��� ��ư Ȱ��ȭ �� �� �ʱ�ȭ 
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
	
	public void Start()//���۽� ����ȭ�鸸 ���̵��� 
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
	
	public void setbtnEnable(JButton btn)//�Ķ���� ��ư�� ������ ���ϵ��� . �������� ���� �� �ֵ���:: ���� ��� ǥ�ÿ��� 
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
		setFillbtnEnable();//Fillbtn�� ���� ���� ���� 
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
	public void setNewAnswer()//�� ���� �����ϴ� �Լ� 
	{
		boolean check = true;//check�� true or false�� ���� booleanŸ�� �������� 
		if(count == 10)//10���� ���ߴٸ� 
		{
			count = 0;//count�� �ʱ�ȭ�ϰ� 
			check = false;//check�� false�� 
		}
		else
		{
			check = true;//���������� �ִٸ� check�� true�� 
		}
		if(check)//���� ������ ���� ��, if���� ���ư��� 
		{
			randNum = (int)(Math.random()*10);//�� ���� �ѹ� ã�� �ְ� 
			while(dc.DID[randNum] == 1)//���� ��Ǭ ������ ã�� �� ���� ����
			{
				randNum = (int)(Math.random()*10);//0~0.9999... * 10 + 1 , int :: 1~10���� 
				//�������� ���� �޾ƿͼ� 
			}
			dc.DID[randNum] = 1;//�� �ε����� Ǭ ������ �ٲ� 
		}
		else//��� ������ �� Ǯ���ٸ� 
		{
			InitDID();//DID�迭�� Init���ش� 
			randNum = (int)(Math.random()*10);
			dc.DID[randNum] = 1;
		}
		count++;//���� Ǭ ���ڵ� �ϳ� ���������ش� 
	}
	
	
	public void InitDID()//DID�迭�� �ʱ�ȭ�Ѵ� 
	{
		for(int i=0; i<10;i++)
		{
			dc.DID[i] = 0;
		}
	}
	
	public void InitEveryThings()//��� �ʱ�ȭ 
	{
		count = 0;//count �ʱ�ȭ 
		score = 0;
		drawPanel.InitDrawing();//�׸��׸��� ����� 
		InitDID();//DID�迭�� �ʱ�ȭ�ϰ� 
		setNewAnswer();//�䵵 �����ϰ� 
		str = "Version : 2.0 Answer : " + answer[randNum];//�׿����� �䵵 �������ְ� 
		scorelbl.setText(""+score+ "/" + count);//���ھ� �缳�� 
	}
	
	public void saveAnswer()//�� ���� 
	{
		answer[0] = "��";
		answer[1] = "��";
		answer[2] = "��";
		answer[3] = "����";
		answer[4] = "��";
		answer[5] = "���̽�ũ��";
		answer[6] = "��";
		answer[7] = "����";
		answer[8] = "�б�";
		answer[9] = "����";
	}
	
	public void InitBtn()//�迭 ��ư �ʱ�ȭ
	{
		
		setModebtn[0] = new JButton("��");
		setModebtn[1] = new JButton("��");	
		setModebtn[2] = new JButton("�簢��");
		setModebtn[3] = new JButton("��");
		setModebtn[4] = new JButton("������ο�");
		for(int i = 0;i < 5;i++)
		{
			setModebtn[i].setBackground(Color.black);//���� 
			setModebtn[i].setForeground(Color.white);//��Ʈ�� 
		}
	}
	
	public void setBoxPanel()//�ڽ� ���̾ƿ� �г� ���� 
	{
		boxPanel.setLayout(new GridLayout(7,1));
		boxPanel.setBackground(Color.white);//���� 
		boxPanel.setBounds(630,30,100,400);//��ġ & ũ�� 
		boxPanel.add(Passbtn);//��ư add 
		boxPanel.add(setColorbtn);
		boxPanel.add(setModebtn[0]);
		boxPanel.add(setModebtn[1]);
		boxPanel.add(setModebtn[2]);
		boxPanel.add(setModebtn[3]);
		boxPanel.add(setModebtn[4]);// ���� �۾� ���� 
	}		
	
	public void setGridPanel()//�׸��� ���̾ƿ� �г� ���� 
	{
		GridPanel.setLayout(new GridLayout(1,4));//1�� 4���� �� �׸��� ���̾ƿ� 
		GridPanel.setBackground(Color.white);//���� 
		GridPanel.setBounds(10,520,400,30);//��ġ & ũ�� 
		GridPanel.add(resetDraw);
		GridPanel.add(Erase);
		GridPanel.add(Fillbtn);
		GridPanel.add(lastbtn);
		//add ��ư 
	}
	
	
	public class bListener implements ActionListener//�׼� ������ Ŭ���� 
	{
		public void actionPerformed(ActionEvent event)
		{
			Object obj = event.getSource();//��ü�� �����ؼ� �ҽ� �޾ƿ��� 
			
			
			if(obj == Startbtn)//��ŸƮ ��ư�� ������ ��, 
			{
				StartShow();
			}
			else if(obj == Passbtn)//�н���ư�� ������ ��, 
			{
				int pass;
				int look = 0;
				int fullCount;
				
				pass = JOptionPane.showConfirmDialog(null,"������ �н��Ͻðڽ��ϱ�?");
				if(pass == JOptionPane.YES_OPTION)//�н��� �� 
				{
					answerTxt.setText("");//�� �ִ� �ؽ�Ʈ�� ���� 
					drawPanel.InitDrawing();//�׸��� �� ����� 
					look = 1;//look�� 1�� 
				}
				else
				{
					look = 0;//look�� 0���� 
				}

				if(count == 10 & look == 1)//10��° �����̸鼭, ��� 10��° ������ ������� ��, 
				{
					fullCount = JOptionPane.showConfirmDialog(null,""+score+"�� ������ϴ�."+"��� ������ �� Ǯ�����ϴ�. �ٽ� �Ͻðڽ��ϱ�?");
					if(fullCount == JOptionPane.YES_OPTION)//�� Ǯ�� ��� �� �� 
					{
						score = 0;//���� �ʱ�ȭ 
						answerTxt.setText("");//�� �ؽ�Ʈ �ʱ�ȭ 
						drawPanel.InitDrawing();//�׸� ����� 
						look = 1;//look�� 1�� 
					}
					else//��� ���� ��
					{
						look = 0;//look�� 0���� 
					}
				}
				if(look == 1)//�н��߰ų� 10���� ���� ����� �� ,
				{
					setNewAnswer();//�� ���� �������� 
					str = "Version : 2.0 Answer : " + answer[randNum];//str�� ���� 
				}
				if(count<=10)//count�� 10���� �۰ų� ���� �� 
				{
					scorelbl.setText(""+score+ "/" + count);//���ھ� ���ΰ�ħ 
				}
			}
			else if(obj == answerTxt || obj == answerInbtn)//���� �־��� �� 
			{
				String check;//���ڿ� üũ ��Ʈ��Ÿ�� ���� 
				check = answerTxt.getText();//answer.Txt�� ���� �޾ƿͼ� 
				if(check.equals(answer[randNum]))//��� ���ؼ� ������ , 
				{
					int continueGame,fullCount;
					int look = 0;
					score++;//���ھ� ����
					scorelbl.setText(""+score+ "/" + count);
					
					
					continueGame = JOptionPane.showConfirmDialog(null,"�����Դϴ�. ��� �Ͻðڽ��ϱ�?");
					if(continueGame == JOptionPane.YES_OPTION)//��� �� �� 
					{	
						look = 1;//look 1�� 
						answerTxt.setText("");//�� ĭ ���� 
						drawPanel.InitDrawing();//�׸� ����� 
					}
					else
					{
						look = 0;
					}
					
					if(count == 10)
					{
						fullCount = JOptionPane.showConfirmDialog(null,""+score+"�� ������ϴ�."+"��� ������ �� Ǯ�����ϴ�. �ٽ� �Ͻðڽ��ϱ�?");
						if(fullCount == JOptionPane.YES_OPTION)//���߰� ����� ��, 
						{
							score = 0;//���� �ʱ�ȭ 
							answerTxt.setText("");//��ĭ ���� 
							drawPanel.InitDrawing();//�׸� ����� 
							look = 1;
						}
						else
						{
							look = 0;
						}
					}
					if(look == 1)
					{
						setNewAnswer();//�� �� �������� 
						str = "Version : 2.0 Answer : " + answer[randNum];
					}
					if(count<=10)
					{
						scorelbl.setText(""+score+ "/" + count);//���ھ� ���ΰ�ħ 
					}

				}
				else // Ʋ���� ��, 
				{
					String str1;
					str1 = "Ʋ�Ƚ��ϴ�";
					JOptionPane.showMessageDialog(null,str1);//�˷��ְ� 
					answerTxt.setText("");//��ĭ ���� 
				}
			}
			else if(obj == setModebtn[0])//POINT �׸��� 
			{
				setbtnEnable(setModebtn[0]);
				if(getBack == 1)//��� ���찳�� ��ٸ�, 
				{
					getBack = 0;//getBack�� 0���� �ٲ��ְ� 
					drawPanel.setdrawColor(selectColor);//���� �������� �ǵ����� 
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setDrawMode(dc.POINT);//��ο� ��嵵 �ٲ��ֱ� 
				sizeTxt.setVisible(true);
				sizelbl.setVisible(true);
				setSizebtn.setVisible(true);//�������Ŵϱ� ũ�⼳�� �� �����ֱ� 
			}
			else if(obj == setModebtn[1])//LINE �׸��� 
			{
				setbtnEnable(setModebtn[1]);
				if(getBack == 1)//���� ���� 
				{
					getBack = 0;
					drawPanel.setdrawColor(selectColor);
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setDrawMode(dc.LINE);
				sizeTxt.setVisible(false);
				sizelbl.setVisible(false);
				setSizebtn.setVisible(false);//�Ⱥ��̰� 
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
			else if(obj == sizeTxt || obj == setSizebtn)//������ ������ �� 
			{
				drawPanel.setsize(Integer.parseInt(sizeTxt.getText()));//drawPanel�� setsize�Լ��� �̿��Ͽ� ������ ���� 
			}
			else if(obj == setColorbtn)//���� ���� ��ư�� ������ �� 
			{
				setFillbtnEnable();
				selectColor = JColorChooser.showDialog(drawPanel,"Select Color",selectColor);//�÷� ���ϰ�
				drawPanel.setdrawColor(selectColor);//�׸� ���� ���� 
				Colorpane.setBackground(selectColor);
			}
			else if(obj == About)//About��ư 
			{
				JOptionPane.showMessageDialog(null,str);//���� ��� 
			}
			else if(obj == EXIT)//������ ��ư 
			{
				int confirm;
				confirm = JOptionPane.showConfirmDialog(null,"���� �����ðڽ��ϱ�?");
				if(confirm == JOptionPane.YES_OPTION)//�����ٸ� 
				{
					InitEveryThings();//��ü�� �ʱ�ȭ �ϰ���
					//������ ���� 
				}
				else//������ �ʴ´ٸ� �׳� �α� 
				{}
			}
			else if(obj == resetDraw)//ȭ�� Ŭ���� 
			{
				setFillbtnEnable();
				drawPanel.InitDrawing();//ȭ�� ��ü�� ����� 
			}
			else if(obj == Erase)//���찳 ��� 
			{
				setbtnEnable(Erase);
				getBack = 1;//getBack������ 1�� 
				drawPanel.setdrawColor(Color.white);//�׸��� ������ ������� 
				Colorpane.setBackground(Color.white);//Color�г��� ��浵 ������� 
				drawPanel.setDrawMode(dc.FREE);//�׸����带 ������ο���� 
				sizeTxt.setVisible(true);
				sizelbl.setVisible(true);
				setSizebtn.setVisible(true);//����Ʈ ũ�� ���� �����ϵ��� 
			}
			else if(obj == Fillbtn)//ȭ�� ä��� ��ư 
			{
				setbtnEnable(Fillbtn);
				if(getBack == 1)//��� ���찳 ������ 
				{
					getBack = 0;
					drawPanel.setdrawColor(selectColor);
					Colorpane.setBackground(selectColor);
				}
				drawPanel.setdBackground();//drawPanel�� setdBackground�Լ� �̿� .
			}	
			else if(obj == lastbtn)//�������� �����Ѱ� ����� 
			{
				setFillbtnEnable();
				drawPanel.Undo();//drawPanel�� Undo�Լ� �̿� 
			}
		}
	}
}

package CatchMind;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Drawing extends JPanel//드로잉 패널 
{
	private ArrayList<DrawingData> data;//DrawingData를 어레이 리스트로 갖는 data 선언 
	private int size = 30;//기본 사이즈 
	private MListener ml;//마우스 리스너 선언 
	private int DrawMode;//드로우 모드 변수 
	private Color drawColor;//드로우 색상 변수 
	private boolean drag;//드래그 체크 boolean변수 
	private Point dragPoint;//드래그한 지점 받는 포인트 변수 
	private Point pt1,pt2;//선, 사각형 등에 쓰이는 포인트 변수 
	private ArrayList<Point> pt3;
	
	public Drawing()
	{
		//this Initiate//
		setPreferredSize(new Dimension(600,430));
		setBackground(Color.white);
		setVisible(true);
		//////////////
		
		//변수들 초기화//
		drawColor = Color.black;
		drag = false;
		dragPoint = new Point();
		pt1 = new Point();
		pt2 = new Point();	
		pt3 = new ArrayList<Point>();
		data = new ArrayList<DrawingData>();
		////////////////////
		
		InitDrawing();//data를 초기화하는 함수 
		
		ml = new MListener();

		addMouseListener(ml);
		addMouseMotionListener(ml);
	}
	

	
	public void InitDrawing()////맞췄을때, 혹은 재실행 했을 때, 모두 초기화 
	{
		for(int i = 0 ; i<data.size(); i++)//data에 있는 내용을 모두 초기화한다 
		{
			DrawingData delete;
			delete = data.get(i);
			delete.pt = null;
			delete.pt1 = null;
			delete.pt2 = null;
			delete.pt3 = null;
			delete.drawMode = DrawingConstant.NONE; 
			delete.pointSize = 30;
			delete.drawColor = Color.black;
			repaint();
		}
	}
	
	public void Undo()//방금 실행한 내용을 되돌리기 
	{
		DrawingData delete;//새 변수를 만들어서 
		int i = data.size()-1;//i에 data의 마지막 인덱스를 받아온다음 
		if(i>=0)//만약 마지막 인덱스가 0이상이라면(값이 하나라도 존재한다면)
		{	
			delete = data.get(i);//delete에 data의 i번째 값을 받아온다 
		
			if(delete.drawMode == DrawingConstant.POINT || delete.drawMode == DrawingConstant.LINE || delete.drawMode == DrawingConstant.RECT || 
			delete.drawMode == DrawingConstant.OVAL || delete.drawMode == DrawingConstant.FILL)
			{
				data.remove(delete);
				repaint();
			}
		
			else if(delete.drawMode == DrawingConstant.FREE)//프리 드로우일 때 
			{
				int k = data.size()-1;//k에는 data의 마지막 인덱스를 
				int ptk = pt3.size()-1;//ptk에는 pt3의 마지막 인덱스를(마지막 프리드로우의 시작 지점)
				DrawingData j;//하나의 변수를 만들어서 
			
				Point savept = pt3.get(ptk);//Point변수에는 pt3의 마지막 값을 가져와서 
				for(j = data.get(k);j.pt3 != savept;j = data.get(--k))//j에는 data의 마지막 값을 가져와서  
				{
					data.remove(j);//마지막 프리드로우의 시작+1 인덱스부터 data의 마지막까지 지워버린다.
				}
			
				if(j.pt3 == savept)//마지막 프리드로우의 시작 인덱스가 남아있으므로 
				{
					data.remove(j);//지워버리고 
					repaint();//그려준다 그럼 없어지지롱 
				}
				pt3.remove(savept);//포인트에서도 마지막 프리드로우 시작 인덱스를 지워버린다. 
			}
		}
	}

	
	public void setdrawColor(Color color)
	{
		drawColor = color;
	}
	public Color getdrawColor()
	{
		return drawColor;
	}
	
	public void setdBackground()//채우기 수행함수 
	{
		Point p1,p2;
		p1 = new Point();
		p2 = new Point();
		p1.x = 0;
		p1.y = 0;
		p2.x = 600;
		p2.y = 430;//포인트변수 두개 선언 후 설정해주고 
		setDrawMode(DrawingConstant.FILL);//사각형을 그리도록 설정한다 
		data.add(new DrawingData(p1,p2,getdrawColor(),getDrawMode()));
		repaint();//그려 
	}
	
	public void setDrawMode(int drawmode)
	{
		DrawMode = drawmode;
	}
	public int getDrawMode()
	{
		return DrawMode;
	}
	
	public void setsize(int sz)
	{
		size = sz;
	}
	public int getsize()
	{
		return size;
	}
	
	public void dRect(Graphics pg,Point pt1,Point pt2)//사각형 그리기 
	{
		if(pt1.x > pt2.x && pt1.y > pt2.y)
		{
			pg.drawRect(pt2.x,pt2.y,(pt1.x-pt2.x),(pt1.y-pt2.y));
		}
		else if(pt1.x > pt2.x && pt1.y < pt2.y)
		{
			pg.drawRect(pt2.x,pt1.y,(pt1.x-pt2.x),(pt2.y-pt1.y));
		}
		else if(pt1.x < pt2.x && pt1.y > pt2.y)
		{
			pg.drawRect(pt1.x,pt2.y,(pt2.x-pt1.x),(pt1.y-pt2.y));
		}
		else if(pt1.x < pt2.x && pt1.y < pt2.y)
		{
			pg.drawRect(pt1.x,pt1.y,(pt2.x-pt1.x),(pt2.y-pt1.y));
		}
	}
	
	public void dOval(Graphics pg,Point pt1,Point pt2)//원 그리기 
	{
		if(pt1.x > pt2.x && pt1.y > pt2.y)
		{
			pg.drawOval(pt2.x,pt2.y,(pt1.x-pt2.x),(pt1.y-pt2.y));
		}
		else if(pt1.x > pt2.x && pt1.y < pt2.y)
		{
			pg.drawOval(pt2.x,pt1.y,(pt1.x-pt2.x),(pt2.y-pt1.y));
		}
		else if(pt1.x < pt2.x && pt1.y > pt2.y)
		{
			pg.drawOval(pt1.x,pt2.y,(pt2.x-pt1.x),(pt1.y-pt2.y));
		}
		else if(pt1.x < pt2.x && pt1.y < pt2.y)
		{
			pg.drawOval(pt1.x,pt1.y,(pt2.x-pt1.x),(pt2.y-pt1.y));
		}
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.drawRect(0,0,599,429);
		for(int i = 0 ; i < data.size() ; i ++ )//포문 돌 때 마다 그린것도 또 그림 
		{
			DrawingData dData = data.get(i);
			page.setColor(dData.drawColor);//색 설정을 이곳에서 dData.drawColor를 이용하여 하는것에 유의 
			
			if(dData.drawMode == DrawingConstant.POINT)
			{
				page.fillOval(dData.pt.x-(dData.pointSize/2),dData.pt.y-(dData.pointSize/2),dData.pointSize,dData.pointSize);
			}
			else if(dData.drawMode == DrawingConstant.LINE)
			{
					page.drawLine(dData.pt1.x,dData.pt1.y,dData.pt2.x,dData.pt2.y);
			}
			else if(dData.drawMode == DrawingConstant.RECT)
			{
					dRect(page,dData.pt1,dData.pt2);
			}
			else if(dData.drawMode == DrawingConstant.OVAL)
			{
					dOval(page,dData.pt1,dData.pt2);
			}
			else if(dData.drawMode == DrawingConstant.FREE)
			{
					page.fillOval(dData.pt3.x-(dData.pointSize/2),dData.pt3.y-(dData.pointSize/2),dData.pointSize,dData.pointSize);
			}
			else if(dData.drawMode == DrawingConstant.FILL)
			{
				page.fillRect(dData.pt1.x,dData.pt1.y,dData.pt2.x,dData.pt2.y);
			}
		}
		
		if(drag)//드래그했을 때, 잠깐 보여주는 그림 
		{
			if(DrawMode == DrawingConstant.LINE)
			{
				page.drawLine(pt1.x,pt1.y,dragPoint.x,dragPoint.y);
			}
			else if(DrawMode == DrawingConstant.RECT)
			{
				dRect(page,pt1,dragPoint);
			}
			else if(DrawMode == DrawingConstant.OVAL)
			{
				dOval(page,pt1,dragPoint);
			}
		}			
	}
	
	
	public class MListener implements MouseListener,MouseMotionListener
	{	
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mousePressed(MouseEvent event)
		{
			if(getDrawMode() == DrawingConstant.POINT)//점 찍기. Clicked가 부자연스러워서 Press로 구현 
			{
				data.add(new DrawingData(event.getPoint(),getsize(),getdrawColor(),getDrawMode()));
				repaint();
			}
			else if(getDrawMode() == DrawingConstant.LINE || getDrawMode() == DrawingConstant.RECT ||
			getDrawMode() == DrawingConstant.OVAL)//선,사각형,원 그리기 
			{
				pt1 = event.getPoint();
				drag = true;
			}
			else if(getDrawMode() == DrawingConstant.FREE)//프리드로우 
			{
				Point pt;
				pt = event.getPoint();//pt에 시작 포인트를 받고 
				pt3.add(pt);//그것을 pt3에 저장(Undo수행할 때를 위해 저장해둠)
				data.add(new DrawingData(pt,getsize(),getdrawColor(),getDrawMode(),1));
				repaint();
			}		
		}
		public void mouseReleased(MouseEvent event)
		{
			if(getDrawMode() == DrawingConstant.LINE || getDrawMode() == DrawingConstant.RECT ||
			getDrawMode() == DrawingConstant.OVAL)//드래그하다가 뗏을 때, 
			{
				pt2 = event.getPoint();
				data.add(new DrawingData(pt1,pt2,getdrawColor(),getDrawMode()));
				drag = false;
				repaint();//pt1과 pt2에 대해 그리기 
			}
		}
		public void mouseDragged(MouseEvent event)
		{
			if(getDrawMode() == DrawingConstant.LINE || getDrawMode() == DrawingConstant.RECT ||
			getDrawMode() == DrawingConstant.OVAL)
			{
				dragPoint = event.getPoint();//드래그 하고있는 지점의 포인트 받아서 
				repaint();//그리기 
			}
			else if( getDrawMode() == DrawingConstant.FREE)
			{
				data.add(new DrawingData(event.getPoint(),getsize(),getdrawColor(),getDrawMode(),1));
				repaint();//드래그 하는 지점을 어레이 리스트로 받아서 드래그 할 때마다 계속 그려서 남기도록 
			}
		}
		public void mouseMoved(MouseEvent event){}
	}
}
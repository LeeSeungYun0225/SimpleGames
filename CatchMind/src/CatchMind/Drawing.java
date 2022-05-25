package CatchMind;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Drawing extends JPanel//����� �г� 
{
	private ArrayList<DrawingData> data;//DrawingData�� ��� ����Ʈ�� ���� data ���� 
	private int size = 30;//�⺻ ������ 
	private MListener ml;//���콺 ������ ���� 
	private int DrawMode;//��ο� ��� ���� 
	private Color drawColor;//��ο� ���� ���� 
	private boolean drag;//�巡�� üũ boolean���� 
	private Point dragPoint;//�巡���� ���� �޴� ����Ʈ ���� 
	private Point pt1,pt2;//��, �簢�� � ���̴� ����Ʈ ���� 
	private ArrayList<Point> pt3;
	
	public Drawing()
	{
		//this Initiate//
		setPreferredSize(new Dimension(600,430));
		setBackground(Color.white);
		setVisible(true);
		//////////////
		
		//������ �ʱ�ȭ//
		drawColor = Color.black;
		drag = false;
		dragPoint = new Point();
		pt1 = new Point();
		pt2 = new Point();	
		pt3 = new ArrayList<Point>();
		data = new ArrayList<DrawingData>();
		////////////////////
		
		InitDrawing();//data�� �ʱ�ȭ�ϴ� �Լ� 
		
		ml = new MListener();

		addMouseListener(ml);
		addMouseMotionListener(ml);
	}
	

	
	public void InitDrawing()////��������, Ȥ�� ����� ���� ��, ��� �ʱ�ȭ 
	{
		for(int i = 0 ; i<data.size(); i++)//data�� �ִ� ������ ��� �ʱ�ȭ�Ѵ� 
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
	
	public void Undo()//��� ������ ������ �ǵ����� 
	{
		DrawingData delete;//�� ������ ���� 
		int i = data.size()-1;//i�� data�� ������ �ε����� �޾ƿ´��� 
		if(i>=0)//���� ������ �ε����� 0�̻��̶��(���� �ϳ��� �����Ѵٸ�)
		{	
			delete = data.get(i);//delete�� data�� i��° ���� �޾ƿ´� 
		
			if(delete.drawMode == DrawingConstant.POINT || delete.drawMode == DrawingConstant.LINE || delete.drawMode == DrawingConstant.RECT || 
			delete.drawMode == DrawingConstant.OVAL || delete.drawMode == DrawingConstant.FILL)
			{
				data.remove(delete);
				repaint();
			}
		
			else if(delete.drawMode == DrawingConstant.FREE)//���� ��ο��� �� 
			{
				int k = data.size()-1;//k���� data�� ������ �ε����� 
				int ptk = pt3.size()-1;//ptk���� pt3�� ������ �ε�����(������ ������ο��� ���� ����)
				DrawingData j;//�ϳ��� ������ ���� 
			
				Point savept = pt3.get(ptk);//Point�������� pt3�� ������ ���� �����ͼ� 
				for(j = data.get(k);j.pt3 != savept;j = data.get(--k))//j���� data�� ������ ���� �����ͼ�  
				{
					data.remove(j);//������ ������ο��� ����+1 �ε������� data�� ���������� ����������.
				}
			
				if(j.pt3 == savept)//������ ������ο��� ���� �ε����� ���������Ƿ� 
				{
					data.remove(j);//���������� 
					repaint();//�׷��ش� �׷� ���������� 
				}
				pt3.remove(savept);//����Ʈ������ ������ ������ο� ���� �ε����� ����������. 
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
	
	public void setdBackground()//ä��� �����Լ� 
	{
		Point p1,p2;
		p1 = new Point();
		p2 = new Point();
		p1.x = 0;
		p1.y = 0;
		p2.x = 600;
		p2.y = 430;//����Ʈ���� �ΰ� ���� �� �������ְ� 
		setDrawMode(DrawingConstant.FILL);//�簢���� �׸����� �����Ѵ� 
		data.add(new DrawingData(p1,p2,getdrawColor(),getDrawMode()));
		repaint();//�׷� 
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
	
	public void dRect(Graphics pg,Point pt1,Point pt2)//�簢�� �׸��� 
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
	
	public void dOval(Graphics pg,Point pt1,Point pt2)//�� �׸��� 
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
		for(int i = 0 ; i < data.size() ; i ++ )//���� �� �� ���� �׸��͵� �� �׸� 
		{
			DrawingData dData = data.get(i);
			page.setColor(dData.drawColor);//�� ������ �̰����� dData.drawColor�� �̿��Ͽ� �ϴ°Ϳ� ���� 
			
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
		
		if(drag)//�巡������ ��, ��� �����ִ� �׸� 
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
			if(getDrawMode() == DrawingConstant.POINT)//�� ���. Clicked�� ���ڿ��������� Press�� ���� 
			{
				data.add(new DrawingData(event.getPoint(),getsize(),getdrawColor(),getDrawMode()));
				repaint();
			}
			else if(getDrawMode() == DrawingConstant.LINE || getDrawMode() == DrawingConstant.RECT ||
			getDrawMode() == DrawingConstant.OVAL)//��,�簢��,�� �׸��� 
			{
				pt1 = event.getPoint();
				drag = true;
			}
			else if(getDrawMode() == DrawingConstant.FREE)//������ο� 
			{
				Point pt;
				pt = event.getPoint();//pt�� ���� ����Ʈ�� �ް� 
				pt3.add(pt);//�װ��� pt3�� ����(Undo������ ���� ���� �����ص�)
				data.add(new DrawingData(pt,getsize(),getdrawColor(),getDrawMode(),1));
				repaint();
			}		
		}
		public void mouseReleased(MouseEvent event)
		{
			if(getDrawMode() == DrawingConstant.LINE || getDrawMode() == DrawingConstant.RECT ||
			getDrawMode() == DrawingConstant.OVAL)//�巡���ϴٰ� ���� ��, 
			{
				pt2 = event.getPoint();
				data.add(new DrawingData(pt1,pt2,getdrawColor(),getDrawMode()));
				drag = false;
				repaint();//pt1�� pt2�� ���� �׸��� 
			}
		}
		public void mouseDragged(MouseEvent event)
		{
			if(getDrawMode() == DrawingConstant.LINE || getDrawMode() == DrawingConstant.RECT ||
			getDrawMode() == DrawingConstant.OVAL)
			{
				dragPoint = event.getPoint();//�巡�� �ϰ��ִ� ������ ����Ʈ �޾Ƽ� 
				repaint();//�׸��� 
			}
			else if( getDrawMode() == DrawingConstant.FREE)
			{
				data.add(new DrawingData(event.getPoint(),getsize(),getdrawColor(),getDrawMode(),1));
				repaint();//�巡�� �ϴ� ������ ��� ����Ʈ�� �޾Ƽ� �巡�� �� ������ ��� �׷��� ���⵵�� 
			}
		}
		public void mouseMoved(MouseEvent event){}
	}
}
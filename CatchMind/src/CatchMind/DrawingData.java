package CatchMind;
import java.awt.*;
import java.util.*;

public class DrawingData//������ ���� Ŭ����, ����ü�� ����� ����//
{
	public Point pt,pt1,pt2,pt3;
	public int drawMode;
	public int pointSize = 30;
	public Color drawColor;
	
	public DrawingData()//�⺻ ������ 
	{
		pt = null;
		pt1 = null;
		pt2 = null;
		pt3 = null;
		drawMode = DrawingConstant.NONE;
		pointSize = 30;
		drawColor = Color.black;
	}
	public DrawingData(Point p,int size,Color color,int mode)//�� ��� ������ 
	{
		pt = p;
		pointSize = size;
		drawColor = color;
		drawMode = mode;
	}
	
	public DrawingData(Point p,int size,Color color,int mode,int toOverride)//������ο� ������ 
	{
		pt3 = p;
		pointSize = size;
		drawColor = color;
		drawMode = mode;
	}//toOverride�� �� ��� �����ڿ��� ������ ���� �뵵�� ���� 
	
	public DrawingData(Point p1,Point p2,Color color,int mode)//�簢��, ��, ������ ������ 
	{
		pt1 = p1;
		pt2 = p2;
		drawColor = color;
		drawMode = mode;
	}
}
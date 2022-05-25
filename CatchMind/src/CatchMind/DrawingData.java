package CatchMind;
import java.awt.*;
import java.util.*;

public class DrawingData//데이터 저장 클래스, 구조체와 비슷한 역할//
{
	public Point pt,pt1,pt2,pt3;
	public int drawMode;
	public int pointSize = 30;
	public Color drawColor;
	
	public DrawingData()//기본 생성자 
	{
		pt = null;
		pt1 = null;
		pt2 = null;
		pt3 = null;
		drawMode = DrawingConstant.NONE;
		pointSize = 30;
		drawColor = Color.black;
	}
	public DrawingData(Point p,int size,Color color,int mode)//점 찍기 생성자 
	{
		pt = p;
		pointSize = size;
		drawColor = color;
		drawMode = mode;
	}
	
	public DrawingData(Point p,int size,Color color,int mode,int toOverride)//프리드로우 생성자 
	{
		pt3 = p;
		pointSize = size;
		drawColor = color;
		drawMode = mode;
	}//toOverride는 점 찍기 생성자와의 구분을 위한 용도일 뿐임 
	
	public DrawingData(Point p1,Point p2,Color color,int mode)//사각형, 원, 직선의 생성자 
	{
		pt1 = p1;
		pt2 = p2;
		drawColor = color;
		drawMode = mode;
	}
}
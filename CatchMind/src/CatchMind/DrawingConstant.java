package CatchMind;
public class DrawingConstant
{
	public static final String[] Mode = {"POINT","LINE","RECT","OVAL","FREE"};//스트링 배열 
	
	//상수의 선언//
	public static final int POINT = 0;
	public static final int LINE = 1;
	public static final int RECT = 2;
	public static final int OVAL = 3;
	public static final int FREE = 4;
	public static final int FILL = 5;
	public static final int NONE = -1;
	/////////////////
	
	
	public static int[] DID = new int[10];//int타입 배열 
	
	public DrawingConstant()
	{
		for(int i=0;i<10;i++)
		{
			DID[i] = 0;
		}
	}
}//상수 저장 클래스 
// final은 c언어의  Define과 같은 역할로 상수 선언에 사용 

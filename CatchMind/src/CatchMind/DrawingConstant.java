package CatchMind;
public class DrawingConstant
{
	public static final String[] Mode = {"POINT","LINE","RECT","OVAL","FREE"};//��Ʈ�� �迭 
	
	//����� ����//
	public static final int POINT = 0;
	public static final int LINE = 1;
	public static final int RECT = 2;
	public static final int OVAL = 3;
	public static final int FREE = 4;
	public static final int FILL = 5;
	public static final int NONE = -1;
	/////////////////
	
	
	public static int[] DID = new int[10];//intŸ�� �迭 
	
	public DrawingConstant()
	{
		for(int i=0;i<10;i++)
		{
			DID[i] = 0;
		}
	}
}//��� ���� Ŭ���� 
// final�� c�����  Define�� ���� ���ҷ� ��� ���� ��� 

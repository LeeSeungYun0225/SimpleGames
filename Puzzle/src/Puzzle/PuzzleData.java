package Puzzle;

import java.lang.*;

public class PuzzleData
{
	public int[] imgidx;//�̹����ε��� �迭���� 
	
	public void PuzzleData()
	{
		imgidx = new int[15];//�ε������� ���̺� �ѹ��� ����//
		//�������� �̹��� �ѹ��� ����//
		for(int i=0;i<15;i++)
		{
			imgidx[i] = -1;
		}
	}
	
	public void setData(int index,int x)
	{
		imgidx[index] = x;
	}
}

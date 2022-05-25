package Puzzle;

import java.lang.*;

public class PuzzleData
{
	public int[] imgidx;//이미지인덱스 배열변수 
	
	public void PuzzleData()
	{
		imgidx = new int[15];//인덱스에는 레이블 넘버를 저장//
		//변수에는 이미지 넘버를 저장//
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

import java.util.Scanner;

public class NQueenBT 
{ 
	static int[][] board;
	static int N;
	
	public void input() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of N :- ");
		N = sc.nextInt();
		System.out.print("\n");
		
		board = new int[N][N];
	}

	public void printsol() 
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0;j<N;j++)
				System.out.print(board[i][j]+"   ");
			
			System.out.println();
		}
	}
	
	public boolean issafe(int[][] board2, int row, int col)
	{
		int i, j ;
		
		for(i= 0;i<col ;i++)
		{
			if(board[row][i] == 1)
				return false;
		}
		
		for(i=row,j=col ; i >=0 && j >= 0 ;i--, j--)
		{
			if(board[i][j] == 1)
				return false;
		}
		
		for(i=row,j=col ; j >= 0 && i <N ;i++, j--)
		{
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	public boolean solve(int[][] board2, int col) 
	{
		if(col >= N)
			return true;
		
		for(int i=0;i<N;i++)
		{
			if(issafe(board,i,col))
			{
				board[i][col] = 1;
				
				if(solve(board,col+1))
					return true;
				
				board[i][col] = 0;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		NQueenBT nq = new NQueenBT();
		nq.input();
		
		boolean b = nq.solve(board,0);
		 
		if(b)
			nq.printsol();
		
		else
			System.out.println("Solution doesn't exist.");
	}
}

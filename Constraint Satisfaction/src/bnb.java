import java.util.Arrays;
import java.util.Scanner;

public class bnb
{	
	static int n;
	
	public void solveProblem(int n)
	{
		int[][] board = new int[n][n];
		int[][] slash = new int[n][n];
		int[][] backslash = new int[n][n];
		
		boolean[] slashlookup = new boolean[2*n -1];
		boolean[] backslashlookup = new boolean [2*n-1];
		boolean[] rowlookup = new boolean[n];
		
		Arrays.fill(slashlookup, false);
		Arrays.fill(backslashlookup, false);
		Arrays.fill(rowlookup, false);
		
		for(int i=0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				slash[i][j] = i+j;
				backslash[i][j] = i-j + (n-1);
			}
		}
		
			
		boolean b1 = solve(board,0 , slash , backslash ,slashlookup, backslashlookup, rowlookup);
		
		if(b1)
			printsol(board);
		
		else
			System.out.print("Solution doesn't exist.");
		
		
	}
	
	public void printsol(int board[][]) 
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(board[i][j]+"  ");
			
			System.out.print("\n");
		}
	}
	
	public boolean solve(int[][] board, int col, int[][] slash, int[][] backslash, boolean[] slashlookup, boolean[] backslashlookup, boolean[] rowlookup)
	{
		if(col >= n)
			return true;
		
		for(int i=0;i<n;i++)
		{
			if(isSafe(board, i, col, slash, backslash, slashlookup,backslashlookup, rowlookup))
			{
				board[i][col] = 1;
				slashlookup[slash[i][col]] = true;
				backslashlookup[backslash[i][col]] = true;
				rowlookup[i] = true;
				
				if(solve(board, col+1,slash, backslash,slashlookup,backslashlookup,rowlookup))
					return true;
				
				board[i][col] = 0;
				slashlookup[slash[i][col]] = false;
				backslashlookup[backslash[i][col]] = false;
				rowlookup[i] = false;
			} 
		}
		
		return false;
	}
	
	
	private boolean isSafe(int[][] board2,int row, int col, int[][] slash2, int[][] backslash2, boolean[] slashlookup2,
			boolean[] backslashlookup2, boolean[] rowlookup2)
	{
		
		if(slashlookup2[slash2[row][col]] || backslashlookup2[backslash2[row][col]] || rowlookup2[row])
			return false;
		
		return true;
	}

	public static void main(String[] args)
	{
		bnb b = new bnb();
		
		System.out.print("Enter the value of N :- ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println();
		
		b.solveProblem(n);
	}
	
}

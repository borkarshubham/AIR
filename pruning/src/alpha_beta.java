import java.lang.*;

class alpha_beta 
{
	static int max = 10000;
	static int min  = -10000;
	
	public static int get_height(int length)
	{
		double ans = Math.log(length)/Math.log(2);
		int a= (int) ans;
		return a;
	}

	public static int find_ans(int depth, int nodeindex, int height, int[] values, boolean b, int alpha, int beta) 
	{
		int best = 0, value;
		
		if(depth == height)
			return values[nodeindex];
		
		else if(b)
		{
			best = min;
			
			for(int i = 0;i<2;i++)
			{
				value = find_ans(depth+1,nodeindex*2+i,height,values, false , alpha, beta);
				best = Math.max(best,value);
				alpha = Math.max(best, alpha);
				
				if(beta <= alpha)
					break;
			}
			
			System.out.print(best+"->");
			return best;
		}
		
		else
		{
			best = max;
			
			for(int i = 0;i<2;i++)
			{
				value = find_ans(depth+1,nodeindex*2+i,height,values, true , alpha, beta);
				best = Math.min(best,value);
				beta = Math.min(best, beta);
				
				if(beta <= alpha)
					break;
			}
			
			System.out.print(best+"->");
			return best;
		}
	}
	
	public static void main(String[] args)
	{
		int values[] = {3, 4, 2,1,7,8,9,10,2,11,1,12,14,9,13,16};
		int h = get_height(values.length);
		System.out.print("Node in sequence :- ");
		int b = find_ans(0,0,h,values,true,min,max);
		System.out.println("\nThe result is :- " + b);
	}
	
}

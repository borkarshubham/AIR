import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Block
{
	int id,on;
	
	public Block(int i)
	{
		this.on = -1;
		this.id = i;
	}
	
	public int getOn()
	{
		return this.on;
	}
	
	public void setOn(int i)
	{
		this.on = i;
	}
}

public class demo 
{
	List<Block> curr;
	List<Block> goal;
	boolean hand;
	int n;
	
	public demo(int n)
	{
		curr = new ArrayList<>();
		goal = new ArrayList<>();
		hand = true;
		this.n = n;
	}
	
	public static void main(String[] args)
	{
		System.out.print("Enter the number of blocks :- ");
		Scanner sc =  new Scanner(System.in);
		int a = sc.nextInt();
		
		System.out.println();
		
		demo d = new demo(a);
		
		for(int i=0;i<a;i++)
		{
			System.out.println("Enter the block above which the block "+i+" resides in current state :-");
			int a1 =sc.nextInt();
			
			if(a1 == i || a1 >= d.n)
			{
				System.out.println("Invalid Input\n");
				return;
			}
			
			Block B = new Block(i);
			B.setOn(a1);
			d.curr.add(B);
			
			System.out.println("Enter the block above which the block "+i+" resides in goal state :-");
			a1 =sc.nextInt();
			
			if(a1 == i || a1 >= d.n)
			{
				System.out.println("Invalid Input\n");
				return;
			}
			
			Block B1 = new Block(i);
			B1.setOn(a1);
			d.goal.add(B1);
		}
		
		d.satisfy();	
	}

	public void satisfy() 
	{
		boolean b = true;
		
		while(b)
		{
			b = false;
			
			for(int i=0;i<n;i++)
			{
				if(curr.get(i).getOn() != goal.get(i).getOn())
					stack(i,goal.get(i).getOn());
			}
			
			for(int i=0;i<n;i++)
			{
				if(curr.get(i).getOn() != goal.get(i).getOn())
					b = true;
			}
		}
	}

	public void stack(int i, int on)
	{
		//clear(i);
		
		if(on >= 0)
		{
			//clear(on);
			if(curr.get(i).getOn() != -1)
				System.out.println("Unstack "+i+ " from "+ curr.get(i).getOn());
			
			else
				System.out.println("Pick "+i+ " from ground");
			
			curr.get(i).setOn(on);
			
			System.out.println("Stack "+i+ " on "+ on);
		}
		
		else
		{
			curr.get(i).setOn(-1);
			System.out.println("Place "+i+ " on ground");
		}
	}

	public void clear(int id) 
	{
		for(int i=0;i<n;i++)
		{
			if(curr.get(i).getOn() == id)
			{
				//clear(i);
				curr.get(i).setOn(-1);
				System.out.println("Unstack "+ i +" from " +id);
			}
		}
	}
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class fun
{
	ArrayList<Integer> a1 = new ArrayList<>();
	
	int g,h,a,z;
	
	fun(ArrayList<Integer> b,int g,int h,int z)
	{
		this.a1 = b;
		this.g = g;
		this.h = h;
		this.a = this.g+this.h;
		this.z = z;
	}
}

class SortByAt implements Comparator<fun>
{
	public int compare(fun a, fun b){
		return a.a - b.a;
	}
}

public class Demo 
{
	public static void pri(ArrayList<Integer> a1)
	{
		for(int i=0;i<3;i++)
		{
			for(int j = 0;j<3;j++)
			{
				int in = i*3+j;
				System.out.print(a1.get(in)+"  ");
			}
			System.out.println();
		}
		
	}
	
	public static int mis(ArrayList<Integer> a)
	{
		int a1 = 0;
		
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i) != (i+1) && a.get(i) != 0)
				a1++;
		}
		
		return a1;
	}
	
	public static void main(String[] args)
	{
		System.out.print("Enter the size of matrix :- ");
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		System.out.println("\nEnter Initial State :-");
		ArrayList<Integer> int_state = new ArrayList<>(n*n);
		for(int i=0;i<n*n;i++)
		{
			int c = sc.nextInt();
			int_state.add(c);
		}
		
		System.out.println("\nThe Initial State :-");
		for(int i=0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				int in = i*n+j;
				System.out.print(int_state.get(in)+"  ");
			}
			System.out.println();
		}
		
		System.out.println("\nThe considered Goal State is :-");
		ArrayList<Integer> goal_state  =new ArrayList<>(n*n);
		goal_state.add(1);
		goal_state.add(2);
		goal_state.add(3);
		goal_state.add(4);
		goal_state.add(5);
		goal_state.add(6);
		goal_state.add(7);
		goal_state.add(8);
		goal_state.add(0);
		
		for(int i=0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				int in = i*n+j;
				System.out.print(goal_state.get(in)+"  ");
			}
			System.out.println();
		}
		
		int moves = 0;
		
		int h = mis(int_state);
		int z_in = int_state.indexOf(0);
		//fun f1 = new fun(int_state,0,h);
		
		ArrayList<fun> tree = new ArrayList<>();
		tree.add(new fun(int_state,0,h,z_in));
		System.out.println("\n\n");
		for(int i=0;i<tree.size();i++)
			System.out.println((tree.get(i).a1) + "  "+tree.get(i).g+"   "+tree.get(i).h+"   "+tree.get(i).a+"  "+tree.get(i).z);
	
		System.out.println("\n\n");
		
		while(tree.size() > 0)
		{	
			//moves++;
			
			int zero_ind = tree.get(0).z;
			int curr_g = tree.get(0).g;
			ArrayList<Integer> curr_arr = tree.get(0).a1;
			
			
			
			//tree.remove(0);
 			
			if(zero_ind == 0)
			{
				//moves right
				
				//moves down
			}
			
			else if(zero_ind == 1)
			{
				//moves down
				
				//moves left
				
				//moves right
			}
			
			else if(zero_ind == 2)
			{
				//moves down
				
				//moves left
			}
			
			else if(zero_ind == 3)
			{
				curr_g++;
				
				//moves top
				ArrayList<Integer> temp_arr = new ArrayList<>();
				temp_arr = curr_arr;
				
				int temp = temp_arr.get(0);
				temp_arr.set(0,curr_arr.get(3));
				temp_arr.set(3,temp);
				
				int h2 = mis(temp_arr);
				
				tree.add(new fun(temp_arr,curr_g,h2,0));
				
				//moves right
				
				ArrayList<Integer> temp_arr1 = new ArrayList<>();
				temp_arr1 = curr_arr;
				
				temp = temp_arr1.get(4);
				temp_arr1.set(4,temp_arr1.get(3));
				temp_arr1.set(3,temp);
				
				h2 = mis(temp_arr1);
				
				tree.add(new fun(temp_arr1,curr_g,h2,4));
				
				//moves down
				ArrayList<Integer> temp_arr2 = new ArrayList<>();
				temp_arr2 = curr_arr;
				
				temp = temp_arr2.get(6);
				temp_arr2.set(6,temp_arr2.get(3));
				temp_arr2.set(3,temp);
				
				h2 = mis(temp_arr2);
				
				tree.add(new fun(temp_arr2,curr_g,h2,6));
			}
			
			else if(zero_ind == 4)
			{
				curr_g++;
				
				//moves left
				
				ArrayList<Integer> temp_arr = new ArrayList<>();
				temp_arr = curr_arr;
				
				int temp = temp_arr.get(3);
				temp_arr.set(3,curr_arr.get(4));
				temp_arr.set(4,temp);
				
				int h2 = mis(temp_arr);
				
				tree.add(new fun(temp_arr,curr_g,h2,3));
				
				//moves down
				
				ArrayList<Integer> temp_arr1 = new ArrayList<>();
				temp_arr1 = curr_arr;
				
				temp = temp_arr1.get(7);
				temp_arr.set(7,temp_arr1.get(4));
				temp_arr.set(4,temp);
				
				h2 = mis(temp_arr1);
				
				tree.add(new fun(temp_arr1,curr_g,h2,7));
				
				//moves right
				
				ArrayList<Integer> temp_arr2 = new ArrayList<>();
				temp_arr2 = curr_arr;
				
				temp = temp_arr2.get(5);
				temp_arr2.set(5,temp_arr2.get(4));
				temp_arr2.set(4,temp);
				
				h2 = mis(temp_arr2);
				
				tree.add(new fun(temp_arr2,curr_g,h2,5));
				
				//moves top
				
				ArrayList<Integer> temp_arr3 = new ArrayList<>();
				temp_arr3 = curr_arr;
				
				temp = temp_arr3.get(1);
				temp_arr3.set(1,temp_arr3.get(4));
				temp_arr3.set(4,temp);
				
				h2 = mis(temp_arr3);
				
				tree.add(new fun(temp_arr3,curr_g,h2,1));
				
			}
			
			else if(zero_ind == 5)
			{
				//moves top
			
				//moves left
				
				//moves down
			}
			
			else if(zero_ind == 6)
			{
				//moves top
				
				//moves right
			
			}
			
			else if(zero_ind == 7)
			{
				curr_g++;
				
				//moves left
				ArrayList<Integer> temp_arr = new ArrayList<>();
				temp_arr = curr_arr;
				
				int temp = temp_arr.get(6);
				temp_arr.set(6,temp_arr.get(7));
				temp_arr.set(7,temp);
				
				int h2 = mis(temp_arr);
				
				tree.add(new fun(temp_arr,curr_g,h2,6));
				
				
				//moves right
				
				ArrayList<Integer> temp_arr1 = new ArrayList<>();
				temp_arr1 = curr_arr;
				
				temp = temp_arr1.get(8);
				temp_arr1.set(8,temp_arr1.get(7));
				temp_arr1.set(7,temp);
				
				h2 = mis(temp_arr1);
				
				tree.add(new fun(temp_arr1,curr_g,h2,8));
				
				//moves top
				ArrayList<Integer> temp_arr2 = new ArrayList<>();
				temp_arr2 = curr_arr;
				
				temp = temp_arr2.get(4);
				temp_arr2.set(4,temp_arr2.get(7));
				temp_arr2.set(7,temp);
				
				h2 = mis(temp_arr2);
				
				tree.add(new fun(temp_arr2,curr_g,h2,4));	
			}
			
			else if(zero_ind == 8)
			{
				//moves top
				
				//moves left
				
			}
			
			tree.remove(0);
			Collections.sort(tree,new SortByAt());
			 
			for(int i=1;i<tree.size();i++)
				 	tree.remove(i);
			
			curr_arr = tree.get(0).a1;
			
			if( curr_arr == goal_state)
				break;
			
			moves++;
			
			for(int i=0;i<tree.size();i++)
				System.out.println(i+"    "+tree.get(i).a1+"  "+tree.get(i).g+"   "+tree.get(i).h+"   "+tree.get(i).a+"  "+tree.get(i).z);
		}
		
//		if(int_state == goal_state)
//		{
			System.out.println("The problem is solved in "+moves);
//			System.exit(0);
//		}
		
				
	}
}

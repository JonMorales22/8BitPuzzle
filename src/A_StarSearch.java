import java.util.ArrayList;

public class A_StarSearch {
	int[][] goal;
	Board board;
	A_StarSearch(Board board, int[][] goal)
	{
		this.board = board;
		this.goal = goal;
	}
	
	int findGoal()
	{
		int test = findManhattanDist(board);
		int dist = 1;
		board.setHVal(test);
		ArrayList<Board> children = board.findChildren();
		
		System.out.print("Start: ");
		main.print(board.getBoard());
		System.out.println("HVal of start: " + board.getHVal());
		System.out.println();
		
		for(int i=0;i<children.size();i++)
		{
			Board child = children.get(i);
			int mDist = findManhattanDist(child);
			child.setHVal(mDist);
			child.setGVal(dist);
			child.setParent(board);
			
			System.out.print("Child " + i + ":" );
			main.print(child.getBoard());
			System.out.println(child.toString());
			System.out.println();
		}
		
		return 0;
	}
	
	private int calcNVal()
	{
		int gVal=0;
		int hVal = 0;
		return hVal+ gVal;
	}
	
	private int findManhattanDist(Board b)
	{
		int[][] currentState = b.getBoard();
		int total = 0;
		for(int x=0;x<3;x++)
		{
			for(int y=0;y<3;y++)
			{
				if(currentState[x][y]==0)
					continue;
				
				int arr[] = findNumAxes(currentState[x][y], goal);
				
				if(arr[0]!=-1)
				{
					int num = Math.abs(arr[0]-x) + Math.abs(arr[1]-y);
					total+=Math.abs(num);
				}
				else
					throw new java.lang.RuntimeException("Could not find num!");
			}
		}
		return total;
	}
	
	public int[] findNumAxes(int num, int [][] state)
	{
		int arr[]= {-1,-1};
		for(int x=0;x<3;x++)
		{
			for(int y=0;y<3;y++)
			{
				if(num==state[x][y])
				{
					arr[0] = x;
					arr[1] = y;
					return arr;
				}
			}
		}
		return arr;
	}
	
	public int[][] getGoal()
	{return goal;}
}

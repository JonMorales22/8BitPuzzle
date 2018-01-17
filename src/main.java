import java.util.*;

public class main {
	
	//Need to find a better solution for finding the manhattan distace. The way im doing it right now is pretty sloppy, theres a better way to engineer it
	public static void main(String args[])
	{
		InputHandler h = new InputHandler();
		String startString = h.getInput("input4.txt");
		String goalString = h.getInput("solution.txt");
		
		int[][] start = h.stringToBoard(startString);
		int[][] goal = h.stringToBoard(goalString);
		
		Board board = new Board(start);
		A_StarSearch search = new A_StarSearch(board,goal);
		search.findGoal();
	}
	
	public static void print(int[][] arr)
	{
		System.out.println();
		for(int x=0;x<3;x++)
		{
			for(int y=0;y<3;y++)
			{
				System.out.print(arr[x][y] + " ");
			}
			System.out.println();
		}
	}

	

}

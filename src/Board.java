import java.util.*;

public class Board implements Comparable<Board> {
	private int[][] board;
	private  Board parent;
	private int gVal, hVal;
	private int space;
	
	public Board()
	{
		board = new int[3][3];
		parent = null;
		gVal = 0;
		hVal = 100000;
		space = -1;
	}
	
	public Board(int b[][])
	{
		board = getCopy(b);
		space = findSpace();
	}
	
	//this may cause errors later because it is a shallow copy
	public Board(Board b)
	{
		board = b.board;
	}
	
	public ArrayList<Board> findChildren()
	{
		ArrayList<Board> boardArr = new ArrayList();
		if(space==0)
		{
			boardArr.add(new Board(moveDown()));
			boardArr.add(new Board(moveRight()));
		}
		else if(space==1)
		{
			boardArr.add(new Board(moveLeft()));
			boardArr.add(new Board(moveDown()));
			boardArr.add(new Board(moveRight()));
		}
		else if(space==2)
		{
			boardArr.add(new Board(moveLeft()));
			boardArr.add(new Board(moveDown()));
		}
		else if(space==3)
		{
			boardArr.add(new Board(moveUp()));
			boardArr.add(new Board(moveRight()));
			boardArr.add(new Board(moveDown()));
		}
		else if(space==4)
		{
			boardArr.add(new Board(moveUp()));
			boardArr.add(new Board(moveRight()));
			boardArr.add(new Board(moveDown()));
			boardArr.add(new Board(moveLeft()));			
		}
		else if(space==5)
		{
			boardArr.add(new Board(moveUp()));
			boardArr.add(new Board(moveLeft()));
			boardArr.add(new Board(moveDown()));
		}
		else if(space==6)
		{
			boardArr.add(new Board(moveUp()));
			boardArr.add(new Board(moveRight()));
		}
		else if(space==7)
		{
			boardArr.add(new Board(moveLeft()));
			boardArr.add(new Board(moveUp()));
			boardArr.add(new Board(moveRight()));
		}
		else if(space==8)
		{
			boardArr.add(new Board(moveUp()));
			boardArr.add(new Board(moveLeft()));
		}
		else 
		{
			throw new java.lang.RuntimeException("Get Rekt!");
		}
		return boardArr;
	}
	
	public int[][] moveUp()
	{
		int[][] b = getCopy(board);

		if(space<3)
			throw new java.lang.RuntimeException("Out of Bounds!");
		else
		{
			int x = space/3;
			int y = space%3;
			int temp = b[x-1][y];
			
			b[x-1][y] = 0;
			b[x][y] = temp;	
		}
		return b;
	}
	
	public int[][] moveDown()
	{
		int[][] b = getCopy(board);
		if(space>6)
			throw new java.lang.RuntimeException("Out of Bounds!");
		else
		{
			int x = space/3;
			int y = space%3;
			int temp = b[x+1][y];

			b[x+1][y] = 0;
			b[x][y] = temp;	
		}
		return b;
	}
	
	public int[][] moveLeft()
	{
		int[][] b = getCopy(board);
		if(space==0||space==3||space==6)
			throw new java.lang.RuntimeException("Out of Bounds!");
		else
		{
			int x = space/3;
			int y = space%3;
			int temp = b[x][y-1];

			b[x][y-1] = 0;
			b[x][y] = temp;	
		}
		return b;
	}
	
	public int[][] moveRight()
	{
		int[][] b = getCopy(board);
		if(space==2||space==5||space==8)
			throw new java.lang.RuntimeException("Out of Bounds!");
		else
		{
			int x = space/3;
			int y = space%3;
			int temp = b[x][y+1];
			
			b[x][y+1] = 0;
			b[x][y] = temp;	
		}
		return b;
	}
	
	//getter methods
	public int getSpace()
		{return space;}
	
	public int[][] getBoard()
		{return board;}
	
	public Board getParent()
		{return parent;}
	
	public int getGVal()
	{return gVal;}
	
	public int getHVal()
	{return hVal;}
	
	//SETTER METHODS
	public void setParent(Board parent)
		{this.parent=parent;}
	
	public void setGVal(int val)
		{gVal = val;}
	
	public void setHVal(int val)
		{hVal = val;}
		
	//@OVERRIDE
	public String toString()
	{
		return "Gval = " + gVal + ", Hval = " + hVal + ", space = " + space;
	}
	
	@Override
	public int compareTo(Board other) 
	{
		int flag = gVal+hVal - (other.getGVal()+other.getHVal());
		return flag;
	}
	
	//PRIVATE FUNCTIONS
	private int findSpace()
	{
		for(int x=0;x<3;x++) 
		{
			for(int y=0;y<3;y++)
			{
				if(board[x][y]==0)
				{
					return (x*3)+(y);
				}	
			}
		}
		return -1;
	}
	
	private int[][] getCopy(int[][] og)
	{
		int [][] copyOf = new int[3][];
		for(int x=0;x<3;x++)
		{
			copyOf[x] = og[x].clone();
		}
		return copyOf;
	}
}

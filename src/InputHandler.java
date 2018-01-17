import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputHandler {
	public InputHandler()
	{
		
	}
	public String getInput(String inputFile)
	{
		String line = "";
		try
		{
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader buffReader = new BufferedReader(fileReader);
			String temp;
			while((temp=buffReader.readLine())!=null)
			{
				line+=temp;
			}
		}
		
		catch(FileNotFoundException ex)
		{
			System.out.print("Unable to open file '" + inputFile + "'");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		return line;
	}
	
	public int[][] stringToBoard(String boardString)
	{
		int [][] tempBoard = new int[3][3];
		Scanner scanner = new Scanner(boardString);
		for(int x=0;x<3;x++)
		{
			for(int y=0;y<3;y++)
			{
				tempBoard[x][y] = scanner.nextInt();
			}
		}
		
		return tempBoard;
	}
}

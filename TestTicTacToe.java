
import java.util.*;
import java.io.*;

public class TestTicTacToe
{
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe(3);
		
		play_game(game);
	}
			
	static void play_game(TicTacToe game)
	{
		boolean win = true;
		Scanner in = new Scanner(System.in);
		int location;
		int row,column;
		
		while(win)
		{
			game.show_board();
			//System.out.println(game.player + "  no player your turn and input the location");
			//location = Integer.parseInt(in.nextLine());
			row = -1;
			column = -1;
			
			/* This while loop will run until user enters the correct input */
			while(true)
			{
				System.out.println(game.player + "  no player your turn and input the row");
				try{
					row = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e){
					System.out.println("play_game " + e);
				}	
			}
			
			while(true)
			{
				System.out.println(game.player + "  no player your turn and input the column");
				try{
					column = Integer.parseInt(in.nextLine());
					break;
				}catch(Exception e){
					System.out.println("play_game " + e);
				}
			}
			
			if(game.player == 0)
			{
				if(false == game.update_board(game.player, row, column, 'X'))
				{
					System.out.println("This location is already occupied");
					continue;
				}
			}	
			else
			{
				if(false == game.update_board(game.player, row, column, 'O'))
				{
					System.out.println("This location is already occupied");
					continue;
				}
			}	

			if(0 == game.check_game_status())
			{
				System.out.println(game.player + " won");
				win = false;
			}
						
			game.change_player();
		}
	}
}
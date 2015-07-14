
public class TicTacToe
{
	//instane variable
	int player;
	int[][] board;
	int matrix_len;		//this will be initialized  with matrix size passed in constructor and to check the game status
	
	//constructor 
	public TicTacToe(int matrix_size)
	{
		//System.out.println("constructor \n");
		int row,column;
		int count ;
		
		player = 0;	//0 means first
		count = 1;
		
		matrix_len = matrix_size;
		board = new int[matrix_len][matrix_len];
		for(row = 0; row < matrix_size; row++)
		{
			for(column = 0; column < matrix_size; column++)
			{
				board[row][column] = count++;
			}
		}
	}
	
	//methods
	boolean update_board(int player, int row,int column, /*int location*/ char sign)
	{
		//System.out.println("update_board \n");

		if(false == is_valid(row,column))
			return false;
		
		board[row][column] = (int)sign;
		return true;
	}
	
	void change_player()
	{		
		//System.out.println("change_player ");
		if(player == 0)
			player = 1;
		else	
			player = 0;
		//System.out.println("change_player " + player );
	}
	
	//print the board
	void show_board()
	{
		//System.out.println("show_board \n");
		int row,column;

		for(row = 0; row < matrix_len; row++)
		{
			for(column = 0; column < matrix_len; column++)
			{
				if((board[row][column] >= 0) && (board[row][column] <= 9))
				{
					System.out.print("[" + board[row][column] + "]" + "   ");
				}
				else
				{
					System.out.print("[" + (char)board[row][column] + "]" + "   ");	
				}
			}
			System.out.println();
		}
	}
	
	boolean is_valid(int row, int column)
	{
		//System.out.println("is_valid \n");
		char curr_elem;

		try{
			curr_elem = (char)board[row][column];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("is_valid" + e);
			return false;
		}

		
		if(('X' == curr_elem)||('O' == curr_elem))
			return false;

		return true;	//success
	}
	
	int check_game_status()
	{
		//System.out.println("check_game_status \n");
		int result;
		int row,column;
		int loopIndex;
		
		row = column = 0;
		loopIndex = 0;
		result = 1;
		
		while(row < matrix_len)
		{
			result = get_row_status(row);
			if(result == 1)
			{
				break;
			}
			row++;
		}	
		
		if(result == 1)
			return 0;
		
		while(column < matrix_len)
		{
			result = get_column_status(column);
			if(result == 1)
			{
				break;
			}
			column++;
		}	
		
		if(result == 1)
			return 0;

		result = get_diagonal_status();

		if(result == 0)
			return 0;
		
		return 1;
	}
	
	int get_diagonal_status()
	{
		int row,col;
		int result;
		int curr;

		row = col = 0;
		curr = board[row][col];
		result = 0;
		
		while(row < matrix_len)
		{
			if(board[row++][col++] != curr)
			{
				result = 1;break;
			}
		}
		
		if(0 == result)
			return 0;
		
		row = 0;
		col = matrix_len-1;
		
		//this logic need to be checked
		curr = board[row][col];
		while(row < matrix_len)
		{
			if(board[row++][col--] != curr)
			{
				result = 1;break;
			}
		}

		if(1 == result)
			return 1;
		else
			return 0;
	}
	
	int get_row_status(int row)
	{
		//System.out.println("get_row_status \n");
		//int count;
		int curr;
		int temp_column ;
		
		temp_column = 0;
		
		curr = board[row][0];
		
		while(temp_column<matrix_len)
		{
			if(board[row][temp_column] != curr)
			{
				break;
			}
			temp_column++;
		}
		
		if(temp_column==matrix_len)
			return 1;
		else
			return 0;
	}
	
	int get_column_status(int column)
	{
		//System.out.println("get_column_status \n");
		//int count;
		int curr;
		int temp_row ;
		
		temp_row = 0;
		
		curr = board[0][column];
		
		while(temp_row<matrix_len)
		{
			if(board[temp_row][column] != curr)
			{
				break;
			}
			temp_row++;
		}
		
		if(temp_row==matrix_len)
			return 1;
		else
			return 0;
	}
	
}
package chess;

import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	

	//This method requires your input
	public static void play()
	{
		Console keyboardConsole = System.console();

		boolean turn = true;
		boolean originCorrect, destinationCorrect, correctMove;
		String originMove = "", destinationMove = "";
		CheckInput checkInput = new CheckInput();
		int i0,j0,i1,j1;
		Piece piece;

		while (!gameEnd)
		{
	
			if (turn == true)
			{
				System.out.println("------ Whites move ------\n");
			}
			else
			{
				System.out.println("------ Blacks move ------\n");;
			}

			correctMove = false;

			while(!correctMove)
			{
				originCorrect = false;
				destinationCorrect = false;

				while(!originCorrect)
				{
					originMove = keyboardConsole.readLine("> Enter Origin: ");

					if(originMove.equals("END"))
					{
						gameEnd = true;
						originCorrect = true;
						if (gameEnd)
						{
							destinationCorrect = true;
							break;
						}
					}

					if(checkInput.checkCoordinateValidity(originMove))
					{
						originCorrect = true;
					}
					else
					{
						System.out.println("Origin incorrect! Please try again.");
					}
				}

				while(!destinationCorrect)
				{
					destinationMove = keyboardConsole.readLine("> Enter Destination: ");

					if(destinationMove.equals("END"))
					{
						gameEnd = true;
						destinationCorrect = true;
					}

					if(checkInput.checkCoordinateValidity(destinationMove))
					{
						destinationCorrect = true;
					}
					else
					{
						System.out.println("Destination incorrect! Please try again.\n");
					}
				}

				if(gameEnd == true)
				{
					if(turn == true)
						{
							System.out.println("Blacks win!");
						}
					else
						{
							System.out.println("Whites win!");
						}
					break;
				}

				i0 = originMove.charAt(0) - '1';
				j0 = originMove.charAt(1) - 'a';

				i1 = destinationMove.charAt(0) - '1';
				j1 = destinationMove.charAt(1) - 'a';

				if(!Board.hasPiece(i0,j0))
				{
					System.out.println("Origin square empty! Please try again.");
					System.out.println();
					break;
				}
				else
				{
					piece = Board.getPiece(i0,j0);
					if (turn == true)
					{
						if(piece.getColour() == PieceColour.BLACK)
						{
							System.out.println("Wrong colour! Choose again.\n");
							System.out.println();
							break;
						}
					}
					else
					{
						if(piece.getColour() == PieceColour.WHITE)
						{
							System.out.println("Wrong colour! Choose again.\n");
							break;
						}
					}
					if (piece.isLegitMove(i0,j0,i1,j1))
					{
						correctMove = true;
						//Board.movePiece(i0,j0,i1,j1,piece);
						gameEnd = Board.movePiece(i0,j0,i1,j1,piece);
						Board.printBoard();
						System.out.println();
						if (gameEnd == true)
						{
							if(turn == false)
							{
							System.out.println("Blacks win!");
							}
							else
							{
							System.out.println("Whites win!");
							}
						}
					}
					else
					{
						System.out.println("Move not permitted! Try again!\n");
						break;
					}
				turn = !turn;	
				}
			}
		}
	}		
	
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		System.out.println();
		Game.play();	}
}
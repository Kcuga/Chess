package chess;

public class Pawn extends Piece
{	
	public Pawn (PieceColour pieceColour)
	{
		colour = pieceColour;
		if (pieceColour == PieceColour.BLACK)
			setSymbol("♟︎");
		else
			setSymbol("♙");
	}	

	@Override
	public boolean isLegitMove (int i0, int j0, int i1, int j1)
	{
		Piece piece;

		if(colour == PieceColour.WHITE)
		{
			if(i1 == i0-1 && j1 == j0)
			{
				if(Board.hasPiece(i1, j1))
				{
					return false;
				}
				return true;
			}
			else if (i1 == i0-2 && j1 == j0)
			{
				if(i0 != 6)
				{
					return false;
				}
				else
				{
					if(Board.hasPiece(i0-1,j0) || Board.hasPiece(i1,j1))
					{
						return false;
					}
					return true;
				}
			}
			else if (i1 == i0-1 && ((j1 == j0-1) || (j1 == j0+1)))
			{
				if(Board.hasPiece(i1,j1))
				{
					piece = Board.getPiece(i1,j1);
					if(piece.getColour() == PieceColour.BLACK)
					{
						return true;
					}
				}
			}
		}
		else
		{
			if(i1 == i0+1 && j1 == j0)
			{
				if(Board.hasPiece(i1, j1))
				{
					return false;
				}
				return true;
			}
			else if (i1 == i0+2 && j1 == j0)
			{
				if(i0 != 1)
				{
					return false;
				}
				else
				{
					if(Board.hasPiece(i0+1,j0) || Board.hasPiece(i1,j1))
					{
						return false;
					}
					return true;
				}
			}
			else if (i1 == i0+1 && ((j1 == j0+1) || (j1 == j0-1)))
			{
				if(Board.hasPiece(i1,j1))
				{
					piece = Board.getPiece(i1,j1);
					if(piece.getColour() == PieceColour.WHITE)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}

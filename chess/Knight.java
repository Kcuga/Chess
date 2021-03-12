package chess;

public class Knight extends Piece 
{
	public Knight (PieceColour pieceColour)
	{
		colour = pieceColour;
		if (pieceColour == PieceColour.BLACK)
			setSymbol("♞");
		else
			setSymbol("♘");
	}

	@Override
	public boolean isLegitMove (int i0, int j0, int i1, int j1)
	{
		Piece piece;

		if((i1 == i0 + 2 && j1 == j0 + 1) ||
		   (i1 == i0 + 1 && j1 == j0 + 2) ||
		   (i1 == i0 - 1 && j1 == j0 + 2) ||
		   (i1 == i0 - 2 && j1 == j0 + 1) ||
		   (i1 == i0 - 2 && j1 == j0 - 1) ||
		   (i1 == i0 - 1 && j1 == j0 - 2) ||
		   (i1 == i0 + 1 && j1 == j0 - 2) ||
		   (i1 == i0 + 2 && j1 == j0 - 1))
		{	
			if(Board.hasPiece(i1, j1))
			{
				piece = Board.getPiece(i1, j1);
				if(colour != piece.getColour())
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
}

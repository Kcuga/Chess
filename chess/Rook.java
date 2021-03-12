package chess;

public class Rook extends Piece
{
	public Rook (PieceColour pieceColour)
	{
		colour = pieceColour;
		if (pieceColour == PieceColour.BLACK)
			setSymbol("♜");
		else
			setSymbol("♖");
	}

	@Override
	public boolean isLegitMove (int i0, int j0, int i1, int j1)
	{
		int i,j;
		Piece piece;

		if(i1 != i0 && j1 != j0)
		{
			return false;
		}
		else
		{
			if (i1 < i0 && j1 == j0)
			{
				for(i = i0-1; i >= i1+1; i--)
				{
					if(Board.hasPiece(i, j1))
					{
						return false;
					}
				}
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
			else if (i1 > i0 && j1 == j0)
			{
				for(i = i0+1; i <= i1-1; i++)
				{
					if(Board.hasPiece(i, j1))
					{
						return false;
					}
				}
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
			else if (i1 == i0 && j1 > j0)
			{
				for(j = j0+1; j <= j1-1; j++)
				{
					if(Board.hasPiece(i1, j))
					{
						return false;
					}
				}
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
			else if (i1 == i0 && j1 < j0)
			{
				for(j = j0-1; j >= j1+1; j--)
				{
					if(Board.hasPiece(i1, j))
					{
						return false;
					}
				}
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
}

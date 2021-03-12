package chess;

public class Bishop extends Piece 
{
	public Bishop (PieceColour pieceColour)
	{
		colour = pieceColour;
		if (pieceColour == PieceColour.BLACK)
			setSymbol("♝");
		else
			setSymbol("♗");
	}

	@Override
	public boolean isLegitMove (int i0, int j0, int i1, int j1)
	{
		int num;
		Piece piece;

		if(Math.abs(i1-i0) != Math.abs(j1-j0))
		{
			return false;
		}
		else
		{
			if(i1 < i0 && j1 < j0)
			{
				for(num = 1; i1 != i0 - num; num++)
				{
					if(Board.hasPiece(i0-num, j0-num))
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
			else if(i1 < i0 && j1 > j0)
			{
				for(num = 1; i1 != i0 - num; num++)
				{
					if(Board.hasPiece(i0-num, j0+num))
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
			else if(i1 > i0 && j1 > j0)
			{
				for(num = 1; i1 != i0 + num; num++)
				{
					if(Board.hasPiece(i0+num, j0+num))
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
			else if(i1 > i0 && j1 < j0)
			{
				for(num = 1; i1 != i0 + num; num++)
				{
					if(Board.hasPiece(i0+num, j0-num))
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

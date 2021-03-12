package chess;

public class Queen extends Piece
{
	public Queen (PieceColour pieceColour)
	{
		colour = pieceColour;
		if (pieceColour == PieceColour.BLACK)
			setSymbol("♛");	
		else
			setSymbol("♕");	
	}

	@Override
	public boolean isLegitMove (int i0, int j0, int i1, int j1)
	{
		Piece piece;
		Rook rookSimulation = new Rook(colour);
		Bishop bishopSimulation = new Bishop(colour);

		return rookSimulation.isLegitMove(i0,j0,i1,j1) || bishopSimulation.isLegitMove(i0,j0,i1,j1);
	}
}

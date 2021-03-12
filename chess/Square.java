package chess;

//This class requires your input
public class Square {
	private boolean hasPiece;
	private Piece p;

	public Piece getPiece()
	{
		return p;
	}

	public void setPiece(Piece pIn)
	{
		p = pIn;
		hasPiece = true;
	}	

	public void removePiece()
	{
		p = null;
		hasPiece = false;
	}

	public boolean hasPiece(){
		return hasPiece;
	}
}

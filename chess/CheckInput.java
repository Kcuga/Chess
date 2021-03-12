package chess;

public class CheckInput {

	//This method requires your input
	public boolean checkCoordinateValidity(String input)
	{	
		String numbers = "12345678";
		String letters = "abcdefgh";
		char char1, char2;

		input = input.toLowerCase();
		input = input.trim();

		if(input.length() == 2)
		{
			char1 = input.charAt(0);
			char2 = input.charAt(1);

			switch(char1)
			{
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':							
					break;
				default:
					return false;
			}

			switch(char2)
			{
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
					break;
				default:
					return false;
			}
			return true;
		}
		return false;
	}
}

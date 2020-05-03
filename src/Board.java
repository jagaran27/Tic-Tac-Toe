
public class Board {

	private char board[][] = new char[3][3];

	Board() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}

	public void displayBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	public boolean isWin(char c) {
		boolean result = false;
		for (int i = 0; i < 3; i++)
			if (board[i][0] == c && board[i][1] == c && board[i][2] == c)
				result = true;
		for (int i = 0; i < 3; i++)
			if (board[0][i] == c && board[1][i] == c && board[2][i] == c)
				result = true;
		if (board[0][0] == c && board[1][1] == c && board[2][2] == c)
			result = true;
		if (board[0][2] == c && board[1][1] == c && board[2][0] == c)
			result = true;
		return result;
	}

	public boolean move(int n, char c) {
		int i, j;
		if (n % 3 == 0) {
			i = n / 3 - 1;
			j = 2;
		} else {
			i = n / 3;
			j = (n % 3) - 1;
		}
		if (isValidMove(i, j, n)) {
			board[i][j] = c;
			return true;
		}
		return false;
	}

	private boolean isValidMove(int i, int j, int n) {
		boolean res = false;
		if (n >= 1 && n <= 9 && board[i][j] == '-')
			res = true;
		return res;

	}

	public boolean isGameOver() {
		boolean res = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-')
					res = false;
			}
		}
		return res;
	}
	
	public char getSquarevalue(int i, int j) {
		return board[i][j];
	}
	
	public void setSquareValue(int i,int j, char c) {
		board[i][j] = c;
	}
	
	public boolean squaresRemaining() {
		boolean res = false;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j] == '-')
					res = true;
			}
		}
		return res;
	}
}



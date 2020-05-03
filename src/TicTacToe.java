import java.util.Scanner;

public class TicTacToe {

	Board board;

	public TicTacToe() {
		board = new Board();
	}

	public void playGame() {
		System.out.println("### Let's play Tic Tac Toe ###");
		board.displayBoard();
		Scanner s = new Scanner(System.in);
		int input = 0;
		MachinePlay machinePlay = new MachinePlay(board);
		while (true) {
			System.out.println("X's Move :");
			input = s.nextInt();
			while(!board.move(input,'x')) {
				System.out.println("Invalid move. Please try again");
				System.out.println("X's Move :");
				input = s.nextInt();
			}
			if(board.isWin('x')) {
				System.out.println("X wins!!!");
				board.displayBoard();
				break;
			}else if(board.isGameOver()) {
				System.out.println("It's a draw");
				board.displayBoard();
				break;
			}
			board.displayBoard();
			System.out.println("O's Move:");
			/* input = s.nextInt();
			while(!board.move(input,'o')) {
				System.out.println("Invalid move. Please try again");
				System.out.println("O's Move :");
				input = s.nextInt();
			} */
			machinePlay.makeBestMove();
			if(board.isWin('o')) {
				System.out.println("O wins!!!");
				board.displayBoard();
				break;
			}else if(board.isGameOver()) {
				System.out.println("It's a draw");
				board.displayBoard();
				break;
			}
			board.displayBoard();
		}s.close();
		
	}

}


public class MachinePlay {

	Board board;

	public MachinePlay(Board board) {
		this.board = board;
	}

	public void makeBestMove() {
		int bestMoveScore = Integer.MIN_VALUE;
		int bestI = -1;
		int bestJ = -1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.board.getSquarevalue(i, j) == '-') {
					int moveScore = calculateMoveScore(i, j, 'o',0);
					if (moveScore > bestMoveScore) {
						bestMoveScore = moveScore;
						bestI = i;
						bestJ = j;
					}
				}
			}
		}
		this.board.setSquareValue(bestI, bestJ, 'o');
	}

	private int calculateMoveScore(int i, int j, char c, int depth) {
		this.board.setSquareValue(i, j,c);
		if(c == 'x') {
			if (this.board.isWin('x')) {
				this.board.setSquareValue(i, j, '-');
				return -10+depth;
			} else if (this.board.isWin('o')) {
				this.board.setSquareValue(i, j, '-');
				return 10-depth;
			} else if (!this.board.squaresRemaining()) {
				this.board.setSquareValue(i, j, '-');
				return 0;
			}
			int bestScore = Integer.MIN_VALUE;
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					if (this.board.getSquarevalue(x, y) == '-') {
						bestScore = Math.max(bestScore, calculateMoveScore(x, y, 'o',depth+1));
					}
				}
			}
			this.board.setSquareValue(i, j, '-');
			return bestScore;	
		}
		else {
			if (this.board.isWin('x')) {
				this.board.setSquareValue(i, j, '-');
				return -10+depth;
			} else if (this.board.isWin('o')) {
				this.board.setSquareValue(i, j, '-');
				return 10-depth;
			} else if (!this.board.squaresRemaining()) {
				this.board.setSquareValue(i, j, '-');
				return 0;
			}
			int bestScore = Integer.MAX_VALUE;
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++) {
					if (this.board.getSquarevalue(x, y) == '-') {
						bestScore = Math.min(bestScore, calculateMoveScore(x, y, 'x',depth+1));
					}
				}
			}
			this.board.setSquareValue(i, j, '-');
			return bestScore;	
		}
	}

}

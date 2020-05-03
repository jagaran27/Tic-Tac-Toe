# Tic-Tac-Toe
Minimax algorith for tic tac toe
This is only the terminal version of the Tic Tac Toe. It is a player vs machine game.The UI will follow shortly. 
--------------------------
Rules
-----
1.You can only play as 'X' right now. The machine plays as 'O'. 
2. You need to enter a value between 1 and 9 to put 'X' in the corresponding square of the matrix below:
    1 2 3 - top row
    4 5 6 - second row
    7 8 9 - third row
    
  
 -----------------------------
 Algorithm:
 ----------
 This game uses the minimax algorithm for finding the best move. Tic Tac Toe is a perfect information zero sum game. This game 
 uses the minimax algorithm to find out the best possible move at every stage.
 The algorithm works as follows:
 For every move of the machine, it finds out the best possible move and thereafter simulates the human's possible game play and 
 selects their possible move.The human's best move is obviously the machines worst move (minimizer function). The game tree is computed
 till the terminal state for every branch, where one branch simulates one possible move, and then the solution is backtracked picking 
 the minimum and maximum values at each turn
 
 
**Evaluator function - At the terminal state machine wins is computed as +10, human wins is computed as -10 and draw as 0.

**Use of depth to reduce win time or maximise lose time: The algorithm might chose a play which will win in a longer time as all the
branches with a sure win return +10. To optimize this further, a depth function is used
A win returns : 10-depth
A loss returns: -10+depth
Thereby providing incentives to choose the branch which wins in a shorter depth and reduces the number of moves.
 
 

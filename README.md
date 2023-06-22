# Tic-Tac-Toe

A text-based Tic-Tac-Toe game made with Java.

## Rules:

Tic-tac-toe is a two-player board game. The board is 3 x 3. The first player puts 'X' on the board and the second player puts 'O'. Whoever places three of the same mark either horizontally, vertically, or diagonally wins the game. If the board is full at the end of 9 moves and there is no winner, it is a tie.

Here's a sample tic-tac-toe board:

OXO

-XO

--X

'X' is the first player, and 'O' is the second player. '-' represents an empty square. If player 1 plays "3 2", they win the game since the second column has three 'X's:

OXO

-XO

-XX



## Game Design:

1. The board is full of dashes (-) initially. The first player starts with 'X'.
2. In each turn output the board and the player in turn.
3. Program asks the player to enter a move. The player will enter two integers; row and column. Both row and column have to be between 1 and 3 inclusively. Otherwise, the program will tell the move is invalid and ask the same player to make the move again. If any user selects an occupied square that is also an invalid move.

import TicTacToeModel.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player>players;
    Board board;

    TicTacToeGame() {
        initializeGame();
    }

    public void initializeGame() {
        //creating 2 players
        players = new LinkedList<>();
        PlayingPieceX cross = new PlayingPieceX();
        Player player1 = new Player("player1", cross);

        PlayingPieceO zero = new PlayingPieceO();
        Player player2 = new Player("player2", zero);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {
            //take out player whose turn is it and then move that player in the end of the list.
            Player playerTurn = players.removeFirst();
            //get free space from board
            board.printBoard();
            List<Pair<Integer, Integer>> freeSpace = board.getFreeCells();
            if (freeSpace.isEmpty()) {
                noWinner = true;
                continue;
            }

            //read user Input
            System.out.println("Player:" + playerTurn.name +"Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully = board.addPiece(inputRow, inputCol, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position : TRY AGAIN");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isThereWinner(inputRow, inputCol, playerTurn.playingPiece.pieceType);
            if(winner) {
                return playerTurn.name;
            }

        }
        return "tie";
    }

    boolean isThereWinner(int row, int col, PieceType pieceType) {
        boolean rm = true;
        boolean cm = true;
        boolean dm = true;
        boolean adm = true;

        for(int i = 0;i< board.size; i++) {
            if((board.board[row][i] == null) || (board.board[row][i].pieceType != pieceType)) {
                rm = false;
            }
        }
        for(int i = 0;i< board.size; i++) {
            if(board.board[i][col] == null || board.board[i][col].pieceType != pieceType) {
                cm = false;
            }
        }
        for(int i=0,j=0; i< board.size; i++, j++) {
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                dm = false;
            }
        }
        for(int i=0,j=board.size-1; i< board.size; i++, j--) {
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                adm = false;
            }
        }

        return rm || cm || dm || adm;
    }
}

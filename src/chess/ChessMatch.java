package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

//Partida de Xadrez
public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces(){
			ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
			for(int i = 0; i < board.getRows(); i++) {
				for(int j = 0; j < board.getColumns(); j++) {
					mat[i][j] = (ChessPiece) board.piece(i, j);
				}
			}
			return mat; //Retorna a matrix de peças da partida
	}
	
	private void placeNewPiece (char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	//Método responsável por iniciar a partida de Xadrez
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
	}
	
}

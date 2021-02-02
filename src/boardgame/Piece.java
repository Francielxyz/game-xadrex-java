package boardgame;

//Peça
public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][]	possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPositionMove() {
		boolean [][] mat = possibleMoves();
		for (int x = 1; x<mat.length; x++) {
			for(int y = 1; y<mat.length; y++) {
				if(mat[x][y]) {
					return true;
				}
			}
		}
		return false;
	}
	
}

package boardgame;

//Tabuleiro
public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar Tabuleiro: Necessario 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posicao nao existe no Tabuleiro");			
		}
		return pieces[row][column];
	}
	
	//Sobrecarga da classe Pe�a
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posicao nao existe no Tabuleiro");			
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//Colocando pe�as no tabuleiro
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe um peca na posicao " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece; 
		piece.position = position;
	}
	
	//Removendo pe�as do tabuleiro
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao existe no Tabuleiro");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position =  null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	//Saber se posi��o esta dentro do tabuleiro
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	//Saber se posi��o existe
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//Saber se a posi��o esta ocupada
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posicao nao existe no Tabuleiro");
		}
		return piece(position) != null;
	}
	

}

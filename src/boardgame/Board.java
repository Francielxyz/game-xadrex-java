package boardgame;

//Tabuleiro
public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar Tabuleiro: Necessário 1 linha e 1 coluna");
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
			throw new BoardException("Posição não existe no Tabuleiro");			
		}
		return pieces[row][column];
	}
	
	//Sobrecarga da classe Peça
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição não existe no Tabuleiro");			
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//Colocando peças no tabuleiro
	public void placePiece(Piece piece, Position position) {
		if(thereIsApiece(position)) {
			throw new BoardException("Já existe um peça na posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//Saber se posição esta dentro do tabuleiro
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	//Saber se posição existe
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//Saber se a posição esta ocupada
	public boolean thereIsApiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição não existe no Tabuleiro");
		}
		return piece(position) != null;
	}
	

}

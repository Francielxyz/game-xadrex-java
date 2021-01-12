package boardgame;

//Tabuleiro
public class Board {
	
	private int rows;//linhas
	private int columns;//colunas
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	

}

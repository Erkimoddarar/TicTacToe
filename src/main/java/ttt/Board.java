package ttt;
# Haha Thetta er hilmar arid 2017, thvi eg er ad profa git, thvi eg nae ekki ad lata thad virka hja broadsheet 
public class Board {
	private Cell[][] _board;

	private final int _maxRows = 3;
	private final int _maxColumns = 3;

	public Board() {
		_board = new Cell[3][3];
		int count = 0;
		for (int i = 0; i < _maxRows; i++) {
			for (int j = 0; j < _maxColumns; j++) {
				Cell newCell = new Cell(count);
				_board[i][j] = newCell;
				count++;
			}
		}
	}

	public Cell[][] getBoard() {
		return _board;
	}

	public boolean markCell(final int number,final char sign) {
		int count = 0;

		if(number < 0 || number > 8) {
			final String exceptionMessage = "Number must be from 0 to 8";
			throw new IllegalArgumentException(exceptionMessage);
		}
		else if (sign == 'X' || sign == 'O') {
			for (int i = 0; i < _maxRows; i++) {
				for (int j = 0; j < _maxColumns; j++) {
					if (count == number) {
						if(this._board[i][j].isChecked()){
							return false;
						} else {
							this._board[i][j].setSign(sign);
							this._board[i][j].setChecked();
							return true;
						}		
					}
					count++;
				}
			}			
		}
		else{
			final String exceptionMessage = "Sign must be either X or O";
			throw new IllegalArgumentException(exceptionMessage);
		}	
		return false;
	}

	public String displayBoard() {
		String board = "";
		for(int i = 0; i < _maxRows; i++) {
			for(int j = 0; j < _maxColumns; j++) {
				board = board + this._board[i][j].getSign() + " | ";
			}
			board = board.substring(0, board.length() - 3);
			board = board + "\n";
		}
		return board;
	}

	public boolean isFull() {
		for(int i = 0; i < _maxRows; i++) {
			for(int j = 0; j < _maxColumns; j++) {
				if(!this._board[i][j].isChecked()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isWinner() {
		return isWinnerHorizontalCheck() || isWinnerVerticalCheck() || isWinnerDiagonalCheck();
	}

	private boolean isWinnerHorizontalCheck() {
		for(int i = 0; i < _maxRows; i++) {
			if(this._board[i][0].isChecked() && 
				this._board[i][0].getSign() == this._board[i][1].getSign() &&
				this._board[i][1].getSign() == this._board[i][2].getSign()) {
				return true;
			}
		}
		return false;
	}

	private boolean isWinnerVerticalCheck() {
		for(int i = 0; i < _maxRows; i++) {
			if(this._board[0][i].isChecked() &&
				this._board[0][i].getSign() == this._board[1][i].getSign() &&
				this._board[1][i].getSign() == this._board[2][i].getSign()) {
				return true;
			}
		}
		return false;
	}

	private boolean isWinnerDiagonalCheck() {
		if(this._board[0][0].isChecked() &&
			this._board[0][0].getSign() == this._board[1][1].getSign() &&
			this._board[1][1].getSign() == this._board[2][2].getSign()) {
			return true;
		}
		if(this._board[2][0].isChecked() &&
			this._board[2][0].getSign() == this._board[1][1].getSign() &&
			this._board[1][1].getSign() == this._board[0][2].getSign()) {
			return true;
		}
		return false;
	}


	public char getCellSign(final int number) {
		int count = 0;
		for (int i = 0; i < _maxRows; i++) {
				for (int j = 0; j < _maxColumns; j++) {
					if (count == number) {
						return this._board[i][j].getSign();							
					}
					count++;
				}
			}
		return ' ';
	}


}


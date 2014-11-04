package ttt;

public class Cell {
	private char _sign;
	private boolean _isChecked;
	private final int _number;
	//private boolean _partOfWinningLine;

	public Cell(final int number) {
		_sign = ' ';
		_isChecked = false;
		_number = number;
		//_partOfWinningLine = false;
	}

	public boolean isChecked() {
		return _isChecked;
	}

	public void setChecked() {
		_isChecked = true;
	}

	public char getSign() {
		return _sign;
	}

	public void setSign(final char sign) {
		_sign = sign;
	}

	public int getNumber() {
		return _number;
	}
	
	/*
	public int foo() {
		return 0;
	}

	public int foo1() {
		return 0;
	}

	public int foo2() {
		return 0;
	}

	public int foo3() {
		return 0;
	}

	public int foo4() {
		return 0;
	}
	*/
}
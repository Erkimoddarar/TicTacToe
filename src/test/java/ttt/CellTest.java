package ttt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class CellTest {

	public static void main(final String args[]) {
		org.junit.runner.JUnitCore.main("ttt.CellTest");
	}

	@Test
	public void isCheckedTest() {
		final Cell cell = new Cell(0);
		assertFalse("Returned true, sould be false.", cell.isChecked());
	}

	@Test
	public void setCheckedTest() {
		final Cell cell = new Cell(0);
		cell.setChecked();
		assertTrue("Returned false, sould be true.", cell.isChecked());
	}

	@Test
	public void getSignTest() {
		final Cell cell = new Cell(0);
		assertEquals("The sign was not a whiteline!", ' ', cell.getSign());
	}

	@Test
	public void setSignTest() {
		final Cell cell = new Cell(0);
		cell.setSign('X');
		assertEquals("The sign was not X.", 'X', cell.getSign());
	}

	@Test
	public void getNumberTest() {
		final Cell cell = new Cell(2);
		assertEquals("Did not get the right number, 5.", 5, cell.getNumber());
	}
}

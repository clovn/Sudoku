public class Field {
	private int[][] field = new int[9][9];

	public int getDigit(int sector, int i, int j){
		return field[sector % 3  + i][sector / 3 + i];
	}

	public void setDigit(int sector, int i, int j, int digit){
		field[sector % 3  + i][sector / 3 + i] = digit;
	}

	public boolean validator(int digit, int sector, int i, int j){
		return true;
	}
}
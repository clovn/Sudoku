import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Game {
	private int[][] field = new int[9][9];
	private final Random RND = new Random();
	private static double difficulty;

    public Game(){
    	generateField();
    }

    public void start() {
    	boolean isLose = false;

    	while(!checkEndCondition()){
    		int[] guess = View.printField(field);

    		if( guess == null || !validate(guess)){
    			continue;
    		}

    		setDigit(guess);
    	}

    	View.printGameResult(!isLose);
    }

    private void setDigit(int[] guess){
        field[guess[1]][guess[0]] = guess[2];
    }

    public static void setDifficulty(int diff){	
    	switch(diff){
    		case 1:
    			difficulty = 0.9;
    			break;
    		case 2:
    			difficulty = 0.7;
    			break;
    		case 3:
    			difficulty = 0.5;
    			break;
    	}
    }

    private int getDigit(int[] guess){
    	return field[guess[1]][guess[0]];
    }

    private void generateField(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
            	if(Math.random() < difficulty){
                	field[i][j] = (i*3 + i/3 + j) % 9 + 1;
            	}
            }
        }

        for(int i = 0; i < 100; i++){
        	switch(RND.nextInt(4)){
        		case 0:
        			transposition();
        			break;
        		case 1:
        			swapRowsSmall();
        			break;
        		case 2:
        			swapColumsSmall();
        			break;
        		case 3:
        			swapRowsArea();
        			break;
        	}
        }
    }

    private boolean validate(int[] guess){
    	guess[2]++;

    	if(getDigit(guess) != 0){
    		return false;
    	}

    	for(int i = 0; i < 9; i++){
    		if(field[guess[1]][i] == guess[2] || field[i][guess[0]] == guess[2] || field[guess[1]/3*3 + i%3][guess[0]/3*3 + i/3] == guess[2]) {
    			return false;
    		}
    	}

    	return true;
    }

	private boolean checkEndCondition(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(field[i][j] == 0){
					return false;
				}
			}
		}

		return true;
	}

	private void transposition() {
		int[][] copy = new int[9][9];

		for(int i = 0; i < 9; i++){
			copy[i] = Arrays.copyOf(field[i], 9);
		}

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				field[i][j] = copy[j][i];
			}
		}
	}

	private void swapRowsSmall() {
		int area = RND.nextInt(3);
		int row1 = RND.nextInt(3);
		int row2 = RND.nextInt(3);
		int[] buff = field[area*3 + row1];

		field[area*3 + row1] = field[area*3 + row2];
		field[area*3 + row2] = buff;
	}

	private void swapColumsSmall() {
		int area = RND.nextInt(3);
		int colum1 = RND.nextInt(3);
		int colum2 = RND.nextInt(3);
		int[] buff = new int[9];

		for(int i = 0; i < 9; i++){
			buff[i] = field[i][colum1];
			field[i][colum1] = field[i][colum2];
			field[i][colum2] = buff[i];
		}
	}

	private void swapRowsArea() {
		int area1 = RND.nextInt(3);
		int area2 = RND.nextInt(3);
		int[] buff = new int[9];

		for(int i = 0; i < 3; i++){
			buff = field[area1*3 + i];
			field[area1*3 + i] = field[area2*3 + i];
			field[area2*3 + i] = buff;
		}
	}

	private void swapColumsArea() {
		int area1 = RND.nextInt(3);
		int area2 = RND.nextInt(3);
		int[] buff = new int[9];

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				buff[j] = field[j][area1*3 + i];
				field[j][area1*3 + i] = field[j][area2*3 + i];
				field[j][area2*3 + i] = buff[j];
			}
		}
	}
}
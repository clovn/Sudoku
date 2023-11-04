import java.util.Arrays;
import java.util.Scanner;

public class Game {
	private int[][] gameField = new int[9][9];

    public Game(){
    	generateGameField();
    }

    public void start() {
    	boolean isLose = false;

    	while(!checkEndCondition()){
    		int[] guess = View.printGameField(gameField);

    		if(!validate(guess)){
    			continue;
    		}

    		setDigit(guess);
    	}

    	View.printGameResult(!isLose);
    }

    private void setDigit(int[] guess){
        gameField[guess[1]][guess[0]] = guess[2];
    }

    private int getDigit(int[] guess){
    	return gameField[guess[1]][guess[0]];
    }

    private void generateGameField(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
            	if(Math.random() < 0.95){
                	gameField[i][j] = (i*3 + i/3 + j) % 9 + 1;
            	}
            }
        }
    }

    private boolean validate(int[] guess){
    	guess[2]++;

    	if(getDigit(guess) != 0){
    		return false;
    	}

    	for(int i = 0; i < 9; i++){
    		if(gameField[guess[1]][i] == guess[2] || gameField[i][guess[0]] == guess[2] || gameField[guess[1]/3*3 + i%3][guess[0]/3*3 + i/3] == guess[2]) {
    			return false;
    		}
    	}

    	return true;
    }

	private boolean checkEndCondition(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(gameField[i][j] == 0){
					return false;
				}
			}
		}

		return true;
	}
}
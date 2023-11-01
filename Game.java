import java.util.Arrays;

public class Game {
	private int[][] gameField = new int[9][9];
    //private int[][] rightField = new int[9][9];

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

//    	for(int i = 0; i < 9; i++){
//    		if(!Arrays.equals(rightField[i], gameField[i])){
//    			isLose = true;
//    			break;
//    		}
//    	}

    	View.printGameResult(!isLose);
    }

    private void setDigit(int[] guess){
        gameField[guess[0]/3*3 + guess[2]][guess[0]%3*3 + guess[1]] = guess[3];
    }

    private int getDigit(int[] guess){
    	return gameField[guess[0]%3*3 + guess[1]][guess[0]/3*3 + guess[2]];
    }

    private void generateGameField(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
            	if(Math.random() < 0.5){
                	gameField[i][j] = (i*3 + i/3 + j) % 9 + 1;
            	}
            }
        }


    }

    private boolean validate(int[] guess){
    	for(int i = 0; i < 9; i++){
    		if(getDigit(guess) != 0 && gameField[guess[1]][i] != guess[3] && gameField[i][guess[2]] != guess[3] && gameField[guess[0]/3*3 + i/3][guess[0]%3*3 + i%3] != guess[3]) return false;
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
package baseball;

import java.util.List;

import baseball.View.InputView;
import baseball.View.OutputView;

public class Game {
	private NumberGenerator numberGenerator;
	private RoundManager roundManager;


	Game(NumberGenerator numberGenerator, RoundManager roundManager){
		this.numberGenerator = numberGenerator;
		this.roundManager = roundManager;
	}

	public void run(){
		boolean isRestart = false;
		do{
			runGame();
			isRestart = getIsRestart();
		}while(isRestart);
	};

	private void runGame(){
		OutputView.printStartMessage();
		List<Integer> computerNumber = numberGenerator.makeComputerNumber();
		while(true){
			List<Integer> userNumber = roundManager.getUserNumber();
			int numberOfStrike = roundManager.countStrike(computerNumber, userNumber);
			int numberOfBall = roundManager.countBall(computerNumber, userNumber);
			OutputView.printGuessResult(numberOfStrike, numberOfBall);

			if(numberOfStrike == 3){
				OutputView.printCorrectMessage();
				break;
			}
		}
	}

	private boolean getIsRestart(){
		String input = InputView.getRestartInput();
		validateRestartInput(input);

		boolean isRestart = false;
		if(input.equals(Constants.RETRY_TRUE)){
			isRestart = true;
		}
		if(input.equals(Constants.RETRY_FALSE)){
			isRestart = false;
		}
		return isRestart;
	}

	private void validateRestartInput(String input){
		boolean isOneOrTwo = input.equals(Constants.RETRY_TRUE) || input.equals(Constants.RETRY_FALSE);
		if(!isOneOrTwo){
			throw new IllegalArgumentException(Constants.INVALID_RETRY_INPUT_ERROR);
		}
	}
}

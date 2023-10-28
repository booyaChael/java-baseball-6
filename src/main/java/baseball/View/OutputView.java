package baseball.View;

import baseball.Constants;

public class OutputView {
	public static void printStartMessage(){
		System.out.println(Constants.START_MESSAGE);
	}
	public static void printGuessResult(int numberOfStrike, int numberOfBall){
		StringBuilder guessResult = new StringBuilder();
		if(numberOfBall > 0){
			guessResult.append(numberOfBall).append("볼").append(" ");
		}
		if(numberOfStrike > 0){
			guessResult.append(numberOfStrike).append("스트라이크");
		}
		if(numberOfStrike == 0 && numberOfBall == 0){
			guessResult.append("낫싱");
		}
		System.out.println(guessResult);
	}

	public static void printCorrectMessage(){
		System.out.println(Constants.CORRECT_MESSAGE);
	}

}

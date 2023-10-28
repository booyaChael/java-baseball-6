package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.View.InputView;

public class RoundManager {
	public List<Integer> getUserNumber(){
		String input = InputView.getUserNumberInput();
		validateUserGuess(input);
		return convertStringToList(input);
	}

	//스트라이크의 수 계산
	public int countStrike(List<Integer> computerNumber, List<Integer> userGuessNumber){
		int strikeCount = 0;
		for(int i = 0; i < Constants.NUMBER_LENGTH; i++){
			int number = userGuessNumber.get(i);
			if(computerNumber.get(i).equals(number)){
				strikeCount++;
			}
		}
		return strikeCount;
	}

	//볼의 수 계산
	public int countBall(List<Integer> computerNumber, List<Integer> userGuessNumber){
		int ballCount = 0;

		for(int i = 0; i < Constants.NUMBER_LENGTH; i++){
			int number = userGuessNumber.get(i);
			if(computerNumber.get(i) != number && computerNumber.contains(number)){
				ballCount++;
			}
		}
		return ballCount;
	}

	private void validateUserGuess(String input) {
		// 숫자로만 이루어져 있는지 확인
		boolean isOnlyNumber = input.matches("\\d+");
		// 3자리인지 확인
		boolean isRightSize = input.length() == Constants.NUMBER_LENGTH;

		if (!isOnlyNumber || !isRightSize) {
			throw new IllegalArgumentException(Constants.INVALID_LENGTH_ERROR);
		}

		// 숫자가 서로 다른지 확인
		if (!hasUniqueDigits(input)) {
			throw new IllegalArgumentException(Constants.DUPLICATE_DIGITS_ERROR);
		}
	}

	// 사용자 입력에 중복된 숫자가 있는지 확인
	private boolean hasUniqueDigits(String input) {
		for (char c : input.toCharArray()) {
			if (input.indexOf(c) != input.lastIndexOf(c)) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> convertStringToList(String userGuess){
		List<Integer> resultList = new ArrayList<>();
		for (char c : userGuess.toCharArray()) {
			int digit = Character.getNumericValue(c);
			resultList.add(digit);
		}
		return resultList;
	}
}

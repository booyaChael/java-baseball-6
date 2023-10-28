package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	public List<Integer> makeComputerNumber(){
		List<Integer> computerNumber = new ArrayList<>();

		while (computerNumber.size() < Constants.NUMBER_LENGTH) {
			int randomNumber = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}
		return computerNumber;
	}
}

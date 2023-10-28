package baseball.View;

import baseball.Constants;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String getUserNumberInput(){
		System.out.print(Constants.GUESS_MESSAGE);
		return Console.readLine();
	}

	public static String getRestartInput(){
		System.out.println(Constants.RETRY_MESSAGE);
		return Console.readLine();
	}
}

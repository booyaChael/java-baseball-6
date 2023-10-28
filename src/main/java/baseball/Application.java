//Application.java
package baseball;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        RoundManager roundManager = new RoundManager();

        Game game = new Game(numberGenerator, roundManager);
        game.run();
    }
}

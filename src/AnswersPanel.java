import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AnswersPanel extends JPanel {
    TriviaGame game;

    public AnswersPanel(TriviaGame game) {
        this.game = game;
        setLayout(new GridLayout(2, 2));
        setSize(400, 200);
        addAnswerButtons(game.questionPanel.triviaQuestion.answers);
    }

    public void addAnswerButtons(String[] answers) {
        int idx;
        Random random = new Random();
        boolean[] added = new boolean[4];
        while (!(added[0] && added[1] && added[2] && added[3])) {
            idx = random.nextInt(4);
            if (!added[idx]) {
                this.add(new AnswerButton(answers[idx], idx, this.game));
                added[idx] = true;
            }
        }

    }

}

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class QuestionPanel extends JPanel {

    public QuestionPanel(TriviaQuestion triviaQuestion){
        setLayout(null);
        setSize(400,600);
        AnswerButton[] answerButtons = new AnswerButton[4];
        for (int i=0; i<4; i++)
            answerButtons[i]=new AnswerButton(triviaQuestion.answers[i], i);


    }




}

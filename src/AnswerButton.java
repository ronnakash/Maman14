import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AnswerButton extends JButton implements MouseListener {
    boolean correct;
    TriviaGame game;

    public AnswerButton(String answerString, int idx){
        super(answerString);
        correct = idx == 0;
        setSize(100,40);
    }

    //TODO: ask weather to present next question
    @Override
    public void mouseClicked(MouseEvent e) {
        if (correct)
            JOptionPane.showConfirmDialog(null, "Correct!", "Trivia", JOptionPane.CLOSED_OPTION);
        else
            JOptionPane.showConfirmDialog(null, "Wrong!", "Trivia", JOptionPane.CLOSED_OPTION);
        game.nextQuestion();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
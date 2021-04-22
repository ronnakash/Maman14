import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AnswerButton extends JButton implements MouseListener {
    boolean correct;
    TriviaGame game;

    public AnswerButton(String answerString, int idx, TriviaGame game){
        super(answerString);
        this.game = game;
        addMouseListener(this);
        correct = idx == 0;
        setSize(50,40);

    }

    //TODO: ask weather to present next question
    @Override
    public void mouseClicked(MouseEvent e) {
        game.questionPanel.questionTimer.timer.stop();
        showResult(correct);
        askForNext();
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

    public void showResult(boolean correct){
        if (correct)
            JOptionPane.showConfirmDialog(null,"Correct!", "Trivia", JOptionPane.CLOSED_OPTION);
        else
            JOptionPane.showConfirmDialog(null,"Wrong!", "Trivia", JOptionPane.CLOSED_OPTION);
    }

    public void askForNext(){
        if (JOptionPane.showConfirmDialog(null, "next question?", "Trivia",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            game.nextQuestion();
        else
            game.endGame();

    }

}
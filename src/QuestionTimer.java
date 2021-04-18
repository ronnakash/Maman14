import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionTimer implements ActionListener{
    Timer timer;
    QuestionPanel questionPanel;
    int timeLeft;

    public QuestionTimer(QuestionPanel questionPanel) {
        timer = new Timer(1000,this);
        timeLeft = 30;
        this.questionPanel = questionPanel;
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timeLeft--;
        questionPanel.repaint();
        if (timeLeft==0)
            questionPanel.timeOut();
    }
}

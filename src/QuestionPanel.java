import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class QuestionPanel extends JPanel {
    TriviaGame game;
    QuestionTimer questionTimer;
    TriviaQuestion triviaQuestion;

    public QuestionPanel(TriviaQuestion triviaQuestion, TriviaGame triviaGame){
        game = triviaGame;
        this.triviaQuestion = triviaQuestion;
        setLayout(new GridLayout(2,2));
        setSize(600,200);
        questionTimer = new QuestionTimer(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Ariel", 1, 50));
        g.setColor(new Color(10, 10, 10));
        g.drawString(triviaQuestion.question, 100,100);
        if (questionTimer.timeLeft<31)
            g.setColor(new Color(0, 255, 0));
        if (questionTimer.timeLeft<11)
            g.setColor(new Color(255, 255,0 ));
        if (questionTimer.timeLeft<6)
            g.setColor(new Color(255, 0, 0));
        g.drawString(String.valueOf(questionTimer.timeLeft),500,100);
        game.repaint();
    }

    public void timeOut(){
        JOptionPane.showConfirmDialog(null, "too slow!", "Hangman", JOptionPane.CLOSED_OPTION);
        game.nextQuestion();
    }


}

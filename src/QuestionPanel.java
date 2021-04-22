import javafx.scene.text.Text;

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
        setLayout(null);
        setSize(500,150);
        questionTimer = new QuestionTimer(this);
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        QuestionTextArea questionTextArea = new QuestionTextArea(triviaQuestion.question);
        add(questionTextArea,BorderLayout.NORTH);
        if (questionTimer.timeLeft<31)
            g.setColor(new Color(0, 255, 0));
        if (questionTimer.timeLeft<11)
            g.setColor(new Color(255, 255,0 ));
        if (questionTimer.timeLeft<6)
            g.setColor(new Color(255, 0, 0));
        g.setFont(new Font("Ariel", 1, 50));
        g.drawString(String.valueOf(questionTimer.timeLeft),500,100);
        game.repaint();

    }

    public void timeOut(){
        JOptionPane.showConfirmDialog(null, "too slow!", "Hangman", JOptionPane.CLOSED_OPTION);
        game.nextQuestion();
    }

    public static class QuestionTextArea extends JTextArea{
        public QuestionTextArea(String text) {
            super(text);
            setFont(new Font("Ariel", 1, 30));
            setLineWrap(true);
            setWrapStyleWord(true);
            setBackground(Color.LIGHT_GRAY);
            setForeground(new Color(10, 10, 10));
            setSize(450,200);
        }
    }

}

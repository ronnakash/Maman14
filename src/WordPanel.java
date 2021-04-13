import org.w3c.dom.Text;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class WordPanel extends JPanel {
    public GameWord gameWord;
    HangmanGame game;

    public WordPanel(String word, HangmanGame game) {
        this. game = game;
        gameWord = new GameWord(word, game);
        setSize(800, 300);
        setBackground(Color.WHITE);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Ariel", 1, 50));
        g.drawString(gameWord.revealedString, 100, 100);
        g.setFont(new Font("Calabri", 1, 60));
        g.setColor(new Color(255, 0, 0));
        String failedAttemptsString = "";
        for (int i = 0; i < gameWord.failedAttempts; i++)
            failedAttemptsString = failedAttemptsString.concat("X");
        g.drawString(failedAttemptsString, 670, 100);
    }
}

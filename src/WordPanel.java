import org.w3c.dom.Text;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

public class WordPanel extends JPanel {
    public GameWord gameWord;
    HangmanGame game;

    public WordPanel(String word, HangmanGame game) {
        this.game = game;
        gameWord = new GameWord(word, game);
        setPreferredSize(new Dimension(830, 400));
        setBackground(Color.WHITE);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw revealed string
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Ariel", 1, 50));
        g.drawString(gameWord.revealedString, 0, 100);
        g.setColor(new Color(2, 2, 2));
        //draw noose
        ((Graphics2D)g).setStroke(new BasicStroke(6));
        g.drawLine(720,125,720,30);
        //draw pole
        ((Graphics2D)g).setStroke(new BasicStroke(12));
        g.drawLine(550,30,750,30);
        g.drawLine(550,30,550,240);
        g.drawLine(650,340,550,240);
        g.drawLine(650,340,450,340);
        g.drawLine(550,240,450,340);
        //draw stick figure
        ((Graphics2D)g).setStroke(new BasicStroke(8));
        for (int i = 0; i < gameWord.failedAttempts; i++) {
            switch (i) {
                case 0:
                    g.drawOval(700, 130, 40, 40);
                    break;
                case 1:
                    g.drawLine(720, 170, 720, 230);
                    break;
                case 2:
                    g.drawLine(720, 180, 780, 210);
                    break;
                case 3:
                    g.drawLine(720, 180, 660, 210);
                    break;
                case 4:
                    g.drawLine(720, 230, 750, 290);
                    break;
                case 5:
                    g.drawLine(720, 230, 690, 290);
                    //end game
                    break;

            }
        }
    }
}

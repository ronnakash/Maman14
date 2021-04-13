import javax.swing.*;
import java.awt.*;

public class HangmanGame extends JFrame {
    WordPanel wordPanel;
    Keyboard keyboard;


    public HangmanGame() {
        wordPanel = new WordPanel("ihatejavafx", this);
        setSize(850, 600);
        setLayout(new GridLayout(2, 1));
        keyboard = new Keyboard(this);
        add(wordPanel);
        add(keyboard);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        HangmanGame newGame = new HangmanGame();
    }

}

import javax.swing.*;
import java.awt.*;

public class HangmanGame extends JFrame {
    WordPanel wordPanel;
    Keyboard keyboard;


    public HangmanGame() {
        keyboard = new Keyboard(this);
        wordPanel = new WordPanel("ihatejavafx", this);
        FlowLayout layout = new FlowLayout();
        setSize(830, 630);
        setLayout(layout);
        layout.setHgap(0);
        layout.setVgap(0);
        add(wordPanel);
        add(keyboard);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        HangmanGame newGame = new HangmanGame();
    }

}

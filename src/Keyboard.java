import javax.swing.*;
import java.awt.*;


public class Keyboard extends JPanel {
    HangmanGame game;

    public Keyboard(HangmanGame game) {
        this.game = game;
        int x = 50, y = 20;
        setPreferredSize(new Dimension(830,230));
        setLayout(null);
        setBackground(Color.GRAY);
        JButton[] buttons = new JButton[26];
        String realKeyboardLayout = "QWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0; i < 26; i++) {
            buttons[i] = new KeyboardButton(realKeyboardLayout.charAt(i), game);
            add(buttons[i]);
            buttons[i].setBounds(x, y, 60, 40);
            x += 75;
            if (x > 700) {
                switch (y) {
                    case 20:
                        if (x > 750) {
                            y = 75;
                            x = 87;
                        }
                        break;
                    case 75:
                        y = 130;
                        x = 162;
                }
            }
        }
        repaint();


    }


}

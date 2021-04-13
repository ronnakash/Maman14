import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class KeyboardButton extends JButton implements MouseListener {
    HangmanGame game;
    private char buttonLetter;

    public KeyboardButton(char c, HangmanGame game) {
        super(Character.toString(c));
        this.game = game;
        buttonLetter = (char) (c - 'A' + 'a');

        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.isEnabled()) {
            this.setEnabled(false);
            game.wordPanel.gameWord.tryLetter(buttonLetter);
        }
        repaint();
        game.wordPanel.repaint();
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
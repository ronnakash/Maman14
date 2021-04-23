import javax.swing.*;

public class GameWord {
    HangmanGame game;
    String wordString;
    String revealedString;
    int failedAttempts;

    public GameWord(String word, HangmanGame game) {
        this.game = game;
        wordString = word;
        revealedString = " _";
        for (int i = 1; i < word.length(); i++)
            revealedString = revealedString.concat(" _");
    }

    void tryLetter(char c) {
        if (wordString.indexOf(c) != -1) {
            for (int i = wordString.indexOf(c); i < wordString.length(); i++) {
                if (wordString.charAt(i) == c)
                    revealedString = revealedString.substring(0, i * 2 + 1) + c + revealedString.substring(2 * i + 2);
            }
            game.wordPanel.repaint();
        } else
            failedAttempts++;
            game.wordPanel.repaint();
        if (failedAttempts==6){
            JOptionPane.showConfirmDialog(null, "Oops! you've ran out of attempts", "Hangman", JOptionPane.DEFAULT_OPTION);
            game.askForNext();
        }
        if (revealedString.indexOf('_') == -1) {
            JOptionPane.showConfirmDialog(null, "You got it!", "Hangman", JOptionPane.DEFAULT_OPTION);
            game.askForNext();
        }
    }

}

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class HangmanGame extends JFrame {
    WordPanel wordPanel;
    Keyboard keyboard;
    List<GameWord> hangmanGameWordsList;
    Iterator<GameWord> listIterator;
    Scanner scanner;

    public HangmanGame() {
        try {
            scanner = new Scanner(new File("hangman.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("hangman.txt not found");
            System.exit(0);
        }
        hangmanGameWordsList = getHangmanGameWordsListFromFile(scanner);
        listIterator = hangmanGameWordsList.iterator();
        try {
            wordPanel = new WordPanel(listIterator.next(), this);
        } catch (NullPointerException e) {
            System.out.println("file found but empty");
            System.exit(0);
        }
        keyboard = new Keyboard(this);
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

    public List<GameWord> getHangmanGameWordsListFromFile(Scanner scanner){
        String tempLine;
        String[] parsedLine;
        List<GameWord> hangmanGameWordsList = new ArrayList<>();
        while (scanner.hasNext()){
            tempLine = scanner.nextLine();
            parsedLine = tempLine.split(" ");
            for (String nextWord : parsedLine)
                hangmanGameWordsList.add(new GameWord(nextWord, this));
        }
        Collections.shuffle(hangmanGameWordsList);
        return hangmanGameWordsList;
    }

    public void nextWord(){
        if (!listIterator.hasNext()){
            JOptionPane.showConfirmDialog(null,"out of words!", "Hangman", JOptionPane.DEFAULT_OPTION);
            endGame();
        }
        GameWord nextWord = listIterator.next();
        remove(wordPanel);
        remove(keyboard);
        wordPanel = new WordPanel(nextWord,this);
        keyboard = new Keyboard(this);
        add(wordPanel);
        add(keyboard);
        setSize(830, 631);
        setSize(830, 630);
        repaint();
    }

    public void endGame(){
        JOptionPane.showConfirmDialog(null,"Thanks for playing!", "Hangman", JOptionPane.DEFAULT_OPTION);
        System.exit(0);
    }

    public void askForNext(){
        if (JOptionPane.showConfirmDialog(null, "next word?", "Hangman",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            nextWord();
        else
            endGame();
    }

}

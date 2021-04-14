import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class TriviaGame extends JFrame {
    QuestionPanel questionPanel;
    AnswersPanel answersPanel;
    Scanner scanner;
    List <TriviaQuestion> triviaQuestionsList;
    Iterator<TriviaQuestion> listIterator;

    public TriviaGame(){
        try {
            scanner = new Scanner(new File("trivia.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("trivia.txt not found");
            System.exit(0);
        }
        triviaQuestionsList = new ArrayList<>();
        while (scanner.hasNext())
            triviaQuestionsList.add(new TriviaQuestion(scanner));
        Collections.shuffle(triviaQuestionsList);
        listIterator = triviaQuestionsList.iterator();
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        nextQuestion();
        }

    public static void main(String[] args) {
        TriviaGame game = new TriviaGame();
    }


    public void nextQuestion(){
        if (!listIterator.hasNext()){
            JOptionPane.showConfirmDialog(null, "Out of questions", "Trivia", JOptionPane.CLOSED_OPTION);
            System.exit(0);
        }
        if (questionPanel != null)
            remove(questionPanel);
        if (answersPanel != null)
        remove(answersPanel);
        TriviaQuestion nextQuestion = listIterator.next();
        questionPanel = new QuestionPanel(nextQuestion, this);
        answersPanel = new AnswersPanel(this);
        add(questionPanel);
        add(answersPanel);
        answersPanel.setLocation(0,200);
        repaint();
    }

}

import javax.swing.*;
import java.util.Scanner;

public class TriviaQuestion {
    String question;
    String[] answers;
    QuestionPanel questionPanel;


    public TriviaQuestion(Scanner scanner){
        answers = new String[4];
        if(scanner.hasNext()){
            question = scanner.nextLine();
            for (int i=0; scanner.hasNext() && i<4; i++){
                answers[i] = scanner.nextLine();
            }
        }




    }


}

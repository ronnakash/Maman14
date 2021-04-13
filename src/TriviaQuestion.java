import javax.swing.*;
import java.util.Scanner;

public class TriviaQuestion {
    String question;
    String[] answers;
    QuestionPanel questionPanel;


    public TriviaQuestion(Scanner scanner){
        if(scanner.hasNext()){
            question = scanner.next();
            for (int i=0; scanner.hasNext() && i<4; i++){
                answers[i] = scanner.next();
            }
        }
        if (answers[3]!=null){




        }



    }


}

package mathquiz2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuestionList {
    HashMap<Integer,Question> qset;

    public HashMap<Integer,Question> getQuestionMap() throws FileNotFoundException {
        HashMap<Integer,Question> questions=new HashMap<>();
        File file=new File("GeneralQuestions.txt");
        Scanner sc=new Scanner(file);
        int index=0;
        while(sc.hasNext()){

            String line=sc.nextLine();
            StringTokenizer st=new StringTokenizer(line,";");
            StringBuffer buffer=new StringBuffer();
            for(int i=0;i<5;i++){
                buffer.append(st.nextToken().trim());
            }
            String answer=st.nextToken().trim();
            Question q=new Question(buffer.toString(),answer);
            questions.put(index,q);
        }
        return questions;
    }
    public int checkAnswer(Question question,String answer){
        if(question.getAnswer().equals(answer))
            return 10;
        else
            return -10;
    }

    public static void main(String[] args) throws FileNotFoundException {
        QuestionList questionList=new QuestionList();
        questionList.getQuestionMap();
    }
}

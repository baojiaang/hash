package mathquiz2;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class GenerateQuestion {
    private static QuestionList questionList;
    private MathQuestion mathQuestion=new MathQuestion();
    private static HashMap<Integer,Question> map;
    private static HashSet<MathQuestion> set=new HashSet<>();
    public void init() throws FileNotFoundException {
        questionList=new QuestionList();
        map=questionList.getQuestionMap();
        set=new HashSet<>();
    }
    public String generate() throws FileNotFoundException {

        Random r=new Random();
        int random=r.nextInt(2);
        if(map.size()>0){
            if(random==0){
                int i=r.nextInt(map.size());
                Question question=map.get(i);
                System.out.println(question.getQ());
                map.remove(i);
                return question.getAnswer();
            }
            else {
                MathQuestion mathQuestion1=mathQuestion.generateQuestion();
                boolean flag=false;
                while(flag){
                    flag=set.contains(mathQuestion1);
                    mathQuestion1=mathQuestion.generateQuestion();
                }
                System.out.println(mathQuestion1.getQuestion());
                return mathQuestion1.getAnswer();
            }
        }
        else{
            MathQuestion mathQuestion1=mathQuestion.generateQuestion();
            boolean flag=false;

            while(flag){
                flag=set.contains(mathQuestion1);
                mathQuestion1=mathQuestion.generateQuestion();
            }
            System.out.println(mathQuestion1.getQuestion());
            return mathQuestion1.getAnswer();
        }



    }
}

package quiz2;

import java.io.FileNotFoundException;
import java.util.*;

public class Question {
    private String q;
    private String answer;
    private LinkedList<Question> qmaps;

    public Question() throws FileNotFoundException {

    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question(String q, String answer) {
        this.q = q;
        this.answer = answer;
    }

    public LinkedList<Question> getQmaps() throws FileNotFoundException {
        GeneralQuestion generalQuestion=new GeneralQuestion();
        MathQuestion mathQuestion=new MathQuestion();
        LinkedList<Question> maps=new LinkedList<>();
        generalQuestion.setGeneralQustionMap(generalQuestion.init());
        mathQuestion.setMathQuestions(mathQuestion.init());
        for(int i=0;i<10;i++){
            int random=MathQuestion.generateNumber(2);
            if(random==0){
                maps.add(generalQuestion.getGeneralQuestion());
            }
            else {
                maps.add(mathQuestion.getMathQuestion());
            }
        }
        this.qmaps=maps;
        return maps;
    }

    public Question getQustion() throws FileNotFoundException {
        int random=MathQuestion.generateNumber(qmaps.size());
        
        Question q=qmaps.get(random);
        qmaps.remove(q);
        return q;
    }
}
